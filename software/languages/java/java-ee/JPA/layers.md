# Layered Architecture

- Layer communicate from top to bottom
  - A layer is dependent only on the interface of the layer directly below it

- Each layer is unaware of any other layers except for the layer just below it

```shell
          Presentation Layer 
        /                     \
       /                       \
Domain -  Business Layer    --   Interceptors/Utility/HelperClasses
 Model                         /
       \                      /
        \ Persistence Layer  /
                 |
                 |
              Database
```

## Addressing leakage of concerns

- When concerns suc as persistence, transaction management, or authorization
  start to appear in the domain model classes, this is an example of leakage of
  concers

- The domain model implementation is such an important piece of code that it
  shouldnt depend on orthogonal Java APIs.

- code in the domain model shouldnt perform JNDI lookups or call the database
  via JDBC API, not directly and not through an intermediate abstraction

- All allows you to reuse the domain model classes virtually anywhere:

* The presentation layer can access instance and attributes of domain model
  entities when rendering views

* The controller components in the business layer can also access the state of
  domain model entities and call methods of the entities to execute business logic

* The persistence layer can load and store instances of domain model entities
  from and to the database, preserving their state

- Also you get the benefit of being easily testing the domain model

