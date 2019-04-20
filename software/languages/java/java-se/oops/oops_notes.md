# OOP Concept

- Security
  - Data Hiding
  - Abstraction
  - Encapsulation
  - Tightly Encapsulated Class

- Inheritence
  - Is-A Relationship
  - Has-A Relationship
- Method Signature
- Overloading
- Overriding
- Static Control Flow
- Instance Control Flow
- Constructors
- Coupling
- Cohesion
- Type-casting

## Data Hiding
Outside person cannot access our internal directly, or our internal data should
not go out direclty. This OOP feature is nothing but data hiding.

After validation or authentication outside person can access our internal data.
After providing proper username and password we can access our inbox
information.

Even though we are valid customer of the bank, we are able to see our account
information and we cannot see others account information.

By declaring data member(variable) as private we can achieve data hiding.


```java
public class Account {
  private double balance;

  public double getBalance() {
    // validation
    return balance;
  }
}
```

The main advantage of data hiding is security.

**NOTE:** It is highly recommended to declare data member(variable) as private.

## Abstraction
"Hiding internal implementation" and just highlight a set of services what we are
offering, is the concept of abstraction.

Though bank ATM GUI screen bank people highlighting a set of services what they
are offering without highlighting internal implementation.

Put the card, enter the pin code: query? language? server? database?

The main advantages of abstraction are:

1. We can achieve security. Because we are not highlighting our internal
   implementation.

2. Without affecting outside person, we can able to perform any type of changes
   in our internal system. Hence, enhancement will become easy.

3. It improves maintainability of the application.

4. It improves easiness to use our system.

By using interfaces and abstract classes we can implement abstraction.

## Encapsulation
The process of binding data and the corresponding methods into a single unit is
nothing but encapsulation.

Capsule medicine example.

```java
class Student {
  // data members (variables)
  // +
  // methods (behaviour)
}
```

If any component follows data hiding and abstraction, such type of component is
said to be encapsulated component.

Encapsulation = Data Hiding + Abstraction


```java
public class Account {
  private double balance; // data hiding

  // methods are abstraction, user doesnt have to know what/how happens
  public double getBalance() {
    // validation
    return balance;
  }

  public void setBalance(double balance) {
    // validation
    this.balance = balance;
  }
}
```

The main advantages of encapsulation are:

1. We can achieve security.
2. Enhancement will become easy.
3. It improves maintainability of the application.

The main advantages of encapsulation is we can achieve security, but the main
disadvantage of encapsulation is it increases length of code, and slows down
execution.

4 doors letting students in a room vs checking all students for security reason
and then letting in.

## Tightly Encapsulated Class
A class is said to be tightly encapsulated if and only if each and every
variable is declared as private. Whether class contains corresponding getter and
setter methods or not, and whether these methods are declared as public or not.
These things we are not required to check.

```java
public class Account {
  private double balance; // one variable, is private, tightly encapsulated

  public double getBalance() {
    // validation
    return balance;
  }
}
```

**QUESTION:** Which of the following classes are tightly encapsulated?


```java
class A {
  private int x = 10; // tightly encapsulated
}

class B extends A {
  int y = 20; // default modifier, not private, not tightly encapsulated
}

class C extends A {
  private int z = 20; // both variables from child and parent are private, tightly
}
```

If the parent class is not tightly encapsulated, then no child class is tightly
encapsulated.

```java
class A {
  int x = 10; // not tightly encapsulated
}

class B extends A {
  private int y = 20;  // has default x from parent, not tightly encapsulated
}

class C extends B {
  private int z = 20;  // has default x from parent, not tightly encapsulated
}
```

## Is-A Relationship
- It is also known as 'inheritence'.
- The main advantage of is-A relationship is 'code reusebility'.
- By using 'extends' keyword we can implement is-A relationship.


```java
class P {
  public void m1() {
    System.out.println("parent method");
  }
}

class C extends P {
  public void m2() {
    System.out.println("child method");
  }
}

class Test {
  public static void main(String[] args) {
    P p = new P();
    p.m1(); // valid
    p.m2(); // CE: cannot find symbol, symbol: method m2 location: class P

    C c = new C();
    c.m1(); // valid, parent method available to child class
    c.m2(); // valid, its own method

    P p2 = new C();
    p2.m1(); // valid
    p2.m2(); // CE: cannot find symbol, symbol: method m2 location: class P

    C c2 = new P(); // CE: incompatible types. found: P required: C
  }
}
```

#### Conclusions
1. Whatever methods parent has by default available to the child. And hence,
   on child reference can call both parent and child class methods.

2. Whatever methods child has by default NOT available to the parent. And hence,
   on parent reference we canNOT call child specific methods.

3. Parent reference can be used to hold child object, but by using that
   reference we canNOT call child specific methods. But we can call methods
   present in parent class(polyphormism)

4. Parent reference can be used to hold child object, but child reference canNOT
   be used to hold parent object.

- Without inheritence

```java
class VLoan {
  // 300 methods
}

class HLoan {
  // 300 methods
}

class PLoan {
  // 300 methods
}

// 900 methods
// 90  hours
```

- With inheritence

```java
class Loan {
  // 250 common methods
}

class VLoan extends Loan {
  // 50 specific methods
}

class HLoan extends Loan {
  // 50 specific methods
}

class PLoan extends Loan {
  // 50 specific methods
}

// 400 methods
// 40  hours
```

**NOTE:**
The most common methods which are applicable for any type of child, we
have to define in parent class.

The specific methods which are applicable for a particular child, we have to
define in child class.

Total Java API is implemented based on inheritence concept. The most common
methods which are applicable for any java object are defined in Object class.
And hence every class in java is a child class of Object either directly or
indirectly so that Object class methods are by default available to every java
class without rewriting. Due to this, Object class acts as root for all java
classes.


Throwable class defines the most common methods which are required for every
Exception and Error classes. Hence the class acts as root for Java exception
hierarchy.

#### Multiple Inheritence
A java class canNOT extend more than one class at a time, hence java wont
provide support for multiple inheritence for classes.

**NOTE:** If our class doesnt extend any other class, then only our class is
direct child class of Object.

```java
class A {}
// Object <---- A
```

If our class extends any other class, then our class is indirect child class of
object.

```java
class A extends B {}
// Object <--- B <---- A : multi-level inheritence
```

**QUESTION:**  Why Java won't provide support for multiple inheritence?

There may be a chance of ambiguity problem. Hence Java wont provide support for
multiple inheritence.(Diamond Problem)


```java
class P1 {
  public void m1();
}

class P2 {
  public void m1();
}

class Test extends P1, P2 { // if it was possible
  public static void main(String[] args) {
    m1(); // ambiguity problem. Which m1 will be executed?
  }
}
```

