# Notes from Jav How to Program - Deitel 8th Edition

## CHAPTER 1

- Java Enterprise Edition(EE) is geared toward developing large-scale,
  distributed networking applications and web-based applications.

- Java Micro Edition(ME) is geared toward developing applications for small,
  memory-constrained devices, such as cell phones, pagers and PDAs.

- Java Class Libraries == Java APIs

- Java Development Environment
  - Phase 1: Edit    Editor - Disk - .java
  - Phase 2: Compile Compiler  - Disk - .class
  - Phase 3: Load    Class Loader - from disk to memory
  - Phase 4: Verify  Bytecode Verifier - confirms that do not violate javas security
  - Phase 5: Execute JVM - reads bytecodes and JIT compiles them into machines lang

```shell
# Compile a java program
$ javac ClassName.java
# Run a java program
$ java ClassName
```

#### Java HotSpot Compiler
Translates the bytecodes into the underlying machine language.
When JVM encounters these compiled parts again, the faster machine-language code executes.
Thus Java programs actually go through two compilation
phases—one in which source code is translated into bytecodes
(for portability across JVMs on different computer platforms)
and a second in which, during execution, the bytecodes are translated into
machine language for the actual computer on which the program executes.

#### Computer Organization
  - Input unit
  - Output unit
  - Memory unit
  - ALU
  - CPU
  - Secondary stroage

Not: Agile Software and Design Patterns

## CHAPTER 2 - Intro to Java Applications

```java
/**
  * Javadoc commets
 */
```

- syntax errors - compiler errors - compile-time errors - compilation errors

#### 8 primitive types :
  boolean, byte, char, short, int, long, float, double

```java
if( num1 == num2 ); // logic error

if( num1 == num2 )
  ; // empty statement
```
## CHAPTER 3 - Control Statements - Part 1

* sequential execution - execute one after another
  - transfer of control
  - goto statement
  - structured programming - "goto elimination"

**Not:** goto is a reserved word in java.

### Three Control Structures
  - sequence structure
  - selection structure
    - If statement - single selection statement
    - If-Else statment - double selection statement
    - Switch statement - multiple selection statement
  - repetition structure - looping structure
    - for
    - while
    - do while


**Not:** Control statements can be combined in only two ways : stacking and nesting.

Counter-controlled repetition (10 students):
  Sentinel-controlled repetition (arbitrary number, signal value, dummy value, flag value )

* Three logical phases
  - initializes the variables
  - processing input data
  - termination phase, final result

* Refinement of an algorithm, going in details.
  - initialize variables (first refinement)
  - initialize total to zero
  - initialize counter to zero (second refinement)

* Compound Assigment Operators
  a += 10

**NOT:** Primitive types in java are portable across all computer platforms that support java.

## CHAPTER 4 - Control Statements - part 2

- off-by-one errors, counting from 1 to 10 if while < 10

- loop-continuation condition

- Formatting Strings
  -  %20s  - field width 20 characters, default right justified
  -  %-20s - field width 20 characters, left justified

- Formatting Floating-point numbers
  -  %,20.2f - group them by comma, field width 20, 2 digits of precision, 1,234.05

**NOT:** Do not use variables of type double or float to perform precise monetary calculations.

* end-of-file indicator
  - on unix ctrl + d
  - on win  ctrl + z

* Dependent Condition
```java
  ( i != 0 ) && ( 10 / i )
```

* %b specifier used for printing true or false. ("%b", true && true)

## CHAPTER 5 - Methods

* modules in java : methods, classes, packages

* Every method should be limited to performing a single, well-defined task,
  and the name of the method should express that task effectively.

* static method = class method

* static fields = class variables

* "y + 2 = " + y + 2 => "y + 2 = 5 + 2" if y = 5, string concat from left to right

* Three ways of method calling
  - max(x,y) - using a method name by itself to call another method of the same class
  - input.nextDouble();
  - Math.sqrt(900.0);

* Activation record or stack frame. Keep track of local variables of method

