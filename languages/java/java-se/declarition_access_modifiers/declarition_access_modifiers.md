# Declaration & Access Modifiers

- Java Source File Structure
- Class Level Modifiers
- Member Level Modifiers
- Interfaces

## Java Source File Structure
A java program can contain any number of classes. But at most one class can be
declared as public. If there is a public class, then name of program and name of
public class must be matched. Otherwise we will get compile time error.


#### Case 1
If there is no public class, then we can use any name and there are no
restrictions.

```java
// this file can be named anything. No public class
// A.java, B.java, C.java, Durga.java
class A {}
class B {}
class C {}
```

#### Case 2
If class B is public, then name of program should be B.java. Otherwise we will
get CE: class B is public, should be declared in a file named B.java

```java
// this file should be named B.java, because class B is public.
class A {}
public class B {}
class C {}
```

#### Case 3
If class B and C are declared as public, and the name of the program is B.java,
then we will get CE: class C is public, should be declared in a file named
C.java

```java
// public classes has to be defined in their own .java files.
class A {}
public class B {}
public class C {}
```

#### Case 4

```java
// Mixed.java
class A {
  public static void main(String[] args) {
    System.out.println("A class main");
  }
}

class B {
  public static void main(String[] args) {
    System.out.println("B class main");
  }
}

class C { }

// javac Mixed.java
// A.class B.class C.class
// java A
// A class main
// java B
// B class main
// java C
// RE: NoSuchMethodError : main
// java Mixed
// RE: NoClassDefFoundError : Mixed
```

Whenever we are compiling a java program, for every class present in the program
a separate .class file will be generated.

We can compile a java program(java source file), but we can run a java .class file.

Whenever we are executing a java class, the corresponding class main method will
be executed. If the class doesnt contain main method, then we will get
RE:NoSuchMethodError : main.

If the corresponding .class file is not available, then we will get
RE:NoClassDefFoundError.

**NOTE:**
It is not recommended to declare multiple classes in a single source file.
It is highly recommended to declare only one class per source file. And the name
of the program we can have to keep same as class name. The main advantage of
this approach is readability and maintainibility of the code will be improved.

### Import Statement


```java
class Test {
  public static void main(String[] args) {
    ArrayList l = new ArrayList();
  }
}

// javac Test.java
.// CE: cannot find symbol. symbol: class ArrayList, location: class Test
```

We can solve this problem by using fully qualified name.(java.util.ArrayList)

```java
class Test {
  public static void main(String[] args) {
    java.util.ArrayList l = new java.util.ArrayList();
  }
}
```

The problem with usage of fully qualified name every time is, it increases the
legnth of the code and reduces readability. We can solve this probmlem by using
import statement. Whenever we are writing import statement, it is not required
to use fully qualified name every time. We can use short name directly.

```java
import java.util.ArrayList;
class Test {
  public static void main(String[] args) {
    ArrayList l = new ArrayList();
  }
}
```

Hence import statement acts as typing short cut.

#### Case 1 : Types of Import Statements
There are two types of import statements.

1. Explicit Class Import
2. Implicit Class Import

##### Explicit Class Import

```java
import java.util.ArrayList;
```

It is highly recommended to use Explicit class import because it improves
readability of the code. Best suitable for hi-tech where readability is
important.

##### Implicit Class Import

```java
import java.util.*;
```

Not recommended to use because it reduces the readability of the code.

#### Case 2 : Valid Import Statements

```java
import java.util.ArrayList;    // valid, importing a class
import java.util.ArrayList.*;  // invalid. importing what?
import java.util.*;            // valid. importing all classes in a package
import java.util;              // invalid. importing what?
```

#### Case 3 : Fully Qualified Name vs Import Statement

```java
class MyObject extends java.rmi.UnicastRemoteObject {}
```

The code compiles fine. Even though we are not writing import statement. Because
we used fully qualified name.

**NOTE:** Whenever we are using fully qualified name, it is not required to
write import statement. Similary, whenever we are writing import statement, it
is not required to use fully qualified name.

#### Case 4 : Import Ambiguity

```java
import java.util.*;
import java.sql.*;

class Test {
  public static void main(String[] args) {
    Date d = new Date(); // CE: reference to Date is ambiguous
  }
}
```

**NOTE:** Even in the case of List also, we may get same abiguity problem.
Because it is available in both util and awt packages.

#### Case 5 : Import Priority
While resolving class names, compiler will always give precedence in the
following order:

1. Explicit class import
2. Classes present in the current working directory(default package)
3. Implicit class import

