# Entities (a.k.a Reference Objects)

- Many objects are fundamentally defined by their attbitues, but rather by a
  thread of continuity and identity.

- Some objects are not defined primarily by their attributes. They represent a
  thread of identity that runs through time and often across distinct
  representations. Sometimes such an object must be matched with another object
  even though attributes differ. An object must be distinguished from other
  objects even though they might have the same attributes. Mistaken identity can
  lead to data corruption.

- An object defined primarily by its identity is called an Entity.

- An entity is anything that has continuity through a life cycle and
  distinctions independent of attributes that are important to the application's
  user. It could be a person, a city, a car, a lottery ticket, or a bank
  transaction.

- When an object is distinguished by its identity, rathen than its attributes,
  make this primary to its definition in the model. Define a means of
  distinguishing each object regardless of its form or history.

## Modeling Entities

- Add only behavior that is essential to the concept and attrbitues that are
  required by that behavior. Beyond that, look to remove behavior and attributes
  into other objects associated with the code Entity.

- Id is the most important for an entity, could a generated key or unique
  business key. Should always tell if the object are same by their id.