But interface can extend any number of interfaces simultaneously. Hence java
provide support for multiple inheritence with the respected to interfaces.

```java
interface A {}
interface B {}

interface C extends A, B {}
```
**QUESTION:** Why ambiguity problem wont be there in interfaces?

Even though multiple method declaration are available, but implementation is
unique and hence there is no chance of ambiguity problem in interfaces.

```java
interface A {
  void m1();
}
interface B {
  void m1();
}

interface C extends A, B {
  void m1();
}

class Test implements C {
  public void m1() {
    // implementation
  }
}
```
**NOTE:** Strictly speaking through interfaces we wont get any inheritence.

#### Cyclic Inheritence
Cyclic Inheritence is not allowed in java. Of course it is not required.

```java
class A extends A {}

// CE: cyclic inheritence involving A
```
A already has its methods, what is the need to extend itself?

```java
class A extends B {}
class B extends A {}
// CE: cyclic inheritence involving A
```

If A methods required in B and B methods are reqired in A, then just a class
containing methods from both class should be defined.

## Has-A Relationship
1. Has-A relationship is also known composition or aggregation.
2. There is no specific keyword to implement has-a relation but most of the time
   we are depending on new keyword.
3. The main advantage of has-a relationship is reusebility of the code.

```java
class Car {
  Engine e = new Engine(); // car has-a engine reference
}

class Engine {
  // engine specific functionality
}
```

### Difference between Composition and Aggregation

#### Composition
Without existing container object if there is no chance of existing contained
objects, then container and contained objects are strongly associated. And this
strong association is nothing but composition.

University(container object) consists of several departments(contained objects),
without existing university there is no chance of department. Hence university
and department are strongly associated, and this strong association is nothing but composition.

#### Aggregation
Without existing container object if there is a chance of existing contained
object, then container and contained objects are weakly associated. And this
weak association is nothing but aggregation.

Deparment(container object) consists of several professors(contained objects),
without existing deparment there may be a chance of existing professor objects.
Hence deparment and professor objects are weakly associated.
And this weak association is nothing but aggregation.

**NOTE:** If composition objects are strongly associated whereas in aggregation
objects are weakly associated.

In composition container object holds directly contained objects(encapsulated),
whereas in aggregation container object holds just references of contained
objects.

### Is-A vs Has-A
If we want total functionality of a class automatically, then we should go for
is-a relationship.


```java
class Person {
  // person functionality
}

class Student extends Person {
  // I need all person functionality
}
```

If we want part of the functionality, then we should go for has-a relationship.


```java
class Test {
  // 100 methods
}

class Demo {
  Test t = new Test;

  // i just need a few methods of Test
  t.m1();
  t.m7();
}
```

## Method Signature
In Java method Signature consists of method names followed argument types.


```java
public static int m1(int i, float f) {}

// signature: m1(int, float)
```

Return type is not part of method signature is in java.

Compiler will use method signature to resolve method calls.


```java
class Test {
  public void m1(int i) {}
  public void m2(String s) {}
}

// compiler will create a method table for the class
// m1(int)
// m2(String)

class Demo {
  public static void main(String[] args) {
    Test t = new Test();
    t.m1(10);       // valid corresponding method: m1(int)
    t.m2("selim");  // valid corresponding method: m2(String)
    t.m3(10.5); // CE: cannot find symbol. symbol: method m3(double) l: class Test
  }
}
```

Within a class two methods with the same signature is not allowed.

```java
class Test {
  public void m1(int i) {}
  public int  m1(int x) { return 10; }
  // CE: m1(int) is already defined in Test
}
```

## Overloading
Two methods are said to be overloaded if and only if both methods having same
name but different argument types.

In C language method overloading concept is not available. Hence we cannot
declare multiple methods with the same name but different argument types. If
there is a change in argument type, compulsory we should go for a new method
name, which increases complexity of programming.

```c
abs(int i);
labs(long l);
fabs(long f);
```

But in Java we can declare multiple methods with same name but different
argument types. Such type of methods are called overloaded methods.

```java
abs(int i);
abs(long l);
abs(float f);
```

Having overloading concept in Java reduces complexity of programming.


```java
class Test {
  public void m1() {
    System.out.println("no arg");
  }
  public void m1(int i) {
    System.out.println("int arg");
  }
  public void m1(double d) {
    System.out.println("double arg");
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.m1();     // no arg
    t.m1(10);   // int arg
    t.m1(10.5); // double arg
  }
}

```

**NOTE:** In overloading method resolution is always being taken care of by
compiler based on difference type. Hence overloading is also considered as
'compile time polyphormism' or 'static polyphormism' or 'early binding'.

## Overriding
Whatever methods parent has by default available to the child through
inheritence. If child class is not satisfied with parent class implementation,
then child is allowed to redefine that method based on its requirement. This
process is called overriding.

Parent class method -> overridden method
Child  class method -> overriding method


```java
class P {
  public void properties() {
    System.out.println("cash + land + gold");
  }

  public void marry() { // overridden method
    System.out.println("afemalename");
  }
}

class C extends P {
  public void marry() { // overriding method
    System.out.println("anotherfemalename");
  }
}
```


```java
class Test {
  public static void main(String[] args) {
    P p = new P();
    p.marry(); // parent method

    C c = new C();
    c.marry(); // child method

    P p1 = new C();
    p1.marry(); // child method
  }
}
```

**NOTE:** In overriding method resolution is always taken care by JVM based on
runtime object. And hence overriding is also considered as 'runtime polyphormism',
or 'dynamic polyphormism' or 'late binding'.

### Rules for Overriding
1. In overriding method names and argument types must be matched. That is method
   signature must be same.

2. In overriding return types must be same. But this rule is applicable until
   1.4V only. From 1.5V onwards we can take co-varient return type. According to
   this, child class method return type need not be same as parent method return
   type. Its child type is also allowed.


```java
class P {
  public Object m1() { return null; }
}

class C extends P {
  public String m1() { return null; }
}
```

Parent Class Return Type : Object            Number           String       int
                             |                  |               |           |
                             |                  |               X           X
Child  Class Return Type :Obj, SubClasses  Number|Integer     Object      double

**NOTE:** Co-varient return type concept is applicable only for object types but not
primitive types.

3. Parent class private methods are not available to child. And hence overriding
concept is NOT applicable for private methods.

Based on our requirement we can define exactly same private method in child
class. It is valid but not overriding(method-hiding).

```java
class P {
  private void m1() {}
}

class C extends P {
  private void m1() {} // is not overriding
}
```

4. We cannot override parent class final methods in child classes. If we are trying
to override, we will get compile time error.