```java
import java.util.Date;
import java.sql.*;

class Test {
  public static void main(String[] args) {
    Date d = new Date();
    System.out.println(d.getClass().getName()); // java.util.Date
  }
}
```

In the above example, util package Date got considered.

#### Case 6 : Importing Subpackages
Whenever we are importing a java package, all classes and interfaces present in
that package by default is available, but not subpackage classes. If we want to
use subpackage class, compalsry we should write import statement until
subpackage level.


- java
  - util
    - regex
      - Pattern

To use Pattern class in our program, which import statement is required?


```java
import java.*;             // doesnt import subpackages of java
import java.util.*;        // doesnt import subpackages of util
import java.util.regex.*;  // imports Pattern class in regex subpackage
```

#### Case 7 : By default imported java packages
All classes and interfaces present in the following packages are by default
available to every program. Hence we are not required to write import statement.

1. java.lang package
2. default package(current working directory)


```java
public class Test {
  public static void main(String[] args) {
    String s = new String("test"); // already imported in java.lang.String
    Student std = new Student("test", 10); // Student.java in cwd
  }
}
```

#### Case 8 : Compile Time Difference
Import statements is totaly compile time related concept. If more number of
imports, then more there will be compile time. But there is no effect on execution
time(run time). Compiler every time refer to import to see where class is
located. In fully qualified name there wont be such overhead.

#### Case 9 : include vs import
Difference between C language #include and Java import statement:

- In the case of #include all header files will be loaded at the beginning
  only(at the translation time) hence it is static include.

- In case of java import statement, no .class file will be loaded at the
  beginning. Whenever we are using a particular class, then only corresponding
  .class file will be loaded. This is considered as dynamic include, or load on
  demand or load on fly.

### Static Import (1.5V)
Introduced in 1.5V. According to SUN, usage of static import reduces length of
the code and improves readability. But According to worldwide programming
experts, usage of static imports creates confusion and reduces readability.
Hence if there is no specific requirement, then it is not recommended to use
static import.


Usually we can access static members by using class name. But whenever we are
writing static import, we can access static members directly without class name.


```java
// without static import
public class Test {
  public static void main(String[] args) {
    System.out.println(Math.sqrt(4));
    System.out.println(Math.max(10, 20));
    System.out.println(Math.random());
  }
}
```

```java
// with static import
import static java.lang.Math.sqrt; // imports static sqrt method
import static java.lang.Math.*; // imports all static members in Math class

public class Test {
  public static void main(String[] args) {
    System.out.println(sqrt(4));
    System.out.println(max(10, 20));
    System.out.println(random());
  }
}
```

###### Q: Explain about System.out.println() :


```java
class Test {
  static String s = "test";

  public static void main(String[] args) {
    Test.s.length();
  }
}

// Test is class name
// 's' is static variable present in Test class of type String
// length() is a method present in String class
```

```java
class Test {
  public static void main(String[] args) {
    System.out.println("hello");
  }
}

// System is class present in java.lang package
// out is a static variable present in System class of type PrintStream
// println() is a method present in PrintStream class
```

out is a static variable present in System class, hence we can access by using
class name System. But whenever we are writing static import, it is not required
to use class name, and we can access out directly.

```java
import static java.lang.System.out;

public class Test {
  public static void main(String[] args) {
    out.println("Hello");
  }
}
```


```java
import static java.lang.Integer.*;
import static java.lang.Byte.*;

public class Test {
  public static void main(String[] args) {
    System.out.println(MAX_VALUE); // CE: reference to MAX_VALUE is ambiguous
  }
}
```

While resolving static members compiler will always consider the precedence in
the following order:

1. Current class static member
2. Explicit static import
3. Implicit static import

```java
import static java.lang.Integer.MAX_VALUE; // commented out: Byte.MAX_VALUE
import static java.lang.Byte.*;

public class Test {
  static int MAX_VALUE = 999; // commented out : Integer.MAX_VALUE

  public static void main(String[] args) {
    System.out.println(MAX_VALUE); // 999
  }
}
```

- Normal Import
  - Explicit Import
    - import packagename.classname;
    - import java.util.ArrayList;
  - Implicit Import
    - import packagename.\*;
    - import java.util.\*;

- Static Import
  - Explicit Static Import
    - import static packagename.classname.staticmembername;
    - import static java.lang.Math.sqrt;
    - import static java.lang.System.out;
  - Implicit Static Import
    - import static packagename.classname.\*;
    - import static java.lang.Math.\*;
    - import static java.lang.System.\*;

###### Which of the following import statements are valid?


