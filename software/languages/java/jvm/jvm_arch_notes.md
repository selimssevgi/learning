# JVM Architecture

* Module 1
- Virtual Machine
- Type of Virtual Machines
  1. Hardware based VM
  2. Application based VM
- Basic Architecture of JVM
- Class Loader Subsystem
  1. Loading
  2. Linking
  3. Initialization
- Types of Class Loaders
  1. Bootstrap Class Loader
  2. Extension Class Loader
  3. Application Class Loader
- How Class Loader Works
- What is the need of Customized Class Loader
- Psuedo code for Customized Class Loader

* Module 2
- Various Memory Areas of JVM
  1. Method Area
  2. Heap Area
  3. Stack Area
  4. PC Registers
  5. Native Method Stacks
- Program to display heap memory statistics
- How to set Maximum and Minimum heap size?
* Module 3
- Execution Engine
  1. Interpreter
  2. JIT Compilers
- Java Native Interface(JNI)
- Complete Architecture Diagram of JVM
- Class File Structure


## Virtual Machine
It is a software simulation of a machine, which can perform operation like a
physical machine. There are two types of VM:

1. Hardware Based | System Based
2. Application Based | Process Based

### Hardware | System Based Virtual Machine
It provides several logical systems on the same computer with the strong
isolation from each other. That is, on one physical machine we are defining
multiple logical machines.

The main advantage of hw based VM is, hardware resources sharing and improves
utilization of hardware resources. Example: KVM[Kernel based VM for Linux
System], VMWare, Xen, Cloud computing etc.

### Application | Process based Virtual Machine
These VMs act as runtime engines to run a particular programming language
applications.

- JVM(Java VM): Acts as runtime engine to run Java based applications.
- PVM(Perl VM): Acts as runtime engine to run Perl based applications.
- CLR(Common Language Runtime): Acts as runtime engine to run .NET based app.

#### JVM
JVM is a part of JRE and it is responsible to load and run java class file.

- Load .class file
- Run  .class file

## Basic Architecture of JVM

.class file ==> [Class Loader SubSystem]
                      ^^
                      ||
                      ||
                      ||
                      VV
         [Varios Memory Areas of JVM]
(Method)(Heap)(Stack)(PC Registers)(Native Method Stacks)
                      ^^
                      ||
                      ||
                      ||
                      VV
             [Execution Engine] <===> [JNI] <=== [Native Method Libraries]

## Class Loader Subsystem
Class Loader Subsystem is responsible for the following 3 activies:

1. Loading
2. Linking
3. Initialization

#### Class Loader Subsystem - 1. Loading
Loading means reading class files and store corresponding binary data in method
area. For each class file JVM will store corresponding information in the method
area.

1. Fully qualified name of class
2. Fully qualified name of immediate parent class
3. Methods information
4. Variables/Fields information
5. Constructors information
6. Modifiers information
7. Constant pool information

Test.class(on HDD) --- reading/loading/storing ---- method area by CLSubsystem


After loading .class file,immediately JVM creates an object for that loaded
class in heap memory of type java.lang.Class.

- Student.class(on HDD) -- CLsubsystem loads --->
- Student.class information(on method area of JVM) --- JVM creates --->
- Class class object to represent Student.class information(on heap area of JVM)

**NOTE:** The object being create by JVM is type of Class(java.lang.Class) to
hold Student.class information.


Class class object can be used by programmer to get class level information like
methods information or variables information, constructors information etc.


```java
import java.lang.reflect.*;
class Student {
  public String getName() {
    return null;
  }

  public int getMarks() {
    return 10;
  }
}

class Test {
  public static void main(String[] args) throws Exception {
    int count = 0;
    Class c = Class.forName("Student");
    // Class c = Class.forName("java.lang.Object");
    Method[] methods = c.getDeclaredMethods();
    for (Method m : methods) {
      count++;
      System.out.println(m.getName());
    }

    System.out.println("number of methods: " + count);
  }
}
```

**NOTE:** For every loaded type only one class object will be created even
though we are using class multiple times in our program.

```java
import java.lang.reflect.*;
class Student {
  public String getName() {
    return null;
  }

  public int getMarks() {
    return 10;
  }
}

class Test {
  public static void main(String[] args) throws Exception {
    Student s1 = new Student();
    Class c1 = s1.getClass();

    Student s2 = new Student();
    Class c2 = s2.getClass();

    System.out.println(c1.hashCode()); // 26117676
    System.out.println(c2.hashCode()); // 26117676
    System.out.println(c1 == c2); // true
  }
}
```

