# Suite

- or test suite, a group of tests

- a test suite is a convenient way to group together tests that are related

- if you don't define a test suite for a test class, JUnit automatically
  provides a test suite that includes all tests found int the test class

- a suite usually groups test classes from the same package

- The Suite object is a Runner that executes all of the @Test methods in the test class

```java
@RunWith(Suite.class)
@SuiteClasses({FolderConfigurationTest.class, FileConfiguration.class})
public class FileSystemConfigurationTestSuite {}
```

- can also create suite of suites

- test suites provide a powerful way to organize your tests

- the convience isn't unique to JUnit

- Maven als provides ways to run groups of test classes and suites by allowing
  you to specify, with a type of regex

- IDEs allow you to run all test classes and Suites in a selected package or source directory
