# Interfaces

- Introduction
- Interface Declaration & Implementation
- extends vs implements
- Interface Methods
- Interface Variables
- Interface Naming Conflicts
  - Method naming conflicts
  - Variable naming conflicts
- Marker Interface
- Adapter Classes
- interface vs abstract class vs concrate class
- Differences between Interface and Abstract Classes
- Conclusions

## Introduction

1. Definition
Any service requirement specification(SRS) is considered as an interface.

EX1:
JDBC API acts as requirement specifications to develop database driver. Database
vendor is responsible to implement JDBC API.

SUN -> specifies -> JDBC API -> gets implemented by -> Oracle, MySQL driver

EX2:
Servlet aPI acts as requirement specifications to develop web server. Web server
vendor is responsible to implement Servlet API.

SUN -> specifies -> Servlet API -> gets implemented by -> Tomcat, Weblogic, Websphere

2. Definition
From client point of view, an interface defines a set of services of what he is
expecting. From service provider point of view, an interface defines a set of
services of what he is offering. Hence any contract between client and service
provider is considered as an interface.

EX1:
Through bank atm GUI screen, bank people are highlighting what services they are
offering. At the same time GUI screen represent a set of service what customer
is expecting. Hence the GUI screen acts as contract between customer and bank.

Customer ---> expects service from --> GUI SCREEN <--- offers service <-- Bank

3. Definition (Not completely valid after 1.8V)
Inside interface every method is always abstract whether we are declaring or
not. Hence interface is considered as %100 pure abstract class.

4. Summary definition
Any service requirement specifications, any contact between client and service
provider, %100 pure abstract class is nothing but interface.

## Interface Declaration and Implementation
Whenever we are implementing an interface for each and every method of that
interface we have to provide implementation. Otherwise, we have to declare class
as abstract. Then next level child class is responsible to provide
implementation.

Every interface method is always public and abstract, wheter we are declaring or
not. Hence whenever we are implementing an interface method, compulsory we
should declare as public. Otherwise, we will get compile time error.


```java
interface Interf {
  void m1(); // by default it is public abstract
  void m2(); // by default it is public abstract
}
```

```java
// has to be declared as abstract, because doesnt implement all methods
abstract class ServiceProvider implements Interf {
  // void m1() {} // CE: assinging weaker modifier public -> default

  public void m1(){
    // implementation
  }
}

class SubServiceProvider extends ServiceProvider {
  public void m2() {
    // implementation
  }
}
```

## extends vs implements
- A class can extend only one class at a time.
- An interface can extends any number of interfaces simultaneously.

```java
interface A {}
interface B {}
interface C extends A, B {}
```
- A class can implement any number of interfaces simultaneously.
- A class can extend another class, and can implement any number of interfaces
  simultaneously.

```java
class A extends B implements C, D, E {}
```

**Q:** Which of the following is valid?

A class can extend any number of classes at a time. INVALID
A can can implement only one interface at a time. INVALID
An interface can extend only one interface at a time. INVALID.
An interface can implement any number of interfaces simultaneously. INVALID
A class can extend another class, or can implement another interface but not both simultaneously. INVALID

( X extends Y ) which one is correct?

- Both X and Y should be classes. (X and Y can be interfaces, too.)
- Both X and Y should be interfaces. (X and Y can classes, too.)
- Both X and Y can be either classes or interface (correct)
- No restriction (X class, Y interface)

( X extends Y,Z ) : only possibility is all should interfaces.

(X implements Y,Z) : X is class, Y and Z are interfaces

(X extends Y implements Z) : X and Y are classes, Z is interface.

(X implements Y extends Z) : CE: extends first followed by implements

## Interface Methods
Every method present inside interface is always public and abstract whether we
are declaring or not.


```java
interface Interf {
  void m1(); // by default, public abstract
}
```

public   : to make m1 method available to every implementation class.
abstract : implementation class is responsible to provide implementation.

Hence inside interface the following method declaration are equal:

```java
void m1();
public void m1();
abstract void m1();
public abstract void m1();
```

As every interface is always public and abstract, we can declare interface
method with the following modifiers:

