# Method Handles

- Java 7 introduced a new API for invoking methods indirectly.
- java.lang.invoke
- Method handles
- Could be thought of as a more modern approach to reflection
- Method handles were produced as part of the project to bring invokedynamic to the JVM.

## MethodHandle

- An object that repesents the ability to call a method safely.
- A bit like reflection and a bit like Callable interface
- Callable is an earlier attempt to model the ability to call a method.
- The problem with Callable is that it can only model methods that take no arg.
- MH can model any method signature, without needing to produce a vast number of small classes.
- MethodType class

## MethodType

- Is a immutable object that represents the type signature of a method
- Every MH has a MethodType instance that includes the return type and the argument types.

```java
MethodType mtToString = MethodType.methodType(String.class);
MethodType mtSetter = MethodType.methodType(void.class, Object.class);
MethodType mtStringComparator = 
           MethodType.methodType(int.class, String.class, String.class);

// MethodType.methodType(RetType.class, Arg0.class, Arg1.class, ...);
```