Student.class(onHDD) --load--> methodAreaJVM --creates--> Class object for
Student(HeapAreaJVM).

c1 ve c2 refers to same Class object created by JVM only once.

In the above program even though we are using Student class multiple times, only
one Class class object got created.

#### Class Loader Subsystem - 2. Linking
Linking consists of 3 activies:

1. Verify
2. Prepare
3. Resolve

##### Linking - 1.Verify
It is a process of ensuring that binary representation of a class is structurely
correct or not. That is, JVM will check whether .class file is generated by
valid compiler or not. That is, .class file is properly formatted or not.

Internally 'Bytecode Verifier' is responsible for this activity. Bytecode
verifier is a part of Class Loader Subsystem.

If verification fails, then we will get RE: java.lang.VerifyError.

**NOTE:** This is the very reason why Java is considered as a secure language.


##### Linking - 2.Prepare
In this phase JVM will allocate memory fro class level static variables and
assign default values.

**NOTE:** In initialization phase original values will be assigned to static
variables and here only default values will be assigned.

##### Linking - 3.Resolve
It is a process of replacing symbolic names in our program with the original
memory references from method area.

```java
class Test {
  public static void main(String[] args) {
    String s = new String("selim");
    Student s1 = new Student();
  }
}
```

For the above class, ClassLoader loads Test.class, String.class, Student.class
and Object.class(Parent of class is loaded too). The names of these classes are
stored in constant pool of Test class. In resolution phase these names are
replaced with original memory references from method area.

#### Class Loader Subsystem - 3. Initialization
In this all static variables are assigned with the original values and static
blocks will be executed from parent to child and from top to bottom.

- Assign original values
- Execute static blocks

                           Class Loader SubSystem
+-----------------------------------------------------------------------------+
|                                                                             |
|                     +-----------+                                           |
|                     |  Verify   |                                           |
|                     |    |      |                                           |
|  +---------+        |    |      |        +----------------+                 |
|  |         |        |    V      |        |                |                 |
|  | Loading | =====> |  Prepare  | =====> | Initialization |                 |
|  |         |        |    |      |        |                |                 |
|  +---------+        |    |      |        +----------------+                 |
|                     |    V      |                                           |
|                     |  Resolve  |                                           |
|                     +-----------+                                           |
|                        Linking                                              |
|                                                                             |
+-----------------------------------------------------------------------------+
                           Class Loader Process

**NOTE:** While loading, linking, and initialization if any error occurs, then
we will get runtime exception saying java.lang.LinkageError.

## Types of Class Loaders
Class Loader Subsystem contains the following 3 types of class loaders:

1. Bootstrap class loader | premordial class loader
2. Extension class loader
3. Application class loader | System class loader

### Bootstrap Class Loader
Is responsible to load core java api classes. That is, the classes present in
rt.jar.


```shell
JDK
 |-- JRE
      |-- lib
           | -- rt.jar
```

JDK/JRE/lib location is called bootstrap classpath. That is, bootstrap class
loader is responsible to load classes from bootstrap classpath.

Bootstrap class loader is by default available with every JVM. It is implemented
in native languages like C/C++ and not implemented Java.

### Extension Class Loader
Extension class loader is child class of bootstrap class loader. Extension class
loader is responsible to load classes from extension class path(JDK/JRE/lib/ext)

```shell
JDK
 |-- JRE
      |-- lib
           |-- rt.jar
           |-- ext
                 |-- *.jar
```

Extension class loader is implemented in Java, and the correspoding .class file
is: sun.misc.Launcher$ExtClassLoader.class.

### Application Class Loader | System Class Loader
Application class loader is the child class of extension class loader. This
class loader is responsible to load classes from application classpath. It
internally uses environment variable classpath.

Application class loader is implemented in java and correspoding .class file
name is: sun.misc.Launcher$AppClassLoader.class.

Bootstrap CL (JDK/JRE/lib/rt.jar, implemented in C/C++)
    ^
    |
Extension CL (JDK/JRE/lib/ext/\*.jar, sun.misc.Launcher$ExtClassLoader.class)
    ^
    |
Application CL (classpath env variable, sun.misc.Launcher$AppClassLoader.class)

