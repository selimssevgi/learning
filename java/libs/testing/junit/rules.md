# JUnit Rules

- @Test(timeout=20)
- Rules allow very flexible addition or redefinition of the behavior of each test method in a test class.
- Rules are like AOP.
- Inbuilt rules can be used or custom ones can be defined.

* @Rule public Timeout globalTimeout    = new Timeout(20, TimeUnit.MILLISECONDS);
* @Rule public ExpectedException thrown = ExpectedException.none();
* @Rule public TemporaryFolder folder   = new TemporaryFolder();
* @Rule public ErrorCollector collector = new ErrorCollector();

### Timeout Rule
public class TimeoutTest {
  // applied to all methods in this class
  @Rule
  public Timeout globalTimeout = new Timeout(20, TimeUnit.MILLISECONDS);

  @Test
  public void timeOut() throws InterruptedException {
    Thread.sleep(3000);
  }

  @Test
  public void anotherTimeOut() throws InterruptedException {
    Thread.sleep(3000);
  }
}

### ExpectedException Rule

- Important rule for handling exceptions
- assert the expected exception type and exception message
- Differentiate same exception type with exception message
- @Test(expected=NullPointerException.class)

```java
public class ExpectedExceptionRuleTest {

  @Rule // this object is reset on each test
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void throwsNothing() {}

  @Test
  public void throwsNPE() {
    thrown.expect(NullPointerException.class);
    throw new NullPointerException();
  }

  @Test
  public void throwsISEWithMessage() {
    thrown.expect(IllegalStateException.class);
    thrown.expectMessage("Is this a legal state?");

    throw new IllegalStateException("Is this a legal state?");
  }
}
```

### TemporaryFolder Rule

- allows creation of files and folder
- deleted after test method finished(passes or fails)

```java
@Rule
public  TemporaryFolder folder  = new TemporaryFolder();

@Test
public  void  testUsingTempFolder() throws  IOException {
    File  createdFile = folder.newFile("myfile.txt");
    File  createdFolder = folder.newFolder("mysubfolder");
}
```

### ErrorCollector Rule

- Allows execution of a test to continue in case of fails
- Collecting all errors

```java
public class ErrorCollectorRuleTest {
  @Rule
  public ErrorCollector collector = new ErrorCollector();

  @Test
  public void collectError() {
    collector.checkThat("a", CoreMatchers.equalTo("b"));
    collector.checkThat(1, CoreMatchers.equalTo(2));
  }
}
```