```java
import java.lang.Math.*;              // invalid
import static java.lang.Math.*;       // valid, all static members
import java.lang.Math.sqrt;           // invalid
import static java.lang.Math.sqrt();  // invalid, no brackets
import java.lang.Math.sqrt.*;         // invalid
import static java.lang.Math.sqrt;    // valid
import java.lang;                     // invalid, need class name
import static java.lang;              // invalid, need static member
import java.lang.*;                   // valid
import static java.lang.*;            // invalid, static * after class name
```


#### Disadvantages of Static Import

##### Common Ambiguity Problem
Two packages contain a class or interface with the same name, it is very rare.
Hence Ambiguity problem is also very rare in normal import.

Two classes and interfaces contain a variable or method with the same name is
very common. And hence Ambiguity problem is also very common problem in static
import.

##### Readability Problem
Usage of static import reduces readability and creates confusion. And hence if
there is no specific requirement, then it is not recommended to use static
import.

What if there is a sqrt() in our class and there is the one from Math class
imported staticly. In a long problem it will be hard to know which one it is.

#### Differences between Normal and Static Import
We can use normal import to import classes and interfaces of a particular
package. Whenever we are writing normal import, it is not required to use fully
qualified name, and we can use short names directly.

We can use static import to import static member of particular class or
interface. Whenever we are writing static import, it is not required to use
class name to access static member, and we can access directly.

## Packages (Package Statement)
Package is an encapsulation mechanism to group related classes and interfaces
into a signle unit.

All classes and interfaces which are required for database operations are
grouped into a single package, which is nothing but java.sql package.

All classes and interfaces which are useful for file io operations are grouped
into a separate package, which is nothing but java.io package.


### Advantages of Packages
The main advantages of package are :

1. to resolve naming conflict(java.util.Date, java.sql.Date)
2. It improves modularity of the application
3. It improves maintainibility of the application
4. It provides security for our component.



### Universal Naming Convention
There is one universally accepted naming convention for packages. That is to use
internet domain name in reserve.

com.selimssevgi.loan.housing.Account


### How to Compile
```java
package com.selimssevgi.scjp;

public class Test {
  public static void main(String[] args) {
    System.out.println("package demo");
  }
}
```

```shell
$ javac Test.java
```

Generated .class file will be placed in the current working directory.

- CWD
  - Test.class


```shell
$ javac -d . Test.java
# -d : destionation to place generated class files
#  . : current working directory
```

Generated .class file will be placed in corresponding package structure.

- CWD
  - com
    - selimssevgi
      - scjp
        - Test.class

If the corresponding package structure is already not available, then this command
itself will create the corresponding package structure.

As destionation instead of . we can take any valid directory name.

```shell
$ javac -d F: Test.java
```

If the specified directy is not already available, then we will get compile time
error.

```shell
$ javac -d Z: Test.java
// CE: directory not found: Z:
```

### How to Run
At the time of execution we have to use fully qualified name.


```shell
$ java com.selimssevgi.scjp.Test
// package demo
```

### Multiple package Statements in a Source File
In any source file there can be at most one package statement, that is more than
one package statement is not allowed. Otherwise, we will get compile time error.


```java
package pack1;
package pack2;

class Test {}
```

```shell
$ javac Test.java
# class, interface or enum expected
```

### package Statement Location
In any java program the first non-commented statement should be package
statement(if it is available). Otherwise, we will get compile time error.

```java
import java.util.*;
package pack1;

class Test {}
```

```shell
$ javac Test.java
# class, interface or enum expected
```

The following is valid java source file structure :


```java
// the order is important
package statement;     // at most one
import statements;     // any number
class|interface|enum;  // any number
```

**NOTE:** An empty source file is a valid java program. Hence following are
valid java source files(Test.java):


```java
```

```java
package pack1;
```

```java
import java.util.*;
```

```java
package pack1;
import java.util.*;
```

```java
class Test {}
```

## Class Level Modifiers
Whenever we are writing our own classes, we have to provide some information
about our class to JVM.

- Whether this class can be accessible from anywhere or not(public).
- Whether child class creation is possible or not(final).
- Whether object creation is possible or not(abstract).


We can specify this information by using an apropriate modifiers.


The only applicable modifiers for top level classes are :

- public
- <default>
- final
- abstract
- strictfp

But for inner classes applicable modifiers are:

- modifiers for top level
- private
- protected
- static


```java
private class Test {
  public static void main(String[] args) {
    System.out.println("hello");
  }
}

// CE: modifier private not allowed here
```

#### Access Specifiers vs Access Modifiers
public, private, protected default are considered as specifiers, except these
remaining considered as modifiers. But this rule is applicable only for old
languages like C++ but no for JAVA.