## How Class Loader Works

1. JVM request .class file from Class Loader Subsystem
2. Class Loader Subsystem requests from Application Class Loader
3. Application Class Loader delegates it to Extension Class Loader
4. Extension Class Loader delegates it to Bootstrap Class Loader
5. BCL searches in Bootstrap Classpath(JDK/JRE/lib/)
6. BCL delegates back to ECL
7. ECL searches in Extension Classpath(JDK/JRE/lib/ext)
8. ECL delegates back to ACL
9. ACL searches in Application Classpath(environment variable classpath)
10. If still not found, RE:
    - ClassNotFoundException
    - NoClassDefError

Class Loader follows *delegation hierarchy algorithm*.

Whenever JVM come across a particular class, first it will check whether the
correspoding .class file is already loaded or not. If it is already loaded in
method area, then JVM will considered that loaded class. If it is not loaded,
then JVM requests Class Loader Subsystem to load that particular class. Then
Class Loader Subsystem hands over the request to Application Class Loader.
Application Class Loader delegates the request to Extension Class Loader, which
in turn delegates the request to Bootstrap Class Loader. Then BCL will search in
Bootstrap Classpath. If it is available, then the correspoding .class will be
loaded by BCL. If it is not available, then BCL delegates the request to ECL.
ECL will search in Extension Classpath. If it is available, then it will be
loaded, otherwise ECL delegates the request to ACL. ACL will search in
Application Classpath. If it is available, then it will be loaded. Otherwise we
will get RE: NoClassDefFoundError or ClassNotFoundException.


```java
class Test {
  public static void main(String[] args) {
    System.out.println(String.class.getClassLoader());
    System.out.println(Test.class.getClassLoader());
    System.out.println(Customer.class.getClassLoader());
  }
}

// null : because BCL is not implemented in Java
// sun.misc.Launcher$AppClassLoader@1234
// sun.misc.Launcher$ExtClassLoader@5678


// Assume Customer.class present in both extension and application classpath
// Test.class present only application classpath
```

For String.class:
Bootstrap Class Loader from Bootstrap classpath

For Test.class:
Application Class Loader from Application classpath

For Customer.class:
Extension Class Loader from Extension classpath


**NOTE:** Bootstrap Class Loader is not Java object, hence we got null in the
first case. But extension and application class loaders are java objects. Hence,
we are getting correspoding output for the remaining two statements.


**NOTE:** Class Loader Subsystem will give the highest priority for Bootstrap
Classpath, and then extension classpath and followed by application classpath.

## Need of Customized Class Loader
Default Class Loader will load .class file only once even though we are using
multiple times that class in our program. After loading .class file if it is
modified outside, then default class loader wont load updated version of class
file(because that .class is already available in method area). We can resolve
this problem by defining our own costomized class loader. The main advantage of
customized class loader is, we can control class loading mechanism based on our
requirement. For example; we can load .class file separately every time so that
updated version available to our program.

```java
// default class loading
Student s = new Student(); // Load Student.class file
//.
//. PROBLEM: at this point Student.class file might be modified
Student s1 = new Student(); // use loaded Student.class file
//.
//.
Student s2 = new Student(); // use loaded Student.class file
```

```java
// customized class loading
Student s = new Student(); // Load Student.class file
//.
//.
Student s1 = new Student(); // check if Student.class is modified, then load the
                            // modified version. If not, use the loaded one
//.
//.
Student s2 = new Student(); // check if Student.class is modified, then load the
                            // modified version. If not, use the loaded one
```

## Psuedo code for Customized Class Loader
We can define our own customized class loader by extending
java.lang.ClassLoader.

```java
public class CustClassLoader extends ClassLoader {
  public Class loadClass(String cname) throws ClassNotFoundException {
    // check for updates(modifid version) & load updated .class file
    // and return corresponding Class
  }
}

class Client {
  public static void main(String[] args) {
    Dog d1 = new Dog(); // loaded by default class loader
    CustClassLoader cl = new CustClassLoader();
    // .
    // .
    // .
    cl.loadClass("Dog"); // loaded by customized class loader
    // .
    // .
    // .
    cl.loadClass("Dog"); // loaded by customized class loader
  }
}
```

**NOTE:** While developing web servers and application servers, usually we can
go for customized class loaders to customize class loading mechanism.

