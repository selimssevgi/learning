# FIRST

- is an acronym by Tim Ottinger and Brett Schubert

## Fast

- the faster, the more frequently they run, the more value

## Isolated

- no network, no database dependency

- no dependency on another test result

- no multiple assertions

## Repeatable

- same result, does not matter how many times they run

## Self-verifying

- tests should be very unambigous when they fail and it should be obvious when a
  test fails and what the failure reason was

- the easist way to achieve this to create many small unit tests, which are very
  very specific that should only ever fail for a single reason or creating a
  single assertion per test

## Timely

- they are written as close to the time that the production code is written.

- as soon as prod code is written you are most familiar with the inner workings
  of the code as well as its intention, so it is easier to exercise the code
  through the test

- at this point, code has also likely accrued less dependencies on top of it so
  if it is necessary to refactor the code to get it under the tests, it is less
  of an exercise
