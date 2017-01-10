# Inner Class Notes
Sometimes we can declare a class inside another class. Such type of classes are
called inner classes.

Inner Classes concept is introduced in 1.1V to fix GUI(AWT) bugs as a part of event
handling. But because of powerful features and benefits of inner classes, slowly
programmers started to use in regular coding also.

Without existing one type of object if there is no chance of existing another
type of object. Then we should go for inner classes.


University consists of several deparments, without existing university there is
no chance of existing deparments. Hence we have to define department class inside
university class.

```java
class University {   // outer class

  class Department { // inner class
    //
  }

}
```

Without existing car object there is no chance of existing engine object. Hence
we have to declare engine class inside car class.

```java
class Car {        // outer class

  class Engine {   // inner class
    //
  }
}
```

Map is a group of key-value pairs. Each key-value pair is called an Entry.
Without existing Map object, there is no chance of existing Entry object. Hence
interface Entry is defined inside Map interface.

```java
interface Map {      // outer interface

  interface Entry {  // inner interface
    //
  }
}
```

**NOTE:** Without existing outer class object there is no chance of existing
inner class object.

**NOTE:** The relation between outer class and inner class is not IS-A relation.
It is HAS-A relationship(composition or aggregation).

## Inner Class Types
Based on position of declaration and behaviour all inner classes are divided
into 4 types.

1. Normal or Regular Inner Classes
2. Method Local Inner Classes
3. Anonymous Inner Classes
4. Static Nested Classes


### Normal or Regular Inner Classes
If we are declaring any named class directly inside a class without static
modifier, such type of inner class is called normal or regular inner class.


```java
class Outer {
  class Inner {
    //
  }
}
```

```shell
$ javac Outer.java
$ ls
Outer.class Outer$Inner.class
$ java Outer
RE: NoSuchMethodError : main
$ java Outer$Inner
RE: NoSuchMethodError : main
```

```java
class Outer {
  class Inner {
    //
  }

  public static void main(String[] args) {
    System.out.println("outer class main method");
  }
}
```

```shell
$ javac Outer.java
$ ls
Outer.class Outer$Inner.class
$ java Outer
outer class main method
$ java Outer$Inner # java8 run outer main method?
RE: NoSuchMethodError : main
```

Inside inner class we cannot declare any static members. Hence we cannot declare
main method and we cannot run inner class directly from command prompt.(In Java8
static constant variables are allowed)

```java
class Outer {
  class Inner {
    public static void main(String[] args) {
      System.out.println("inner class main method");
    }
  }
}
```

```shell
$ javac Outer.java
CE: Inner class cannot have static declarations
```

#### Case 1: Accessing inner class code from static area of outer class


```java
class Outer {
  class Inner {
    public void m1() {
      System.out.println("inner class method");
    }
  }

  public static void main(String[] args) {
    Outer o = new Outer();
    Outer.Inner i = o.new Inner();
    i.m1();

    Outer.Inner i2 = new Outer().new Inner();
    i2.m1();

    new Outer().new Inner().m1();
  }
}
```

#### Case 2: Accessing inner class code from instance area of outer class


```java
class Outer {
  class Inner {
    public void m1() {
      System.out.println("inner class method");
    }
  }

  public void m2() {
    Inner i = new Inner(); // to be here, there should be already outer object
    i.m1();
  }

  public static void main(String[] args) {
    Outer o = new Outer();
    o.m2();
  }
}
```

#### Case 3: Accessing inner class code outside of outer class
Same as case 1.

```java
class Outer {
  class Inner {
    public void m1() {
      System.out.println("inner class method");
    }
  }
}

class Test {
  public static void main(String[] args) {
    Outer o = new Outer();
    Outer.Inner i = o.new Inner();
    i.m1();

    Outer.Inner i2 = new Outer().new Inner();
    i2.m1();

    new Outer().new Inner().m1();
  }
}
```

- Accessing inner class code
  - From static area of outer class(C1) or from outside of outer class(C3)
  ```java
  Outer o = new Outer();
  Outer.Inner i = o.new Inner();
  i.m1();
  ```
  - From instance area of outer class(C2)
  ```java
  Inner i = new Inner();
  i.m1();
  ```