```java
class P {
  public final void m1() {}
}

class C extends P {
  public void m1() {} // CE: m1() in C cannot override m1() in P, overridden method is final
}
```

5. Parent class abstract methods, we should override in child class to provide
implementation.

```java
abstract class P {
  public abstract void m1();
}

class C extends P {
  public void m1() {}
}
```

6. We can override non-abstract method as abstract.

```java
class P {
  public void m1() {}
}

abstract class C extends P {
  public abstract void m1() {}
}
```

The main advantage of this approach is we can stop availability of parent
method implementation to next level child classes.


In overriding the following modifiers wont keep any restriction:

- synchronized
- native
- strictfp

Parent : final             non-final    abstract, synchronized, strictfp
          |                   |                  |     ^
          |                   |                  |     |
          X                   v                  v     |
Child  : non-final|final    final       non-abst, non-synchro, non-strictfp

(static?)

7. While overriding we cannot reduce scope of access modifier but we can increase
the scope.


```java
class P {
  public void m1() {}
}

class C extends P {
  void m1(); // CE: m in C cannot override m1() in P; attempting to assign
  weaker access priviliges; was public
}
```

Parent Class Method ----> Child Class Method
public              ----> public
protected           ----> protected | public
default             ----> default | protected | public
private             ----> overriding concept not applicable for private methods


**Reason:** If child method doesnt change the implementation, and other people
depend on  parent class implementation for some time. Then child class decides
to reimplement the method, if modifier will be more strict, there may be a
chance of breaking code of some people depending on parent class method. Hence,
access modifier cannot be more strict than the parent class has.

#### Exception and Overriding
If child class method throws any checked exception, compulsory parent class
method should throw the same checked exception or its parent. Otherwise, we will
get compile time error. But there are no restrictions for unchecked exceptions.


Valid. Child doesnt throw anything.
- P: public void m1() throws Exception
- C: public void m1()

Invalid. Parent should throws Exception or its parent.
- P: public void m1()
- C: public void m1() throws Exception

Valid. Parent throws parent of IOException.
- P: public void m1() throws Exception
- C: public void m1() throws IOException

Invalid. Parent should throw Exception or its parent.
- P: public void m1() throws IOException
- C: public void m1() throws Exception

Valid. Parent throws parent of FNFE and EOFE.
- P: public void m1() throws IOException
- C: public void m1() throws FileNotFoundException, EOFException

Valid. Child throws unchecked exception, no requirement on the parent.
- P: public void m1() throws IOException
- C: public void m1() throws AE, NPE, CCE


```java
import java.io.*;

class P {
  public void m1() throws IOException {}
}

class C extends P {
  public void m1() throws EOFException, InterruptedException {}
}

// CE: m1() in C cannot override m1() in P; overridden method does no throw j.l.IE
```

**Reason:**


```java
class P {
  public void m1() throws IOException {}
}

class C extends P {
  // 1: no implementation, parent class method being used
  // 2: public void m1() {} // doesnot break the main code
  // 3: public void m1() throws EOFException {}
  // 4: public void m1() throws ArithmeticException {}
  // 5: public void m1() throws Exception {}
  // 5 breaks the code, thats why child should throw same exception, its child
  exception, or unchecked exception.
}

class Test {
  public static void main(String[] args) {
    P p = new C();
    try {
      p.m1();
    } catch (IOException e) {}
  }
}
```

#### Overriding with Static Methods
We cannot override a static method as non-static. Otherwise, we will get compile
time error.

[instance method cannot be replaced with class method or vice versa]

```java
class P {
  public static void m1() {}
}

class C extends P {
  public void m1() {} // CE: m1() in C cannot override m1() in P; overridden method is static
}
```

Similarly we cannot override a non-static method as static.

```java
class P {
  public void m1() {}
}

class C extends P {
  public static void m1() {} // CE: m1() in C cannot override m1() in P; overriding method is static
}
```

3. If both parent and child class methods are static, then we wont get any
   compile time error. It seems overriding concept is applicable for static
   methods. But it is not overriding and it is 'method hiding'.

```java
class P {
  public static void m1() {}
}

class C extends P {
  public static void m1() {} // is not overriding, it is method-hiding
}
```

##### Method Hiding
All rules of method hiding are exactly same as overriding except the following
differences:

Method Hiding
- Both parent and child class methods should be static.
- Compiler is responsible for method resolution based on reference type.
- It is also known as compile time polyphormism, static polyphormism, or early
  binding.

Method Overriding
- Both parent and child class methods should be non-static.
- JVM is always responsible for method resolution based on runtime object.
- It is also known as run time polyphormism, dynamic polyphormism, or late
  binding.


```java
class P {
  public static void m1() {
    System.out.println("parent");
  }
}

class C extends P {
  public static void m1() {
    System.out.println("child");
  }
}

class Test {
  public static void main(String[] args) {
    P p = new P();
    p.m1(); // parent

    C c = new C();
    c.m1(); // child

    P p1 = new C();
    p1.m1(); // parent, if it was overriding, it would be child
  }
}
```

If both parent and child class methods are non-static, then it will become
overriding. In this case output: parent\nchild\nchild

#### Overriding with Var-arg Methods
WE can override var-arg method with another var-arg method only. If we are
trying to override with normal method, then it will become overloading but not
overriding.


```java
class P {
  public void m1(int... x) {
    System.out.println("parent");
  }
}

class C extends P {
  public void m1(int x) { // is not overriding, it is overloading
    System.out.println("child");
  }
}

class Test{
  public static void main(String[] args) {
    P p = new P();
    p.m1(10); // parent object, parent reference : parent

    C c = new C();
    c.m1(10); // child object, child reference : child

    P p1 = new C();
    p1.m1(10); // child object, parent reference, is overloading, compiler, static
    binding : parent
  }
}
```

In the above problem, if we replace child method with var-arg method, then it
will become overriding. In this case:

```java
class P {
  public void m1(int... x) {
    System.out.println("parent");
  }
}

class C extends P {
  public void m1(int... x) { // is overriding
    System.out.println("child");
  }
}

class Test{
  public static void main(String[] args) {
    P p = new P();
    p.m1(10); // parent object, parent reference : parent

    C c = new C();
    c.m1(10); // child object, child reference : child

    P p1 = new C();
    p1.m1(10); // child object, parent reference, is overriding, JVM, dynamic
    binding : child
  }
}
```

#### Overriding with respected to Variables
Variable resolution is always takes care by compiler based on reference type
respected of wheather the variable is static or non-static(overriding concept
applicable only for method but not for variable).


