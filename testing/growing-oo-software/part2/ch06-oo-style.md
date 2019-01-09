# ch06 - object-oriented style

- we value code that is easy to maintain over code that is easy to write

#### designing for maintainability

1. separation of concerns

- when we have to change the behavior of a system, we want to change as little code as possible

- we gather together code that will change for the same reason

2. higher levels of abstraction

- the only way for humans to deal with complexity is to avoid it, by working at higher level of abstraction



- cockburn's ports and adapters

#### encapsulation and information hiding

- the terms are often used interchangeably but actually refer to two separate,
  and largely orthogonal, qualities:

* *encapsulation:* ensures that the behavior of an object can only be affected through its API

* *information hiding:* conceals how an object implements its functionality
  behind the abstraction of its API

- when working badly encapsulated code, we spend too much time tracing what the
  potential effects of a change might be, looking at where objects are created,
  what common data they hold, and where their contents are referenced

- we follow standard practices to maintain encapsulation when coding:
  - define immutable value types
  - avoid global variables and singletons
  - copy collections and mutable values when passing them between objects

- if we expose too much of an object's internals through its API, its clients
  will end up doing some of its work


### object peer stereotypes

1. dependencies: services that the object requires from its peers so it can perform its responsibilities

2. notifications: peers that need to be kept up to date with the object's activity

3. adjustments: peers that adjust the object's behavior to the wider needs of the system

- pass dependencies in through the constructor, they are required

- nofications and adjustments can be passed to the constructor as a convenience
- alternataively, they can be initialized to safe defaults and overwritten later
- there is no safe default for a dependency

- adjustments can be initialized to common values, and notifications to a null object or an empty collection

### context independence

- a system is easier to change if its objects are context-independent

- if each object has no built-in knowledge about the system in which it executes

- this allows us to take units of behavior(objects) and apply them in new situations
