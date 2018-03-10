# Value Objects

- Many objects have no conceptual identity. These objects describe some
  characteristic of a thing.

- Tracking the identity of Entities is essential, but attaching identity to
  other objects can hurt the system performance, add analytical work, and muddle
  the model by making all objects look the same.

- An object that represents a descriptive aspect of the domain with no
  conceptual identity is called a Value Object.

- A value object can be an assemblage of other objects.

- Value objects can even reference entities.

- VOs are often passed as parameters in messages between objects.

- They are frequently transient, created for an operation and then discarded.

- VOs are used as attributes of Entities and other Value objects.

- A person may be modeled as an Entity with an identity, but that person's name
  is a Value.

- Treat the VO as immutable

- Dont give VO any identity and avoid the design complexities necessary to maintain Entities.

- see whole value pattern.

- We dont care which instance we have of a VO. This lack of constraints gives
  us design freedom we can use to simplify the design or optimize performance..
  This involves making choices about copying, sharing, and immutability.

- Can use Flyweight pattern for better optimization and memory.
