# Polyglot Programming on JVM

- Was coined to describe projects that utilize one or more non-Jaa JVM languages
  alongside a core of Java code.

- One common way to think about polyglot programming is as a form of separation
  of concerns.

- There are potentially tree layers where non-Java technologgies can play a
  useful role: (pyramid)
  - Domain-specific(Camel DSL, Drools, Web templating)
  - Dynamic(Groovy, Jython, Clojure)
  - Stable(Java, Scala)

- The pyramid represents a trade-off between concerns like performance and
  thorough testing at the bottom verses flexibility and rapid deployment at the top.


Name            | Description
----------------|------------------------------------------------------------
Domain-specific | DSL. Tightly coupled to a specific part of the application domain
Dynamic         | Rapid, productive, flexible development of functionality
Stable          | Core functionality, stable, well-tested, performant


## Why use a non-Java language?

- Recompilation is laborious
- Static typing can be inflexible and lead to long refactoring times
- Deployment is a heavyweight process
- Java's syntax isn't a natural fit for producing DSLs

## How to choose a non-Java language

- Domain-specific
  - Build,CI, CD
  - Dev-ops
  - Enterprise Integration Pattern modeling
  - Business rules modeling

- Dynamic
  - Rapid web development
  - Prototyping
  - Interactive administrative and user consoles
  - Scripting
  - Tests

- Stable
  - Concurrent code
  - Application containers
  - Core business functionality