```java
class P {
  int x = 888;
}

class C extends P {
  int x = 999;
}

class Test {
  public static void main(String[] args) {
    P p = new P();
    System.out.println(p.x); // 888

    C c = new C();
    System.out.println(c.x); // 999

    P p1 = new C();
    System.out.println(p1.x); // 888
  }
}
```

P -> static | P -> non-static | P -> non-static | P -> static
C -> static | C -> non-static | C -> static     | C -> non-static
------------|-----------------|-----------------|----------------
888         | 888             | 888             | 888
999         | 999             | 999             | 999
888         | 888             | 888             | 888

### Differences between Overloading and Overriding

Properity | Overloading | Overriding
----------|-------------|-----------
Method name | same | same
argument types | must be different(at least order) | must be same(including order)
method signature | must be different | must be same
return types | no restrictions | must be same till 1.4, co-varient 1.5 onwards
private, static, final, static | can be overloaded | cannot be overridden
access modifiers | no restriction | scope of a.m cannot be reduces, but can be increased
throws clause | no restrictions | child throws checked, parent should throw same or its parent
method resolution | compiler based on reference type | JVM based on runtime object
also known as | c.t.p, s.p, early binding | r.t.p, d.p or late binding

**NOTE:** In overloading we have to check only method names(must be same) and
argument types(must be different). We are not required to check remaning like
return types, access moifier etc. But in overriding, we have to check like
method names, argument types, return types, throws clause, access modifier etc.

**QUESTIO::** Consider the following method in parent class:

```java
public void m1(int i) throws IOException
```

In child class which of the following methods we can take?

```java
public void m1(int i) // valid, overriding

public static int m1(long l) // valid overloading

public static void m1(int i) // invalid overriding, non-static -> static

public void m1(int i) throws Exception // invalid overriding cus of exceptions

public static abstract void m1(double d) // invalid method, static + abstact = illegal
```

### Polymorphism
One name but multiple forms is the concept of polymorphism.

Ex1: Method name is same but we can apply for different types of
arguments(overloading).


```java
abs(int)
abs(long)
abs(double)
```

Ex2: Method signature is same but in parent class one type implementation and in
the child class another type of implementation(overriding).

```java
class P {
  marry() {
    System.out.println("femalename");
  }
}

class C extends P {
  System.out.println("anotherfemalename");
}
```

Ex3: Usage of parent reference to hold child object is the concept of
polymorphism.

```java
List l = new ArrayList();
List l = new LinkedList();
List l = new Stack();
List l = new Vector();
```

Parent class reference can be used to hold child object, but by using that
reference we call only the method available in parent class, and we cannot call
child specific methods.


```java
// P has m1(), C has m2()
P p = new C();
p.m1();
p.m2(); // CE: cannot find symbol. symbol: method m2(), location: class P
```

But by using child reference we can call both parent and child class method.

```java
// P has m1(), C has m2()
C c = new C();
c.m1();
c.m2();
```

**Question:** When should we go for parent reference to hold child object?

If we dont know exact runtime type of object, then we should go for parent
reference. For example; the first element present in the arraylist can be any
type, hence return type of get method is object type, which can hold any type of
object.

C c = new C() | P p = new P();
--------------------------------|--------------------------
ArrayList al = new ArrayList(); | List l = new ArrayList();

1. We can use the first approach if we know exact runtime type of object.
2. By using child reference, we can call both parent and child class
   methods. This is the advantage of this approach.
3. We can use child reference to hold only particular child class object(this is
   the disadvantage of this approach).

1. We can use the second approach if we dont know exact runtime type of object.
2. By using parent reference, we can call only methods available in parent
   class, and we cannot call child specific methods.(this is the disadvantage of
   this approaach)
3. We can use parent reference to hold any child class object(this is the
   advantage of this approach).


- Polymorphism
  1. Static Polymorphism, Compiler Polymorphism, Early Binding
     - Overloading
     - Method Hiding
  2. Dynamic Polymorphism, Runtime Polymorphism, Late Binding
     - Overriding

#### Three Pillars of OOPs

- OOPs
  1. Encapsulation (Security)
  2. Polymorphism  (Flexibility)
  3. Inheritence   (Reusebility)

A boy starts LOVE with the word FRIENDSHIP, but girl ends LOVE with the same word
FRIENDSHIP. Word is the same but attitude is different. This beautiful concept
of OOPs is nothing but polymorphism.

## Coupling
The degree of dependency between components is called 'coupling'. If dependency is
more, then it is considered as 'tightly coupling'; and if the dependency is less,
then it is considered 'loosely coupling'.


```java
class A {
  static int i = B.j;
}

class B {
  static int j = C.k;
}

class C {
  static int k = D.m1();
}

class D {
  public static int m1() {
    return 10;
  }
}
```

The above components are said to be tightly coupled with each other. Because the
dependency between components is more.

Tightly coupling is not a good programming practice. It has several serious
disadvantages:

1. Without affecting remaining component we cannot modify any component. And
   hence, 'enhancement' will become difficult.
2. It surpresses 'reusability'.
3. It reduces 'maintainability' of the application.

Hence we have to maintain the dependency between components as less as possible.
That is loosely coupling is a good programming practise.

## Cohesion
For every component a clear well defined functionality is defined, then that
component is said to be follow high cohesion.

low-cohesion: totalServlet does Everything(showing pages, validation, sending email etc)
high-cohesion: a separate servlet or component for different tasks

High-cohesion is always a good programming practise, because it has several
advantages:

1. Without affecting remaning component, we can modify any component. Hence
   enhancement will become easy.
2. It promotes reusability of the code(whereever validation is required, we can
   reuse the same validateServlet without rewriting.)
3. It improves maintainability of the application.

**NOTE:** Loosely coupling and high cohesion are good programming practices.

## Object Type-Casting
WE can use parent reference to hold child object.

```java
Object o = new String("selim");
```

We can use interface reference to hold implemented class object.


```java
Runnable r = new Thread();
```

- Sytnax : A b = (C) d;
  - A : class or interface name
  - b : name of reference variable
  - C : class or interface name
  - d : reference variable name

1. (compile time checking): The type of 'd' and 'C' must have some relation
   either child to parent, parent to child or same type. Otherwise, we will get
   compile error: inconvertable types. found: D type, required: C.

   ```java
   Object o = new String("selim");
   StringBuffer sb = (StringBuffer) o; // object is parent of stringbuffer

   String s = new String("selim");
   StringBuffer sb = (StringBuffer) s; // CE: incorvertable types. f: S, r: SB
   ```

