# Application Service

- Provides some application functionality
- The receiver of requests
- A dependency of other service(s)
- One or more instances
- User of the discovery client(call out discover server, register, deregister)

# Setup

- Add starter-netflix-eureka-client in pom

- Add @EnableDiscoveryClient

```yaml
eureka.client.service-url.defaultZone: localhost:8761/eureka
```