In Java all are considered as modifiers only. There is no word like specifier.

```java
private class Test {
  public static void main(String[] args) {
    System.out.println("hello");
  }
}

// CE: "modifier" private not allowed here
```

### public Classes
If a class is declared as public, then we can access that class from any where.


```java
package pack1;

public class A {
  public void m1() {
    System.out.println("Hello");
  }
}
```

```java
package pack2;
import pack1.A;

class B {
  public static void main(String[] args) {
    A a = new A();
    a.m1();
  }
}
```

If A is not public, then while compiling B class, we will get CE: pack1.A is not
public in pack1: cannot be accessed from outside package.

### default Classes
If a class is declared as default, then we can access that class only within the
current package. That is outside package we cannot access.

default access is also known as package level access.

### final Modifier
final is a modifier applicable for classes, methods and variables.

#### final Method
Whatever methods parent has by default available to the child throught
inheritence. If the child is no satisfied with parent method implementation then
child is allowed to redefine that method based own its requirements. This
process is called overridden. So if the parent class method is declared as
final, then we cannot override that method in child class. Because its
implementation is final.


```java
class P {
  public void property() {
    System.out.println("cash + land + gold");
  }

  public final void marry() {
    System.out.println("afemalename");
  }
}

class C extends P {
  public void marry() {
    System.out.println("anotherfemalename");
  }
}

// CE: marry() in C cannot override marry() in P; overridden method is final
```

### final Class
If a class is declared as final, we cannot extend functionality of that class.
That is we cannot create child class for that class. That is inheritence is not
possible for final classes.

```java
final class P {
}

class C extends P {
}

// CE: cannot inherit from final P
```

**NOTE:** Every method present inside final class is always final by default.
But every variable present inside final class need not be final.

```java
final class P {
  static int x = 10;

  public static void main(String[] args) {
    x = 777;
    System.out.println(x); // 777
  }
}
```


**NOTE:** The main advantage of final keyword is : we can achieve security and
provide unique implementation. But the main disadvantage of final keyword is: we
are missing key concept of OOPs : inheritence (because of final classes) and
polymorphism (because of final methods). Hence if there is no specific
requirements, then it is not recommended to use final keyword.

### Abstract Modifier
Abstract is a modifier applicable for classes and methods, but not for
variables.

#### Abstract Method
Even though we dont know about the implementation, still we can declare a method
with abstract modifier. That is for abstract methods only Declaration is
available but not implementations. Hence abstract method Declaration should end
with semicolon.

```java
public abstract void m1();    // valid
public abstract void m1() {}  // invalid
```

Child class is responsible to provide implementation for parent class abstract
method.


```java
abstract class Vehicle {
  abstract public int getNoOfWheels();
}

class Bus extends Vehicle {
  @Override
  public int getNoOfWheels() {
    return 7;
  }
}
```

By declaring abstract method in the parent class, we can provide guidelines to
child classes such that which methods compulsory child has to implement.

Abstract method never talks about implementation if any modifier talks about
implementation, then forms illegal conbination with abstract modifier. The
following are various illegal combination of modifiers for methods with the
respected to abstract:

- abstract final
- abstract native
- abstract synchronized
- abstract static
- abstract private
- abstract strictfp


```java
abstract final void m1();

// CE: illegal combination of modifiers: abstract and final
```

#### abstract Class
For any java class if we are not allowed to create an object(because of partial
implementation) such type of class we have to declare with abstract modifier.
That is for abstract classes instantation is not possible.


```java
abstract class Test {
  public static void main(String[] args) {
    Test t = new Test(); // CE: Test is abstract : cannot be instantiated
  }
}
```

##### abstract class vs abstract method
1. Point
If a class contains at least one abstract method, then compalsry we should
declare class as abstract. Otherwise we will get compile time error.

If a class contains at least one abstract method, then implementation is not
complete. And hence it is not recommended to create an object. To restrict
object instantation compalsry we should declare class as abstract.

2. Point
Even though class doesnt contain any abstract method, still we can declare class
as abstract if we dont want instantation. That is abstract class can contain
zero number of abstract methods also.

- HttpServlet is abstract but it deosnt contain any abstract methods.
- Every Adapter class is recommended to declare as abstract but it doesnt contain
any abstract method.


```java
class P {
  public void m1();
}

// CE: missing method body, or declare abstract
```

```java
class P {
  public abstract void m1() {}
}

// CE: abstract methods cannot have a body
```

```java
class P {
  public abstract void m1();
}

// CE: P is not abstract and does not override abstract method m1() in P
```

