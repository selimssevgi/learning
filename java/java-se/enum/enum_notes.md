# Enum (Enumaration) (V1.5)
If we want to represent a group of named constants, then we should go for enum.

```java
enum Month {
  JAN, FEB, MAR,..DEC;
}
```


```java
enum Beer {
  KF, KO, RC, FO;
}
```

Semicolon is optional.

The main objective of enum is, to define our own data types(enumarated data
type,EDT).


Enum concept introduced in 1.5V. When compared with old languages enum, Java
Enum is more powerful.

## Internal Implementation of Enum

1. Every enum is internally implemented by using class concept.

2. Every enum constant is always public static final.

3. Every enum constant represents an object of type enum.


```java
enum Beer {
  KF, RC;
}

class Beer {
  public static final KF = new Beer();
  public static final RC = new Beer();
}
```

## Enum Declaration and Usage
Every enum contant is always public static final. Hence we can access enum
constant by using enum name.

```java
enum Beer {
  KF, KO, RC, FO;
}

class Test {
  public static void main(String[] args) {
    Beer b = Beer.RC; // RC --> Object, b --> Same object
    System.out.println(b); // RC
  }
}
```

**NOTE:** Inside enum toString() method is internally implemented to return the
name of the constant.


We can declare enum either within the class or outside of the class but not
inside a method.(no static declaration(static inner class) inside method).
If we are trying to declare inside a method, we will get CE: Enum types must not be local.


```java
// outside of class : valid
enum X {}
class Y {}
```

```java
// inside of class : valid
class X {
  enum Y {}
}
```

```java
// inside a method : CE: enum types must not be local.
class X {
  public void m1() {
    enum Y {  }
  }
}
```

If we declare enum outside of class, the applicable modifiers are:

- public
- default
- strictfp

If we declare enum inside a class, the applicable modifiers are:

- public
- default
- strictfp
- private
- protected
- static

**NOTE:** enum is implicitly final. We cannot use final explicitly though. final
and abstract are illegal combination.

## enum vs switch()
Until 1.4V the allowed argument types for switch statement are:

- byte, short, char, int

from 1.5V onwards, corresponding wrapper classes and enum types are allowed.

from 1.7V onwards, String type is also allowed.

Hence from 1.5V onwards, we can pass enum type as argument to switch statement.

```java
enum Beer {
  KF, KO, RC, FO;
}

class Test {
  public static void main(String[] args) {
    Beer b = Beer.KF;

    switch(b) {
      case KF:
        System.out.println("It is for children.");
        break;
      case KO:
        System.out.println("it is too light");
        break;
      case RC:
        System.out.println("it is not that much kick");
        break;
      case FO:
        System.out.println("but one get one free");
        break;
      default:
        System.out.println("others are not recommended");
    }
  }
}
```

**NOTE:** If we pass enum type as argument to switch statement, then every case
label should be valid enum constant. Otherwise, we will get compile time error.

```java
switch(b) {
  case KF:
  case KO:
  case RC:
  case FO:
  case KALYANI: // CE: unqualified enumaration constant name required
}
```

## enum vs inheritance
Every enum is always direct child class of java.lang.Enum, and hence our enum
cannot extend any other enum(because java wont provide support for multiple
inheritance).

Every enum is always final implicitly, and hence for our enum, we cannot create
child enum.

Because of above reasons, we can conclude that inheritance concept is not
applicable for enum explicitly, and we cannot use extends keyword for enum.


```java
enum X {}

enum Y extends X {
  //!! enum cannot use extends keyword
}
```

```java
enum X extends java.lang.Enum {
  //!! cannot even extends Enum class explicitly.
}
```

```java
class X {}

enum Y extends X {
  //!! multiple inherence not allowed
}
```

```java
enum X {}

class Y extends X {
  // CE: cannot inheret from final X(enum is final implicitly)
  // CE: enum types are not extensible
}
```

Anyway an enum can implement any number of interfaces.

```java
interface X {}

enum Y implements X {}
```

## java.lang.Enum

1. Every enum in Java is direct child class of java.lang.Enum. Hence this class
   acts as base class for all java enums.

2. It is an abstract class and direct child class of Object.

3. It implements Serializable(I) and Comparable(I).

### values() method
Eery enum implicitly contains values() method to list all values present inside enum.

```java
Beer[] beers = Beer.values();
```

**NOTE:** values() method not present in java.lang.Enum and Object classes. Enum
keyword implicitly provides this method.

### ordinal() method
Inside enum order of constants is important. We can represent this order by
using ordinal value. WE can find ordinal value of enum constant by using
ordinal() method.

```java
public final int ordinal() { return ordinal; }
```

Ordinal value is zero based like array index.

```java
enum Beer {
  KF, KO, RC, FO;  
}

class Test {
  public static void main(String[] args) {
    Beer[] beers = Beer.values();

    for (Beer b : beers) {
      System.out.println(b + "...." + b.ordinal());
    }
  }
}

// KF....0
// KO....1
// RC....2
// FO....3
```

## Speciality of Java Enum
In old languages enum, we can take only constants. But in Java Enum, in addition
to constants we can take methods, constructors, normal variables etc. Hence Java
Enum is more powerful than old languages enum.

Even inside Java Enum we can declare main method and we can run enum class
directly from command prompt.

```java
enum Fish {
  STAR, GOLD, GUPPY;

  public static void main(String[] args) {
    System.out.println("enum main method");
  }
}

// o/p: enum main method
```