* Randomazation : Random class or Math.rand
  - rand.nextInt();
  - rand.nextInt(2); // returns 0 or 1
  - rand.nextInt(6); // returns 0..5
  - rand.nextInt(6) + 1; // return 1..6, shifting by one

* To repeat the same random number, normally it takes systems time
  - new Random(seedValue);
  - rand.set( seedValue );
```java
private enum Status { CONTINUE, WON, LOST }
Status gameStatus;
gameStatus = Status.WON;
```

##### Shadowing
If a local variable or parameter in a method has the same as a field of the class,
the field is "hidden" until the block terminates execution.

**NOT:** Method calls cannot be distinguished by return type

## CHAPTER 6 - Arrays; Intro Strings and Files

* Java's types are divided into primitive types and references types
  - primitive types : boolean, byte, char, short, int, long, float and double

* Every array object knows its own length

```java
int[] intArr = new int[12];
int[] intArr = { 10, 20, 30, 40, 50 }; // array initializer
final int ARRAY_LENGTH = 10; // named constant
```

* "%5d" , start to print from the 5th column

* Arguments : method( args1, arg2 )

* Parameters : public void method( para1, para2 )

* Pass-by-value : a copy of the argument's value is passed

* Pass-by-reference : access and modify arguments value in the method

* Pass-by-reference improves performance by eliminating the need to copy possibly large amounts of data.

* In java all arguments are passed by VALUE.
  - copies of primitive values
  - copies of references to objects

**NOT:** If you modify a reference-type parameter so that it refers to another object,
  only the parameter refers to the new object—
  the reference stored in the caller’s variable still refers to the original object.
```java
// in main class
int[] myArray = {1,2,3};
test(myArray);
// myArray => {1,4,3}
// in test method
myArray[1] = 4; // this will change second element in original array
myArray = new int[10]; // this will not have any affect
```

* Variable-length arguments list : u can create methods that receive
  unspecified number of arguments.

```java
public static double average( double... numbers ) {
  // do something with numbers array
}
```

* Command line arguments

* class Arrays : sort, binarySearch, fill, copyarray

* Collection : ArrayList

* ASCII < Unicode

**NOT:** Java treats all string literals with the same content as a single String
  object that has many references to it. This conserves memory.

### String class
  - length, charAt, getChars
  - equals, equalsIgnoreCase, compareTo, regionMatches
  - startsWith, endsWith
  - indexOf, lastIndexOf
  - substring
  - concat
  - replace
  - toUpperCase, toLowerCase, trim
  - toCharArray
  - valueOf

* Java uses Unicode characters that are composed of two bytes, each composed of eight bits.

* bit - character - field - record - file

* byte-based stream : representing data in its binary format.

* character-based stream : representing data as a sequence of characters.

```java
Formatter output = new Formatter("clients.txt");
output.format("%d %s\n", 10, "apples");

Scanner input = new Scanner(new File( "clients.txt" ));
```
## CHAPTER 7 - Intro Classes and Objects

* Each new class you create becomes a new type that can be used. This is one
  reason why Java is known as an extensible language.

* Unlike local variables, which are not automatically initialized,
  every field has a default initial value.
    - primitive numerical types default 0
    - Objects defaults to null
    - boolean default to false

* Classes in the same package are implicitly imported into the source-code

## CHAPTER 8 - Classes and Objects: A Deeper Look

* if you declare any constructors for a class,
  the Java compiler will not create a default constructer for that class.

* If a class doesnt have any constructor, compiler provides a default one without args.

* If a class has a constructor defined, compiler wont provide the no-argument constructor.

* Hour range is 0-23, and values out of this range are not **consistent**.

* Java conserves storage by maintaining only one copy of each method per class.
This method is invoked by every object of the class.
Each object, on the other hand, has its own copy of the class’s instance variables (i.e., non- static fields).
Each method of the class implicitly uses this to determine the specific object of the class to manipulate.

* Static method cannot use 'this' keyword, cus it doesnt know which object it is operating on.

