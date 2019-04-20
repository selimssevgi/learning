# TDD by Example by Kent Beck

- Write a failing automated test before you write any code
- Remote duplication

1. Triangulation (use it when unsure about the correct abstraction)
2. Fake it
3. Obvious implementation (just implement if you already know)

## Part I: the money example

1. quickly add a test
2. run all tests and see the new one fail
3. make a little change
4. run all tests and see them all succeed
5. refactor to remove duplication

### Chapter 1: Dependecy and duplication

- commit to all the sins to make the test green
- take small stess and iterate
- spot the duplication and remove it

### Chapter 2: Degenerate Objects

1. Write a test. Think about how you would like the operatin in your mind to
   appear in your code. Invent the interface you wish you had.

2. Make it run. Quickly getting that bar to go to green dominates everything else.
   If a clean solution will take you a minute, take a note, and go back to main problem: to see green.
   This is not easy for experience engineers, they only know how to follow the
   rules of good engineering. Quick green excuses all sings. But only for a moment.

3. Make it right. Now that the system is behaving, put the sinful ways of recent
   past behind you. Step back onto the straight and narrow path of software
   righteousness. Remote the duplication that you have introduced, and get to
   green quickly.


* "We are changing the interface of Dollar when we make this change, so we have to change the test"

- Following are two of three strategies for quickly getting to green:

1. Fake it: return a constant and dradually replace constants with variables until you have the real code
2. Use obvious implemntation: type in the real implementation

### Ch3: Equality for All

**Triangulation:** we only generalize code when we have two examples or more. We
briefly ignore the duplication between test and model code. When the second
example demands a more general solution, then and only then do we generalize.

- Used functionality just developed to improve other tests
- proceeded in spite of the risk(errorouness equals implementation)
- used new functionality in the object under test to reduce coupling between
  tests and the code

### Ch4: Duplication is okay for a little time

- to get to speed for green, duplication of code is okay
- the important piece is that not to leave that duplication, refactor!

### Ch6: Deduplication

- abstract away common code(super class?)
- do not refactor code that is not covered by tests
- first write the tests, then refactor

### Ch7: Apples and Oranges

- Took an objection that was bothering us and turned it into a test(equals)
- Made the test run a reasonable, but not perfect way (getClass)
- Decided not to introduce more design until we had a better motivation

### Ch8: Making Objects

- took a step toward eliminating duplication by reconciling the signatures of two variants of the same method(times)
- moved at least a declaration of the method to the common superclass
- decoupled test code from the existence of concrete subclasses by introducing factory methods

### Ch9: Times we are living in

- never interrupt an interruption

- Are the teeny-tiny steps feeling restrictive? Take bigger steps. Are you
  feeling a little unsure? Take smaller steps. TDD is a steering process: a
  little this way, a little that way. There is no right step size, now and forever.

### Ch10: Interesting Times

"Does it really matter whether we have a Franc or a Money? We could creafully
reason about this given our knowledge of the system, but we have clean code and
we have tests that give us confidence that the clean code works. Rather than
apply minutes of suspect reasoning, we can just ask the computer by making the
change and running the tests. In teaching TDD, I see this situation all the
time: excellent software engineers spending 5 to 10 mins reasoning about a
question that the computer could answer in 15 seconds. Without the tests you
have no choice, you have to reason. With the tests you can decide whether an
experiment would answer the question faster. Sometimes you should just ask the
computer."

### Ch11: The root of all evil

- Eliminated tests that made sense with the old code structure, but were
  redundant with the new code structure.

### Ch12: Addition, finally

- try to keep the objects at the heart as ignorant of the rest of the world as
  possible, so they stay flexible as long as possible (and remain easy to test,
  and reuse, and understand.)

- reduced a big test to a smaller test that represented progress ($5 + 10 CHF -> $5 + $5)
- got the test to compile quickly
- made it run

### Ch13: Make it

- Any time we ar echecking class explicitly(instanceof), we should be using polymorphism instead.

- worked forward instead of backward to realize the implementation

### Ch14: Change

- factored out the data duplication between code and tests
- wrote a test t ocheck an assumption about the operation of java
- introduced a private helper class without distinct tests of its own
- made a mistake in refactoring and chose to forge ahead, writing another test
  to isolate the problem

### What's next?

- When the todo-list is empty, it is a good time to review the design
  - do the words and concepts play together?
  - is there duplication that is difficult to eliminate given the current design?

* Lingering duplication is a symptom of latent design.

- the three approaches to making a test work cleanly: fake it, triangulation, and obvious implementation

- removing duplication between test and code as a way to drive the design

- the ability to control the gap between tests to increase traction when the
  road gets slippery and cruise faster when conditions are clear

## Part II: the xUnit Example

### Ch19: Set the Table

- when you begin writing tests, you will discover a common pattern (3A)

1. Arrange: create some objects
2. Act: simulate them
3. Assert: check the results

- How often do we want to create new objects to test/ Two constrains come into conflict:

* Performance: we would like our tests to run as quickly as possible; namely, if
  we use similar objects in several tests, we would like to create them once for all tests

* Isolation: we would like the success or failure of one test to be irrelevant
  to other tests. If tests share objects and one test changes the objects,
  following tests are likely to change their results.

