# java.lang.reflect.Array

- a convenience facility for performing reflective operations on all array objects

```java
int length = Array.getLength(obj);

Array.get(obj, i); // obj[i]

Array.newInstance(String.class, 5); // new String[5]
Array.newInstance(String[].class, 5); // new String[][5]

Array.newInstance(String.class, new int[] { 2, 3 }); // new String[2][3]
```
