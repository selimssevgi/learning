# ch08 - how do i add a feature?

- when we sprout or wrap, we don't significantly modify the existing code, so it
  isn't going to get any better for a while.

- once we have tests in place, we are in a better position to add new features.
  We have a solid foundation.

- one of the most valuable things about TDD is that it lets us concentrate on
  one thing at a time, we are either writing code or refactoring; we are never
  doing both at once.

#### normalized hierarchy

- in a normalized hierarchy, no class has more than one implementation of a method

- none of the classes has a method that overrides a concrete method in inherited from a superclass

- When you ask: "How does this class do X?" you can answer by looking at class X

- Either the method is there or it is abstract and implemented in one of the subclasses

- in normalized hierarchy you dont have to worry about subclasses overriding
  behavior they inherited from their superclasses