**QUESTION:** What is the need of ClassLoader class?
We can use java.lang.ClassLoader class to define our own customized class
loaders. Every class loader in java should be child class of
java.lang.ClassLoader class either directly or indirectly. Hence this class acts
as base class for all customized class loaders.

## Various Memory Areas of JVM
Whenever JVM loads and runs a java program, it needs memory to store several
things like byte code, objects, variables etc.

Total JVM memory is organized following 5 categories:

1. Method Area (JVM)
2. Heap Area (JVM)
3. Stack Area (Thread)
4. PC Registers
5. Native Method Stacks


### Method Area
- For every JVM one method area will be available.
- Method area will be created at the time of JVM start-up.
- Inside method area class level binary data including static variables are stored
- Constant pools of a class will be stored inside method area

[ (Class Level Data) (Class Level Data) (Class Level Data)] <- Method Area

- It needs not to be contunios memory.
- It is global data area.
- Method Area can be accessed by multiple threads simultaneosly. Hence it is not
thread-safe.

### Heap Area
- For every JVM one heap area is available.
- Heap Area will be created at the time of JVM start-up.
- Objects and corresponding instance variables will be stored in heap area.
- Every array in Java is object only. Hence arrays are also stored in heap area.
- Heap Area can be accessed by multiple threads, hence data stored in the heap area is not thread-safe.
- Heap Area need not be contunious.

[ (Object Data) (Object Data) (Object Data)] <- Heap Area

##### Program to display heap memory statistics
A java application can communicate with the JVM by using Runtime object. Runtime
class present in java.lang package and it is a singleton class. We can create
runtime object as follows:

```java
Runtime r = Runtime.getRuntime();
```

Once we got runtime object, we can call the following methods on that object:

1. maxMemory() : it returns the number of bytes of max memory allocated to heap.
2. totalMemory() : It returns number of bytes of total memory allocated to heap.(initial memory)
3. freeMemory(): It returns number of bytes of free memory present in the heap.

```java
class HeapDemo {
  public static void main(String[] args) {
    Runtime r = Runtime.getRuntime();

    long KB = 1024;
    long MB = 1024 * 1024;
    double GB = KB * MB;
    System.out.println("Max memory: " + r.maxMemory() / MB);
    System.out.println("Initial(total) memory: " + r.totalMemory());
    System.out.println("Free memory: " + r.freeMemory());
    System.out.println("Consumed memory: " + r.totalMemory() - r.freeMemory());
  }
}
```

##### How to set Maximum and Minimum heap size
Heap memory is finite memory. But based on our requirement we can set max and
min heap sizes. That is, we can increase and decrease the heap size based on our
requirement.

We can use the following flags with java command:

- (-Xmx) to set max heap size(maxMemory).

```shell
$ java -Xmx512m HeapDemo
// this command will set the max heap size as 512MB
```

- (-Xms) to set min heap size(totalMemory).

```shell
$ java -Xms64m HeapDemo
// this command will set the min heap size as 64MB
```

### Stack Area
For every thread JVM will create a separate stack at the time of thread
creation. Each and every method call performed by that thread will be stored in
the stack including local variables also. After completing a method, the
corresponding entry from stack will be removed. After completing all method
calls, the stack will become empty. And that empty stack will be destroyed by
the JVM just before terminating the thread.

Each entry in the stack is called stack frame or activation record.


The data stored in the stack is available *only* for the corresponding thread.
And not available to the remaining thread. Hence this data is thread-safe.

+-----------------------------------------------------------------------------+
|                                                                             |
|    Thread-1            Thread-2          Thread-3          Thread-4         |
|                                                                             |
|  |           |       |           |     |           |     |           |      |
|  |-----------|       |-----------|     |-----------|     |-----------|      |
|  |           |       |           |     |           |     |           |      |
|  |-----------|       |-----------|     |-----------|     |-----------|      |
|  |Stack Frame|       |           |     |           |     |           |      |
|  +-----------+       +-----------+     +-----------+     +-----------+      |
|  Runtime Stack       Runtime Stack     Runtime Stack     Runtime Stack      |
|                                                                             |
+-----------------------------------------------------------------------------+
                                Stack Area

##### Stack Frame Structure
Each stack frame contains 3 parts:

+------------------------+
|  local variable array  |
|------------------------|
|  operand stack         |
|------------------------|
|  frame data            |
+------------------------+
Stack Frame

