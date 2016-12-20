# Effective Java Notes

Item 1: Consider static factory methods instead of constructors
Item 2: Consider a builder when faced with many constructor parameters
Item 3: Enforce the singleton property with a private constructor or an enum type
Item 4: Enforce noninstantiability with a private constructor
Item 5: Avoid creating unnecessary objects
Item 6: Eliminate obsolete object references
Item 7: Avoid finalizers


### Chapter 1

- A few fundamental principles:
  - Clarity and simplicity are of paramount importance.
  - The user of a module should never be surprised by its behavior.
  - Modules should be as small as possible but not smaller.
  - Code should be reused rather than copied.
  - The dependencies between modules should be kept to a minimum.
  - Errors should be detected as soon as possible after they are made, ideally
    at compile time.

- The language supports four kinds of types:
  - Interface (including annotations)
  - Classes (including enums)
  - Arrays
  - Primitives

- package-private = default access

### Chapter 2: Creating and Destroying Objects

#### Item1: Consider static factory methods instead of constructors

```java
public static Boolean valueOf(boolean b) {
  return b ? Boolean.TRUE : Boolean.FALSE;
}
```

- One advantage of static factory methods is that, unlike constructors, they
  have names.

- A second advantage of static factory methods is that, unlike constructors,
  they are not required to create a new object each time they are invoked.

- A third advantage of static factory methods is that, unlike constructors, they
  can return an object of any subtype of their return type.

- A fourth advantage of static factory methods is that, unlike constructors,
  they reduce the verbosity of creating parameterized type instances.

```java
Map<String, List<String>> m = new HashMap<String, List<String>>();

// static factory method
public static <K, V> HashMap<K, V> newInstance() {
  return new HashMap<K, V>();
}

Map<String, List<String>> m = HashMap.newInstance();
```

- The main disadvantage of providing only static factory methods is that classes
  without public or protected constructors cannot be subclassed.

- A second disadvantage of static factory methods is that they are not readily
  distinguisable from other static methods.

#### Item2: Consider a builder when faced with many constructor parameters

- The telescoping constructor pattern(calling this in a constructor) works, but
  it is hard to write client code when they are many parameters, and harder
  still to read it.

- A JavaBean may be in an inconsistent state partway through its construction.

- JavaBeans Pattern precludes the possibility of making a class immutable.

- Builder Pattern combines the safety of the telescoping constructor pattern 
  with the readability of the JavaBeans pattern.

- The Builder Pattern simulates named optional parameters as found in Ada and Python.

- The Builder Pattern is a good choice when designing class whose constructors
  or static factories would have more than a handful of parameters(4 or 5 or more)

#### Item3: Enforce the singleton property with a private constructor or an enum tpye

- Making a class a singleton can make it difficult to test its clients, as it is
  impossible to subsituate a mock implementation for a signleton.

```java
// Signleton with public final field
public class Elvis {
  public static final Elvis INSTANCE = new Elvis();
  private Elvis() { //... }
}
```

```java
// Signleton with public final field
public class Elvis {
  private static final Elvis INSTANCE = new Elvis();
  private Elvis() { //... }

  public static Elvis getInstage() { return INSTANCE; }
}
```

- Above two approaches have security flaw(invoking even private constructor) and
  have problems with serialization(extra programmer effort needed)

- Enum singleton approach both problems. A single-element enum type is the best
  way to implement a singletion.

```java
// Enum singleton - the preferred approach
public enum Elvis {
  INSTANCE;
}
```

#### Item 4: Enforce noninstantiability with a private constructor

- You will want to write a class that is just grouping of static methods and
  static fields. Like java.lang.Math, java.util.Arrays, java.util.Collections.

- Such utility classes were not designed to be instantiated.

- Attempting to enforce noninstantiability by making a class abstract does not
  work. Subclassed. Instantiated subclass!.

- A default constructor is generated only if a class contains no explicit
  constructors, so a class can be made noninstantiable by including a private
  constructor:

```java
// noninstantiable utility class
public class UtilityClass {
  // supress default constructor for noninstantiability
  private UtilityClass() {
    throw new AssertionError(); // it should NOT come here
  }
}
```
- Because of private constructor the class cannot be subclassed, any subclass
  has to call superclass constructor implicity or explicity.

#### Item 5: Avoid creating unnecessary objects


```java
String s = new String("stringette") // DONT DO THIS!
String s = "stringette"; // SCP, it will be reused
```

- Creating additional objects to enhance the clarity, simplicity, or power of
  program is generally a good thing.

- Avoiding object creation by maintaining your own object pool is a bad idea
  unless the objects in the pool are extremely heavyweight.

#### Item 6: Eliminate obsolete object references

```java
public Object pop() {
  if (size == 0)
    throw new EmptyStackException();
  Object result = elements[--size];
  elements[size] = null; // Eliminate obsolete reference
  return result;
}
```

- Nulling out object references should be the exception rather than the norm.

- The besy way to eliminate an obsolete reference is to let the variable that
  contained reference fall out of scope. This occurs naturally if you define
  each variable in the narrowest possible scope.

- Whenever a class manages its own memory, the programmer should be alert for
  memory leaks.

- Another common source of memory leaks is caches..., present the cache as a
  WeakHashMap; entries will be removed automatically after they become obsolete.

- A third common source of memory leaks is listeners and other callbacks.

#### Item 7: Avoid finalizers

- Finalizers are unpredictable, often dangerous, and generally unnecessary.

- There is no guarantee when the finalizer will be executed. This means that you
  should never do anything time-critical in a finalizer.

- You should never depend on a finalizer to update critical persistent state.

- There is a severe performance penalty for using finalizers.

- So what should you do instead of writing a finalizer for a class whose objects
encapsulate resources that require termination, such as files or threads? Just
provide an explicit termination method, and require clients of the class to invoke
this method on each instance when it is no longer needed. One detail worth 
mentioning is that the instance must keep track of whether it has been terminated:
the explicit termination method must record in a private field that the object is no
longer valid, and other methods must check this field and throw an
IllegalStateException if they are called after the object has been terminated.

- Explicit termination methods are typically used in combination with the
  try-finally construct to ensure termination.

```java
// try-finally block guarantees execution of termination method
Foo foo = new Foo(...);
try {
  // Do what must be done with foo
  ...
} finally {
  foo.terminate(); // Explicit termination method
}
```

- It is important to note that “finalizer chaining” is not performed
  automatically. If a class (other than Object ) has a finalizer and a subclass
  overrides it, the subclass finalizer must invoke the superclass finalizer manually.

```java
// Manual finalizer chaining
@Override protected void finalize() throws Throwable {
  try {
    ... // Finalize subclass state
  } finally {
    super.finalize();
  }
}
```
