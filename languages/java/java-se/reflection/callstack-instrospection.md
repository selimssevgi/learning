# Performing Call stack instrospection

- Callstack introspection allows a program to obtain information about its
  static context including class name, method name, and program line number.

```java
new Throwable().getStackTrace(); // StackTraceElement[]
// 0 is top of the stack, the last element is the bottom of the stack
```

- the first StackTraceElement represent the most recent method invocation


```java
// in static method
this.getClass().getName(); // does not work, no this in static

// now get the class name in static context
(new Throwable()).getStackTrace()[0].getClassName();
```

- we may introspect the callstack for recursive calls, and break it
