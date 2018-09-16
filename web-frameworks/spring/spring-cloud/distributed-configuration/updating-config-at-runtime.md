# Updating Configuration at Runtime

- Refresh @ConfigurationProperties

- Update logging levels


## Step One: Configuration Changes

- make config in config repo and push

## Step Two: Notify Applications to Refresh Configuration

- Manually: call actuator /refresh for each application

- Combination of manumatic: /bus/refresh with spring-cloud-bus
  - every application will refresh their properties even if change does not affect them

** Smart Refresh **

- VCS + /monitor with spring-cloud-config-monitor & spring-cloud-bus

- push the change
- repository knows what changed
- it sends that change to monitor endpoint
- then it decides to notify one or two application for changes

### @RefreshScope

- @Bean will not see new config value after a refresh
- /refresh endpoint will reload configuration properties


```java
@Configuration
public class SomeConfig {

  @Value("${some.config.value}")
  private String configVal;

  @Bean
  public FooService fooService(FooProperties props) {
    return new FooService(props.getConfigVal()) ;
  }

  @Bean
  public BooService booService() {
    return new BooService(configVal) ;
  }
}
```

- Configuration updates made
- POST to /refresh
- Result: FooService, BooService will still contain the OLD configuration value

* How do I refresh a @Bean or @Value that only gets its configuration during initialization?

```java
@Configuration
@RefreshScope
public class SomeConfig {

  @Value("${some.config.value}")
  private String configVal;

  @Bean
  @RefreshScope
  public FooService fooService(FooProperties props) {
    return new FooService(props.getConfigVal()) ;
  }

  @Bean
  public BooService booService() {
    return new BooService(configVal) ;
  }
}
```
