# StackWalker

- before java 9

- Low performance
- No guarantee all stack elements are returned
- No partial handling possible

```java
StackTraceElement[] stackTrace =
  new Throwable().getStackTrace();

// or
StackTraceElement[] stackTrace =
  Thread.getStackTrace();
```

- with java 9

- StackWalker#walk -> StackFrame
- StackWalker#forEach

```java
StackWalker stackWalker = StackWalker.getInstance();
stackWalker.forEach(System.out::println);
```
