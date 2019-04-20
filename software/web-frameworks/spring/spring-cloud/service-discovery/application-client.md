# Application Client

- Calls another application service to implements its functionality

- The issuer of request

- Depends on other service(s)

- User of the discovery client (find service locations)

- A client can be a service at the same time

# Setup

- Same as service

```yml
spring.application.name=client
eureka.client.service.service-url.defaultZone=localhost:8761/eureka
# is not gonna provide service
eureka.client.register-with-eureka=false
```

## Discovering services as a client

- Two options

1. Eureka server specific

```java
@Inject
EurekaClient eurekaClient;

// next instance using round-robin
InstanceInfo instance = eurekaClient.getNextServerFromEureka("service-id", false);

String baseUrl = instance.getHomePageUrl(); // can be used in rest template
```

2. Discovery server agnostic

```java
@Inject
DiscoveryClient client; // belongs to Spring

List<ServiceInstance> instances = client.getInstances("service-id");
String baseUrl = instances.get(0).getUri().toString();
```
