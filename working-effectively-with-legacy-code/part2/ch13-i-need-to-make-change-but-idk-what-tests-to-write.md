# ch13 - i need to make a change, but i dont know what tests to write

### characterization tests

- in nearly every legacy system, what the system does is more important than
  what it is supposed to do(requirements docs in the past not very useful)

- the tests that we need when we want to preserve behavior are what i call *characterization tests*

- a characterization test is a test that characterizes the actual behavior of a piece of code

- here is a little algorithm for creating characterization tests:

1. use a piece of code in a test harness
2. write an assertion that you know will fail
3. let the failure tell you what the behavior is
4. change the test so that it expects the behavior that the code produces
5. repeat

* characterization tests record the actual behavior of a piece of code. if we
  find something unexpected when we write them, it pays to get some
  clarification. it could be a bug. that deosnt meant that we dont include the
  test in our test suite; instead, we should mark it as suspicious and find out
  what the effect would be of fixing it.

### characterizing classes

### targeted testing

- after we have written tests to understand a section of code, we have to look
  at the things that we want to change and see if our tests really cover them
