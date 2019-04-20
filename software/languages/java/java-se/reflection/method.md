# java.lang.reflect.Method


- Class getDeclaringClass
- Class getReturnType
- Class[] getExceptionTypes
- Class[] getParameterTypes
- Object invoke(Object obj, Object... args)
- int getModifiers()

## Dynamic invocation

- Enables a program to call a method on an object at runtime without specifying
  which method at compile time.


```java
method.invoke(obj, color);

method.invoke(null, color); // static method invocation

method.invoke(obj, null); // a method with no parameters
method.invoke(obj);       // a method with no parameters
```

## Using primitives with dynamic invocation

- parameters or return type can be primitive types
- use wrapper classes for parameter types
- return value will be wrapped if is primitive
- return value will be null if it is void method

**NOTE:** Cannot cache an method and call on every other object. For example,
hashCode is defined on every object, but one hashCode get from a class
definition will not work with another. Because in Java, each method is
identified by both its signature and its declaring class.

```shell
Method hashCode = String.class.getMethod("hashCode");
hashCode.invoke(5);
// IllegalArgumentException: object is not an instance of declaring class
```

- If any exception is thrown by the method being invoked that exception is
  wrapped in an InvocationTargetException and then thrown.


## Find methods in superclasses

- getMethod will not find methods defined protected in superclasses

```java
private static Method getSupportedMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) throws NoSuchMethodException {
  if (clazz == null) {
    throw new NoSuchMethodException("method not found");
  }

  try {
    return clazz.getDeclaredMethod(methodName, paramTypes);
  } catch (NoSuchMethodException nsme) {
    return getSupportedMethod(clazz.getSuperclass(), methodName, paramTypes);
  }
}
```
