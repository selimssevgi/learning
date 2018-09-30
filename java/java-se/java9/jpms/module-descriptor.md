# Module Descriptor

- A module has a 'name', it 'groups' related code and is 'self-contained'

* Are JAR file modules? (NO)

- They have a (file)name
- JARs group related code
- No explicit dependencies(weak boundaries)
- Can be pick up anything from classpath(fragile)

## Encapsulation

- module name (java.base)
- public, exported (java.lang, java.util)
- private, encapsulated (sun.util, jdk.internal)

```java
// module-info.java
module java.base {
  exports java.lang;
  exports java.util;
  exports java.io;
  // and more
}
```

```java
// module-info.java
module java.sql {
  exports java.sql;
  exports javax.sql;

  requires java.logging;
  requires java.xml;
}
```

* module, exports, requires are keywords only in context of a module-info. Can
  use this names in normal source code freely
