# Garbage Collector 
- Introduction
- The ways to make an object eligible for GC
- The methods for requesting JVM to run GC
- Finalization


## Introduction
In old languages like C++, programmer is responsible to create new object and to
destroy useless objects. Usually programmer is taking very much care while
creating objects and neglecting destruction of useless objects. Because of this
neglecting at certain point for creation of new objects sufficient memory may
not be available. Because total memory filled with useless  objects only. And
total application will be down with the memory problems. Hence out of memory
error is very common problem in old languages like C++.

But in Java programmer is responsible only for creation of objects. And
programmer is NOT responsible to destroy useless objects. Sun people provided
one assistant to destroy useless objects. This assistant is always running in
the background(deamon thread) and destroys useless object.s Just because of this
assistant, the chance of failing Java program with memory problem is very low.
(Robust) This assistant is nothing but Garbage Collector.

Hence the main objective of GC is to destroy useless objects.

## The Ways to Make an Object Eligible for GC
Even though programmer is not responsible to destroy useless objects, it is
highly recommended to make an object Eligible for GC if it is no longer
required. 

An object is said to be eligible for GC if and only if it doesnot contain any
reference variable. 

The following are various ways to make an object eligible for GC:

1. Nullifying the Reference Variable
If an object is no longer required, then assign null to all its reference
variables. Then that object is automatically eligible for GC. This approach is
nothing but 'nullifying the reference variable'.
```java
Student s1 = new Student();
Student s2 = new Student();
//---------- No object is eligible for GC
// s1 is no longer required
s1 = null;
// --------- One object is eligible for GC
// s2 is no longer required
s2 = null;
// --------- Two objects are eligible for GC
```

2. Reassigning the Reference Variable
If an object is no longer required, then reassign its reference variable to some
other object, then old object is by default eligible for GC.

```java
Student s1 = new Student();
Student s2 = new Student();
//---------- No object is eligible for GC
// a new student object is reqired, 
s1 = new Student();
// --------- One object is eligible for GC
s2 = s1;
// at this point there are three objects, but variable references pointing to
// same object. Two objects are without reference variables.
// --------- Two objects are eligible for GC
```

3. Objects Created Inside a Method
The objects which are created inside a method are by default eligible for GC
once method completes. (Object references are local variables, they will be
destroy after completing method call)

```java
class Test {
  public static void main(String[] args) {
    m1();
    // two objects are eligible for GC
  }

  public static void m1() {
    Student s1 = new Student();
    Student s2 = new Student();
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    Student s =  m1();
    // one object is eligible for GC
  }

  public static Student m1() {
    Student s1 = new Student();
    Student s2 = new Student();
    return s1;
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    m1();
    // two objects are eligible for GC
  }

  public static Student m1() {
    Student s1 = new Student();
    Student s2 = new Student();
    return s1;
  }
}
```

```java
class Test {
  static Student s;
  public static void main(String[] args) {
    m1();
    // one object is eligible for GC
  }

  public static void m1() {
    s = new Student();
    Student s2 = new Student();
  }
}
```

4. Island of Isolation


```java
class Test {
  Test i;

  public static void main(String[] args) {
    Test t1 = new Test();
    Test t2 = new Test();
    Test t3 = new Test();
    // no object is eligible for GC
    t1.i = t2;
    t2.i = t3;
    t3.i = t1;
    // no object is eligible for GC
    t1 = null;
    t2 = null;
    t3 = null;
    // three objects are eligible for GC
    // there is no external reference variable to reach them
    // draw diagram
  }
}
```

**NOTE:** If an object doesnt contain any reference variable, then it is
eligible for GC always.

**NOTE:** Even though objects having references sometimes it is eligible for GC.
(If all references are internal references). Example; island of Isolation

## The Methods/Ways for Requesting JVM to Run GC
Once we made an object eligible for GC, it may not be destroyed immediately by
GC. Whenever JVM runs GC then only the objects will be destroyed. But when
exactly JVM runs GC, we cannot expect, it is varied from JVM to JVM. Instead of
waiting until JVM runs GC, we can request JVM to GC programmatically. But
whether JVM accepts our request or not there is no guarantee. But most of times
JVM accepts our request.

The following are two ways for requesting JVM to run GC:

1. By using System class.
System class contains a static method 'gc()' for this purpose.

```java
System.gc();
```

2. By using Runtime class
Java application can communicate with JVM  by using Runtime object. Runtime
class present in java.lang package, and it is a signleton class. WE can create
Runtime object by using Rumtime.getRuntime() method.

```java
Runtime r = Runtime.getRuntime();
```

Once we got Runtime object, we can call the following methods on that object:

```java
r. totalMemory();
// it returns number of bytes of total memory present in the heap(heap size)

r.freeMemory();
// it returns number of bytes of free memory present in the heap

r.gc();
// for requesting jvm to run garbage collector
```


```java
import java.util.Date;

class RuntimeDemo {
  public static void main(String[] args) {
    Runtime r = Runtime.getRuntime();
    System.out.println(r.totalMemory());
    System.out.println(r.freeMemory());
    for (int i=0; i<1000; i++) {
      Date d = new Date();
      d = null;
    }

    System.out.println(r.freeMemory());
    r.gc();
    System.out.println(r.freeMemory());
  }
}

```

