# Local-Variable Syntax for Lambda Parameters

- In java 11, usage of var keyword is unified

```java
(String a, String b) -> a.concat(b)
// could leave out the types
(a, b) -> a.concat(b)

// were not able to use var in lambda in java 10
(var a, var b) -> a.concat(b) // same as leaving out the type
```

- We could want to use var before the variable, in order to be able to annotate

```java
(@Nonnull var a, @Nullable var b) -> a.concat(b) // same as leaving out the type
```

### Limitations


```java
// illegal usage
(var a, b) -> a.concat(b)
(var a, String b) -> a.concat(b)
// a -> a.concat(b)
var a -> a.concat(b)
```
