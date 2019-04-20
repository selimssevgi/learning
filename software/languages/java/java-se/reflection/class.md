# java.lang.Class

- Class objects(java.lang.Class) are the most important kind of metaobject
  because all Java programs consist solely of classes (Object.getClass)

* getMethod(String name, Class... parameterTypes) // declared/inherited/public
* getMethods() // all visibilities
* getDeclared(String name, Class... parameterTypes)
* getDeclaredMethods()


## Representing primitive types

```shell
public Object get(int index);
getMethod("get", ??)
```

- Although primitives are not objects at all, Java uses class objects to represent all 8 primitive types

```java
Method m = Vector.class.getMethod("get", int.class);

int.class.isPrimitive(); // true
void.class.isPrimitive(); // true
```

## Representing interfaces

```java
public boolena addAll(Collection c);
Vector.class.getMethod("addAll", Collection.class);

Collection.class.isInterface(); // true
```

## Representing Array types

- Java arrays are objects, but their classes are created by the JVM at runtime

- A new class is created for each element type and dimension.

```java
Method m = Vector.class.getMethod("copyInto", Object[].class);

Object[].class.isArray(); // true
int[][].class.getComponentType();
// component type int[].class
// element type int
```

## Instrospecting the inheritance hierarchy

- Class[] getInterfaces()
- Class getSuperclass()
- boolean isAssignableFrom(Class)
- boolean isInstance(Object)         // instanceof


```java
// reflective circularity
Class.class.isInstance(Class.class); // true, circular instanceof dependency

Class.class.isInstance(Object.class); // true
Object.class.isAssingableFrom(Class.class); // true
```

## forName

- The big difference between using forName and a class literal is that forName
  does not require name of the class at compile time.

- although there are not class files for arrays, forName can still be used to
  obtain their class objects.

```java
Class.forName("java.lang.String[]"); // ClassNotFoundException
```

- most class objects respond to getName with a compilable Java class name.
  Generated array classes do not.


```java
sout(String[].class.getName());
Class.forName("[Ljava.lang.String;");
```

```shell
B                 -> byte
C                 -> char
D                 -> double
F                 -> float
I                 -> int
J                 -> long
L<element-type>;  -> reference type
S                 -> short
Z                 -> boolean
```

- forName throws exception for primitive types

```java
Class.forName(char.class.getName()); // ClassNotFoundException
```