#### Case 4: Accessing Outer class members from inner class
From normal or regular inner class we can access both static and non-static
members of outer class directly.

```java
class Outer {
  int x = 10;
  static y = 20;

  class Inner {
    public void m1() {
      System.out.println("inner class method");
      System.out.println(x); // 10
      System.out.println(y); // 20
    }
  }

  public static void main(String[] args) {
    new Outer().new Inner().m1();
  }
}
```

#### Case 5:
Within inner class, 'this' alwyas refers to current inner class object. If we
want to refer current outer class object, we have to use 'outerclassname.this'.

```java
class Outer {
  int x = 10;

  class Inner {
    int x = 100;
    public void m1() {
      int x = 1000;
      System.out.println(x); // 1000
      System.out.println(this.x); // 100
      System.out.println(Inner.this.x); // 100
      System.out.println(Outer.this.x); // 10
    }
  }

  public static void main(String[] args) {
    new Outer().new Inner().m1();
  }
}
```

The only applicable modifiers for outer classes are :

- public
- default
- final
- abstract
- strictfp

But for inner classes applicable modifiers are :

- outer class modifiers
- private
- protected
- static

#### Nesting of Inner Classes
Inside inner class we can declare another inner class. That is, nesting of inner
classes is possible.

```java
class A {
  class B {
    class C {
      public void m1() {
        System.out.println("innermost class method");
      }
    }
  }
}

class Test {
  public static void main(String[] args) {
    A a = new A();
    A.B b = a.new B();
    A.B.C c = b.new C();
    c.m1();
  }
}
```

### Method Local Inner Classes (Most Rarely Used, Limited)
Sometimes we can declare a class inside a method, such type of inner classes are
called method local inner classes.

The main porpuse of method local inner class is to define method specific
repeatly required functionality. MLIC best suitable to meet nested method
requirments(nested methods is not allowed in Java).

We can access MLIC only within the method where we declared. Outside of the
method we cannot access. Because of its less scope, MLIC are most rarely used
type of inner classes.

```java
class Test {
  public void m1() {
    class Inner {
      public void m1(int x, int y) {
        System.out.println("sum :" + (x+y));
      }
    }

    Inner i = new Inner();
    i.sum(10,20);
    ;;;;;
    i.sum(100,200);
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.m1();
  }
}
```

WE can declare MLIC inside both instance and static methods.

If we declare inner class inside instance method, then from that MLIC we can
access both static and non-static members of outer class directly.

```java
class Test {
  int x = 10;
  static int y = 20;

  public void m1() {
    class Inner {
      public void m2() {
        System.out.println(x);
        System.out.println(y);
      }
    }

    Inner i = new Inner();
    i.m2();
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.m1();
  }
}
```

If we declare inner class inside static method, then we can access only static
members of outer class directly from that MLIC.

If we declare m1 method as static, then we will get compile time error saying:
non-static variable x cannot be referenced from a static context.

```java
class Test {
  int x = 10;
  static int y = 20;

  public static void m1() {
    class Inner {
      public void m2() {
        System.out.println(x);   // CE:
        System.out.println(y);
      }
    }

    Inner i = new Inner();
    i.m2();
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.m1();
  }
}
```

From MLIC we cannot access local variables of the method in which we declared
inner class. If the local variable is declared as final, then we can access.(in
Java8 we can even access without final modifier?)

```java
class Test {
  public void m1() {
    int x = 10; // if it was final, we could access

    class Inner {
      public void m2() {
        System.out.println(x); //CE: local variable x is accessed from within
                               // inner class; need to be declared final
      }
    }
    Inner i = new Inner();
    i.m2();
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.m1();
  }
}
```

**Question:** Consider the following code:

```java
class Test {
  int i = 10;
  static int j = 20;
  public void m1() {
    int k = 30;
    final int m = 40;

    class Inner {
      public void m2() {
        // LINE1
      }
    }
  }
}
```

