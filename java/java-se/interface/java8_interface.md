## Before Java 8

- Interfaces are written in stone
- Interfaces are locked
- Backward compatibility is a must
- Libraries are getting aged
- Functional style

## Interface Unlocking

- New methods can be added
- Existing methods can be deleted
- Interface is reborn
- Functional Interface introduced
- Default methods
- Static methods

### Functional Interface

- One abstract method
- Target type of lambda must be a functional interface
- @FunctionalInterface
- Thanks to the annotation, compiler will complain in case of adding a new method
- Default and static methods can be added

```java
@FunctionalInterface
public interface Employee {
  // abstract method
  Employee find(int id);

  // default method : instance method
  default boolean isExec(int id) { return true; }

  // static method  : class method
  static String getDefaultCountry() { return "NoWhere"; }
}
```

### Default and Static Methods
 
#### Default Methods

- Adding new methods to existing interfaces
  - Use new types and provide new functionality
- For every declared interface method there must be an implementation
  - Normally it is required to provide those method in implementation
- Methods added to interfaces would be missing in implementations
  - You couldnt write a method you didnt know would be needed
- What if new method declarations came with default implementations
  - "If you cannot afford a method one will be provided for you"

- Use new default method attribute
- Can call other interface methods, public static methods and constructors
- Throw exceptions

```java
public default boolean isEmpty() { return size() == 0; }
public default Rectangle makeRect() { return new Square(); }
public default forEach(Consumer<? extends E> consumer) {
  for (E e : this) { consumer.consume(e); }
}
```

- Cannot be any of the Object methods(toString)
- Cannot access directly access instance state
- Has no knowledge of synchronozation protocol
- Luckily(much) less efficient than possible implementations

### Inheriting Behavior

- Implementing two interfaces with same default methods.


```java
interface Engine {
  default String make() { return "DEFAULT MAKE"; }
}

interface Vehicle {
  default String model() { return "DEFAULT MODEL"; }
}

class Car implements Engine, Vehicle {
  String makeAndModel() {
    return Engine.super.make() + Vehicle.super.model();
  }
}
```

### Multiple Inheritance

* Four rules of default methods:

1. You get what is in the base interface
2. You may override a default method
3. If a method is there in the class hierarchy then it takes precedence
4. If there is no method on any of the classes in the hierarchy, but two of your
   interfaces that you implement has the default method.(Collision) To solve
   this use rule 3.


## Java 8 Interface vs Abstract Class

### Both Interface and Abstract Class in Java 8

- Partial Implementation
- Cannot be instantiated
- No independence
- Deriving state and behavior expected
- Fields and method structures vary

### Abstract Classes
- Instance fields and methods
- Any access modifiers(public, private, protected, static, final, non-final)

### Interfaces
- Restricted access modifiers
- public static and final
- Implicit access

#### When to Use

* Abstract class strategy (resuing state)
  - common functionality
  - related class groups
  - inherit state and behavior

* Interface strategy (reusing behavior)
  - multiple types
  - logic from many interfaces
  - inherit behavior