2. (compile time checking): 'C' must be either same or deriveate type of A,
   otherwise we will get compile time error saying:
   CE: incompatible types. found: C required: A

   ```java
   Object o = new String("selim");
   StringBuffer sb = (StringBuffer) o; // A and C are both StringBuffer

   Object o = new String("selim");
   StringBuffer sb = (String) o; //CE: incompatible types. f: String r: SB
   ```

3. (runtime checking): Runtime object type of 'd' must be either same or
   derivate type of 'C', otherwise we will get RE: ClassCastException

   ```java
   Object o = new String("selim");
   StringBuffer sb = (StringBuffer) o;
   // RE: ClassCastException: String cannot be casted to StringBuffer

   Object o = new String("selim");
   Object ob = (String) o; // Valid!
   ```

**Example:**


```java
// Object
//  Base1 -> Der1, Der2
//  Base2 -> Der3, Der4

Base2 b = new Der4();

Object o = (Base2) b; // valid
Object o = (Base1) b; // CE: inconvertable types. f: Base2 r: Base1
Object o = (Der3) b;  // RE: CCE
Base2 b1 = (Base1) b; // CE: inconvertable types.
Base1 b1 = (Der4) b;  // CE: incompatible types. f: Der4 r: Base1
Base1 b1 = (Der1) b;  // CE: inconvertable types. f: Base2 r: Der1
```

Strcitly speaking, through type-casting we are NOT creating any new object, for
the existing ibject we are providing another type of reference variable. That is
we are performing type-casting but not object-casting.


```java
String s = new String("selim");
Object o = (Object) s;
// can be written in one line
Object o = new String("selim");
```


```java
Interger I = new Integer(10); // creating an object
Number   N = (Number) I; // number type reference to same object
Object   O = (Object) N; // object type reference to same object

System.out.println(I == N); // true
System.out.println(N == O); // true
```

**NOTE:**
A <---- B <----- C

```java
C c = new C();
B b = (B) c; // B b = new C();
A a = (A)((B) c); // A a = new C();
```

**Example1**
P has m1(), C has m2()

```java
C c = new C();
c.m1(); // valid
c.m2(); // valid
((P)c).m1(); // P p = new C(); valid
((P)c).m2(); // P p = new C(); invalid. Parent reference calling child method
```

**Reason:** Parent reference can be used to hold child object, but by using that
reference we cannot call child specific methods. And we can call only methods
available in parent class.

**Example2**

```java
class A {
  public void m1() {
    System.out.println("A");
  }
}

class B extends A {
  public void m1() {
    System.out.println("B");
  }
}

class C extends B {
  public void m1() {
    System.out.println("C");
  }
}
// overriding concept

class Test {
  public static void main(String[] args) {
    C c = new C();
    c.m1(); // C
    ((B)c).m1(); // C
    ((A)((B)c)).m1(); // C
  }
}
```

It is overriding. And method resolution is always based on runtime object.

**Example3**

```java
class A {
  public static void m1() {
    System.out.println("A");
  }
}

class B extends A {
  public static void m1() {
    System.out.println("B");
  }
}

class C extends B {
  public static void m1() {
    System.out.println("C");
  }
}

class Test {
  public static void main(String[] args) {
    C c = new C();
    c.m1(); // C
    ((B)c).m1(); // B
    ((A)((B)c)).m1(); // A
  }
}
```

It is method-hiding. And method resolution is always based on reference type.

**Example4**

```java
class A {
  int x = 777;
}

class B extends A {
  int x = 888;
}

class C extends B {
  int x = 999;
}

class Test {
  public static void main(String[] args) {
    C c = new C();
    c.m1(); // 999
    ((B)c).m1(); // 888
    ((A)((B)c)).m1(); // 777
  }
}
```

Variable resolution is always based on reference type, but not based on runtime
object.

## Static Control Flow
Whenever we are executing a java class, the following sequence of steps will be
executed as the part of static control flow:

1. Identification of static member from top to bottom [1 to 6]
2. Execution of static variable assignment and static block from top to bottom [7 to 12]
3. Execution of main method [13 to 15]


```java
class Base {
  static int i = 10; // 1:static int i(default value zero)
                     // 7: i = 10

  static { // 2:
    m1(); // 8
    System.out.println("first static block"); // 10:
  }

  public static void main(String[] args) { // 3:
    m1(); // 13
    System.out.println("main method"); // 15
  }

  public static void m1() { // 4:
    System.out.println(j); // 9: (prints 0)
                           // 14: prints 20
  }

  static { // 5:
    System.out.println("second static block"); // 11:
  }

  static int j = 20; // 6: static int j(default value zero)
                     // 12: j = 20
}

// 0
// first static block
// second static block
// 20
// main method
```

#### RIWO(Read Indirectly Write Only)
Inside static block if we are trying to read a variable, that read operation is
called direct read. If we are calling a method and within that method if we are
trying to read a variable, that read operation is called indirect read.

```java
class Test {
  static int i = 10;

  static {
    m1();
    System.out.println(i); // direct read
  }

  public static void m1() {
    System.out.println(i); // indirect read
  }
}
```
If a variable is just identified by JVM and original value not yet assigned then
the variable is said to be in RIWO state. If a variable is in RIWO state, then
that we cannot perform direct read but we can perform indirect read. If we are
trying to read to directly we will get compile time error saying: illegal
forward reference.


```java
class Test {
  static int x = 10; // 1: x = 0 [RIWO]
                     // 3: x = 10

  static { // 2:
    System.out.println(x); // 4: 10
  }
}
```

```java
class Test {
  static { // 1:
    System.out.println(x); // 3: //CE: illegal forward reference
  }

  static int x = 10; // 2: x = 0 [RIWO]
}
```

```java
class Test {
  static { // 1:
    m1(); // 4:
  }

  public static void m1() {  // 2:
    System.out.println(x); // 4: indirect read. print 0
  }
  static int x = 10; // 3: x = 0 [RIWO]
                     // 5: x = 10 [R&W]
}
```

### Static Block
Static blocks will be executed at the time of class loading. Hence at the time
of class loading if we want to perform any activity, we have to define that
inside a static block.

Ex1: At the time of class loading the corresponding native libraries should be
loaded. Hence we have to define this activity inside static block.

```java
class Test {
  static {
    System.loadLibrary("native_lib_path");
  }
}
```

Ex2: After loading every db driver class, we have to register driver class with
driver manager but inside db driver class there is a static block to perform
this activity. And we are not responsible to register explicitly.


```java
class DbDriver {
  static {
    // register this driver with drivermanager
  }
}
```

**NOTE:** Within a class we can declare any number of static blocks, but all
these static blocks will be executed from top to bottom.

**Question1:** Without writing main method is it possible to print some
statements to the console?

Yes, by using static block.