At LINE1 which of the following variables we can access directly?

```java
i // yes
j // yes
k // no
m // yes
```

If we declare m1 method as static, then at LINE1 which variables we can access
directly?

```java
i // no
j // yes
k // no
m // yes
```
if we declare m2 method as static, then at LINE1 which variable we can access
directly?

We will get compile time error, because we canNOT declare static members inside
inner classes.

The only applicable modifiers for MILC are:
- final
- abstract
- strictfp

If we are trying to apply any other modifier, then we will get compile time
error.

### Anonymous Inner Classes
Sometimes we can declare inner class without name, such type of inner classes
are called anonymous inner classes.

The main porpuse of anonymous inner classes is just for instant use(one time
usage).

Based on declaration and behaviour there are 3 types of anonymous inner classes:

1. Anonymous inner class that extends a class
2. Anonymous inner class that implements an interface
3. Anonymous inner class that defined inside arguments

#### Anonymous Inner Class that Extends a Class

```java
class PopCorn {
  public void taste() {
    System.out.println("salty");
  }
}

class Test {
  public static void main(String[] args) {
    PopCorn p = new PopCorn() {
      public void taste() {
        System.out.println("spicy");
      }
    };
    p.taste(); // spicy

    PopCorn p1 = new PopCorn();
    p1.taste(); // salty

    PopCorn p2 = new PopCorn() {
      public void taste() {
        System.out.println("sweet");
      }
    };
    p2.taste(); // sweet

    System.out.println(p.getClass().getName());   // Test$1
    System.out.println(p1.getClass().getName());  // PopCorn
    System.out.println(p2.getClass().getName());  // Test$2
  }
}
```

Generated .class file are: PopCorn.class, Test.class, Test$1.class, Test$2.class

##### Analysis


1. Just we are creating PopCorn object.
```java
PopCorn p = new PopCorn();
```

2. We are declaring a class that extends PopCorn without a name(anonymous inner
   class). For that child class we are creating an object with the parent
   reference.
```java
Popcorn p = new PopCorn() {};
```

3. We are declaring a class that extends PopCorn without a name(AIC). In that
   child class we are overriding taste method. For that child class we are
   creating an object with the parent reference.
   ```java
   PopCorn p = new PopCorn() {
      public void taste() {
        System.out.println("sweet");
      }
   };
   ```

##### Defining a Thread by Extending Thread Class

- Normal Class Approach

```java
class MyThread extends Thread {
  public void run() {
    for (int i=0; i<10 ; i++) {
      System.out.println("child thread");
    }
  }
}

class ThreadDemo {
  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();

    for (int i=0; i<10 ; i++) {
      System.out.println("main thread");
    }
  }
}
```

- Anonymous Inner Class Approach

```java
class ThreadDemo {
  public static void main(String[] args) {
    Thread t = new Thread() {
      public void run() {
        for (int i=0; i<10 ; i++) {
          System.out.println("child thread");
        }
      }
    };
    t.start();

    for (int i=0; i<10 ; i++) {
      System.out.println("main thread");
    }
  }
}
```

#### Anonymous Inner Class that Implements an Interface

##### Defining a thread by implementing Runnable Interface

- Normal Class Approach

```java
class MyRunnable implements Runnable {
  public void run() {
    for (int i=0; i<10 ; i++) {
      System.out.println("child thread");
    }
  }
}

class ThreadDemo {
  public static void main(String[] args) {
    MyRunnable r = new MyRunnable();
    Thread t = new Thread(r);
    t.start();

    for (int i=0; i<10 ; i++) {
      System.out.println("main thread");
    }
  }
}
```

- Anonymous Inner Class Approach

```java
class ThreadDemo {
  public static void main(String[] args) {
    MyRunnable r = new MyRunnable() {
      public void run() {
        for (int i=0; i<10 ; i++) {
          System.out.println("child thread");
        }
      }
    };
    Thread t = new Thread(r);
    t.start();

    for (int i=0; i<10 ; i++) {
      System.out.println("main thread");
    }
  }
}
```