## Part III: Patterns for TDD

### Isolated Test

- One test should not affect the result of another tests

- They should run really fast (so, often)

- Tests are order independent

- If one test is broken, you should have one problem, if two, two problems.


### Test List

- Before starting to program, write down as a little todo-list

- mountain climber rule: your four hands and feet, tree of them must be attached at any one time

- pure form of TDD: you are never more than one change away from green bar, is
  like that three-out-of-four rule.

### Assert First


When you should write the asserts? Try writing them first.

- Where should you start building a system? With stories you want to be able to tell about the finished system
- Where should you start writing a bit of functionality? With the tests you want to pass with the finished code.
- Where should you start writing a test? With the asserts that will pass when it is done

### Ch 26: Red bar patterns

- Learning test: when using 3rd party lib, we can write tests to understand and
  test the API, it works as expected. Later on, if we update, those tests could
  help us be confident if the application would run with new version.


- Another test: do not let other ideas to disturb your flow in the middle of
  smth, do not go off topic, if smth strikes, write it down, keep doing what you
  started, and later on check what you took note of.

- Break: take break, shower, walk when stucked.

- Do over: throw away what you have done, and start over.

- Invest more on the chair instead of the desk.

### Ch 27: Testing Patterns

- *Child test:* if test is too big, or even failing test is too big, try to get a
  smaller test out of that one. Do not stay with red too much. Always go for green

- *Mock Object:* use mock object instead of expensive and complicated resources

- *Crash Test Dummy:* create failure cases, like a mock object, but need to
  override only necessary methods

```java
// simulate full file system
// might be defined in where the test is
private class FullFile extends File {
  public FullFile(String path) {
    super(path);
  }

  public boolean createNewFile() throws IOException {
    throw new IOException();
  }
}
```

- *Broken Test:* leave the last test broken when leaving a programming session,
  is like a bookmark. Helps you to catch up with where you left.

- *Clean Check-in:* Be sure you have run all kinds of tests and everything green
  when checking in. If not, throw away your work. check-in more often so you
  wont lose any work. Putting @Ignore or commenting out tests cases just to get
  green and being able to check-in should have some serious punishment.

### Ch 28: Green Bar Patterns

- *Fake it (until you make it):* return a constant. having green bar will make
  you happier and more confident for refactoring. And this way you would be
  scoping out the problem at hand instead of dealing with lot at the same time.

- *Triangulate:* Abstract only when you have two or more examples

- *Obvious implementation:* just implement when you know the answer, if obvious
  implementation turn out to be not so obvious(red bar), go back to tiny steps
  like Triangulate or Fake implementation.

- *One to Many:* How do you implement an operation that works with collections?
  Implement it without collections first, then make it work with collections.


```java
// start with single object parameter
public void testSum() {
   assertEquals(5, sum(5));
}
private int sum(int value) {
   return value;
}

// send along a collection
public void testSum() {
   assertEquals(5, sum(5, new int[] {5}));
}

private int sum(int value, int[] values) {
   return value;
}

// now we can Isolate Changes in sum method, without affecting test code
private int sum(int value, int[] values) {
  int sum= 0;
  for (int i= 0; i<values.length; i++)
    sum += values[i];
  return sum;
}

// now it works, we can remote single parameter from both places
```

### Ch 29: xUnit Patterns

- *Assertion:* do not reach private parts of the object, it is a design problem.
  Fix the design if you can, or reach the variables, take a note. Come back to it later

### Ch30: Design Patterns

- *Command:* represent the invocation of a computation as an object, not just as a message
  - Java Runnable.run is an example. Define your computation and sent it around

- *Value Object:* avoid aliasing problems by making objects whose values never change once created
  - alternative: share a copy, not object itself. Or Observer pattern, be notified for changes

- *Null Object:* represent the base case of a computation by an object

- *Template Method:* represent invariant sequences of computation with an abstract method intended to be specialized through inheritance

- *Pluggable Object:* represent variation by invoking another object with two or more implementations

- *Pluggable Selector:* avoid gratuitous subclasses by dynamically invoking different methods for different instances

- *Factory Method:* create an object by calling a method instead of a constructor

- *Imposter:* introduce variation by introducing a new implementation of existing protocol
  - null object: you can treat the absence of data the same as the presence of data
  - composite: you can treat a collection of objects the same as a single object

- *Composite:* represent the composition of the behavior of a list of objects with an object

- *Collecting Parameter:* pass around a parameter to be used to aggregate the results of computation in many different objects

### Ch31: Refactoring

- Have green tests, add more green tests, remove duplicates!

- Fowler, Martin. 1999. Refactoring: Improving the Design of Existing Code.

### Ch32: Mastering TDD

- What don't you have to test?
  - "Write tests until fear is transformed into boredom"


* How do you know if you have good tests?
  - *Long setup code:* if you have to spend a hundred lines creating the object
    for one simple assertion, then smth is wrong. Your objects are too big and need to split.
  - *Setup duplication:* if you can't easily find a common place for common
    setup code, then there are twoo many objects too tightly intertwined.
  - *Long running tests:* TDD tests that run a long time won't be run often
  - *Fragile tests:* tests that break unexpectedly suggest that one part of the
    app is surprisingly affecting another part.
