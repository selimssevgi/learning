# ch21 - test readability

- every time the developers have to stop and puzzle through a test to figure out
  what it means, they have less time left to spend on creating new features, and
  the team velocity drops

- test code tends to be concrete about the values it uses as examples of what
  results to epect but abstract about how the code works

- production code tends to be abstract about the values it operates on but
  concrete about how it gets job done

#### test names describe features

- a better alternative is to name tests in terms of the features that the target object provides.

- we use a TestDox convention where each name reads like a sentence, with the
  target class as the implicit subject:

```shell
A 'List' holds items in the order they were added
A 'List' can hold multiple references to the same item
A 'List' throws an exception when removing an item it does not hold
```

- we can translate these directly to method names:

```java
@Test public void holdsItemsInTheOrderTheyWereAdded() {}
@Test public void canHoldMultipleReferencesToTheSameItem() {}
@Test public void throwsAnExceptionWhenRemovingAnItemItDoesNotHold
```

- the test name should say something:
  - about the expected result
  - the action on the object
  - the motivation for the scenario

#### canonical test structure

- setup, execute, verify, teardown

- arrange, act, assert

- each test should ony contain one expection or assertion
 - one coherent feature per test, which might be represented by up to a handful of assertions

#### streamline the test code

- use structure to explain: extract language syntax to methods

- use structure to share
  - be careful not to make a test so abstract that we cannot see what it does nay more

- accentuate the positive
  - only catch exceptions in a test if we want to assert smth about them

- delegate to subordinate objects
  - sometimes helper methods aren't enough and we need helper objects to support the tests

#### literal and variables

- literals by themselves does not communicate the intent

```shell
public static final Chat UNUSED_CHAT = null;
public static final int INVALID_ID = 666;
```

- we name variables to show the roles these values or objects play in the test
  and their relationships to the target object
