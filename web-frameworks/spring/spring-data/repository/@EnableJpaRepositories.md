# @EnableJpaRepositories

- scans its basePackages for any interfaces that extends Repository interface

- when it finds any interface extending Repository, it automatically (at
  application startup time) generates an implementation of that interface

```java
@Configuration
@EnableJpaRepositories(
  basePackages = "com.selimssevgi.domain",
  repositoryImplementationPostfix = "Helper") // see custom-functionality
public class JpaConfiguration {}
```
