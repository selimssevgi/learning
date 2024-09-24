# Microservice vs Monolithic

## Monolithic

* Tightly coupled

The invocation of business logic happens at the programming-language level
instead of through implementation-neutral protocols such as SOAP and REST. This
greatly increases the change that even a small change to an application
component can break other pieces of the applicaation and introduce new bugs.

* Leaky

Most large software applications manage different types of data. For instance, a
customer relationship management application might manage customer, sales, and
product information. In a traditional model. this data is kept in the same data
model and within the same data store. Even though there are obvious boundaries
between the data, too often it's tempting for a team from one domain to directly
access the data that belongs to another team. Even small changes to a single db
table can require a significant number of code changes and regression-testing
throughout the entire application.

* Monolithic

Most of the application components for a traditional application reside in a
single code base that's shared across multiple teams, any time a change to the
code is made, the entire application has to be recompiled, rerun through an
entire testing cycle, and redeployed.

## Microservice

* Constrained

Microservices have a single set of responsibilities and are narrow in scope.
Embrace the UNIX philosophy that an application is nothing more than a
collection of services where each service does one thing and does that one thing
really well.

* Loosely coupled

A microservice-based application is a collection of small services that only
interact with one another through a non-implementation specific interface using
a non-proprietary invocation protocol (HTTP, JSON). As long as the interface for
the service doesn't change, the owner of the microservice have more freedom to
make modificataions to the service than in a traditional application architecture

* Independent

Each microservice in a microservice application can be compiled and deployed
independently of the other services used in the application. This means changes
can be isolated and tested much more easily than with a more heavily
interdependent, monolithic application