3. Point
If we are extending abstract class, then for each and every abstract method of
parent class we should provide implementation. Otherwise, we have to declare
child class as abstract. In this case next level child class is responsible to
provide implementation.

```java
abstract class P {
  public abstract void m1();
  public abstract void m2();
}

class C extends P {
  public void m1() {}
}


// CE: C is not abstract and does not override abstract method m2() in P
```

#### final vs abstract
abstract methods compalsry we should override in child classes to provide
implementation. Whereas we cannot override final methods. Hence final, abstract
combination is illegal combination for methods.

For final classes we cannot create child classes, whereas for abstract we should
create child classes to provide implementation. Hence final abstract combination
is illegal for classes.

abstract class can contain final method, whereas final class cannot contain
abstract method.


```java
// valid
abstract class Test{
  public final void m1() {}
}
```

```java
// invalid
final class Test{
  public abstract void m1() {}
}

// firstly, class should be abstract because of abstract method.
// final abstract class illegal
// final cannot be extended where abstract class can be implemented.
```

**NOTE:** It is highly recommended to use abstract modifier because it promotes
several OOP features like inheritence and polymorphism.

### strictfp Modifier (strict floating point 1.2V)
Introduced in 1.2V. We can use strictfp classes and methods but not for
variables.

Usually result of floating-point arithmetic is varied platform to platform. If
we want to platform independent results of floating-point aritchmetic, then we
should go for strictfp modifier.

#### strictfp Method
If a method is declared as strictfp, all floating-point calculations in that
method has to follow IEEE 754 standard. So we will get platform independent
result.

Abstract modifier never talks about implementation, whereas strictfp method
always talks about implementation. Hence abstract strictfp combination is
illegal for methods.


#### strictfp Class
If a class is declared as strictfp, then every floating-point calculation
present in "concreate" method has to follow IEEE 754 standard. So that we will
get platform independent results.

We can declare abstract strictfp combination for classes. That is abstract
strictfp combination is legal for classes, but illegal for methods.


```java
// valid
abstract strictfp class Test {
  public double m1() {} // floating-point calculation method
  public abstract m2();
}
```
```java
// invalid
abstract strictfp class Test {
  public abstract strictfp void m2();
}

// CE: illegal combination of modifiers: abstract and strictfp
```

## Member Level Modifiers (method or variable level)

### public Member
If a member is declared as public, we can access that member from any where. But
corresponding class should be visible. That is before checking member
visibility, we have check class visibility.

```java
package pack1;

class A {
  public void m1() {
    System.out.println("A class method");
  }
}

// $ javac -d . A.java
// compiles fine
```


```java
package pack2;
import pack1.A;

class B {
  public static void main(String[] args) {
    A a = new A();
    a.m1();
  }
}

// $ javac -d . B.java
// CE: pack1.A is not public in pack1; cannot be accessed from outside of package
```

In the above example, even though m1 is public, we cannot access from outside
package. Because corresponding class A is not public. That is if both class and
method are public, then only we can access the method from outside package.

### default Members (package level access)
If a member is declared as default, then we can access that member only within
the current package. That is outside of the package we cannot access. Hence
default access is also known package level access.

### private Members
If a member is private, then we can access that member only within the class.
That is outside of class we cannot access.

abstract methods should be available to child classes to provide implementation.
Whereas private methods are not available to child classes. Hence private
abstract combination is illegal for methods.

### protected Members (the most misunderstood modifier in Java)
If a member is declared as protected, then we can access that member anywhere
within the current package. But only in child classes of outside package.

protected = <default> + kids

We can access protected members within the current package anywhere either by
using parent reference or child reference.

```java
package pack1;

public class A {
  protected void m1() {
    System.out.println("the most misunderstood modifier");
  }
}

class B extends A {
  public static void main(String[] args) {
    A a = new A();
    a.m1(); // valid in the same package

    B b = new B();
    b.m1(); // valid

    A a1 = new B();
    a1.m1(); // valid
  }
}
```

But we can access protected members in outside package only in child class and
we should use child reference only. That is parent reference cannot be used to
access protected members from outside package.

```java
package pack2;
import pack1.A;

class C extends A {
  public static void main(String[] args) {
    A a = new A();
    a.m1(); // invalid outside of package, parent reference

    C c = new C();
    c.m1(); // valid outside of package, child class reference

    A a1 = new C();
    a1.m1(); // invalid, outside of package, parent reference

    // invalid, CE: m1() has protected access in pack1.A
  }
}
```

We can access protected members from outside package only in child classes, and
we should use that child class reference only. For example from D class if we
want to access, we should use D class reference only.

