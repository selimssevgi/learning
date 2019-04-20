# ch07 - achieving object-oriented design

- starting with a test means that we have to describe 'what' we want to achieve before we consider 'how'

- to keep unit tests understable (and, so maintainable), we have to limit their scope

- to construct an object for a unit test, we have to pass its dependencies to
  it, which means that we have to know what they are

#### value types

- we should define types to represent value concepts in the domain, even if they don't do much

- it helps to create a consistent domain model that is more self-explanatory

- we use three basic techniques for introducing value types:

1. breaking out

- when we find that the code in an object is becoming complex, that is often a
  sign that it's implementing multiple concerns and that can break out coherent
  units of behavior into helper types

2. budding off

- when we want to mark a new domain concept in the code, we often introduce a
  placeholder type that wraps a single field, as the code grows we fill in more
  detail in the new type by adding fields and methods

3. bundling up

- when we notice that a group of values are always used together, we take that
  as a suggestion that there is a missing construct


### where do objects come from?

1. breaking out: splitting a large object into a group of collaborating objects

- the tests say break up an object if it becomes too large to test easily, or
  if its test failures become difficult to interpret. Then unit-test the new
  parts separately

2. budding off: defining a new service that an object needs and adding a new object to provide it

- the tests say that when writing a test, we ask ourselves, "if this worked, who
  would know?" if the right answer to that question is not in the target object,
  it is probably time to introduce a new collaborator

3. bundling up: hiding releated objects into a containing object

- the tests say that when the test for an object becomes too complicated to set
  up, when there are too many moving parts to get the code into the relevant
  state, consider building up some of the collaborating objects.
