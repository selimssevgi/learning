# Multi-catch Exceptions

* before java 7

```java
try {
  Arithmetic.class.newInstance();
} catch (InstantiationException e) {
  e.printStackTrace();
} catch (IllegalAccessException e) {
  e.printStackTrace();
}
```
* with java 7, the exception types must be siblings to be used in this way.

```java
try {
  Arithmetic.class.newInstance();
} catch (InstantiationException | IllegalAccessException e) {
  e.printStackTrace();
}
```