```java
class Test {
  static {
    System.out.println("hello I can print...");
    Sytem.exit(0); // Otherwise RE: NoSuchMethodError: main
  }
}
```

**Question2:** Without writing main method and static block is it possible to
print some statement to the console?

Yes of course. There are multiple ways.

```java
class Test {
  static int x = m1();

  public static int m1() {
    System.out.println("hello I can print...");
    System.exit(0);
    return 10;
  }
}
```

```java
class Test {
  static Test x = new Test();

  { // instance block
    System.out.println("hello I can print...");
    System.exit(0);
  }
}
```

```java
class Test {
  static Test x = new Test();

  Test() { // constructor
    System.out.println("hello I can print...");
    System.exit(0);
  }
}
```

**NOTE:** From 1.7V onwards main method is mandatory to start a program
execution. Hence 1.7V onwards, without writing main method it is impossible to
print some statements to console.

### Static Control Flow in Parent-Child Relationship
Whenever we are executing child class, the following sequence of events will be
executed automatically as a part of static control flow:

1. Identification of static member from Parent to Child [1 to 11]
2. Execution of static variable assignment and static blocks from Parent to Child [12 to 22]
3. Execution of only child class main method [23 to 25]

```java
class Base {
  static int i = 10; // 1: i = 0 [RIWO]
                     // 12: i = 10 [R&W]

  static { // 2: identifying
    m1(); // 13: calling
    System.out.println("base static block"); // 15: base static block
  }

  public static void main(String[] args) { // 3: identifying
    m1();
    System.out.println("base main");
  }

  public static void m1() { // 4: identifying
    System.out.println(j); // 14: print 0
  }

  static int j = 20; // 5: j = 0 [RIWO]
                     // 16: j = 20 [R&W]
}

class Derived extends Base {
  static int x = 100; // 6: x = 0 [RIWO]
                      // 17: x = 200 [R&W]

  static { // 7: identifying
    m2(); // 18: calling
    System.out.println("derived static block"); // 20: derived static block
  }

  public static void main(String[] args) { //8: identifying
    m2(); // 23: calling
    System.out.println("derived main"); // 25: derived main
  }

  public static void m2() { // 9: identifying
    System.out.println(y); // 19: prints 0
                           // 24: prints 200
  }

  static { // 10: identifying
    System.out.println("derived second static block"); // 21:
  }

  static int y = 200; // 11: y = 0 [RIWO]
                      // 22: y = 200 [R&W]
}

// javac Base.java
// Base.class, Derived.class

// java Derived
// 0
// base static block
// 0
// derived static block
// derived second static block
// 200
// derived main

// java Base
// 0
// base static block
// 20
// base main method
```

**NOTE:** Whenever we are loading child class automatically parent class will be
loaded but whenever we are loading parent class, child clas wont be
loaded.(because parent class members by default available to child class,
whereas child class members are not available to parent.)

## Instance Control Flow
Whenever we are executing a java class, first static control flow will be
executed. In the static control flow if we are creating an object, the following
sequence of events will be executed as a part of instance control flow:

1. Identification of instance members from top to bottom [3 to 8]
2. Execution of instance variable assignment and instance blocks from top to bottom [9 to 14]
3. Execution of constructor [15]

```java
class Test {
  int i = 10; // 3: i = 0 [RIWO]
              // 9: i = 10 [R&W]

  {  // 4: identifying
    m1(); // 11: calling
    System.out.println("first instance block"); // 12:
  }

  Test() { // 5: identifying
    System.out.println("constructor"); // 15:
  }

  public static void main(String[] args) { // 1: static identifying
    Test t = new Test(); // 2: creating an object   == LINE 1
    System.out.println("main"); // 16:
  }

  public void m1() { // 6: identifying
    System.out.println(j); // 12: prints 0
  }

  { // 7: identifying
    System.out.println("second instance block"); // 13:
  }

  int j = 20; // 8: j = 0 [RIWO]
              // 14: j = 20
}

// 0
// first instance block
// second instance block
// constructor
// main
```
If we comment LINE1, then output is just "main".

**NOTE:** Static control flow is one time activity, which will be performed at
the time of class loading. But instance control flow is not one time activity
and it will be performed for every object creation.

**NOTE:** Object creation is most costly operation. If there is no specific
requirement, then it is not recommended to create object.

### Instance Control Flow in Parent-Child Relationship
Whenever we are creating child class object, the following sequence of events
will be performed automatically as a part of Instance control flow:

1. Identification of instance member from parent to child [4 to 14]
2. Execution of instance variable assignment and instance blocks only in parent class [15 to 19]
3. Execution of parent constructor [20]
4. Execution of instance variable assignment and instance blocks in child class [21 to 26]
5. Execution of child constructor [27]


```java
class Parent {
  int i = 10; // 4: i = 0 [RIWO]
              // 15: i = 10

  { // 5:
    m1(); // 16: calling
    System.out.println("parent instance block"); // 18:
  }

  Parent() { // 6:
    System.out.println("parent constructor"); // 20
  }

  public static void main(String[] args) { // 1: identfying static in parent
    Parent p = new Parent();
    System.out.println("parent main");
  }

  public void m1() { // 7:
    System.out.println(j); // 17: prints 0
  }

  int j = 20; // 8: j = 0 [RIWO]
              // 19: j = 20 [R&W]
}

class Child extends Parent {
  int x = 100; // 9: x = 0 [RIWO]
               // 21: x = 100 [R&W]

  { // 10:
    m2(); // 22: calling
    System.out.println("child first instance block"); // 24:
  }

  Child() { // 11:
    System.out.println("child constructor");   // 27
  }

  public static void main(String[] args) { // 2: identying static in child
    Child c = new Child(); // 3: child main
    System.out.println("child main"); // 28
  }

  public void m2() { // 12:
    System.out.println(y);  // 23: prints 0
  }

  { // 13:
    System.out.println("child second instance block"); // 25:
  }

  int y = 200; // 14: y = 0 [RIWO]
               // 26: y = 200 [R&W]
}

// javac Parent.java
// Parent.class Child.class

// java Child
// 0
// parent instance block
// parent constructor
// 0
// child first instance block
// child second instance block
// child constructor
// child main
```

**Example1**

```java
class Test {
  {  // 8: identying, 17: identying
    System.out.println("first instance block"); // 11: prints
  }

  static { // 1: identfying
    System.out.println("first static block"); // 4: prints
  }

  Test() { // 9: identfying, 18: identfying
    System.out.println("constructor"); // 13: prints, 20:prints
  }

  public static void main(String[] args) { // 2: identfying
    Test t = new Test(); // 7: creating an object
    System.out.println("main"); // 15: prints
    Test t1 = new Test(); // 16: creating an object
  }

  static { // 3: identfying
    System.out.println("second static block"); // 5: prints
  }

  { // 10: identfying, 19: identfying
    System.out.println("second instance block"); // 12: prints
  }
}

// java Test
// first static block
// second static block
// first instance block
// second instance block
// constructor
// main
// first instance block
// second instance block
// constructor
```

