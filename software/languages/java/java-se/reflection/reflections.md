# Reflection Notes

- Code that can examine itself and even change itself runtime
- Metaprogramming
- Code treating code like data


## 3 ways to get class object

1. Class.forName("full.package.name"); // throws ClassNotFound

2. object.getClass()

3. ClassName.class (represent the class object)

## Getting Information about class

```shell
String getName()
Class getSuperClass()
Class[] getInterfaces()
int getModifier() // Modifier.toString(int)

Field fields = c.getFields();
Field fields = c.getDeclaredFields();
```
