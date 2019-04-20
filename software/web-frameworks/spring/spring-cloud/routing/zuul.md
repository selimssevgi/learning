# Netflix Zuul

- is a gateway service that provides dynamic routing, monitoring, resiliency,
  security, and more.

- 'starter-zuul' and @EnableZuulProxy

- With or without service discovery

```shell
spring.application.name=gateway-service
# with 
eureka.client.service-url.defaultZone=localhost:8761/eureka
# without
ribbon.eureka.enabled=false
```

## Default Route to Service Resolution

- /foo -> maps to -> spring.application.name=foo

- /categories/1 -> maps to -> spring.application.name=categories (gets /1)

* prefix is stripped by default. Use zuul.stripPrefix=false to disable and get '/categories/1'

* All services are added by default. Use zuul.ignoredServices=[pattern] to ignore services

## Precise Routing

```shell
# application.properties
spring.application.name=gateway-service

zuul.ignore-services=**
zuul.routes.service1.path=/service1/**
zuul.routes.service1.serviceId=service1ServiceId # used for service discovery

# without service discovery
zuul.routes.service1.path=/service1/**
zuul.routes.service1.url=http://urlToService1/
```