**Example2**

```java
public class Initialization {
  private static String m1(String msg) {
    System.out.println(msg);
    return msg;
  }

  public Initialization() {
    m = m1("1");
  }

  {
    m = m1("2");
  }

  String m = m1("3");

  public static void main(String[] args) {
    Object o = new Initialization();
  }
}

// output:
// 2
// 3
// 1
```

**Example3**

```java
public class Initialization2 {
  private static String m1(String msg) {
    System.out.println(msg);
    return msg;
  }

  static String m = m1("1");

  {
    m = m1("2");
  }

  static {
    m = m1("3");
  }

  public static void main(String[] args) {
    Object o = new Initialization2();
  }
}

// output:
// 1
// 3
// 2
```

**NOTE:** From static area we cannot access instance members directly
becuase while executing static area JVM may not identify instance members.

```java
class Test {
  int x = 10;

  public static void main(String[] args) {
    System.out.println(x); // CE: non-static variable x cannot be referenced from a static area

    Test t = new Test();
    System.out.println(t.x); // 10
  }
}
```

**Question:** In how many ways we can create an object in Java or in how many
ways  we can get object in Java? (5 standard ways)

1. By using new operator
   ```java
   Test t = new Test();
   ```

2. By using newInstance() method:
   ```java
   Test t = (Test) Class.forName("Test").newInstance();
   ```

3. By using factory method:
   ```java
   Runtime r = Runtime.getRuntime();
   DateFormat df = DateFormat.getInstance();
   ```

4. By using clone() method:
   ```java
   Test t1 = new Test();
   Test t2 = (Test) t1.clone();
   ```

5. By using deserialization
   ```java
   FileInputStream fis = new FIS("abc.ser");
   ObjectInputStream ois = new OIS(fis);
   Dog d1 = (Dog) ois.readObject();
   ```

## Constructors
Once we create an object, compulsory we should perform initialization, then only
the object is in a position to respond properly.

Whenever we are creating an object some piece of code will be executed
automatically to perform initialization of the object. This piece of code is
nothing but constructor. Hence the main purpose of constructor is to perform
initialization of an object.


```java
class Student {
  String name;
  int rollno;

  Student(String name, int rollno) { // constructor
    this.name = name;
    this.rollno = rollno;
  }

  public static void main(String[] args) {
    Student s1 = new Student("abc", 100);
    Student s2 = new Student("def", 101);
  }
}
```

**NOTE:** The main porpuse of constructor is to perform initialization of an
object but not to create object.

### Difference between Constructor and Instance Block
The main porpuse of Constructor to perform initialization of an object. But
other than initialization if we want to perform any activity for every object
creation, then we should go for instance block(like updating one entry in db for
every object creation, or incrementing count value for every object creation).

Both constructor and instance block have their own different porpuses. And
replacing one concept with another concept may not work always.

Both constructor and instance block will be executed for every object creation.
But instance block first followed by constructor.

**Example1:** Print number of created object of a class:

```java
class Test {
  static int count = 0;

  {
    count++;
  }

  Test() {}
  Test(int i) {}
  Test(double d) {}

  public static void main(String[] args) {
    Test t1 = new Test();
    Test t2 = new Test(10);
    Test t3 = new Test(10.5);
    System.out.println("The no of objects created:" + count);
  }
}
```

### Rules of Writing Constructors
1. Name of the class and name of constructor must be matched.
2. Return type concept is not applicable for constructor, even void. By mistake
   if we are trying to declare return type for constructor, then we wont get any
   compile time error. Because compiler threats it as a normal method.

    ```java
    class Test {
      void Test() { // it is normal method, not constructor
        System.out.println("method but not constructor");
      }

      public static void main(String[] args) {
        Test t = new Test();
        t.Test();
      }
    }
    ```
    Hence it is legal(but stupid) to have a method whose name is exactly same as
    class name.

3. The only applicable modifiers for constructor are public, private,protected,
   default. If we are trying to use any other modifier, we will get CE.

```java
class Test {
  static Test() {
    // CE: modifier static not allowed here
  }
}
```

#### default Constructor
COmpiler is responsible to generate default constructor(but not JVM). If we are
not writing any constructor, then only compiler will generate default
constructor. That is if we are writing at least one constructor, then compiler
wont generate default constructor. Hence every class in Java can contain
constructor it may default constructor generated by compiler, or customized
constructor explicitly provided by programmer but not both simultaneously.

##### Prototype of Default Constructor
1. It is alwayws no-arg constructor.
2. The access modifier of default constructor is exactly same as access modifier
   of class(this rule is applicable only for public and default).
3. It contains only one line: super(); it is a no-arg call to super class
   constructor.


```java
// Programmers Code
class Test {}

// Compiler's Code
class Test {
  Test() {
    super();
  }
}

//----------------------
// Programmers Code
public class Test {}

// Compiler's Code
public class Test {
  public Test() {
    super();
  }
}

//----------------------
// Programmers Code
public class Test {
  void Test() {} // not a constructor
}

// Compiler's Code
public class Test {
  public Test() {
    super();
  }

  void Test() {}
}
//----------------------
// Programmers Code
class Test {
  Test() {}
}

// Compiler's Code: a constructor should start with this() or super()
class Test {
  Test() {
    super();
  }
}
//----------------------
// Programmers Code
class Test {
  Test(int i) {
    super();
  }
}

// Compiler's Code: compiler wont provide default constructor
class Test {
  Test(int i) {
    super();
  }
}
//----------------------
// Programmers Code
class Test {
  Test() {
    this(10);
  }

  Test(int i) {
  }
}

// Compiler's Code: compiler wont provide default constructor
class Test {
  Test() {
    this(10);
  }

  Test(int i) {
    super();
  }
}
```

**NOTE:** The first line inside every constructor should be either super() or
this(). If we are not writing anything, then compiler will always place super().

##### Case 1:
We can take super() or this() only in first line of constructor. If we are trying to
take anywhere else, we will get compile time error.

```java
class Test {
  Test() {
    System.out.println("constructor");
    super(); // CE: call to super must be first statement in constructor
  }
}
```

##### Case 2:
Within a constructor we can take either super() or this(), but not both
simultaneously.

```java
class Test {
  Test() {
    super();
    this(); // CE: call to this must be first statement in constructor
  }
}
```

