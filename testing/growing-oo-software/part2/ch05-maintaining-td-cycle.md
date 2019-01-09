# ch05 - maintaining the test-driven cycle

### start each feature with an acceptance test

- we write the acceptance test using only terminology from the application's
  domain, not from the underlying technologies (such as databases or web service)

- acceptance tests help us see the feature from user's point of view, instead of implementer's point of view

- unit tests, on the other hand, exercise objects, or small cluster of objects in isolation
- they are important to help us design classes and give us confidence that they work
- but they don't say anything about whether they work together with the rest of the system

- acceptance tests both test the integration of unit-tested objects and push the project forwards

### separate tests that measure progress from those that catch regressions

- we organize our test suites to reflect different roles that the tests fulfill

- unit and integration tests support the development team, should run quickly, and should always pass

- acceptance tests for completed features catch regressions and should always
  pass, although they might take longer to run

### watch the test fail

- we always watch the test fail before writing the code to make it pass, and check the diagnostic message

- when we get the "right" failure, we check that the diagnostics are helpful

- if the failure description isn't clear, someone will have to stuggle when the code breaks

- taking trouble to generate a useful diagnostic helps us clarify what the test,
  and therefore the code, is supposed to do

### unit-test behavior, not methods

- focus on the 'features' that the object under test should provide, each of
  which may require collaboration with its neighbors and calling more than one of its methods

- we need to know how to use the class to achieve a goal, not how to exercise
  all the paths through its code
