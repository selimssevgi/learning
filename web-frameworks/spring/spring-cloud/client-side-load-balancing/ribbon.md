# Netflix Ribbon

- a Inter Process Communication (remote procedure calls) library with built in software load balancer.

- Spring Cloud adds full integration with Ribbon to Spring's RestTemplate class

- 'starter-ribbon'

## Two new annotations

- @LoadBalanced: marks a RestTemplate to support load balancing

- @RibbonClient: used for custom configuration and when Service Discovery is absent

### @LoadBalanced

```java
@Configuration
public class MyConfig {
  @Bean
  @LoadBalanced // interceptor utilizes Ribbon load balancer, round-ribon
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
```

- Usage

```java
// with service discovery
restTemplate.getForEntity("http://my-service/u/1", ...);
```

### @RibbontClient

- Using a @LoadBalanced RestTemplate without Service Discovery

```java
@Configuration
@RibbonClient(name= "someservice")
public class MyConfig {
  @Bean
  @LoadBalanced // interceptor utilizes Ribbon load balancer, round-ribon
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
```

```shell
#application.properties
# someservice
<ribbon-client-name>.ribbon.eureka.enabled=false
<ribbon-client-name>.ribbon.listOfServers:http://host:9000, host:9001
```
