# Discovery Server

- An actively managed registry of service locations

- Source of truth

- One or more instances (important piece)

## Setup

- start.spring.io
- eurake server, actuator, devtools

```yaml
# application.yml
spring.application.name=discovery-server

# just in development
eureka:
  client:
    register-with-eureka: false
    # we are the only instance, there wont be fetching from another one
    fetch-registry: false

server.port = 8761 # default eureka server
```

```java
@EnableEurekaServer
```

* "Cannot execute request on any known server"

- Discovery server is trying to register itself with a peer discovery server
- This is mainly for high availability purposes
- In standalone or dev mode, we do not need multiple instances every time
