# Service Layer

- Defines an application's boundary with a layer of services that establishes a
  set of available operations and coordinates the application's respons in each operation

- Like Transaction Script and Domain Model, Service Layer is a pattern for
  organizing business logic.

- Might be divided "business logic" into two kinds:

1. Domain logic: having to do purely with the problem domain
2. Application logic: having to do with application responsibilities

- Domain Models are preferable to Transaction Scripts for avoiding domain logic
  duplication and for managing complexity using classical design patterns.

- Putting application logic into pure domain object classes has a couple of
  undesirable consequences.

  - Domain object classes are less reusable across applications if they
    implement application-specific logic and depend on application-specific packages
  - Commingling both kinds of logic in the same classes makes it harder to
    reimplement the application logic

- Start with a locally invocable Service Layer whose method signatures deal in
  domain objects. Add remotability when you need it (if ever) by putting Remote
  Facades on your Service Layer or having your SL objects implement remote
  interfaces