**NOT:** Dont access variables in a class direclty even in the class, use get methods.
  Representation of the field could change.

* When implementing a method of a class, use the class’s set and get methods to access the class’s
  private data. This simplifies code maintenance and reduces the likelihood of errors.

* Default constructor, passes default values in order to initialize the fields.

* Mutator methods = set methods

* Accessor methods = query methods = get methods

* Although set and get methods provide access to private data,
  the access is restricted by the implementation of the methods.
  This helps promote good software engineering.

* Predicate methods : another common use for accessor methods is to test whether a condition is true or false

#### Composition
A class can have references to objects of other classes as members.
Is sometimes referred to as a 'has-a relationship'

#### Enumaration
  - enum constants are implicitly 'final', cus they declare constants that shouldnt be modified.
  - enum constants are implicitly 'static'.
  - any attempt to create an object of an enum type with the operator
    new results in a compilation error.(cus contructors of enums must be private!)

* enum have values static method, for(ENUMTPYE et : ENUMTYPE.values() )

* finalize method in Object class.

* Use a static variable when all object of a class must use the same copy of the variable.

* A 'static import' declaration enables you to import 'static member' of a class

#### Principle of Least Privilege
It states that code should be granted only the amount of the privilege
and access that it needs to accomplish its designated task, but no more.

* You can use the keyword 'final' to specify that a variable is not modifiable. it is a constant.

## CHAPTER 9 - OOP: Inheritance

* In Java, the class hierarchy begins with class Object, which every class in Java
  directly or indirectly extends.

* Java supports only 'single inheritance'

* Inheritance represent 'Is-a relationship'

* Validate all the values in your all set methods

* Constructors are not inherited!

* The first task of any subclass constructor is to call its direct superclass' constructor.
  either explicitly or implicitly.

* Subclass cannot access private variable in superclass, use get methods

* One solution could be using protected access modifier instead of private.
  Even though it would increase the performance a little, cus of not having overhead of calling get and set methods,
  it is not a good software practise to let other classes in the package to access these variables.

* Another solution, and the good one, is to use getter and setter to access these fields.

* In most of the cases, using protected a.m. is not a good idea,
  - changing values in subclass can put the object in inconsistent state(no validation)
  - if there would be change in the superclass implementation, it would break the subclass. Fragile software

* Use the protected a.m. when a superclass should provide a method only
  to its subclasses and other classes in the same package, but not to other clients.

* When you create an object, the chain of calling constructor starts up to Object class

## CHAPTER 10 - OOP - Polymorphism

* Polymorphism enables you to write programs that process objects
  that share the same superclass(either directly or indirectly) as if they are
  all objects of the superclass; this can simplify programming.

* Sometimes it's useful to declare classes for which u never intend to create objects.
  They are called abstract classes.

* Abstract classes are used only as superclasses in inheritance hierarchies,
  we refer to them as 'abstract superclasses'.

* Abstract classes cannot be used to instantiate objects, cus abstract classes are incomplete.

#### Purpose of Abstract Classes
Is to provide an appropriate superclass from which other classes can inherit and thus share a common design.

* Abstract superclasses are too general to create real objects,
  they specify only what is common among subclasses.

* Constructors and static methods cannot be declared 'abstract'.
  Contructors can not be inherited, static methods cannot be overridden.

#### final Keyword
* final variable is a constant, cannot be reassigned.

* final method cannot be overridden in a subclass.
  - Methods that are declared private are implicitly final.
  - Methods that are declared static are implicitly final.
  - A final methods declaration can never change, so all subclasses use the same method implementation. - static binding.

* final class cannot be a superclass. All methods in a final class are implicitly final.
  String class is an example of final class.

* An interface contains only constants and abstract methods.(There are some
  changes in Java8)

* All methods declared in an interface are implicitly public abstract methods.

* All fields are implicitly public, static and final.

* Proper style to declare an interface is not to use any modifier neither for methods nor fields.

* Implement all of the methods of the interface or abstract the class.

