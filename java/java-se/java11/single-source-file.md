# Launching Single-file Source Code

```shell
public class Hello {
  public static void main(String[] args) {
    String msg = "Hello Java 11!";
    System.out.println(msg);
  }
}
```
```shell
# previous method
javac Hello.java
java Hello.java

# new in java 11
java Hello.java # assumes source as current jdk version
java Hello.java --source 11 # go into source mode
```

## Executable Scripting

- shebang
- ./listfiles
- have to use --source flag because file does not have .java extention


```java
//listfiles file
import java.nio.file.*;

public class ListFiles {
  public static void main(String[] args) throws Exception {
    Files.walk(Paths.get(args[0]))
      .forEach(System.out::println);
  }
}
```

```shell
java listfiles .
# Error: Could not find or load main class listfiles

java --source 11 listfiles .
```

```java
#!/usr/bin/java --source 11
import java.nio.file.*;

public class ListFiles {
  public static void main(String[] args) throws Exception {
    Files.walk(Paths.get(args[0]))
      .forEach(System.out::println);
  }
}
```

```shell
chmod +x listfiles
./listfiles .
```
