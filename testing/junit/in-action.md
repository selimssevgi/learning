# JUnit in Action

## ch1 - junit jump-start

- unit tests often focus on testing whether a method follows the terms of its API contract

- a core tenet of unit testing is: "any program feature without an automated test doesn't exist"

- all unit testing frameworks should follow:
  - each unit test should run independently of all other unit tests
  - the framework should detect and report errors test by test
  - it should be easy to define which unit tests will run

## ch02 - exploring core junit

- junit creates a new instance of the test class before invoking each @Test method

- each test method runs on a new test class instance, we can't reuse instance
  variable values across test methods

- when you need to run several test classes at once, you create another object called a test suite

- JUnitCore is a facade, operates with any of the test runners
