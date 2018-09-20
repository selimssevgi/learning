# Effective Unit Testing

## Part 1

### Chapter 1: The promise of good tests

- Tests help us cacth mistakes.

- Tests help us shape our design to actual use (tdd)

- Tests help us avoid gold-plating by being explicit about what the required behavior is.

- The biggest value of writing a test lies not in the resulting test but in what we learn from writing it.
  - using tests as desing tool (much higher value)
  - using tests as a quality tool

### Chapter 2: In the search of good

* What makes a test "good"?

- The test code's readability and maintainability
 
- How the code is organized both within the project and within a given source file

- What kinds of things a test is checking for

- How reliable and repeatable a test is

- How a test makes use of test doubles

- A test should have only one reason to fail.

- Long delay in feedback is a real productivity-killer (smaller tests)

- It is not good if it's testing the wrong things

- Independent tests run easily in solitude

- Don't rely on test order within a test class

- Be extra careful with these dependencies in testing code:
  - Time
  - Randomness
  - Concurrency
  - Infrastructure
  - Pre-existing data (each test should setup its own context)
  - Persistence (In-memory database)
  - Networking  (mock-out)

- Reliable tests should be reliable. Happy testing have 100% coverage, no assertion

- Tests that can hardly ever fail are next to useless.

- "Happy tests" never fails, "Random tests" always fail. No good from either

### Chapter 3: Test Doubles

- To serve a placeholder until the real thing become available

- To isolate the code you want to test from its surroundings.

* Isolate the code under test
* Speed up test execution
* Make execution deterministic
* Simulate special conditions
* Gain access to hidden information

- Instead of adding public methods for testing purposes, use mocking objects to
  test internal state.

- May be the only feasible way to simulate certain special situation (network error)

- Test double types:
  - Test stub   (Simplest possible implementation)
  - Fake object (in memory data structure for repository implementation)
  - Test spy    (observe what happens inside the class under test)
  - Mock object

- Stub queries, mock actions

#### Arrange, act, assert

- bdd terminology: Given, When, Then

- Given(a context), When (something happens), Then (we expect certain outcome)


- Check for behaviour, not implementation

## Part 2: Catalog

- Catalog is one of 'test smells'


### Chapter 4: Readability

#### Pritimive assertions

```java
// needs some thinking to figure it out
assertTrue(out.indexOf("test.txt:1 1st match") != -1);

// more clear what to expect
assertThat(out.indexOf("test.txt:1 1st match"), is(not(-1)));

// a better abstraction
assertTrue(out.contains("test.txt:1 1st match"));

// even more readable
assertThat(out.contains("test.txt:1 1st match"), equals(true));
```

- Do not use !=, ==, or magic numbers in your test. Is a code smell

#### Hyperassertions

- A test should have only one reason to fail.

- being able to see "the whole thing in one place vs the essence of a test quickly"

- fine-grained, focused tests point you quickly to the root of the problem in
  case of a test failure.

#### Bitwise assertions

- The essence gets hidden behind the foreign bit operator.

```java
// XOR fails when both sides are same
assertTrue(Platform.IS_32_BIT ^ Platform.IS_64_BIT);
```

```java
assertTrue("Not 32 or 64-bit platform?", Platform.IS_32_BIT || Platform.IS_64_BIT);

assertFalse("Cant be 32 and 64-bit at the same time?",
  Platform.IS_32_BIT && Platform.IS_64_BIT);
```

#### Incidental details

- give me the beef, not the sauce

1. Extract the nonessential setup into private methods or the setup

2. Give things appropriate, descriptive names

3. Strive for a single level of abstraction in a method

- Is it perfectly clear and obvious what this test is all about?