- private
- protected
- static
- final
- synchronized
- strictfp
- native

Which of the following method declaration are allowed inside interface?


```java
public void m1() {}                 // invalid, should end with semicolon
private void m1();                  // invalid, private not allowed
protected void m1();                // invalid, protected not allowed
static void m1();                   // invalid, static not allowed
public abstract native void m1();   // invalid, native not allowed
abstract public void m1();          // valid, order is not important
```

## Interface Variables
An interface can contain variables. The main purpose of interface variable is to
define requirement level constants.

Every interface variable is always public static final whether we are declaring
or not.

```java
interface Interf {
  int x = 10; // by default, public static final
  String LOCATION = "Istanbul";
}
```

- public : to make this variable available to every implementation class
- static : without existing object also, implementation class has to access to this var
- final  : if one implementation class change this value, then remaining
           implementation classes will be affected. to restrict this every interface
           variable is always final.

Hence within the interface the following variable declaration are equal:

```java
int x = 10;
public int x = 10;
static int x = 10;
final  int x = 10;
public static int x = 10;
public final  int x = 10;
static final  int x = 10;
public static final int x = 10;
```

As every interface variable is always public static final, we cannot declare
with the following modifiers:

- private
- protected (classes in other packages should access)
- transient (no object of interface, no serialization, no transient)
- volatile (doesnt go with final)

**NOTE:** For interface variables compulsory we should perform initialazation at
the time of declaration. Otherwise, we will get compile time error.

Static block is not applicable. No such thing as class loading for interface.

```java
interface Interf {
  int x; // CE: = expected
}
```

Inside interface which of the variable declarations are allowed?


```java
int x;
private int x = 10;            // invalid, should be initialized
protected int x = 10;          // invalid, protected not allowed
volatile int x = 10;           // invalid, final doesnt go with volatile
transient int x = 10;          // invalid, no serialization, no transient
public static int x = 10;      // valid
```

Inside implementation class we can access interface variables, but we cannot
modify values.


```java
interface Interf {
  int x = 10;
}

class Test implements Interf {
  public static void main(String[] args) {
    x = 777; // CE: cannot assign a value to final variable x
    System.out.println(x);
  }
}

class Test1 implements Interf {
  public static void main(String[] args) {
    int x = 777; // local variable
    System.out.println(x); // 777
  }
}
```

## Interface Naming Conflicts

### Method Naming Conflicts

#### Case 1: same method same signature same return type
If two interfaces contain method with same signature and return type, then in
the implementation class we have to provide implementation only for one method.


```java
interface Left {
  public void m1();
}

interface Right {
  public void m1();
}

class Test implements Left, Right {
  public void m1() {}
}
```

#### Case 2: same method name, different argument type
If two interfaces contain method with the same name but different argument
types, then in the implementation class we have to provide implementation for
both methods. And this methods acts as overloaded methods.

```java
interface Left {
  public void m1();
}

interface Right {
  public void m1(int i);
}

class Test implements Left, Right {
  public void m1() {}

  public void m1(int i) {}
}
```

#### Case 3:
If two interfaces contain method with same signature but different return types,
then it is impossible to implement both interfaces simultaneously.(If return
types are not co-variant)

```java
interface Left {
  public void m1();
}

interface Right {
  public int m1();
}

class Test implements Left, Right {
  public void m1() {}

  public int m1() {} // CE: m1 already is there
}
```

We cannot write any java class which implements both interfaces simultaneously.

**Q:** Is a java class can implement any number of interfaces simultaneously?

Yes. Except a particular case: If two interfaces contain a method with the same
signature but different return types, then it is impossible to implement both
interfaces simultaneously.

### Interface Variable Naming Conflicts
Two interfaces can contain a variable with the same name, and there may be a
chance of variable naming conflicts. But we can solve this problem by using
interface names.


```java
interface Left {
  int x = 777;
}

interface Right {
  int x = 888;
}

class Test implements Left, Right {
  public static void main(String[] args) {
    // System.out.println(x); // CE: reference to x is ambiguous
    System.out.println(Left.x); // 777
    System.out.println(Right.x); // 888
  }
}
```

