# Test Suite

- To run multiple test cases
- JUnit will invoke the class it references(Suite.class) to run the tests in
  that class instead of runner built into JUnit.

```java
@RunWith(Suite.class)
@SuiteClasses({ClassTest1.class, ClassTest2.class})
public void TestSuite {}
```