#### Anonymous inner class that defined inside arguments

```java
class ThreadDemo {
  public static void main(String[] args) {
    new Thread( new MyRunnable() {
        public void run() {
          for (int i=0; i<10 ; i++) {
            System.out.println("child thread");
          }
        }
    }).start();

    for (int i=0; i<10 ; i++) {
      System.out.println("main thread");
    }
  }
}
```

#### Normal Java Class vs Anonymous Inner Class
1. A NJC can extend only one class at a time. Of course AIC also can extend only
   one class at a time.
2. A NJC can implement any number of interfaces simultanously, but AIC can
   implement only one interface at at time.
3. A NJC can extend a class and can implement any number of interfaces
   simultanously, but AIC can extend a class or can implement an interface but
   not both simultanously.
4. NJC we can write any number of constructors, but in AIC we cannot write any
   constructor explicitly(because the name of class and the name of constructor
   must be but AIC doesnt have any name).

**NOTE:** If the requirement is standard and required several times, then we
should go for normal top level class. If the requirement is temporary and
required only once(instant use) then we should go for AIC.

#### Where AICs are Best Suitable?
We can use AICs frequently in GUI based applications to implement event
handling.

```java
class MyGUI extends JFrame {
  JButton b1,b2,b2;
  // .
  // .
  // .
  b1.addActionListener(new ActionListener() [
    public void actionPerformed(ActionEvent e) {
      // b1 specific functionality  
    }
  ]);
  b2.addActionListener(new ActionListener() [
    public void actionPerformed(ActionEvent e) {
      // b2 specific functionality  
    }
  ]);
}
```

If we wouldnt use AIC, we had to define top level classes for each button action.

### Static Nested Classes
Sometimes we can declare inner class with static modifier. Such type of inner
classes are called static nested classes.

In the case of normal or regular inner class, without existing outer class
object there is no chance of existing inner class object. That is, inner class
object is strongly associated with outer class object.

But in the case of static nested classes without existing outer class object,
there may be a chance of existing nested class object. Hence, static nested
class object is not strongly associated with outer class object.

```java
class Outer {
  static class Nested {
    public void m1() {
      System.out.println("static nested class method");  
    }  
  }  

  public static void main(String[] args) {
    Nested n = new Nested();
    n.m1();
  }
}

// outside of outer class
class Test {
  public static void main(String[] args) {
    Outer.Nested n = new Outer.Nested();
    n.m1();
  }  
}
```

In normal or regular inner classes we cannot declare any static members. But in
static nested classes we can declare static members including main method.
Hence, we can invoke static nested class directly from command prompt.

```java
class Test {
  static class Nested {
    public static void main(String[] args) {
      System.out.println("static nested class main method");
    }
  }

  public static void main(String[] args) {
    System.out.println("outer class main method");
  }
}
```
```shell
$ javac Test
# Test.class Test$Nested.class
$ java Test
outer class main method
$ java Test$Nested
static nested class main method
```

From normal or regular inner class we can access both static and non-static
members of outer class directly. But from static nested classes we can access
static members of outer class directly. And we can not access non-static
members.


```java
class Test {
  int x = 10;
  static int y = 20;

  static class Nested {
    public void m1() {
      System.out.println(x); // CE: non-static variable x cannot be referenced
                             //     from a static context
      System.out.println(y); // 20
    }  
  }
}
```

#### Difference between Normal/Regular Inner Class vs Static Nested Class

- Normal or Regular Inner Class
1. Without existing outer class object, there is no chance of existing inner
   class object. That is, inner class object is 'strongly' associated with outer
   class object.
2. In normal/regular inner class we canNOT declare 'static' members.
3. In normal/regular inner class we canNOT declare 'main' method. And hence, we
   cannot invoke inner class directly from command prompt.
4. From normal/regular inner classes we can access both static and non-static
   members of outer class directly.

- Static Nested Class
1. Without existing outer class object, there may be a chance of existing static
   nested class object. That is, static nested class object is NOT 'strongly'
   associated with outer class object.