## Marker Interface
If an interface doesnot contain any methods and by implementing that interface
if our objects will get some ability, such type interfaces are called marker
interfaces, or ability interface, or tag interface.

- Serializable(I)
- Cloneable(I)
- RandomAccess(I)
- SingleThreadModel(I)

These are marked for some ability.

**Example1:** By implementing Serializable(I) our objects can be saved to the
file, and can travel across the network.

**Example2:** By implementing Cloneable(I) our objects are in a position to
produce exactly duplicate clone objects.

**Q:** Without having any methods how objects will get some ability in marked
interfaces?

Internally JVM is responsible to provide required ability.

**Q:** Why JVM is providing required ability in marker interfaces?

To reduce complexity of programming and to make Java Language as simple.
(writing coding for serialization dealing with network related issues)

**Q:** Is it possible to create our own marker interface?

Yes. But costumization of JVM is required.

## Adapter Classes
Adapter class is a simple Java class that implements an interface with only
empty implementation.


```java
interface X {
  m1();
  m2();
  m3();
  // ...
  m1000();
}
```


```java
abstract class AdapterX implements X {
    m1() {}
    m2() {}
    m3() {}
    // ...
    m1000() {}
}
```

If we implement an interface for each and every method of that interface
compulsory we should provide implementation whether it is required or not
required.


```java
class Test implements X {
    m1() {}
    m2() {}
    m3() {}
    // ...
    m1000() {}
}
```

The problem with this approach is that it increases length of code and reduces
readability. We can solve this problem by using adapter classes. Instead of
implementing interface if we extend adapter class, we have to provide
implementation only for required methods. And we are not responsible to provide
implementation for each and every method of the interface so that length of code
will be reduced.


```java
class Test extends AdapterX {
  // we just need m3 in this class
  m3() {}
}

class Sample extends AdapterX {
  // we just need m1 in this class
  m1() {}
}

class Demo extends AdapterX {
  // we just need m1000 in this class
  m1000() {}
}
```

**Example:**
We can develop a servlet in the following three ways:

Servlet(I) <-- GenericServlet(AC) <--- HttpServlet(AC)

- By implementing Servlet(I)
- By extending GenericServlet(AC)
- By extending HttpServlet(AC)

If we implement servlet interface for each and every method in that interface we
should provide implementation. It increases length of the code and reduces
readability.

Instead of implementing Servlet(I) directly, if we extend GenericServlet(AC), we
have to provide implementation only for service method. For all remaining
methods we are not required to provide implementation. Hence more or less,
GenericServlet(AC) acts as an adapter class for Servlet(I).

**NOTE:** Marker interface and adapter classes simplies complexity of
programming, and these are best utilies to the programmer. And programmers life
will become simpler.

## Interface vs Abstract Class vs Concrete Class
If we do not know anythin about the implementation, just we have requirement
specification, then we should go for interface. (Servlet(I))

If we are talking about implementation but not completely(partial
implementation), then we should go for abstract class.(GenericServlet(AC))

If we are talking about implementation completely and ready to provide service,
then we should go for concrete class.(MyOwnServlet(C))

Interface  ---------------> Servlet(I) -----------------------> Plan
   ^                             ^                               ^
   |                             |                               |
   |                             |                               |
Abstract ----------------> GenericServlet(AC) --------> Partially completed
Class                      HttpServlet(AC)                    building
   ^                             ^                               ^
   |                             |                               |
   |                             |                               |
Concrete ----------------> MyOwnServlet(C) -----------> Fully Completed Building
 Class

## Differences between Interface and Abstract Class

#### Interface
1. If we do not know anythin about the implementation, just we have requirement
specification, then we should go for interface.

2. Inside interface every method is public and abstract whether we are declaring or
not. Hence interface is considered as %100 pure abstract class.

3. As every interface method is always public and abstract, hence we cannot declare with
the following modifiers: private, protected, final, static, synchronized,
native, strictfp.

4. Every variable present inside interfaace is always public static final
   whether we are declaring or not.