* If there is no fields or default method implementation, use interface instead of abstract

## CHAPTER 11 - Exception Handling

* An exception terminates a thread, if they are depended on each other, it will terminate the program.

* Exception handling is designed to process synchronous errors,
  which occurs when a statement executes. Common examples :
    - out of range array indices
    - arithmetic overflow
    - division by zero
    - invalid method parameters
    - thread interruption
    - unsuccessful memory allocation

* All java exception classes inherit directly or indirectly from class Exception

* Only 'Throwable' objects can be used with the exception-handling mechanism.

* Class Throwable has two subclasses : Exception and Error.

* Error and its subclasses represent abnormal situations that happen in the JVM.
  It is usually not possible for applications to recover from Errors.

#### Checked and Unchecked Exception Types
  - Checked exception must be explicitly caught or propagated
  - Unchecked exceptions dont have to be caught or declared thrown
  - Checked exceptions extend Exception class
  - Unchecked exceptions extend RuntimException

* catch-or-declare requirement

* Java guarantees that finally block will be executed if a try block exists by using
  a return, break or continue statement or simply by reaching its closing right brace.

* finally block will not be executed if system.exit used in try block

* finally blcok is an ideal place to release resources acquired in a try
  block(Java7: try-with-resources)

* If a method declares that it throws an exception A, then it is also legal to throw subclasses of A.

**NOT:** Preconditions and postconditions of a method. Write as a comment when defining a method


## CHAPTER 16 - Strings, Characters and RE

- StringBuilder is not thread-safe.
- StringBuffer  is thread-safe

```java
StringBuilder sb = new StringBuilder(); // default capacity 16
sb.append(x);
sb.insert(sb.length(), x);
sb.length();
sb.capacity();
sb.setLength(10);
sb.ensureCapacity(75);
sb.append(any object);
sb.charAt(4);
sb.getChars(0, sb.length(), charArray, 0);
sb.reverse();
sb.insert(0, object);
sb.delete(2, 6);
sb.deleteCharAt(10);
```

* classes wrapping primitive types: Character, Integer, Double...

* Regular Expression, Matcher and Pattern class

## CHAPTER 17 - Files, Streams and Object Serialization

* java.io package doesnt actually address all types of input and output.
  - io to a GUI or web page

* Java IO package is primarily focused on input and output to files, network streams, internal memory buffers etc

* Java IO package does not contain classes to open network sockets
  which are necessary for network communication.

* Java NIO can work in non-blocking mode. It gives a big performance boost over blocking IO.

* Input and Output - Source and Destination

* A stream is a conceptually endless flow of data.
  You can either read from a stream or write to a stream.

* InputStream and OutputStream are abstract classes for performing byte-based io.

* Reader and Writer are abstract classes for performing character-based io

- An InputStream/Reader  is linked to a source of data.
- An OutputStream/Writer is linked to a destination of data.

### JAVA.IO : FILE
- FileInputStream  : for byte-based input from a file
- FileOutputStream : for byte-based output to a file

- FileReader : for character-based input from a file
- FileWriter : for character-based output to a file

* If u need to read a file from one end to the other u can use a 'FileInputStream' or a 'FileReader'
  depending on whether u want to read the file as binary or textual data.

* RandomAccessFile is used to read only parts of it.

- Scanner   : character based input
- Formatter : character based output

* Pipes in java IO provides the ability for two threads running in the same JVM to communicate.

* Pipes in jaca must be used for thread running in the same process in the same JVM

* PipedOutputStream and PipedInputStream

* Reading or writing from a network is the same as reading or writing to/from a file.

* InputStream, read() method typically returns -1 if there is no data to be read.

* Class Scanner does not allow repositioning to the beginning of the file.
  If it is necessary to read the file again, the program must close the file and reopen it.

* Is not economical to rewrite/change data in a record, cus all data has to be copied and written to a new file

* in serialization, there is also type of the data information in the file.

* Serializable interface is just a tagging interface, contains nothing.

