# Roles

- The foundation for successful microservice development starts with the
  perspectives of three critical roles:

1. The architect

The architect's job is to see the big picture and understand how an application
can be decomposed into individual microservices and how the microservices will
interact to deliver a solution.

2. The software developer

The software developer writes the code and understands in detail how the
language and development frameworks for the language will be used to deliver a microservice.

3. The DevOps engineer

The DevOps engineer brings intelligence to how the services are deployed and
managed throughout not only production, but also all the nonproduction
environments. The watchwords for the DevOps are 'consistency' and 'repeatability' in every environment.

## The Architect

1. Decomposing the business problem
2. Establishing service granularity
3. Defining the service interfaces

### Decomposing the business problem

1. Describe the business problem, and listen to the nouns you're using to describe the problem

Using the same nouns over and over in describing the problem is usually an
indication of a core business domain and an opportunity for a microservice

2. Pay attention to the verbs

Verbs highlight actions and often represent the natural contours of a problem
domain. If you find yourself saying "trx X needs to get data from thing A and
thing B" that usually indicates that multiple services are at play.

3. Look for data cohesion

As you break apart your business problem into discrete pieces, look for pieces
of data that are highly related to one another. If suddenly, during the course
of your conversation, you're reading or updating data that's redically different
from what you've been discussing so far, you potentially have another service
candidate. "Microservices should completely own their data."

### Establishing service granularity

Each service owns all the data within their domain. This does not mean that each
service has their own database. It just means that only services that own that
domain can access the database tables within it.

1. It's better to start broad with your microservice and refactor to smaller services

It's easy to go overboard when you begin your microservice journey and make
everything a microservice. But decomposing the problem domain into small service
often leads to premature complexity because microservices devolve into nothing
more than fine-grained data services.

2. Focus first on how your services will interact with one another

This will help establish the coarse-grained interfaces of your problem domain.
It's easier to refactor from being too coarse-grained to being too fine-grained

3. Service responsibilities will change over time as your understanding of the problem domain grows

Often, a microservice gains responsibilities as new application functionality is
requested. What starts as a single microservice might grow into multiple
services, with the original microservice acting as an orchestration layer for
these new services and encapsulating their functionality from other parts of the application

### Defining the service interfaces

* Embrace the REST philosophy

The REST approach to services is at heart the embracing of HTTP as the
invocation protocol for the services and the use of standard HTTP verbs. Model
your basic behaviors around these HTTP verbs

* Use URI's to communicate intent

The URI you use as endpoints for the service should descrie the different
resources in your problem domain and provide a basic mechanism for relationships
of resources within your problem domain

* Use JSON for your request and responses

* Use HTTP status codes to communicate results

## DevOps

1. A microservice should be 'self-contained' and 'independently deployable' with
   multiple instances of the service being started up and torn down with a
   single software artifact

2. A microservice should be 'configurable'. When a service instance starts up,
   it should read the data it needs to configure itself from a central location
   or have its configuration information passed on as environment variables. No
   human intervention should be required to configure the service

3. A microservice instance needs to be 'transparent' to the client. Client
   should never know the exact location of a service. Instead, a microservice
   client should talk to a service discovery agent that will allow the
   application to locate an instance of a microservice without having to know
   its physical location.

4. A microservice should 'communicate' its heath. This is a critical part of
   your cloud architecture. Microservice instances will fail and clients need to
   route around bad service instances

* Service assembly

How do you package and deploy your service to guarantee repeatability and
consistency so that the same service code and runtime is deployed exactly the
same way?

* Service bootstrapping

How do you seprate your application and environment-specific configuration code
from the runtime code so you can start and deploy a microservice instance
quickly in any environment without human intervention to configure the
microservice?

* Service registration/discovery

When a new microservice instance is deployed how do you make the new service
instance discoverable by other application clients?

* Service monitoring

In a microservices environment it's extremely common for multiple instances of
the same service to be running due to high availability needs. From a DevOps
perspective, you need to monitor microservice instances and ensure that any
faults in your microservice are routed around and that failing service instances
are taken down.
