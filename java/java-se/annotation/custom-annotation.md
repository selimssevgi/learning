# Custom Annotation

- annotation methods cant have parameters
- annotation methods return types are limited to primitives, String, Enum, Annotation, or array of these


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


```java
@interface ClassPreamble {
  // annotation type element declarations
   String author();
   int currentRevision() default 1;
   String lastModified() default "N/A";
   String[] reviewers();
}

@ClassPreamble (
  author = "John",
  currentRevision = 6,
  lastModified = "01/01/2000",
  reviewers = {"A", "B", "C"}
)
public class Test {}
```