* The programmer must ensure that every instance variable is a Serializable type.
  Otherwise, it must be declared 'transient' to indicate that
  it is not Serializable and should be ignored during the serialization process.

## CHAPTER 18 - Recursion

* BigInteger in math class is used for number bigger than to be hold in long

```java
// BigInteger.ZERO, BigInteger.ONE, BigInteger.TEN
public static final int TWO = BigInteger.valueOf(2);
number.equals(TWO);
number.compareTo(BigInteger.ONE);
number.add(BigInteger.TEN);
```

#### Recursion vs. Iterative
  - recursion takes more time and memory
  - some problems are easier to understand in recursive way
  - any recursion problem can be solved iteratively.

* SEARCH = Towers of Hanoi

* SEARCH = Fractals

* Recursive Backtracking , maze solving

## CHAPTER 19 - Searching, Sorting and BigO

- O(1)    : Constant time
- O(n)    : Linear run time
- O(n2)   : Quadratic run time
- O(logn) : logarithmic run time

* Linear Search : O(n) linear run time

* Binary Search : O(logn)

* Selection Sort : O(n2)

* Insertion Sort : O(n2)

* Merge Sort : O(nlogn)

## CHAPTER 20 - Generic Collections

- A collection is a data structure---actually, an object--- that can hold references to other objects.

####  Collection
The root interface in the collections hierarchy from which
interfaces Set, Queue and List are derived.

#### Set
A collection that does not contain duplicates.

#### List
An ordered collection that can contain duplicate elements.

#### Map
Associates keys to values and cannot contain duplicate keys.

#### Queue
Typically a first-in, first-out collection that models a waiting line, other orders can be specified.

* In earlier version of Java; in collections, Object were used to provide generic collections,
  problem with that approach was that programmer had to cast the object explicity all the time.

##### Type-wrapper
Corresponding classes for primitive types. Integer, Long, Character etc.

- Boxing conversion : converts a value of a primitive type to an object of the corresponding type-wrapper class.
- Unboxing conversi : converts an object of a type-wrapper class to a value of the corresponding primitive type.

* Above conversions can be performed automatically, called autoboxing and auto-unboxing.

```java
Integer[] integerArray = new Integer[5];
integerArray[0] = 10; // assining Integer 10
int value = integerArray[0]; // get int value of Integer
```

* Collection is used commonly as a parameter type in methods to allow polymorphic
  processing of all objects that implement interface Collection.

* traffic light and intersection analogy

* Similarly, we can synchronize access to a collection to ensure
  that only one thread manipulates the collection at a time.

* List represents an ordered list of objects, in a specific order, and by an index too.

* List(I) is implemented by several classes, including classes
  - ArrayList
  - LinkedList
  - Vector
  - Stack

* Classes ArrayList and Vector have nearly identical behaviors. The primary difference
  between them is that Vectors are synchronized by default, whereas ArrayLists are not.

* Unsynchronized collections provide better performance than synchronized ones.

* three ways of going through elements :
  - for( int i=0; i < list.size(); i++ )
  - while( iterator.hasNext )
  - for( Element e : list )

```java
arrayList.remove(Object o);
arrayList.remove(int index);

Iterator<E> iterator = collection.iterator();
iterator.hasNext();
iterator.next();
iterator.remove();
iterator.forEachRemaining();
```

* Any changes made to a sublist are also made to the original List.

## CHAPTER 26 - Multithreading
- Thread States: Life Cycle of a Thread
  - New : A new thread begins its life cycle in the new state.
          It remains in this state until the program starts the thread.

  - Runnable : A thread remains in the new state until the program starts it.
               When the thread is start, it is in runnable state.
               In this state is considered that it is exectuting its task.

  - Waiting  : Sometimes a runnable thread transitions to the waiting state
               while it wait for another thread to perform a task.
               A waiting thread transitions back to the runnable state only
               when another thread notifies it to continue executing.

  - Timed Waiting :  A runnable thread can enter the timed waiting state for a specified interval of time.
                     Sleeping thread, optional waiting time,
                     Word backup thread goes to sleep, not to check if it should do backup, consuming processor time.

  - Blocked : When a thread do IO operation, it has to wait until that operation
              is compelete. goes to blocked state, cannot use processor even if one is available.

  - Terminated : When it successfully completes its task, or cus of an error.

