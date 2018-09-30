# unnamed module

- when the classpath is loaded, a module is constructed called the unnamed module

- all jar files with their containing classes are loaded as if they are part of
  this unnamed module

- the unnamed module is a very special module inside the JVM

- it automatically gets dependencies to the modules in the modular JDK

- applications in the classpath are still allowed to access the encapsulated
  types in JDK. This is done only to maintain backward compatibility.


```java
// code using encapsulated types is compiles using java 8
// compiles with warning
// compiled code runs on java9 (backward compatibility)
java --illegal-access=permit Main
JAVA9_HOME/bin/java --illegal-access=deny Main // IllegalAccessError

// same source code does not compiles using java 9
// have to play by java 9 rules if you want to compile your code
javac --add-exports java.base/sun.security.X5009=ALL-UNNAMED Main
```

* permit is the default value. Prints out warnings, could be changed in the future
