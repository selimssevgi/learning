# Spring Data JPA

- Makes things easir to work with JPA

## Add to project

- From Spring Initialzr pick:
  - JPA
  - Apache Derby(Embedded): no extra information needed when spring sees it on
    classpath and assumes that to be the database to connect to.
  - Embedded database resets after each reload

## Using

- Annotate domain object(Topic)

- CrudRepository interface provided by Data JPA
- It is a generic interface: CrudRepository<T,ID>

- TopicService <- TopicRepository
