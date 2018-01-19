# Service Discovery using Spring and Cloud Eureka

- Spring Cloud offers multiple methods for looking up information from a service discovery agent

- Netflix's Eureka service discovery engine is used to implement service discovery pattern

- For the client-side load balancing Netflix's Ribbon can be used


1. As the services are bootstrapping, they will also register themselves with
   the Eureka Service. This registration process will tell Eureka the physical
   location and port number of each service instance along with a service ID for
   the service being started

2. When one service calls to another service, it will use the Netflix Ribbon
   library to provide client-side load balancing. Ribbon will contact the Eureka
   service to retrieve service location information and then cache it locally.

3. Periodically, the Netflix Ribbon library will ping the Eureka service and
   refresh its local cache of service locations

## Eureka Server

- a new spring boot project, with spring-cloud-starter-eureka-server dep

```yml
# application.yml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false    # do not register with eureka
    fetch-registry: false          # do not cache registry information locally
  server:
    wait-time-in-ms-when-sync-empty: 5 # initial time to wait before server takes requests
```

*NOTE:* Individual services registering will take up to 30 seconds to show up in
the Eureka service because Eureka requires 3 consecutie heartbeat pings from the
service spaced 10 seconds apart before it will say the service is ready for use.

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {}
```

## Registering service with Spring Eureka

- add spring-cloud-starter-eureka dependency in service's pom.xml

```yml
#application.yml
spring:
  application:
    name: organizationservice
  profiles:
    active: default
  cloud:
    config:
      enabled: true
eureka:
  instance:
    prefer-ip-address: true # register IP rather than service name
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka
```

```java
@SpringBootApplication
@EnableEurekaClient
public class OrganizationServiceApplication {}
```

- Every service registered with Eureka will have two components associated with it:
  - the application ID: represents a group of service instance/spring.application.name
  - the instance ID: random number

- Use Eureka's REST API to see the contents of the registery

- To see all the instances of a service:

```shell
http://localhost:8761/eureka/apps/organizationservice
```

## Using service discovery to look up a service

- Spring Discovery client
- Spring Discovery client enabled RestTemplate
- Netflix Feign client

### Looking up service instances with Spring Discovery Client

- DiscoveryClient offers the lowest level of access to Ribbon and the services registered within it

- Retrieve one of the service URLs from Ribbon and then call the service using a
  standard RestTemplate class

```java
@SpringBootApplication
@EnableDiscoveryClient // enables the app to use the DiscoveryClient and Ribbon libraries
public class LicensingServiceApplication {}
```

```java
@Component
public class OrganizationDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Organization getOrganization(String organizationId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("organizationservice");

        if (instances.size() == 0) return null;
        String serviceUri = String.format("%s/v1/organizations/%s",instances.get(0).getUri().toString(), organizationId);
        System.out.println("!!!! SERVICE URI:  " + serviceUri);

        ResponseEntity< Organization > restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, Organization.class, organizationId);
        return restExchange.getBody();
    }
}
```

- Use only when the service needs to query Ribbon to understand what services
  and service instances are registered with.

*There are several problems with this approach:*

- You aren't taking advantage of Ribbon's client side load-balancing (you choose)

- You are doing too much work

- Instead of AutoWiring, instantiating RestTemplate

- There are better mechanisms for calling a Ribbon-backend service

### Invoking services with Ribbon-aware Spring RestTemplate

- To use a Ribbon-aware RestTemplate class, you need to define a RestTemplate
  bean construction method with a Spring Cloud annotation called @LoadBalanced

```java
// in Application.java
// no need to add @EnableDiscoveryClient or @EnableFeignClients
@LoadBalanced
@Bean
public RestTemplate getRestTemplate() {
  return new RestTemplate();
}
```

```java
@Component
public class OrganizationRestTemplateClient {

  @Autowired
  RestTemplate restTemplate; // Ribbon-aware Spring RestTemplate

  public Organization getOrganization(String organizationId){
    ResponseEntity<Organization> restExchange =
            restTemplate.exchange(
            // build the target URL with the Eureka service ID
                    "http://organizationservice/v1/organizations/{organizationId}",
                    HttpMethod.GET,
                    null, Organization.class, organizationId);

    return restExchange.getBody();
  }
}

```

## Invoking services with Netflix Feign client

- Define a Java interface and then annotate that interface with SCloud
  annotations to map what Eureka-based service Ribbon will invoke

```java
@SpringBootApplication
@EnableFeignClients
public class LicensingServiceApplication {}
```

```java
@FeignClient("organizationservice")  // which service Feign will use
public interface OrganizationFeignClient {
  // path and action to the endpoint, like in a controller class
  @RequestMapping(
          method= RequestMethod.GET,
          value="/v1/organizations/{organizationId}",
          consumes="application/json")
  // parameters passed into endpoint are defined using @PathVariable endpoint
  Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
```

- With RestTemplate, all service calls's HTTP status codes will be returned via
  the ResponseEntity class's getStatusCode()

- With Feign client any HTTP 4xx-5xx status codes returned by the service being
  called will be mapped to a FeignException, can be parsed for the specific error message
