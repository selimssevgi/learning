# Introduction to Spring Data

## Datastore specific and common features

- Database specific features are accessed through familiar Spring Template pattern
  - RedisTemplate, HBaseTemplate, MongoTemplate, Neo4jTemplate, GemfireTemplate

- Spring Data Repository model
  - common CRUD functionality across data stores
  - can still access store specific functionality

- Integration with QueryDSL
  - store specific typesafe DSL for querying

## Repositories

Mediates between the domain and data mapping layers using a collection-like
interface for accessing domain objects.

- Spring data repositories removes the busy work of building a repository