###### Local Variable Array
- It contains all parameters and local variables of the method.
- Each slot in the array is of 4 bytes.
- Values of type int, float, and reference occupy 1 slot in the array.
- Value of double and long occupy 2 consequtive slots in the array.
- byte, short and char values will be converted to int type before storing and
  occupy 1 slot.

**NOTE:** But the way of storing boolean values is varied from JVM to JVM.
But Most of the JVM follow one slot for boolean values.

```java
public void m1(int i, double d, Object o, float f) {
  long x;
}
```

+---------------------------+
| i | d | d | o | f | x | x |
+---------------------------+
Local Variable Array

###### Operand Stack
JVM uses operand stack as workspace. Some instructions can push values to
operand stack and some instructions can pop values from operand stack, and some
instructions can perform required operations.

[One of the most obvious ways that the JVM doesnt look like a hardware CPU(x64
or ARM chip) is that JVM doesnt have processor registers, and instead uses a
stack for all calculations and operations.]

###### Frame Data
Frame Data contains all symbolic references to that method. It also contains a
reference to exception table which provides corresponding catch block
information in case of exception.

### PC Registers (Program Counter Registers)
For every thread a separate PC Register will be created at the of thread of
creation.

PC Register contains the address of current executing instruction. Once
instruction execution completes, automatically PC Register will be incremented
to hold the address of next instruction.

### Native Method Stacks
For every thread JVM will create a separate native method stack.

All native method calls invoked by the thread will be stored in the
corresponding native method stack.


## Conclusions
1. Method area, heap area and stack area are considered as important memory areas
   with the respected to programmer.

2. Method Area and Heap Area are per JVM. Whereas Stack Area, PC Register, Native
   Method Stack are per thread.

For every JVM ---> one Method Area
              ---> one Heap   Area

For every thread ---> one Stack Area
                 ---> one PC Register
                 ---> one Native Method Stack

3. Static variables will be stored in Method Area.
4. Instance variables will be stored in Heap Area.
5. Local variables will be stored in Stack Area.

```java
class Test {
  Student s1 = new Student();
  static Student s2 = new Student();

  public static void main(String[] args) {
    Test t = new Test();
    Student s3 = new Student();
  }

}
```

Firstly, it will create s2 variable object.

s2(in Method Area) -----> StudentObject(in Heap Area)

Test t is local variable, will be placed in stack area.

t(in Stack Area) -----> TestObject(in Heap Area)

As a part of test object s1 variable will be initialized:

s1(in TestObject in Heap Area) ---> AnotherStudentObject(in Heap Area)

s3 is local variable.

s3(in Stack Area) ----> OneMoreStudentOBject(in Heap Area)

(draw on paper is easir to see)

## Execution Engine
This is the central compenent of JVM. Execution engine is responsible to execute
Java .class files. Execution engine mainly contains two components:

1. Interpreter
2. JIT Compiler

### Interpreter
It is responsible to read bytecode and interpret into machine code(native code),
and execute that machine code line by line. The problem with the interpreter is,
it interprets every time even same method invoked multiple times, which reduces
performance of the system. To overcome this problem, SUN people introduced JIT
Compiler in 1.1V.

- read -> interpret -> execute

### JIT Compiler
The main porpuse of JIT Compiler is improve performance. Internally JIT Compiler
maintains a separate count for every method. Whenever JVM come across any method
call, first that method will be interpreted normaly by interpreter and JIT
Compiler increments the corresponding count variable. This process will be
contunied for every method. Once if any method count reaches treshold value,
then JIT Compiler identifies that, that method is a repeatedly used method(Hot Spot).
Immedeately JIT Compiler compiles that method and generates the corresponding
native code. Next time JVM come across that method call, then JVM uses native
code directly and executes it instead of interpreting once again. So that
performance of the system will be improved.

Threshold count is varied from JVM to JVM.


Some advancaed JIT COmpiler will recompile generated native code if count
reaches threshold value second time so that more optimized machine code will be
generated.

Internally profiler, which is part of JIT Compiler, is responsible to identify
hot spots.

**NOTE:** JVM interprets total program at least once.

**NOTE:** JIT Compilation is applicable only for repeatedly required methods and
not for every method.

