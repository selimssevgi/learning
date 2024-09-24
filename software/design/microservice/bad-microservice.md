# The smells of a bad microservice

## Too Coarse-grained

- If a microservice is too coarse-grained, you will likely see the following:

* A service with too many responsibilities

The general flow of the business logic in the service is complicated and seems
to be enforcing an overly diverse array of business rules

* The service is managing data across a large number of tables

A microservice is the system of record for the data it manages. If you find
yourself persisting data to multiple tables or reaching out to tables outside
the immediate database, this is a clue the service is too big. (3-5 tables)

* Too many test cases

- Services can grow in size and responsibility over time. If you have a service
  that started with a small number of test cases and ends up with hundreds of
  unit and integration test cases, you might need to refactor


## Too Fine-grained

- The microservices in one part of the problem domain breed like rabbits

If everything becomes a microservice, composing business logic out of the
services becomes complex and difficult because the number of services needed to
get a piece of work done grows tremendously.

A common smell is when you have dozens of microservices in an application and
each service interacts with only a single db table.

- Your microservices are heavily interdependent on one another

You find that the microservices in one part of the problem domain keep calling
back and forth between each other to complete a single user request.

- Your microservices become a collection of simple CRUD services

Microservices are an expression of business logic and not an abstraction layer
over your data sources. If your microservices do nothing but CRUD-related logic,
they're probably too fine-grained.
