# Effective Java Notes

Item 1: Consider static factory methods instead of constructors
Item 2: Consider a builder when faced with many constructor parameters
Item 3: Enforce the singleton property with a private constructor or an enum type
Item 4: Enforce noninstantiability with a private constructor
Item 5: Avoid creating unnecessary objects
Item 6: Eliminate obsolete object references
Item 7: Avoid finalizers

Item 8: Obey the general contract when overriding equals
Item 9: Always override hashCode when you override equals
Item10: Always override toString
Item11: Override clone juduciously
Item12: Consider implementing Comparable

Item13: Minimize the accessibility of classes and members
Item14: In public classes, use accessor methods, not public fields
Item15: Minimize mutability
Item16: Favor composition over inheritance
Item17: Design and document for inheritance or else prohibit it
Item18: Prefer interface to abstract classes
Item19: Use interfaces only to define types
Item20: Prefer class hierarchies to tagged classes
Item21: Use function objects to represent strategies
Item22: Favor static member classes over nonstatic

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
// Signleton with private final field
public class Elvis {
  private static final Elvis INSTANCE = new Elvis();
  private Elvis() { //... }

  public static Elvis getInstage() { return INSTANCE; }
}
```

- Above two approaches have security flaw(invoking even private constructor) and
  have problems with serialization(extra programmer effort needed)

- Enum singleton approach solves both problems. A single-element enum type is the best
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

- The best way to eliminate an obsolete reference is to let the variable that
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

### Chapter 3: Methods Common to All Objects
- Although Object is concrete class, it is designed primarily for extension.

- All non-final methods (equals, hashCode, toString, clone, finalize) have
  explicit general contracts because they are designed to be overridden.

#### Item 8: Obey the general contract when overriding *equals*

- The easiest way to avoid problems is not to override the equals method, in
  whic case each instance of the classs is equal only itself. Conditions:

- *Each instance of the class is inherently unique*.
- *You dont care whether the class provides a "logical equality" test*.
- *A superclass has already overridden equals, and the superclass behaviour is appropriate for this class*.
- *The class is private or package-private and you are certain that its equals method will never be called*.

- It is a good idea to override equals method for value classes(Integer, Date).

##### Conract of Object#equals()
- Reflexive: x.equals(x) must return true.
- Symmetric: x.equals(y) return true if and only if y.equals(x) returns true.
- Transitive: x.equals(y) and y.equals(z) then x.equals(z)
- Consistent: multiple invocations must return same result.
- x not null, x.equals(null) must return false.

[Too long and important, refer back!]

#### Item 9: Always override hashCode when you override equals

- You must override hashCode in every class that overrides equals. Failure to do
  so will result in a violation of the general contract for Object.hashCode.

- The key provision that is violated when you failt to override hashCode is the
  second one: equal objects must have equal hash codes.

- If a class is immutable and the cost of computing the hash code is
  significant, you might consider caching the hash code in the object rather
  than recalculating it each time it is requested.

```java
// Lazily initialized, cached hashCode
private volatile int hashCode; // (See Item 71)
@Override public int hashCode() {
  int result = hashCode;
  if (result == 0) {
    result = 17;
    result = 31 * result + areaCode;
    result = 31 * result + prefix;
    result = 31 * result + lineNumber;
    hashCode = result;
  }
  return result;
}
```

#### Item 10: Always override toString
- Providing a good toString implementation makes your class much more pleasant
  to use.

- When practical, the toString method should return all of the interesting
  information contained in the object.

- Whether or not you decide to specify the format, you should clearly document
  your intentions.

- Provide programmatic access to all the information contained in the value
  returned by toString.(so others wont parse the string)

#### Item 11: Override clone judiciously
[read it again!]

#### Item 12: Consider implementing Comparable

- It is similar in character to Object's equals method, except that it permits
  order comparisons in addition to simple equality comparisons, and it is generic.

- By implementing Comparable(I), a class indicates that its instances have a
  natural ordering.

- If you are writing a value class with an obvious natural ordering, such as
  alphabetical order, numerical order, or chronological order, you should
  strongly consider implementing the interface:

```java
public interface Comparable<T> {
  int compareTo(T t);
}
```

- Just as a class that violates the hashCode contract can break other classes
  that depend on hashing, a class that violates the compareTo contract can break
  other classes that depend on comparison.

### Chapter 4: Classes and Interfaces

#### Item 13: Minimize the accessibility of classes and members

- Make each class or member as inaccessible as possible.

- By making a class package-private, you make it part of the implementation
  rather than the exported API.

- Instance fields should never be public. Just final primitives or final
  immutable reference variables might be public.

- Classes with public mutable fields are not thread-safe.

#### Item 14: In public classes, use accessor methods, not public fields

- If a class is accessible outside of its package, provide accessor methods, to
  preserve the flexibility to change the class's internal representation.

- If a class is package-private or is a private nested class, there is nothing
  inherently wrong with exposing its data fields.

#### Item 15: Minimize mutability
To make a class immutable, follow these five rules:

- Don't provide any methods that modify the object's state(mutators)
- Ensure that the class can't be extended.(final class)
- Make all fields final.
- Make all fields private.
- Ensure exclusive access to any mutable components.(defensive copies)

- In functional approach, methods return the result of applying a function to
  their operand without modifying it. In procedural or imperative approach,
  methods return apply a procedure to their operand, causing its state to change.

- Immutable objects are simple.

- Immutable objects are inherently thread-safe; they require no synchronization.

- Immutable objects can be shared freely.

- Immutable objects make great building blocks for other objects.

- The only real disadvantage of immutable classes is that they require a
  separate object for each distinct value.

- Classes should be immutable unless there is a very good reason to make them mutable.

- If a class cannot be made immutable, limit its mutability as much as possible.

- Make every field final unless there is a compelling reason to make it nonfinal.

#### Item 16: Favor composition over inheritance

- Forwarding: In composition, there may be referenced field to instance of an
  existing class. Each instance method in the new class invokes the
  corresponding method on the contained instance of the existing class and
  returns the results. And methods in the new class are known as *forwarding methods*.

- *Decorator pattern*: the InstrumentedSet class "decorates" a set by adding
  instrumentation.

- Sometimes the combination of composition and forwarding is loosely refered to
  as *delegation*.

#### Item 17: Design and document for inheritance or else prohibit it
#### Item 18: Prefer interface to abstract classes

- Interfaces are ideal for defining mixins.

- a *mixin* is a type that a class can implement in addition to its "primary
  type" to declare that it provides some optional behavior. For example,
  Comparable is a mixin interface. It allows the optional functionality to be
  "mixed in" to the type's primary functionality.

- Interfaces allow the construction of nonhierarchial type frameworks.

- Interfaces enable safe, powerful functionality enhancements via the wrapper idiom.

- You can combine the virtues of interfaces and abstract classes by providing
  an abstract *skeletal implementation* class to go with each nontrivial interface.

- Skeletal implementations(AbstractInterface): AbstractCollection, AbstractSet, 
  AbstractList, AbstractMap.

#### Item 19: Use interfaces only to define types

- They should be used to define "types".

- *Constant interface:* contains no methods; it consists solely of static final
  fields, each exporting a constant.

- The constant interface pattern is a poor use of interfaces.

#### Item 20: Prefer class hierarchies to tagged classes

- Tagged classes are verbose, error-prone, and inefficient.

- A tagged class is just a pallid imitation of a class hierarchy.

#### Item 21: Use function objects to represent strategies

- Strategy Pattern: the comparator function represents a strategy for sorting
  elements.

- It is possible to define an object whose methods perform operations on other
  objects, passed explicitly to the methods. An instance of a class that exports
  exactly one such method is effectively a pointer to that method. Such
  instances are known as *function objects*.

- java.util.Comparator

#### Item 22: Favor static member classes over nonstatic

- A nested class should exist only to serve its enclosing class.

- If you declare a member class that does not require access to an enclosing
  instance, always put the static modifier in its declaration.

