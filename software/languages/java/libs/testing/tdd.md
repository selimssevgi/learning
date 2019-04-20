# Test Driven Development

- TDD : Test Driven Development
- TFD : Test First Development

- TDD is about eliminating or reducing fear in the development process

- Automated tests are safety nets.
- They run and notify the user if system is broken, so offending code can be fixed very quickly.
- If a test suite runs for an hours, the purpose of quick feedback is compromised.
- Unit tests should act as a safety net and provide quick feedback; *this is the main principle of tdd.*

- Write a test to add a new cpability(automate tests)
- Write code only satisfy tests
- Re-ren the tests if any test is broken, revert the change
- Refactor and make sure all tests are green
- Continue with step 1

## Why TDD?

- How to design your code?
- How to encourage testing?
- YAGNI (You are not gonna need it)

"Always implement things when you actually need them,
never when you foresee that you need them."

- The incremental production of well designed and tested code.

## What is TDD?

- First write the test
- Fail(Red)
- Write passing implementation
- Pass(Green)
- Refactor
- Pas(Green)

## Levels of TDD

Level          | Description
---------------|-------------
Unit           | Tests to verify code contained in a class
Integration    | Tests to verify interaction between classes
System         | Tests to verify a running system
System-Integ   | TEsts to verify a running system, including 3rd party components

