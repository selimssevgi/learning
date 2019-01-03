# Integrated Tests are a Scam

- by J B Rainsberger

- the important thing is that an integrated test is any test where when it fails
  I cannot point right here to find the problem

- one of the properties of good tests is exactly the opposite

- see testing pyramid

- what is a unit in unit tests? Lets call them 'isolated tests'

- checking vs testing by michael bolton

- why do we write integrated tests and not just isolated tests for everything?

- %100 test passes, we have a bug

- if we find the bug by writing integrated tests, that means we should write
  more integrated tests

- the whole point of test-driven development is not to do testing
- one of the goals of test-driven development is learn about the quality of our design
- if our design has problems, then
  - the tests will be hard to write
  - the tests will be hard to understand
  - it will be difficult to write these small isolated tests

- to find design problems I must have isolated tests
- the more integration tests we have the less design feedback we get

- positive feedback of negative feelings:
  - 100% test passes + mistake
  - more write integrated tests
  - more sloppy design
  - less time for isolated tests
  - more mistakes

- someone gives an aspirin that cause you more headache


- Client -- let image this one requires 8 tests
- Server -- and this one requires 10 tests
- for their integration we will need around 8.10 ~= 80 tests

- server is context independent, he does not know how it is being used, easier to test
- client needs server

- lets put an interface between client and server
- interface describes what can i do without describing how do i do it

#### design by contract

- contract is set of behavior of those functions

- if i start with an empty list and i call add with "hello"
- then when i call contains with "hello", it must return true

- this interplay of behavior between add and contains is part of the contract



- there is one set of tests that are designed to check "does the client ask the interface the right questions?"

- we do that with our good friend "mock object" (test doubles)

- stub: is hard-coding an interface to return a convenient answer

- test doubles have two basic ways of working

1. to use expectations
2. do i handle all possible responses

- collabration/integration tests

- tests between interface and server: contract tests
- does the server implements the interface correctly?

- "do i try to answer and do i really answer that way"
