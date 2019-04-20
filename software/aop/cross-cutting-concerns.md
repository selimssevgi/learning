# Cross-Cutting Concerns

- Tracing, Exception Handling, and Transactions are cross-cutting concerns

- A lot of classes and methods must implement them

- Without AOP cross-cutting concerns are implemented in many methods

- Can't be implemented in a single place if you use OOP only

- AOP allows centralized implementation of cross-cutting concerns

- Mostly technical:
  - Tracing
  - Exception Handling
  - Transactions
  - Security

## Developing with AOP

- Implement business logic

- Write Aspects for Cross-Cutting Concerns, or use Spring's Aspect Library

- "Compose" your own infrastructure

- Use Spring AOP or AspectJ to weave aspects into the application
- Most commonly used AOP implementations
- Most powerful Java AOP implementations
