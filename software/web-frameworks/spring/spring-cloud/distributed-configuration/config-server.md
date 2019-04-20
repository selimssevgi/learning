# Spring Cloud Config Server

## Configuration files

- Create a folder to store configuration

- (optional) Add a 'properties' or yml file with a named 'application'

- Add properties or yml files named {application}-{profile}

- git init, git add, git commit, git push

## Server itself

```shell
# application.properties
server.port=8888
spring.cloud.config.server.git.uri=<uri-to-git-repo>
```

- @EnableConfigServer

* Can be registered to eureka

```shell
# application.properties
server.port=8888
spring.cloud.config.server.git.uri=<uri-to-git-repo>
spring.application.name=configserver
eureka.client.server-url.defaultZone=localhost:8761/eureka
```

- Use Spring Security to secure access to config server
