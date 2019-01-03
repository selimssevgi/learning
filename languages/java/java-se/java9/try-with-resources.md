# try-with-resources

```java
class Resource implements AutoCloseable {
  public Resource() {
    sout("CREATED");
  }

  public void op1() {
    sout("OP1");
  }

  @Override
  public void close() {
    sout("clean up external resource");
  }
}

public class Sample {
  psvm(String[] args) {
    // in java 7, variables should be initialized in try
    try (Resource resource = new Resource()) {
      resource.op1();
    }
  }

  public static void use(Resource resource) { // effectively final
    try (resource) {
      resource.op1();
    }
    // will be closed
    sout(resource); // still can talk to object but it closed!
  }
}
```
