# java.lang.reflect.AccessibleObject

- Java access checks could suppressed.

- This suppression allows for reflective code to access protected, package, and
  private data that would otherwise be unreachable.

- Setting objects as accessible can be disabled in the security manager

- it is parent class of both Field and Method.

```java
field.setAccessible(true); // disables all runtime access checks on this field
```

```java
if (!Modifier.isPublic(field.getModifiers())) {
  field.setAccessible(true);
}
Object value = field.get();
```