**NOTE:** gc() present in System class is a static method, wheras gc() method
present in Runtime class is an instance method.

**Question:** Which of the following is valid way for requesting JVM to run GC?

```java
System.gc(); // valid: is a static method
Runtime.gc(); // invalid: in Runtime class gc is an instance method
(new Runtime()).gc(); // invalid, Runtime is a singleton class
Runtime.getRuntime().gc(); // valid, System.gc() internally does the same as this
```

**NOTE:** It is convinient to use System.gc() method when compared with Runtime
class gc() method. With the respected to performance it is highly recommended to
use Runtime class gc() when compared with System class gc() method. Because
System.gc() internally calls Runtime class gc() method.

```java
class System {
  public static void gc() {
    Runtime.getRuntime().gc();  
  }  
}
```

## Finalization
Just before destroying an object GC calls finalize method to perform cleanup
activities. Once finalize() method completes, automatically GC destroys that
object. finalize() method present in Object class with the following
declaration:

```java
protected void finalize() throws Throwable {}
```

We can override finalize() method in our class to define our own cleanup activities.

### Case 1:
Just before destroying an object GC calls finalize() method on the object which
is eligible for GC. Then corresponding class finalize() method will be executed.
For example, if String object is eligible for GC, then String class finalize()
method will be executed. But not Test class finalize() method.

```java
class Test {
  public static void main(String[] args) {
    String s = new String("selim");
    s = null;
    System.gc();
    System.out.println("end of main");
  }

  public void finalize() {
    System.out.println("finalize method called");  
  }
}
```

In the above example String object is eligible for GC, and hence String class
finalize() method got executed, which has empty implementation. Hence the output
is:
```java
// o/p: end of main
```

If we replace String object with Test object, then Test class finalize() method
will be executed. In this case the output is:
```java
// end of main
// finalize method called
// or (after calling gc, there are two threads)
// finalize method called
// end of main
```

### Case 2
Based on our requirement we can call finalize() method explicitly, then it will
be executed just like a normal method call and object wont be destroyed.

```java
class Test {
  public static void main(String[] args) {
    Test t = new Test();
    t.finalize(); // just like normal method call
    t.finalize(); // just like a normal method call
    t = null;
    System.gc();
    System.out.println("end of main");
  }

  public void finalize() {
    System.out.println("finalize method called");  
  }
}
```

**NOTE:** In the above program finalize() method got executed 3 times, two times
explicitly by programmer and one time by GC. In this case output is:

```java
finalize method called
finalize method called
end of main
finalize method called
```

**NOTE:** If we are calling finalize() method explicitly, then it will be
executed like a normal method call and the object wont be destroyed. If GC calls
finalize() method, then object will be destroyed.

**NOTE:** init(), service() and destroy() methods are considered as life cycle
methods of servlets. Just before destroying servlet object, web container calls
destroy() method to perform cleanup activities. But based on our requirement we
can call destroy method from init() and service() methods, then destroy() method
will be executed just like a normal method call and servlet object wont be
destroyed.

### Case 3 : with exception throwing



### Case 4:
Even though object is eligible for GC multiple times, but GC calls finalize()
method only once.

```java
class FinalizeDemo {
  static FinalizeDemo s;

  public static void main(String[] args) throws Exception {
    FinalizeDemo f = new FinalizeDemo();
    System.out.println(f.hashCode()); // 100
    f = null;
    System.gc();
    Thread.sleep(5000);
    System.out.println(s.hashCode()); // 100
    s = null;
    System.gc();
    Thread.sleep(10000);
    System.out.println("end of main");
  }

  public void finalize() {
    System.out.println("finalize method called");  
    s = this; // giving a new reference variable to object
  }
}
```

```java
// output
// 100
// finalize method called
// 100
// end of main
```

In the above program even though object is eligible for GC two times, but GC
calls finalize method only once.

### Case 5:
We cannot expect exact behaviour GC, it is varied from JVM to JVM. Hence for the
following questions we cannot provide exact answers:

1. When exactly JVM runs GC?
2. In which order GC identifies eligible objects?
3. In which order GC destroys eligible objects?
4. Whether GC destroys all eligible objects or not?
5. What is the algorithm folloed by GC?

**NOTE:** Whenever program runs with low memory, then JVM runs GC. But we can
expect exactly at what time. 

**NOTE:** Most of the GC follow standard algorithm 'mark and sweep'. It doesnt mean every
GC follows the same algorithm.

```java
class Test {
  static int count = 0;

  public static void main(String[] args) {
    for (int i=0; i<10; i++) { // LOOP COUNTER
      Test t = new Test();
      t = null;
    }
  }

  public void finalize() {
    System.out.println("finalize method called:" + ++count);  
  }
}
```

If we keep increasing LOOP COUNTER, at a certain point memory problem will be
raised. Then JVM runs GC. GC call finalize() method on every object separately
and destroys that object.

### Case 6: Memory Leaks
The objects which are used in our program and which are not eligible for GC such
type of useless objects are called memory leaks.

In our program if memory leaks present, then program will be terminated by
raising OutOfMemoryError. Hence If an object is no longer required, it is highly
recommended to make that object eligible for GC.

The following are various 3rd party memory management tools to identify memory
leaks:

- HP OVO
- HP J Meter
- JProbe
- Patrol
- IBM Tivoli
