# Microservice

- Microservices are distibuted, loosely coupled software services that carry out
  a small number of well-defined tasks


### Monolithic Architectural Style

- An application is delivered as a single deployable sofware artifact

- All the UI, business and db access logic are packaged together into a single
  application artifact and deployed to an application server

- Multiple development teams might be working on an application that deployed as a single unit of work

- The problems:
  - The size and complexity of the monolithic application grows
  - The communication and coordination cost of the individual teams dont scale
  - Every time an individual team need to make a change, the entire application
    has to be rebuilt, retested and redeployed

### Microservice Arhitectural Style

- A microservice is a small, loosely coupled, distributed service

- Microservices allow you to take a large application and decompose it into
  easy-to-manage components with narrowly defined responsibilities

- Each functional team completely owns their service code and service infrastructure

- They can build, deploy, and test independently of each other

##### Characteristics

- Application logic is broken down into small-grained components with
  well-defined boundaries of responsibility that coordinate to deliver a solution

- Each component has a small domain of responsibility and is deployed completely
  independently of one another. Microservices should have responsibility for a
  single part of a business domain. Also, should be reusable accross multiple applications

- Microservices communicate based on a few basic principles (not standards) and
  employ lightweight communication protocols such as HTTP and JSON

- The underlying technical implementation of the service is irrelevant because
  the applications always communicate with a technology-neutral protocol

* Small, Simple, and Decoupled Services = Scalable, Resilient, and Flexible Applications

#### Microservices are more than writing the code

- Location transparent: How do you manage the physcial location so services
  instances can be added and removed without impacting service clients?

- Resilient: How do you make sure when there is a problem with a service,
  service clients "fail fast"?

- Repeatable: How do you ensure that every time a new service instance is
  started is always has the same code and configuration as exiting instances?

- Scalable: How do you ensure that your applications can scale quickly with
  minimal dependencies between services?

- Right-sized: How do you make sure the service is focused on one area of responsibility?