```java
package pack2;
import pack1.A;

class C extends A { }

class D extends C {
  public static void main(String[] args) {
    A a = new A();
    a.m1(); // invalid outside of package, parent reference

    C c = new C();
    c.m1(); // invalid, outside of package, should be D class reference

    D d = new D();
    d.m1(); // valid

    A a1 = new C();
    a1.m1(); // invalid, outside of package, should be D class reference

    A a2 = new D();
    a2.m1(); // invalid, outside of package, should be D class reference

    C c2 = new D();
    c2.m1(); // invalid, outside of package, should be D class reference
  }

  // invalid, CE: m1() has protected access in pack1.A
}
```

#### Summary Table of private, default, protected, public Modifiers

Visibility | private | default | protected | public
-----------|---------|---------|-----------|-------
within same class | yes | yes | yes | yes
from child class of same package | no | yes | yes | yes
from non-child class of same package | no | yes | yes | yes
from child class of outside package | no | no | yes | yes
from non-child class of outside package | no | no | no | yes

The most restricted access modifier is private. The most accessible modifier is
public.

- private < default < protected < public

Recommended modifier for data member(variable) is private. But recommended
modifier for methods is public.

### final Variables

#### final Instance Variables
If the value of variable is varied from object to object, such type variables
are called instance variables. For every object a separate copy of instance
variables will be created.

For instance variables we are not required to perform initialization explicitly.
JVM will always provide default values.


```java
class Test {
  int x;

  public static void main(String[] args) {
    Test t = new Test();
    System.out.println(t.x); // 0
  }
}
```

If an instance variable is declared as final, then we compalsry have to perform
initialization explicitly. Whether we are using or not. And JVM wont provide
default values.


```java
class Test {
  final int x;  // CE: variable x might have not been initialized
}
```

**RULE:** For final instance variables compalsry we should perform
initialization before constructor complition. That is the following are various
places for initialization.

- At the time of declaretion

```java
class Test {
  final int x = 10;
}
```

- Inside instance block

```java
class Test {
  final int x;

  {
    x = 10;
  }
}
```

- Inside constructor

```java
class Test {
  final int x;

  Test() {
    x = 10;
  }
}
```

These are the only possible places to perform initialization for final instance
variables. If we are trying to perform initialization anywhere else, then we
will get compile time error.


```java
class Test {
  final int x;

  public void m1() {
    x = 1; // CE: cannot assign a value to final variable x
  }
}
```

### final static Variables
If a value of variable is not varied from object to object, such type variables
are not recommended to declare as instance variables(object level variables). We
have to declare those variables at class level by using static modifier.

In the case of instance variables for every object a separate copy will be
created. But in the case of static variables a single copy will be created at
class level. And shared by every object of that class.

For static variables is not required to perform initialization explicitly. JVM
will always provide default values.


```java
class Test {
  static int x;

  public static void main(String[] args) {
    System.out.println(x); // 0
  }
}
```

Order of modifiers is not important in Java.

If a static variable is declared as final, then compalsry we should perform
initialization explicitly. Otherwise, we will get compile time error. And JVM
wont provide any default values.


```java
class Test {
  final static int x; // CE: variable x might have not been initialized
}
```

**RULE:** For final static variables compalsry we should perform initialization
before class loading completion. That is the following various places for this:

- At the time of declarition

```java
class Test {
  final static int x = 10;
}
```

- Inside static block

```java
class Test {
  final static int x;

  static {
    x = 10;
  }
}
```

These are the only possible places to perform initialization for final static
variables. If we are trying to perform initialization anywhere else, then we
will get compile time error.

```java
class Test {
  final static int x;

  public static void m1() {
    x = 10; // CE: cannot assign a value to final variable x
  }
}
```

#### final Local Variables
Sometimes to meet temporary requirement of the programmer, we have to declare
variables inside method, block or constructor. Such type variables are called
local variables, temporary variables, stack variables or automatic variables.

For local variables JVM wont provide any default values, compalsry we should
perform initialization explicitly before using that local variable. That is if
we are not using then it is not required to perform initialization for local
variable.

```java
class Test {
  public static void main(String[] args) {
    int x;
    System.out.println("hello"); // compiles fine because not using x
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    int x;
    System.out.println(x); // CE: variable x might not have been initialized
  } 
}
```

Even though local variable is final before using only we have to perform
initialization. That is if we are not using, then it is not required to perform
initialization even though it is final.

```java
class Test {
  public static void main(String[] args) {
    final int x;
    System.out.println("hello"); // compiles fine because not using x
  }
}
```

