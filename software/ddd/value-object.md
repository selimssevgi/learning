# Value Object

- An object that represents a descriptive aspect of the domain with no
  conceptual identity is called a Value Object.

- VOs are instantiated to represent elements of the design that we care about
  only for what they they are, not who or which they are.

- VOs don't have their own identity.

- VOs are completely interchangeable.

## Attributes of Value Objects

* No identity: unlike entities(they have IDs), should be compared by value, not by identity fields.

* Immutability: Easier to work with, instead of changing create a new one.

* Lifetime shortening: It's another corollary of the VOs' identity-less nature.
  They can't exist without a parent entity owning them. In other words, there
  always must be composition relationship between a VO class and Entity class.
  Without it, VO don't make any sense.

* VOs should not have separate tables in database.
