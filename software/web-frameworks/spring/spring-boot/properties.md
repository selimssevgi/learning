# Spring Properties

- place under    resources/application.properties
- or place under resources/application.yaml
- overwrite defaults
- Command line arguments overwrite properties file
- Different properties file for different settings: properties-prod.properties

```shell
--spring.profiles.active=prod # cause spring to pick up prod.properties
```


```shell
# application.properties
spring.profiles.active=dev # @Profile("dev")
type=Framework
name=Spring Boot ${type}
my.messageValue=${random.int(10,150)}
```

```java
@Value("${name}")
String name;
```

```yaml
server:
  port: 9001
  context-path: /test
type: Framework
name: Spring Boot ${type}
```