+-----------------------------------------------------------------------------+
|            |                 JIT COMPILER                |                  |
|    i       |        1-----------+     3-----------+      |                  |
|    n       |        |inter. code|     |target code|      |                  |
|    t       |        | generator |     | generator |      |   Garbage        |
|    e       |        +-----------+     +-----------+      |   Collector      |
|    r       |                                             |  etc.            |
|    p       |        2-----------+     4-----------+      |                  |
|    r       |        |   code    |     |  machine  |      |                  |
|    e       |        | optimizer |     |    code   |      |                  |
|    t       |        +-----------+     +-----------+      |                  |
|    e       |                   +-----------+             |                  |
|    r       |                   | profiler  |             |                  |
|            |                   +-----------+             |                  |
+-----------------------------------------------------------------------------+
                                Execution Engine

## Java Native Interface(JNI)
JNI acts as mediater for java method calls and corresponding native libraries.
That is, JNI is responsible to provide information about native libraries to
JVM. Native Method Library holds native libraries information.

[Execution Engine] <===> [JNI] <=== [Native Method Libraries]

## Complete Architecture Diagram of JVM

Java Source File(.java)
       |
       V
Java Compiler(javac)
       |
       V
Java Class File(.class)
       |
       V
Class Loader Subsystem
       |
       V
    Loading by
  Bootstrap Class Loader or
  Extension Class Loader or
  Applicati Class Loader
       |
       V
    Linking
  Verify(ByteCode Verifier)
  Prepare(Allocate memory and assign default values)
  Resolve(Replace identifer with memory addresses)
       |
       V
    Initialization
  Assign values of static variables
  Execute static blocks
       |
       V
  Various Memory Areas Of JVM
       |
       V
  Method Area
  Class Data
       |
       V
   Heap Area
   Object data
       |
       V
  Stack Area
  One runtime stack per thread
       |
       V
  Stack Frame
  Local variable array
  Operand Stack
  Frame Data
       |
       V
  PC Registers
  one pc register per thread
       |
       V
  Native Method Stack
  native method stack per thread for native methods(hashCode)
       |
       V
  Execution Engine
       |
       V
  Interpreter
       |
       V
  JIT Compiler
  for methods count passing threshold
  profiler does the counting and decides which method
       |
       V
  Garbage Collector
  Security Manager 
  Etc
       |
       V
      JNI
       |
       V
  Native Method Libraries


## Class File Structure


```java
classFile {
  magic_number;
  minor_version;
  major_version;
  constant_pool_count;
  constant_pool[];
  access_flags;
  this_class;
  super_class;
  interface_count;
  interface[];
  fields_count;
  fields[];
  methods_count;
  methods[];
  attributes_count;
  attributes[];

  
}
```

#### magic_number
The first 4 bytes of class file is magic number. This is a predefined value used
by JVM to identify .class file generated by valid compiler or not. The value
should be 0xCAFEBABE.

**NOTE:** Whenever we are executing a java class, if JVM is unable to find valid
magic number, then we will get RE: j.l.ClassFormatError : incompatible magic value.

### minor_version and major_version
represents .class file version. JVM will use these versions to identify which
version of compiler generated current .class file.

- M.m
  - M: major version
  - m: minor version

- 1.5V : 49.0
- 1.6V : 50.0
- 1.7V : 51.0

**NOTE:** Lower version compiler generated .class files can be run by higher
version JVM. But higher version compiler generated .class file cannot be run by
lower version JVMs. If we are trying to run, we will get runtime exception
saying: j.l.UnsupportedClassVersionError.

- javac 1.6V ==> java 1.7 /valid
- javac 1.7V ==> java 1.6 / RE: UnsupportedClassVersionError

### constant_pool_count
It represents the number of constants present in constant pool.

### constant_pool_count[]
It represents information about constants present in constant pool.

### access_flags
It provides information about modifiers which are declared to the class.

### this_class
It represents fully qualified name of the class.

### super_class
It represents fully qualified name of immediate super class of current class.

- Test.class
- this_class : Test
- super_class : Object

### interface_count
It returns the number of interfaces implemented by current class.

### interfaces[]
It presents interfaces information implemented by current class.

### fields_count
It presents the number of fields(static variables) in the current class.

### fields[]
It represents fields information present in current class.

### methods_count
It represents the number of methods present in current class.

### methods[]
It provides information about all methods present in current class.

### attributes_count
It returns the number of attributes(instance variable) present in current class.

### attributes[]
It provides information about all attributes present in current class.


```shell
javap -verbose Test.class
// information in the class file in readable format
```
