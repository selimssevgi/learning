# producer

- cdi can handle in the bean archieve

- how about in third-party jars?

- producers provide cdi capabilities for other non-owned types


### built-in data types

- with the help of producers we can inject types such as int, long etc

```java
public class NumberProducer {
   @Produces
   private String pre = "7";

   @Produces
   private int random = Math.abs(new Random().nextInt());

   @Produces @ThirteenDigits
   private long post = Math.abs(new Random().nextLong());

   @Produces @CurrentTime
   private long millis = Math.abs(new Random().nextLong());
}
```

### producer methods

- producer fields
  - produce a field
  - initialized with simple values

- producer methods
  - for more complex object creation
  - return value is produced

```java
public class FileProducer {

   @Inject @Root
   private File root;

   @Produces
   private String prefix() {
      return "prefix";
   }

   @Produces
   private Path newFile() {
      // create a new file
      return thePath;
    }

   @Produces @ThirteenDigits
   private long post = Math.abs(new Random().nextLong());

   @Produces @CurrentTime
   private long millis = Math.abs(new Random().nextLong());
}
```

### InjectionPoint


```java
public class LoggingProducer {
  @Produces
  private Logger produceLogger(InjectionPoint ip) {
    return LogManager.getLogger(ip.getMember().getDeclaringClass.getName());
  }
}
```

## disposer

- jdbc clean up

```java
public class Disposers {
  private void disposeConnection(@Disposes Connection conn) {
    conn.close();
  }
}
```

