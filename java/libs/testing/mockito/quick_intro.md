# Mockito

- Mockito is a popular mock framework, used in conjuctuin with JUnit.
- Allows you to create and configure mock objects.
- Simplifies the development of tests for classes with external dependencies.
- Mocking is a way to test to functionality of a class of isolation.
- Mocking doesnot require a db connection, file read to test a functionality.

- Mock away the external dependencies
- Execute the code under test
- Validate that the code executed correctly

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