5. As every interface variable is always public static final, we cannot declare
   with the following modifiers: private, protected, volatile, transient.

6. For interface variable compulsory we should perform initialazation at the
   time of declaration only. Otherwise, we will get compile time error.

7. Inside interface we canNOT declare static and instance blocks.

8. Inside interface we canNOT declare constructors.


#### Abstract
1. If we are talking about implementation but not completely (partial
implementation), then we should go for abstract class.

2. Every method present in abstract class need not be public and abstract, and we
can take Concrete methods also.

3. There are no restrictions on abstrac class method modifiers.

4. Every variable present inside abstract class need not be public static final.

5. There are no restrictions on abstract class variable modifiers.

6. For abstract class variables we are not required to perform initialazation at
   the time of declaration.

7. Inside we can declare static and instance blocks.

8. Inside abstract class we can declare constructors.


**Question:** Anyway we cannot create object for abstract class. But abstract
class can contain constructor, what is the need for constructor in abstract?

Abstract class constructor will be executed whenever we are creating a child
class object to perform initialazation of child class object.

- Without having abstract class constructor

```java
abstract class Person {
  String name;
  int age;
  // another 98 properties
}

class Student extends Person {
  int rollno;

  Student(String name, int age, ..., int rollno) { // other 99 properties
    this.name = name;
    // initialization other properties
    this.rollno = rollno;
  }
}

class Teacher extends Person {
  String subject;

  Student(String name, int age, ..., String subject) {
    this.name = name;
    // initialization other properties
    this.subject = subject;
  }
}

// we have to initialize each object in classes for 100 properties
// more code, code redundancy
```

- with constructor in abstract class

```java
abstract class Person {
  String name;
  int age;
  // another 98 properties

  Person(String name, int age, ..) { // will work for every child object initialization
    this.name = name;
    this.age = age;
    // other 98 properties
  }
}

class Student extends Person {
  int rollno;

  Student(String name, int age, ..., int rollno) { // other 99 properties
    super(name, age, ...);
    this.rollno = rollno;
  }
}

class Teacher extends Person {
  String subject;

  Student(String name, int age, ..., String subject) {
    super(name, age, ...);
    this.subject = subject;
  }
}

// writing the code to initialize 100 properties once in abstract constructor
// less code, code reusability
```

**NOTE:** Either directly or indirectly we cannot create object for abstract class.

**QUESTION:** Anyway we cannot create object for abstract class and interface
but abstract class can contain constructor but interface doesnt contain
constructor. What is the reason?

The main porpuse of constructor is to perform initialization for instance
variables. Abstract class can contain instance variables which are required for
child object. To perform initialization of those instance variables constructor
is required for abstract class. But every variable present Inside interface is
always public static final whether we are declaring or not. And there is no
chance of existing instance variable inside interface. Hence constructor concept
is not required for interfaces.

**NOTE:**
Whenever we are creating child class object, parent object wont be created. Just
parent class constructor will be executed for child porpuse only.


```java
class P {
  P() {
    System.out.println(this.hashCode());
  }
}

class C extends P {
  C() {
    System.out.println(this.hashCode());
  }
}

public class Test {
  public static void main(String[] args) {
    C c = new C();
    System.out.println(c.hashCode());
  }
}

// all three hashcode will be same!
```

**QUESTION:** Inside interface every method is abstract, and we can take only
abstract methods in abstract class also. Then what is the difference between
interface and abstract class? That it is possible to replace interface with
abstract class?

We can replace interface with abstract class but it is not a good programming
practice. This is something recruiting a police officer for sweeping activity.
If everything is abstract, then it is highly recommended to go for interface.


```java
abstract class X {}
class Test extends X {
  // while extending abstract class, it is not possible to extend any other
  // class. Hence we are missing inheritence benefit.

  // in this case object creation is costy. 
  // Test t = new Test(); // 2 mins, calling super constructor etc
}

interface X {}
class Test implements X {
  // while implementing interface we can extend some other class. And hence we
  // wont miss any inheritence benefit.  

  // in this case object creation is not costy.
  // Test t = new Test(); // 2 sec
}
```