##### Case 3:
WE can use super() or this() only inside constructor. If we are trying to use
outside of constructor, we will get compile time error.


```java
class Test {
  public void m1() {
    super(); // CE: call to super must be first statement in constructor
    System.out.println("hello");
  }
}
```

That is we can call a constructor directly from another constructor only.

######  super() and this()
- We can use them only in constructors.
- We can use them only in the first line
- We can use only one of them but not both simultaneously.

###### Difference Between super(), this() and super, this
1. super(), this()
   - These are constructor calls, to call super class and current class
     constructors.
   - We can use only in constructors
   - We can use only once in constructor

2. super, this
   - These are keywords to refer super class and current class instance member.
   - WE can use anywhere except static area.
   - We can use any number of times


```java
class Test {
  public static void main(String[] args) {
    System.out.println(super.hashCode()); // CE: non-static variable super
    cannot be referenced from a static context
  }
}
```

### Overloaded Constructors
Within a class we can declare multiple Constructors, and all these constructors
having same name but different type of arguments. Hence all these constructors
are considered as overloaded constructors. Hence overloading concept is
applicable for constructors.

```java
class Test {
  Test() {
    this(10);
    System.out.println("no-arg");
  }

  Test(int i) {
    this(10.5);
    System.out.println("int-arg");
  }

  Test(double d) {
    System.out.println("double-arg");
  }

  public static void main(String[] args) {
    Test t1 = new Test(); // double-arg
                          // int-arg
                          // no-arg

    Test t2 = new Test(10); // double-arg
                            // int-arg

    Test t3 = new Test(10.5); // double-arg

    Test t4 = new Test(10l); // double-arg
  }
}
```

For constructors inheritence and overriding concepts are NOT applicable. But
overloading concept is applicable.

Every class in Java including abstract class can contain constructor, but
interface cannot contain constructor.


```java
class Test {
  Test() {}
}

abstract class Test () {
  Test() {}
}

interface Test {
  Test() {} // invalid!
}
```

##### Case 1: Recursive Constructor Call
Recursive method call is a RE: StackOverflowError. But in our program if there
is a chance of recursive constructor invocation, then the code wont compile and
we will get compile error.


```java
class Test {
  public static void m1() {
    m2();
  }

  public static void m2() {
    m1();
  }

  public static void main(String[] args) {
    m1(); // RE: StackOverflowError
    // If m1 is not called, there wont be error
    System.out.println("hello");
  }
```

```java
class Test {
  Test() {
    this(10);
  }

  Test(int i) {
    this();
  }

  public static void main(String[] args) {
    System.out.println("hello"); // CE: recursive constructor invocation
  }
}
```

##### Case 2:


```java
class P {
  // compiler add default constructor
}

class C extends P {
  // compiler add default constructor
}
```

```java
class P {
  P() {
    // compiler add super() call
  }
}

class C extends P {
  // compiler add default constructor
}
```

```java
class P {
  P(int i) {
    // compiler add super() call
  }
}

class C extends P {
  // compiler add default constructor
  // but there is no super() constructor in the parent class!!!
  // CE: cannot find symbol. symbol: constructor P(), location: class P
}
```

**NOTE:** If parent class contains any argument constructor, then while writing
child classes we have to take special care with the respected to constructors.

**NOTE:** Whenever we are writing any argument constructor, it is highly
recommended to write no-arg constructor also.

##### Case 3: Constructor with Exception

```java
class P {
  P() throws IOException {
  }
}

class C extends P {
  // compiler add default constructor
  // but super() constructor throws exception in the parent class!!!
  // CE: unreported exception java.io.IOException in default constructor
}
```

```java
class P {
  P() throws IOException {

  }

  class C extends P {
    C() throws IOException { // | Exception | Throwable
      // cannot use try-catch. super() has to be on the first line
      super();
    }
  }
}
```

If parent class constructor throws any checked exception, compulsory child class
constructor should throw the same checked exception or its parent exception,
otherwise the code will not compile.

**Question:** Which of the following valid?

- The main porpuse of constructor is to creante an object(INVALID).
- The main porpuse of constructor is to perform initialization of an object.(VALID)
- The name of the constructor need not be same as class name(INVALID)>
- Return type concept is applicable for constructors, but only void(INVALID).
- WE can apply any modifier for constructor.(INVALID)
- Default constructor generated by JVM(INVALID)
- Compiler is responsible to generate Default constructor.(VALID)
- Compiler will always generate default constructor(INVALID).
- If we are not writing no-arg constructor, then compiler will generate default
  constructor(INVALID).
- Every no-arg constructor is always default constructor.(INVALID)
- Default constructor is always no-arg constructor(VALID)
- The first line inside every constructor should be super() or this(), if we are
  not writing anything, then compiler will generate this().(INVALID)
- For constructor both overloading and overriding concepts are applicable.(INVALID)
- For constructor inheritence concept is applicable but not overriding(INVALID)
- Only concrete classes can contain constructor, but abstract class cannot.(INVALID)
- Interface contains constructor(INVALID)
- Recursive constructor invocation(INVALID: compile time error)
- If parent class constructor throws some checked exception, then compulsory
  child class constructor should throw same checked exception or its child.(FALSE: or its parent)

## Singleton Classes
For any java class if we are allowed to create only one object such type of
class is called singleton class. Example: Runtime, BusinessDelegate, ServiceLocator.

### Advantage of Singleton Class
If several people have same requirement, then it is not recommended to create a
separate object for every requirement. We have to create only one object, and we
can reuse same object for every similar requirement. So that performance and
memory utilization will be improved. This is the central idea of singleton
classes.


```java
Runtime r1 = Runtime.getRuntime();
Runtime r2 = Runtime.getRuntime();
// .
// .
// .
Runtime r1000 = Runtime.getRuntime();
// all get same object
```

#### How to Create our Own Singleton Classes
We can create our own singleton classes, for this we have to use private
constructor and private static variable, and public factory method.

##### Approach 1

```java
// Runtime is implemented in the same way
class Test {
  private static Test t = new Test();

  private() {}

  public static Test getTest() {
    return t;  
  }
}
```

##### Approach 2
The problem with approach one is: object is being created but it may not be used

```java
class Test {
  private static Test t = null;

  private Test() {}

  public static Test getTest() {
    if (t == null) {
      t = new Test();  
    }

    return t;
  }
}
```

At any point of time for Test class we can create only one object. Hence Test
class is singleton class.

**Question:** Class is not final but we are not allowed to create child classes.
How is it possible?

By declaring every constructor as private we can restrict child class creation.


```java
class P {
  private P() {}  
}
```

For the above class it is impossible to create child class. Because every
constructor in child has to call super() method but it is private!
