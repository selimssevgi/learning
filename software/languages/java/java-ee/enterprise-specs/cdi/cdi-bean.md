# cdi bean

- concrete class with a default constructor

- does not need to:
  - implement interface
  - extend a class
  - be annotated

- can have optional
  - qualifiers
  - scope
  - expression language name
  - interceptor bindings

### lice cycle of a cdi bean

- cdi beans are managed by a container
  - container creates the instance
  - gets rid of it

- containers manages the life cycle

- container give handles for after and before construction