* OS has also ready state between new and runnable state of the JVM.
But it hides this details from JVM, and JVM just sees them as runnable state.
New state - ready state (dispatching the thread->) runnable state(running)

##### Preemptie Scheduling
When a higher-priority thread comes in, OS takes out the running thread.
Such operation could cause 'starvation'. 'aging' technique solves the problem.

### Executor Framework
- Runnable Interface : just contains the run method. (java.lang)

```java
public abstract void run();
```

- Callable Interface : just contains the call method. (java.util.concurrent)
  - returns result, difference from Runnable
  - may throw exception if cannot compute the result
```java
V call() throws Exception;
```

- Executor Interface :  just contains the execute method. (java.util.concurrent)

```java
void execute(Runnable command);
```

- An executor object executes Runnables. An Executer does this by creating and
managing a group of threads called 'thread pool'.

- Advantage : Executors can reuse existing threads to eliminate the overhead
of creating a new thread for each task, and can improve performance
by optimizing the number of threads to ensure that the processor stays busy,
without creating so many threads that the application runs out of resources.

### Thread Synchronization
When multiple threads share an object and it's modified by one or more of them
indeterminate results may occur unless access to the shared object is managed
properly.

Above problem can be solved by giving only one thread at a time 'exclusive access'
to the code that manipulates the shared object. During that time other threads
desiring to manipulate the object are kept waiting.
When the thread with exclusive access finishes manipulating the shared object,
other waiting objects are allowed to process. This is called 'thread synchronization'.
Thread synchronization coordinates access to shared data by multiple concurrent threads.

By synchronizing threads in this manner, you can unsure that each thread accessing
a shared object excludes all other threads from doing so simultaneously.
This is called 'mutual exclusion'.

### Monitors
A common way to perform synchronization is to use Java's built-in 'monitors'.
Every object has a monitor and a monitor lock(or intrinsic lock).
The monitor ensure that its object's monitor lock is held by a maximum of only
one thread at a time.
Monitor and monitor lock can thus be used to enforce mutual exclusion.

If a thread has the monitor lock, the others thread must wait, and check if
they can acquire the monitor lock.

To specify that a thread must hold a monitor lock to execute a block of code,
the code should be palced in a 'synchronized' statement.
Such code is said to be guarded by the monitor lock.

```java
synchronized(object){
  // statements
}
```

Where object is the object whose monitor lock will be acquired, object is normally
'this' if it's the object in which the synchronized statement appears.

One of the challenges of multithreaded programming is spotting the errors.
They may occure so infrequently that a broken program does not produce incorrect
result during testing, creating the illusion that the program is correct.

I/O should not be performed in synchronized blocks, because it's important
to minimize the amount of time that an object is 'locked'.
Also never call sleep on a thread in synchronized blocks.

Always declare data fields that you not expect to change as 'final'.
Primitie variable that are declared as final can safely be shared across threads.
An object reference that's declared as final ensures that the object it refers
to will be fully constructed and initialized before it's used by the program,
and prevents the reference from pointing to another object.

### Producer/Consumer Relationship without Synchronization
Producer : generates data and stores it in a shared object
Consumer : reads data from the shared object.

##### Examples
- Printer.
  - Producer : generates pages/documents to be printed, stores on disk
  - Consumer : printer prints these documents when it is available

- DVD.
  - Producer : puts the data in a fixed-size buffer
  - Consumer : burns the data in the buffer to the DVD.

This relationship is 'state dependent'. The operations should proceed only if
the buffer is in the correct state.

- If the buffer is in a not-full state, the producer may produce,
- If the buffer is in a not-empty state, the consumer may consume.
