# Config Client

- Bootstrap, and fetch app configuration

- Config Client needs to fetch the application configuration before the Spring
  application context has even technically started.

## Bootstrapping

- bootstrap.yml, bootstrap.properties

- Config first: specify the location of the config server

- Discover first: discover the location of the config server

## Client Setup

- 'spring-cloud-config-clinet' to pom

### Config First

```shell
# bootstrap.properties
spring.application.name=app-name
spring.cloud.config.uri=http://localhost:8888
```

### Discovery First

- Do not forget @EnableDiscoveryClient, service-url configuration

```shell
# bootstrap.properties
spring.application.name=app-name
spring.cloud.config.discovery.enabled=true
eureka.client.server-url.defaultZone=localhost:8761/eureka
```
