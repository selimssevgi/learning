# Essential Slick

- Slick is a Scala library for working with relational databases

- writea queries in Scala and they are checked by the compiler

- 'queries:' which compose using combinators such as map, flatMap, and filter
- 'actions:' the things you can run against a db, which themselves compose
- 'futures:' which are the result of actions, and also support a set of combinators

## Chapter 1 - Basics

- Slick queries are written in Scala, type-safe, composable

*NOTE:* Slick isn't an ORM

- Lifted embedding:
  - define data types to store row data(case classes, tuples, or other types)
  - define a Table objects representing mappings between data types and db
  - define TableQueries and combinators to build useful queries before running them against db

- Lift embedding is the standard way to work with Slick
- Other approach is called Plain SQL querying

- Database object acts as a factory for managing connections and transactions

- In Slick, what we run against database is an action, DBIO[T]

```scala
val db = Database.forConfig("chapter01")
val action: DBIO[Unit] = messages.schema.create
val future: Future[Unit] = db.run(action)
```

- Futures allow us to chain together computations without blocking to wait for a result

- ++= accepts a seq of object and translates them to a bulk INSERT

- Query is a monad, implements map, flatMap, filter and withFilter
- this makes it possible to be used in for comprehension

- DBIOAction is also a monad, implements the same methods like Query
- this makes it possible to combine actions
- we can combine actions and run them later against the db

```scala
val actions: DBIO[Seq[Message]] = (
  messages.schema.create       andThen
  (messages ++= freshTestData) andThen
  halSays.result
)
```
