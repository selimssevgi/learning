# Mockito

- Mockito is a popular mock framework, used in conjuctuin with JUnit.
- Allows you to create and configure mock objects.
- Simplifies the development of tests for classes with external dependencies.
- Mocking is a way to test to functionality of a class of isolation.
- Mocking doesnot require a db connection, file read to test a functionality.

## Usage

- Add as a dependency in maven or gradle.

## Benefits of Mockito

- *No handwriting:* No need to write mock objects on your own.
- *Refactoring Safe:* Renaming interface method names or reordering parameters
  will not break the test code as Mocks are created at runtime.
- *Return value support:* Supports return values.
- *Exception support:* Supports exceptions.
- *Order check support:* Supports check on order of method calls.
- *Annotation support:* Supports creating mocks using annotation.

## What is mocking?

- A mock object is an object that is configured to return a specific output for
  a specific input, without performing any real action.

## Why use mock?

- Test a component that depends on other component, but which is not yet developed.
- Real component performs slow operations.
- Infrastructure concerns that would make impossible the testing.

- Testing should NOT take really long, otherwise it creates a lot of problems with
  fast-moving team and in case of CI,CD and TDD.

- A test may take time to execute due to following reasons:
  - A test acquires a connection from the database
  - It connects to internet and downloads files
  - It interacts with an SMTP server to send e-mails
  - It performs IO operations

- Above step might be needed for integration tests, but for unit tests we can
  mock out the external dependencies.