**NOTE:** In addition to constants, if we are taking any extra member like
method, then list of constants should in the first line and should end with
semicolon.

```java
enum Fish {
  STAR, GOLD; // semicolon is mandatory

  public void m1() {}
}
```

```java
enum Fish {
  public void m1() {}

  STAR, GOLD; //invalid: list of constants should be on the first line
}
```

**NOTE:** Inside enum if we are taking any extra member like method, compalsory
first line should contain list of constant, at least semicolon.

```java
enum Fish { // invalid!!
  public void m1() {

  }  
}
```

```java
enum Fish {
  ; // at least semicolon, valid
  public void m1() {

  }  
}
```

Anyway an empty enum is valid java syntax.

```java
enum Fish {
  // valid
}
```

## enum constructors
- An enum can contain constructor. 

- Enum constructor will be executed separately for every enum constant at the time
of enum class loading automatically.

```java
enum Beer {
  KF, KO, RC, FO;

  Beer() {
    System.out.println("enum constructor");  
  }
}

class Test {
  public static void main(String[] args) {
    System.out.println("hello");
  }  
}

// javac Test.java
// Beer.class Test.class
// java Test
hello
```

```java
enum Beer {
  KF, KO, RC, FO; // final static, initialized during class loading

  Beer() {
    System.out.println("enum constructor");  
  }
}

class Test {
  public static void main(String[] args) {
    Beer b = Beer.RC; // LINE1
    System.out.println("hello");
  }
}

// javac Test.java
// Beer.class Test.class
// java Test
enum constructor
enum constructor
enum constructor
enum constructor
hello
```
If we comment LINE1, then the output is 'hello'.


We cannot create enum object directly, hence we cannot invoke enum constructor
directly.

```java
Beer b = new Beer(); // CE: enum type may not be instantiated
```

##### A Fully Enum Example


```java
KF     --> public static final Beer KF = new Beer();
KF(70) --> public static final Beer KF = new Beer(70);
```


```java
enum Beer {
  KF(70), KO(80), RC(90), FO;

  Beer(int price) {
    this.price = price;  
  }

  Beer() {
    this.price = 65; // default price  
  }
  
  public int getPrice() {
    return price;
  }
}

class Test {
  public static void main(String[] args) {
    Beer[] beers = Beer.values();

    for (Beer b : beers) {
      System.out.println(b + "..." + b.getPrice()); 
    }
  }  
}

// KF...70
// KO...80
// RC...90
// FO...65
```

**NOTE:** Inside enum we can declare methods but should be concreate methods
only. We cannot declare abstract methods.

## Case 1: methods
Every enum constant represet an object of type enum. Hence whatever methods we
can apply on normal java objects, can be applicable on enum constants also.

```java
Beer.KF.equals(Beer.RC) // valid
Beer.KF.hashCode() > Beer.RC.hashCode() // valid
Beer.KF < Beer.RC // invalid : student1 < student2 : meaningless
Beer.KF.ordinal() < Beer.RC.ordinal() // valid : two integer values
```
## Case 2: static and normal import
If we want to use any class or interface directly from outside package, then
required import is normal import.

If we want to access static members without class name, then the required import
is static import.

```java
import static java.lang.Math.sqrt;
import java.util.ArrayList;

class Test {
  public static void main(String[] args) {
    ArrayList al = new ArrayList();
    System.out.println(sqrt(4));
  }  
}
```


```java
package pack1;

public enum Fish {
  STAR, GUPPY;
}
```

```java
package pack2;

public class Test {
  public static void main(String[] args) {
    Fish f = Fish.GUPPY;
    System.out.println(f);
  }
}

// we need normal import to compile above class
// import pack1.Fish;
// import pack1.*;
```

```java
package pack3;

public class Test {
  public static void main(String[] args) {
    System.out.println(STAR);
  }
}

// we need static import, because of direct access
// import static pack1.Fish.STAR;
// import static pack1.Fish.*;
```

```java
package pack4;

public class Test {
  public static void main(String[] args) {
    Fish f = Fish.STAR;
    System.out.println(GUPPY);
  }  
}

// access with and without class name, requried imports:
// import pack1.Fish;
// or
// import pack1.*;
// import static pack1.Fish.GUPPY;
// or
// import static pack1.Fish.*;
```

## Case 3:

```java
enum Color {
  BLUE, RED, GREEN;

  public void info() {
    System.out.println("universal color");  
  }
}

class Test {
  public static void main(String[] args) {
    Color[] colors = Color.values();

    for (Color c : colors) {
      c.info();
    }
  }  
}

// o/p:
// universal color
// universal color
// universal color
```

// anonymous class in enum, overriding

```java
enum Color {
  BLUE, RED {
    public void info() {
      System.out.println("dangerous color");  
    }
  }, GREEN;

  public void info() {
    System.out.println("universal color");  
  }
}

class Test {
  public static void main(String[] args) {
    Color[] colors = Color.values();

    for (Color c : colors) {
      c.info();
    }
  }  
}

// o/p:
// universal color
// dangerous color
// universal color
```

## Case 4: enum vs Enum vs Enumaration

- enum: is a keyword in java, which can be used to define a group of named
  constants.

- Enum: is a class in java present java.lang package. Every enum in java should
  be direct child class of Enum class. Hence, this class acts as base class for
  all java enums.

- Enumaration: is an interface present java.util package. We can use enumaration
  object to get objects one by one from the collection.
