# How to Create Annotation


```java
@Retention(RetentionPolicy.SOURCE) // discarded by compiler
@Retention(RetentionPolicy.CLASS)  // DEFAULT, recorded in class, need not be retained by VM
@Retention(RetentionPolicy.RUNTIME)// recorded in class file, retained by VM at runtime
public @interface MyAnnotation {
  String value();
  int age();
}

// Usage
@MyAnnotation(value = "Test", age = 6)
```