2. In static nested classes we can declare 'static' members.
3. In static nested classes we can declare 'main' method. And hence, we can
   invoke static nested class directly from command prompt.
4. From static nested classes we can access ONLY static members of outer class.

#### Various Combinations of Nested Classes and Interfaces

##### Case 1: Class inside Class
Witout existing one type of object if there is no chance of existing another
type of object, then we can declare a class inside a class. Example; university
consists of several departments. Without eixsting university there is no
exisitng department. Hence we have declare department class inside university
class.

```java
class University {
  class Department {
   //
  }
}
```

##### Case 2: Interface inside Class
Inside a class if we require multiple implementations of an interface and all
these implementations are related to a particular class, then we can define
interface inside a class.

```java
public class VehicleTypes {
  interface Vehicle {
    int getNoOfWheels();
  }

  class Bus implements Vehicle {
    @Override
    public int getNoOfWheels() {
      return 7;
    }
  }

  class Auto implements Vehicle {
    @Override
    public int getNoOfWheels() {
      return 3;
    }
  }
}
```

##### Case 3: Interface inside Interface
We can declare interface inside interface. Example; a map is a group of 
key-value pairs. And each key-value pair is called entry. Without existing map 
object, there is no chance of existing entry object. Hence interface Entry is 
defined inside Map interface. 
```java
interface Map {
  interface Entry {
  }
}
```

Every interface present inside interface is always public and static whether we
are declaring or not. Hence we can implement inner interface directly directly
without implementing outer interface. Similary, whenever we are implementing
outer interface we are not required to implement inner interface. That is, we
can implement outer and inner interfaces independently.

```java
interface Outer {
  void m1();

  interface Inner {
    void m2();
  }
}

class Test1 implements Outer {
  public void m1() {
    System.out.println("outer interface method implementation");  
  }  
}

class Test2 implements Outer.Inner {
  public void m2() {
    System.out.println("inner interface method implementation");  
  }  
}

class Test {
  public static void main(String[] args) {
    Test1 t1 = new Test1();
    t1.m1();

    Test2 t2 = new Test2();
    t2.m2();
  }  
}
```

##### Case 4: Class inside Interface
If a functionality of a class is closely associated with an interface, then it
is highly recommended to declare class inside interface.

```java
interface EmailService {
  public void sendMail(EmailDetails e);

  class EmailDetails {
    String toList;
    String ccList;
    String subject;
    String body;
  }
}
```

In the above example, EmailDetails is required only for EmailService and we are
not using any where else. Hence, EmailDetails class is recommended to declare to
inside EmailService interface.

We can also define a class inside interface to provide default implementation
for that interface.

```java
interface Vehicle {
  public int getNoOfWheels();

  class DefaultVehicle implements Vehicle { // public static by default
    public int getNoOfWheels() {
      return 2;  
    }  
  }
}

class Bus implements Vehicle {
  public int getNoOfWheels() {
    return 6;  
  }  
}

class Test {
  public static void main(String[] args) {
    Vehicle.DefaultVehicle d = new Vehicle.DefaultVehicle();
    System.out.println(d.getNoOfWheels()); // 2
    Bus b = new Bus();
    System.out.println(b.getNoOfWheels()); // 6
  }  
}
```

In the above example DefaultVehicle is default implementation of Vehicle
interface. Whereas Bus is customized implementation of Vehicle interface.

**NOTE:** The class which is declared inside interface is always 'public static'
whether we are declaring or not. Hence, we can create class object directly
without having outer interface type object.

##### Conclusions
1. Among class and interfaces we can declare anything inside anything.

```java
class A {
  class B {
   //
  }
}
```

```java
class A {
  interface B {
   //
  }
}
```
```java
interface A {
  interface B {
   //
  }
}
```

```java
interface A {
  class B {
   //
  }
}
```
2. the interface which is declared inside interface is always 'public static'
   whether we are declaring or not.

3. The class which is declared inside interface is always 'public static'
   whether we are declaring or not.

4. Interface which is declared inside class is always 'static' but need not be
   public.