**NOTE:** The only applicable modifier for local variable is final. By mistake
if we are trying to apply any other modifier. Then we will get compile time
error.


```java
class Test {
  public static void main(String[] args) {
    public    int x = 10;  // invalid
    private   int x = 10;  // invalid
    protected int x = 10;  // invalid
    static    int x = 10;  // invalid
    transient int x = 10;  // invalid
    volatile  int x = 10;  // invalid, CE: illegal start of expression

    final int x = 10; // valid
  }  
}
```

**NOTE:** If we are not declaring any modifier, then by default it is default.
But this rule is applicable only for instance and static variables. But not for
local variable.

#### Formal Parameters 
Formal parameters of a method simply act as local variables of that method.
Hence formal parameter can be declared as final. If formal parameter is declared
as final, then within the method we cannot perform reassignment.


```java
class Test {
  public static void main(String[] args) {
    m1(10, 20);
  }  

  public static void m1(final int x, int y) { // x and y are formal parameters
    x = 100; // CE: cannot assign a value to final variable x
    y = 200;
    System.out.println(x + "..." + y);
  }
}
```

### static Modifier
Static is a modifier, applicable for methods and variables but not for top level
classes. We can not declare top level class with the static modifier. But we can
declare inner class as static(static nested class).

In the case of instance variables for every object a separate a copy will be
created. But in the case of static variables a single copy will be created at
class level, and shared by every object of that class.


```java
class Test {
  static int x = 10;
  int y = 20;

  public static void main(String[] args) {
    Test t1 = new Test();
    t1.x = 888;
    t1.y = 999;

    Test t2 = new Test();
    System.out.println(t2.x + "..." + t2.y); // 888...20
  }
}
```

We cannot access instance members directly from static area, but we can access
from instance area directly. 

We can access static members both static and instance area directly.


```java
class Test {
  int x = 10;
  static int y = 10;

  public void m1() {
    System.out.println(x); // valid : instance variable instance area
    System.out.println(y); // valid : static variable, instance area
  }

  public static void m2() {
    System.out.println(x); // invalid : instance variable, static area
    System.out.println(y); // valid : static variable, static area
  }

  // invalid, CE: non-static variable x cannot be referenced from a static context
}
```

**NOTE:** Modifiers are not considered in method signature.

- public void m1()
- public static void m1()

CE: m1() is already defined

#### Case 1: Overloading
Overloading concept is applicable for static methods. Including main method. But
JVM can always call String[] argument main method only.


```java
class Test {
  public static void main(String[] args) {
    System.out.println("String[]");
  }  

  public static void main(int[] args) {
    System.out.println("int[]");
  }  

  // main method is overloaded. JVM calls main(String[]) method. 
}
```

#### Case 2: inheritence 
Inheritence concept is applicable for static methods including main method.
While executing child class if child doesnt contain main method, then parent
class main method will be executed.


```java
class P {
  public static void main(String[] args) {
    System.out.println("Parent main");
  } 
}

class C extends P { }

// $ javac P.java
// P.class C.class

// $ java P
// Parent main

// $ java C
// Parent main
```

#### Case 3: Method Hiding

```java
class P {
  public static void main(String[] args) {
    System.out.println("Parent main");
  } 
}

class C extends P { 
  // method hiding, not method overriding
  public static void main(String[] args) {
    System.out.println("Child main");
  }  
}

// $ javac P.java
// P.class C.class

// $ java P
// Parent main

// $ java C
// Child main
```

It seems overriding concept applicable for static method, but it is not
overriding. It is method-hiding.

**NOTE:** For static methods overloading and Inheritence concepts are
applicable. But overriding concept is not applicable. But instead of
overridding, method-hiding concept is applicable.


#### instance methods vs static methods
Inside method implementation if we are using at least one instance variable,
then that method talks about a particular object. Hence we should declare method
as instance method. 

Inside method implementation if we are NOT using any instance variable, then
this method is no way related to a particular object. Hence we have to declare
such type method as static method, either we are using static variables or not.

**NOTE:** For static methods implementation should be available, whereas for
abstract method implementation is not available. Hence abstract static
combination is illegal for methods.

### synchronized Modifier
synchronized is a modifier applicable for methods and blocks, but not for
classes and variables.

If multiple threads are trying to perform simultanously on the same java
object, then there may be a change of data inconsistency problem. This is called
race condition. 

We can overcome this problem by using synchronized keyword. 

If a method or block is declared as synchronized, then at a time only one thread
is allowed to execute that method or block on given object. So that data
inconsistency problem will be resolved.

