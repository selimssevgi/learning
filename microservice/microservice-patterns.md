# Microservice Patterns

- Core development patterns
- Routing patterns
- Client resiliency patterns
- Security patterns
- Logging and tracing patterns
- Build and deployment patterns

## Core Development Patterns

* Service granularity
  How do you approach decomposing a business domain down into microservices so
  that each microservice has the right level of responsibility?

* Communication protocols
  How will developers communicate with your service? XML, JSON, Thrift? 

* Interface design
  What's the best way to design the actual service interfaces that developers
  are going to use to call your service? URLs, versioning?

* Configuration management of service
  How do you manage the configuration of your service so that as it moves
  between different environments in the cloud you never have to change the core
  application code or configuration?

* Event processing between services
  How do you decouple microservices using events so that you minimize hardcoded
  dependencies between your services and increase the resiliency of your apps?

## Microservice Routing Patterns

* Service discovery
  How do you make sure your microservice discoverable so client applications can
  find them without having the location of the service hard-coded into the app?
  How do you ensure that misbehaving microservice instances are removed from the
  pool of available service instances?

* Service-routing
  How do you provide a single entry point for all of your services so that
  security policies and routing rules are applied uniformly to multiple services
  and service instances in your microservices applications? How you do ensure
  that each developer in your team doesnot have to come up with their own
  solutions for providing routing to their services?

## Microservice Client Resiliency Patterns

* Client-side load balancing
  How do you cache the location of your service instances on the service client
  so that calls to multiple instances of a microservice are load balanced to all
  the health instances of that microservice?

* Circuit breakers pattern
  How do you prevent a client from continuing to call a service that's failing
  or suffering performance problems? When a service is running slowly, it
  consumes resources on the client calling it. You want failing microservice
  calls to fail fast so that the calling client can quickly respond and take an
  appropriate action

* Fallback pattern
  When a service call fails, how do you provide a "plug-in" mechanism that will
  allow the service client to try to carry out its work through alternative
  means other than the microservice being called?

* Bulkhead pattern
  Microservice applications use multiple distributed resources to carry out
  their work. How do you compartmentalize these calls so that the misbehavior of
  one service call doesn't negatively impact the rest of the application?

## Microservice Security Patterns

- Authentication
  How do you determine the service client calling the service is who they say
  they are?

- Authorization
  How do you determine whether the service client calling a microservice is
  allowed to undertake the action they're trying to undertake?

- Credential management and propagation
  How do you prevent a service client from constantly having to present their
  credentials for service calls involved in a transaction?

## Microservice Logging and Tracing Patterns

- Log correlation
  How do you tie together all the logs produced between services for a single
  user transaction?

- Log aggregation
  how to pull together all the logs produced by your microservices into a single
  queryable db, how to use correlation IDs to assist in searching aggregated logs

- Microservice tracing
  How to visualize the flow of a client transaction across all the services
  involved and understand the performance characteristics of services involved in the transasction

## Microservice Build/Deployment Patterns

- Build and deployment pipeline
  How do you create a repeatable build and deployment process that emphasizes
  one-button builds and deployment to any environment in your organization?

- Infrastructure as code
  How do you treat the provisioning of your services as code that can be
  executed and managed after it has been deployed?

- Immutable servers
  Once a microservice image is created, how do you ensure that it's never
  changed after it has been deployed?

- Phoenix servers
  The longer a server is running, the more opportunity for configuration drift.
  How do you ensure that servers that run microservices get torn down on a
  regular basis and recreated off an immutable image?

# Spring Cloud

* Development patterns
  - Core microservice patterns: Spring Boot
  - Configuration management: Spring Cloud Config
  - Asynchronous messaging: Spring Cloud Stream

* Routing patterns
  - Service discovery patterns: Spring Cloud / Netflix Eureka
  - Service routing patterns: Spring Cloud/ Netflix Zuul

* Client resiliency patterns
  - Client-side load balancing: Spring Cloud / Netflix Ribbon
  - Circuit breaker pattern: Spring Cloud / Netflix Hystrix
  - Fallback pattern: Spring Cloud / Netflix Hystrix
  - Bulkhead pattern: Spring Cloud / Netflix Hystrix

* Build deployment patterns
  - Continous integration: Travis CI
  - Infrastructure as code: Docker
  - Immutable servers: Docker
  - Phoenix servers: Travis CI/Docker

* Logging patterns
  - Log correlation: Spring Cloud Sleuth
  - Log aggregation: Spring Cloud Sleuth (with Papertrail)
  - Microservice tracing: Spring Cloud Sleuth/Zipkin

* Security patterns
  - Authorization: Spring Cloud Security/OAuth2
  - Authentication: Spring Cloud Security/OAuth2
  - Credential management and propagation: Spring Cloud Security/OAuth2/JWT
