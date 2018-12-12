# Modifier

- Each modifier in Java is assigned a bit in the 'int' returned by getModifiers

- Modifier is convenience class to decode the return value of getModifiers

```shell
static boolean isPublic(int mod)
static boolean isStatic(int mod)
//...
```


```java
System.out.println(Modifier.toString(Member.class.getModifiers()));
// public abstract interface
```

- May seem wierd for java language, but does not violate JLS.