The main disadvantage of synchronized keyword is that it increases waiting time
of threads and creates performance problems. Hence if there is no specific
requirement, then it is not recommended to use synchronized keyword.

synchronized method should compalsry contain implementation, whereas abstract
method doesnt contain any implementation. Hence abstract synchronized is illegal
combination of modifiers for methods.

### native Modifier
native is a modifier applicable only for methods. And we cannot apply anywhere
else.

The methods which are implemented in non-java(mostly C/C++) are called native
methods(foreign methods).

The main objectives of native keyword are:

1. To improve performance of the system
2. To achvieve machine level or memory level communication(native int hashCode)
3. To use already existing legacy non-java code

#### Pseudo code to use native keywords in Java

- Load native library
- Declare a native method
- Invoke a native method


```java
class Native {
  // do it during class loading
  static {
    System.loadLibrary("path_native_library"); // 1: load native method
  }

  public native void m1(); // 2: declare a native method
}

class Client {
  public static void main(String[] args) {
    Native n = new Native();
    n.m1(); // 3: invoke a native method
  }  
}
```

For native methods, implementation is already available in old languages like
C/C++. And we are not responsible to provide implementation. Hence native method
declaration should end with semicolon.

- public native void m1(); // valid
- public native void m1() {} // CE: native method cannot have a bodyo

For native methods, implementation is already available in old languages. But
for abstract methods, implementation should not be available. Hence we cannot
declare native method as abstract. That is native abstract combination is
illegal combination for methods.

We cannot declare native method as strictfp because there is no guarantee that
old languages follow IEEE 754 standard. Hence native strictfp is illegal
combination for methods.

The main advantage of native keyword is performance will be improved. But the
main disadvantage of native keyword is it breaks platform-independent nature of
java.

### transient Modifier
transient is a modifier applicable only for variables. 

We can use transient keyword in serialization context.

At the time of serialization if we dont want to save value of a particular
variable to meet security constraint, then we should declare that variable as
transient. 

At the time of serialization JVM ignores original value of transient variable,
and save default value(null or 0) to the file. Hence transient means "not to serialize".

### volatile Modifier
volatile is a modifier applicable only for variables. And we cannot apply
anywhere else.

If the value of a variable if keep on changing by multiple threads, then there
may be a chance of data inconsistency problem. We can solve this problem by
using volatile problem.

If a variable is declared as volatile, then for every thread JVM will create a
separate local copy. Every modification performed by the thread will take place
in local copy so that there is no affect on remaining threads.

The main advantage of volatile keyword is we can overcome data inconsistency
problem. But the main disadvantage of volatile keyword is creating and maintaing
a separate copy for every thread increases complexity of programming and creates
performance problems. Hence if there is no specific requirement, it is never
recommended to use volatile keyword. and it is almost deprecated keyword.

final variable means the value never changes. Whereas volatile variable means
value keep on changing. Hence volatile final is illegal combination for
variables.


#### Summary Table of Modifiers

Modifiers |oclass|iclass|method|var|block|ointer|iinter|oenum|ienum|constructor|
----------|------|------|------|---|-----|------|------|-----|-----|-----------|
public    |YES---|YES---|YES---|YES|-----|YES---|YES---|YES--|YES--|YES--------|
private   |------|YES---|YES---|YES|-----|------|YES---|-----|YES--|YES--------|
protected |------|YES---|YES---|YES|-----|------|YES---|-----|YES--|YES--------|
default   |YES---|YES---|YES---|YES|-----|YES---|YES---|YES--|YES--|YES--------|
final     |YES---|YES---|YES---|YES|-----|------|------|-----|-----|-----------|
abstract  |YES---|YES---|YES---|---|-----|YES---|YES---|-----|-----|-----------|
static    |------|YES---|YES---|YES|YES--|------|YES---|-----|YES--|-----------|
synch     |------|------|YES---|---|YES--|------|------|-----|-----|-----------|
native    |------|------|YES---|---|-----|------|------|-----|-----|-----------|
strictfp  |YES---|YES---|YES---|---|-----|YES---|YES---|YES--|YES--|-----------|
transient |------|------|------|YES|-----|------|------|-----|-----|-----------|
volatile  |------|------|------|YES|-----|------|------|-----|-----|-----------|

Enum is final implicitly.

The only applicable modifier for local variable is final.
The only applicable modifiers for constructor are public, private, protected, default.
The modifiers which are applicable only for methods are native.
The modifiers which are applicable only for variables are transient and volatile.
The modifiers which are applicable for classes but not for interfaces is final.
The modifiers which are applicable for classes but not for enum are final and abstract.
