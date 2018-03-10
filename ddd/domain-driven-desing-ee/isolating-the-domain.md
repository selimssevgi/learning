# Isolating the Domain

- We need to decouple the domain objects from other functions of the system, so
  we can avoid confusing the domain concepts with other concepts related only to
  software technology or losing sight of the domain altogether in the mass of
  the system.

- In an OO program, UI, database, and other support code often gets written
  directly into the business objects. Additional business logic is embedded in
  the behavior of UI widgets and database scripts. This happens because it is
  the easiest way to make things work, in the short run.

- Concentrate all the code related to domain model on one layer and isolate it
  from the UI, application, and infrastructure code.

- The domain objects, free of responsibility of displaying themselves, storing
  themselves, managing application tasks, and so forth, can be focused on
  expressing the domain model.

  - It is not practical to achieve that correspondence when the domain logic is
    mixed with other concerns of the program. Isolating the domain
    implementation is a prerequisite for ddd.
