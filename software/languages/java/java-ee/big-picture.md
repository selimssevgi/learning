# javaee big picture

- java enterprise edition
- java EE extends java se
- enterprise software
- large scale
- distributed system

* enterprise application:
  - multi-tiered
  - scalable
  - reliable
  - secure
  - solves the problems of large enterprises


### java see vs java ee

* java se
  - APIs handle collections
  - the JVM is a container
  - lower-level services

* java ee
  - APIs handle transactions, messaging, persistence
  - code runs in a container
  - higher-level services

### java ee programming model

- simplified programming model
- convention over configuration
- container takes default decisions
- bring services
- use metadata to deviate from convention
- information understood by the container

### java ee architecture

- container
  - runtime environment
  - hide technical complexity
  - enhance portability
  - host applications
  - handle complex low-level details
  - administrates the applications
- services
  - security
  - trx management
  - naming
  - remote connectivity
  - services are configurable
  - configuration is isolated
- components
  - static/dynamic web pages
  - server-side classes
  - business code
- APIs
- packaging
- deployment
- protocols
- java se APIs

### java ee services

* business tier(trx, persistence, validation, batch)
* web tier (servlets, web pages, expression language, web sockets)
* interoperability tier (soap, rest, messaging, email, connectors)
* common tier (injection, interception, security, concurrency)
* java se services(jdbc, directory)
