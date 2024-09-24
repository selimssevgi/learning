# java 17 - lts

- pattern matching for switch - preview
    - switch accepts objects now, not only string or enum

- sealed classes finalized

```java
public abstract sealed class Shape
    permits Circle, Rectangle, Square {...}
```

- foreign function & memory api (incobator) - alternative to JNI, native calls

- deprecating security manager
