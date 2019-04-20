# ch12 - i need to make many changes in one area? Do i have to break dependencies for all classes involved?

- higher-level tests can be useful in refactoring

- often people prefer them to finely grained tests at each class because they
  think that change is harder when lots of little tests are written against an
  interface that has to change.

- while higher-level tests are an important tool, they shouldnt be a substitute
  for unit tests. Instead, they should be a first step toward getting unit tests in place


### interception points

- is simply a point in your program where you can detect the effects of a particular change

- in general, it is a good idea to pick 'interception points' that are very
  close to your change points, for a couple of reasons:

- the first reason is safety

- the second reasons is difficulty to set up the tests of more distant interception points

- is most cases, the best interception point we can have for a change is a
  public method on the class we're changing

- 'pinch point' is a place where it is possible to write tests to cover a wide set of changes

- a 'pinch point' is a narrowing in an effect sketch, a place where tests are
  against a couple of methods can detect changes in many methods
