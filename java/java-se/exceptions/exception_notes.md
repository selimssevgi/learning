# Exception Handling

- Introduction
- Runtime Stack Mechanism
- Default Exception Handling in Java
- Exception Hierarchy
- Customized Exception Handling by Using try-catch
- Control Flow in try-catch
- Methods to Print Exception Information
- try with Multiple catch Blocks
- finally block
- Difference between final, finally, finalize
- Control Flow in try-catch-finally
- Control Flow in Nested try-catch-finally
- Various Possible Combinations of try-catch-finally
- throw Keyword
- throws Keyword
- Exception Handling Keywords Summary
- Various Possible Compile Time Errors in Exception Handling
- Customized or User Defined Exceptions
- Top 10 Exceptions
- 1.7V Enhancements
  - try with resources
  - multi-catch block

## Introduction
"An unexpected, unwanted event" that disturbs normal flow of the program is called
exception.

Ex1: TyrePuncturedException, SleepingException, FileNotFoundException etc

It is highly recommended to handle exceptions, and main objective of exception
handling is "graceful termination of program".

Exception handling doesnot mean repairing an exception. We have to provide
"alternative way" to continue rest of program normally, is the concept of
handling.

```java
try {
  // read data from remote file locatin at london
} catch(FileNotFoundException e) {
  // use local file and continue rest of the program normally
}
```

## Runtime Stack Mechanism
For every thread JVM will create a runtime stack. Each and every method call
performed by that thread will be stored in the corresponding stack.

Each entry in the stack is called Stack Frame or Activation Record.

After completing every method call, the corresponding entry from the stack will
be removed. After completing all method calls, the stack will be become empty,
and that empty stack will be destroyed by JVM just before terminating the thread.


```java
class Test {
  public static void main(String[] args) {
    doStuff();
  }

  public static void doStuff() {
    doMoreStuff();
  }

  public static void doMoreStuff() {
    System.out.println("hello");
  }
}

// [Empty_Stack] : created by JVM for main thread
// [main] : added as a stack frame or activation record
// [main, doStuff] : another method call
// [main, doStuff, doMoreStuff] : another method call
// [main, doStuff] : doMoreStuff returned
// [main] : doStuff returned
// [] : main returned
// [] : empty stack will be destroyed by JVM before terminating main thread
```

## Default Exception Handling in Java
Inside a method if any exception occurs, then method in which it raised is
responsible to create exception object by including the following information:

1. Name of exception
2. Description of exception
3. Location at which exception occurs (Stack Trace)

After creating exception object, the method hands over that object to JVM.

JVM will check whether the method contains any exception handling code or not.
If the method doesnt contain exception handling code, then JVM terminates that
method abnormally and removes corresponding entry from the stack.

Then JVM identifies caller method and checks whether caller method contains any
handling code or not. If the caller method doesnt contain handle code, then JVM
terminates that caller method also abnormally, and removes corresponding entry
from the stack. This process will be continued until main method. And if the
main method doesnt contain handling code, then JVM terminates main method
abnormally, and removes corresponding entry from the stack.

Then JVM hands over the responsibility of exception handling to "default
exception handler", which is part of JVM.

Default Exception Handler prints exception information in the following format
and terminates program abnormally:

```java
Exception in thread "xXx" name of exception : Description
     Stack Trace
```

```java
class Test {
  public static void main(String[] args) {
    doStuff();
  }

  public static void doStuff() {
    doMoreStuff();
  }

  public static void doMoreStuff() {
    System.out.println(10 / 0);
  }
}

Exception in thread "main" ArithmeticException: / by zero
          at Test.doMoreStuff()
          at Test.doStuff()
          at Test.main()
```

```java
class Test {
  public static void main(String[] args) {
    doStuff();
    System.out.println(10 / 0);
  }

  public static void doStuff() {
    doMoreStuff();
    System.out.println("hi");
  }

  public static void doMoreStuff() {
    System.out.println("hello");
  }
}

// hello
// hi
// Exception in thread "main" ArithmeticException: / by zero
//           at Test.main()
```

**NOTE:**  In a program if at least one method terminates abnormally, then
program termination is abnormal termination. If all method terminates normally,
then only the program termination is normal termination.


## Exception Hierarchy
Throwable class acts as the root for java Exception Hierarchy. Throwable(C)
defines two child classes(Exception and Error).

- Throwable(C)
  - Exception(C)
  - Error(C)

### Exception
Most of the times exceptions caused by our program, and these are recoverable.
For example, if our programming requirement is to read data from remote locating
in London, at runtime if the remote file is not available, then we will get
runtime exception saying: FileNotFoundException. If FNFE occurs, we can provide
local file and continue rest of the program normally.

```java
try {
  // read data from remote file locatin at london
} catch(FileNotFoundException e) {
  // use local file and continue rest of the program normally
}
```

### Error
Most of the times errors are not caused by our program. These are due to lack of
system resources. Errors are non-recoverable. For example; if OutOfMemoryError
occurs, being a programmer we can not do anything and program will be terminated
abnormally. System admin or server admin is responsible to increase heap memory.

- Exception
  - RuntimeException
    - ArithmeticException
    - NullPointerException
    - ClassCastException
    - IndexOutOfBoundsException
      - ArrayIOOBE
      - StringIOOBE
    - IllegalArgumentException
      - NumberFormatException
  - IOException
    - EOFException
    - FileNotFoundException
    - InterruptedIOException
  - ServletException
  - RemoteException
  - InterruptedException
- Error
  - VMError
    - StackOverflowError
    - OutOfMemoryError
  - AssertionError
  - ExceptionInInitializerError

## Checked Exception vs Unchecked Exception
### Checked Exception
The exceptions which are checked by compiler for smooth execution of the program
are called checked exceptions. Example: HallTicketMissingException,
PenNotWorkingException, FileNotFoundException etc.

In our program if there is a chance of raising checked exception, then
compulsory we should handle that checked exception(either by try-catch or throws
keyword), otherwise we will get compile error.

### Unchecked Exception
The exceptions which are not checked by compiler whether programmer handling or
not, such type of exceptions are called unchecked exceptions. Example,
ArithmeticException, BombBlostException etc.

**NOTE:** Whether it is checked or unchecked, every exception occurs at runtime
only. There is no chance of occuring any exception at the compile time.

**NOTE:** RuntimeException and its child classes, Error and its child classes
are unchecked. Except these remaining are checked.

#### Fully Checked vs Partially Checked
A checked exception is said to be fully checked if and only if all its child
classes are also checked. Example: IOException, InterruptedException.

A checked exception is said to partially checked if and only if some of its
child classes are unchecked. Example: Exception, Throwable.

**NOTE:** The only possible partially checked exceptions in Java Exception,
Throwable.

**Question:** Describe the behaviour of following exceptions?

```java
IOException              // checked, fully checked, child of Exception, Throwable
RuntimeException         // unchecked, child of Exception, Throwable
InterruptedException     // checked, fully checked, child of Exception, Throwable
Error                    // unchecked, child of Throwable
Throwable                // checked, partially checked, root of exceptions
ArithmeticException      // unchecked, child of RuntimeException, Exception...
NullPointerException     // unchecked,
Exception                // checked, partially checked, child of throwable
FileNotFoundException    // checked, child of IOException, Exception, Throwable
```

## Customized Exception Handling by Using try-catch
It is highly recommended to handle exceptions. The code which may raise
exception is called risky code, and we have to define that code inside try
block. And corresponding handling code we have to define inside catch block.

```java
try {
  // risky code
} catch (Exception e) {
  // handling code
}
```

```java
// without try-catch == abnormal termination
class Test {
  public static void main(String[] args) {
    System.out.println("statement1");
    System.out.println(10/0);
    System.out.println("statement2");
  }
}

// statement1
// RE: ArithmeticException : / by zero
```

```java
// with try-catch == normal termination
class Test {
  public static void main(String[] args) {
    System.out.println("statement1");
    try {
      System.out.println(10/0);
    } catch (ArithmeticException e) {
      System.out.println(10 / 2);
    }
    System.out.println("statement2");
  }
}

// statement1
// 5
// statement2
```

## Control Flow in try-catch

```java
try {
  // statement1
  // statement2
  // statement3
} catch (X e) {
  // statement4
}
  // statement5
```

#### Case 1: if there is no exception
1,2,3,5 will be executed and normal termination.

#### Case 2: Exception on "statement2"
If an exception raised at the statement2 and corresponding catch block matched:
1,4,5 and normal termination.

#### Case 3: Not Match Catch Block
If an exception raised at the statement2 and corresponding catch block is not
matched: 1 and abnormal termination.

#### Case 4: Exception on "statement4"
If an Exception raised at the statement4 and statement5, then it is always
abnormal termination(because no catch).

**NOTE:** Within try block if any where an exception raised, the rest of block
wont be executed even though we handle the exception. Hence, within the try
block we have to take only risky code, and the length of try block should be as
less as possible.

**NOTE:** In addition to try block, there may be a chance of raising an
exception inside catch and finally blocks.

**NOTE:** If any statement which is not part of try block and raises an
exception, then it is always abnormal termination.

### Methods to Print Exception Informatin
Throwable(C) defines the following methods to print exception information:

Method            | Printable Format |
------------------|------------------|
printStackTrace() | Name of Exception : Description \n Stack Trace
toString()        | Name of Exception : Description
getMessage()      | Description


```java
class Test {
  public static void main(String[] args) {
    try {
      System.out.println(10/0);
    } catch (ArithmeticException e) {
      e.printStackTrace();
      System.out.println(e);
      System.out.println(e.getMessage());
    }
  }
}

// java.lang.ArithmeticException : / by zero
//        at Test.main()
// java.lang.ArithmeticException : / by zero
// / by zero
```

**NOTE:** Internally 'default exception handler' will use printStackTrace()
method to print exception information to the console.

## try with Multiple catch Blocks
The way of handling an exception is varied from exception to exception. Hence
for every exception type it is highly recommended to take separate catch block.
That is, try with multiple catch blocks is always possible, and recommended to
use.


```java
try {
  // risky code
} catch (Exception e) {
  // catching all the exception in one catch
  // same answer for different questions
}

// worst programming practise
```


```java
try {
  // risky code
} catch (ArithmeticException e) {
  // perform alternative arithmetic operation
} catch (SQLException e) {
  // use mysql db instead of oracle db
} catch (FileNotFoundException e) {
  // use local file instead of remote file
} catch (Exception e) {
  // default exception handling
}

// best programming practise
```

If try with multiple catch blocks present, then the order of catch blocks is
very important. We have to take child first and then parent. Otherwise, we will
get compile time error saying "exception xxx has already been caught".

```java
try {
  // risky code
} catch (Exception e) {
  //
} catch (ArithmeticException e) {
  // CE: exception j.l.ArithmeticException has been already caught
}
```

```java
try {
  // risky code
} catch (ArithmeticException e) {
  //
} catch (Exception e) {
  //
}
```

We cannot declare two catch blocks for same exception. Otherwise we will get
compile time error.

```java
try {
  // risky code
} catch (ArithmeticException e) {
  //
} catch (ArithmeticException e) {
  // CE: exception j.l.ArithmeticException has been already caught
}
```

## Difference between final, finally, finalize

### final
final is a modifier, applicable for classes, methods and variables.

If a class is declared as final, then we cannot extend that class. That is, we
cannot create child class for that class. That is, inheritence is not possible
for final classes.

If a method is final, then we cannot override that method in child class.

If a variable is declared as final, then we cannot perform reassignment for that
variable.

### finally
finally is a block, always associated with try-catch to maintain cleanup code.

```java
try {
  // risky code
} catch (Exception e) {
  // handling code
} finally {
  // cleanup code
}
```

The speciality of finally block is, it will be executed always respective of
exception raised or not raised or handled or not handled.

### finalize()
finalize() is a method, always invoke by GC just before destroying an object to
perform cleanup activies. Once finalize() method completes, immediately GC
destroys that object.

**NOTE:** finally block is responsible to perform cleanup activities related to
try block. That is, whatever resources we opened at the part of try block will
be closed inside finally block. Whereas finalize() method is responsible to
perform cleanup activies related to object. That is whatever resources
associated with the object will be deallocated before destroying the object by
using finalize() method.


## Various Possible Combinations of try-catch-finally
- In try-catch-finally order is important.
- Whenever we are writing try, compulsory we should write either catch or
  finally. Otherwise, we will get compile time error. That is, try without catch
  or finally is invalid.
- Whenever we are writing catch, compulsory try block must be reuquired. That is,
  catch without try is invalid.
- Whenever we are writing finally block, compulsory we should write try block.
  That is, finally without try is invalid.
- Inside try-catch-finally block we can declare try-catch-finally blocks. That
  is, nesting of try-catch-finally is allowed.
- For try-catch-finally blocks curly braces are mandatory.


```java
try {
  // risky code
} catch (Exception e) {
  // handling code
}

try {
  // risky code
} catch (Exception e) {
  // handling code
} catch (XException e) {
  // handling code
}

try {
  // risky code
} catch (Exception e) {
  // handling code
} catch (Exception e) {
  // CE: Exception xxx has been already caught
}
```

```java
try {
  // risky code
} catch (Exception e) {
  // handling code
} finally {
  // cleanup code
}

// it will not handle risky code, it will be abnormal termination
// but finally block will be executed for cleanup activities anyway
try {
  // risky code
} finally {
  // cleanup code
}
```

```java
try {
  // risky code
} catch (Exception e) {
  // handling code
}
try {
  // risky code
} catch (AnotherException e) {
  // handling code
}
try {
  // risky code
} finally {
  // cleanup code
}
```

```java
try {
  // CE: try without catch or finally
}
```

```java
catch (Exception e) {
  // CE: catch without try
}
```

```java
finally {
  // CE: finally without try
}
```

```java
try {

} finally {

} catch (Exception e) {
  // catch without try
}
```
Other statements cannot get in them middle of try-catch-block.

```java
try {}
System.out.println("hello");
catch (Exception e) {} // CE: catch witout try

try {}
catch (Exception e) {}
System.out.println("hello");
finally {} // CE: finally without try
```

They can be nested.

```java
// exception can be same, because of different try
try {
  try {
    //
  } catch (Exception e) {
    //
  }
} catch(Exception e) {
  //
}

// ----------------------------------------

try {
  try {
    // CE: try without catch or finally
  }
} catch(Exception e) {
  //
}

// ----------------------------------------

try {
  try {
    //
  } finally {
    //
  }
} catch(Exception e) {
  //
}

// ----------------------------------------

try {
  //
} catch(Exception e) {
  try {
   //
  } finally {
    //
  }
}

// ----------------------------------------

try {
  //
} catch(Exception e) {
  finally {
    // CE: finally without try
  }
}

// ----------------------------------------

try {
  //
} catch(Exception e) {
  //
} finally {
  try {
   //
  } catch (Exception e) {
   //
  }
}

// ----------------------------------------

try {
  //
} catch(Exception e) {
  //
} finally {
  finally {
   // CE: finally without try
  }
}

// ----------------------------------------

try {
  //
} catch(Exception e) {
  //
} finally {
  //
}
finally {
 // CE: finally without try
}
```

Curl braces are mandatory in try-catch-finally.

```java
try // invalid
  System.out.println("try");
catch (Exception e) {
  System.out.println("catch");
} finally {
  //
}

try {
  System.out.println("try");
} catch (Exception e) // invalid
  System.out.println("catch");
finally {
  //
}

try {
  System.out.println("try");
} catch (Exception e) {
  System.out.println("catch");
} finally // invalid
  System.out.println("final");
```

## throw Keyword / Statement / Clause
Sometimes we can create exception object explicitly and hand over to JVM
manually. For this we have to use throw keyword.

```java
throw new ArithmeticException("/ by zero");
// new   -> creation of AE object explicitly
// throw -> handover our created exception object to JVM manually
```

Hence the main objective of throw object keyword is to hand over our created
exception object to JVM manually.

Hence the result of following two programs is same:

```java
class Test {
  public static void main(String[] args) {
    System.out.println(10/0);
  }
}

// Exception in thread "main" j.l.ArithmeticException : / by zero
//        at Test.main()
```

In the above case main method is responsible to create exception object and
hand over to JVM.

```java
class Test {
  public static void main(String[] args) {
    throw new ArithmeticException("/ by zero")
  }
}

// Exception in thread "main" j.l.ArithmeticException : / by zero
//        at Test.main()
```

In the above case programmer creates exception object explicitly and hand over
to JVM manually.

**NOTE:** Best use of throw keyword is for user defined exception or customized
exceptions.

#### Case 1:
throw e; if e refers to null, then we will get NullPointerException.

```java
class Test {
  static ArithmeticException e = new ArithmeticException();

  public static void main(String[] args) {
    throw e;
  }
}
// RE: ArithmeticException
```

```java
class Test {
  static ArithmeticException e;

  public static void main(String[] args) {
    throw e;
  }
}
// RE: NullPointerException
```

#### Case 2:
After throw statement we are not allowed to write any statement directly,
otherwise we will get compile time error saying : unreachable statement.

```java
class Test {
  public static void main(String[] args) {
    System.out.println(10 / 0);
    System.out.println("hello");
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    throw new ArithmeticException("/ by zero");
    System.out.println("hello"); // CE: unreachable statement
  }
}
```

#### Case 3:
We can use throw keyword only for throwable types. If we are trying to use for
normal java object, we will get compile time error.


```java
class Test {
  public static void main(String[] args) {
    throw new Test(); // CE: incompatible types. f: Test r:j.l.Throwable
  }
}
```

```java
class Test extends RuntimeException {
  public static void main(String[] args) {
    throw new Test();
  }
}

// RE: Exception in thread "main" Test
//           at Test.main()
```
## throws Keyword
In our program if there is a possibility of raising checked exception, then
compulsory we should handle that checked exception. Otherwise, we will get
compile time error saying : unreported exception "xxx" must be caught or
declared to be thrown

```java
import java.io.*;

class Test {
  public static void main(String[] args) {
    PrintWriter pw = new PrintWriter("abc.txt");
    pw.println("hello");
  }
}

// CE: unreported exception java.io.FileNotFoundException; must be caught or
// declared to be thrown
```

```java
class Test {
  public static void main(String[] args) {
    Thread.sleep(10000);
  }
}

// CE: unreported exception java.lang.InterruptedException; must be caught or
// declared to be thrown
```

We can handle this compile time error by usin the following two ways:

1. By using try-catch

```java
class Test {
  public static void main(String[] args) {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      //
    }
  }
}
```

2. By using throws keyword
We can use throws keyword to delegate the responsibility of exception handling
to the caller(it may be another method or JVM). Then caller method is
responsible to handle that exception.

```java
class Test {
  public static void main(String[] args) throws InterruptedException {
    Thread.sleep(10000);
  }
}
```

Throws keyword is required only for checked exceptions. Usage of throws keyword
for unchecked exceptions there is no use or impact.

throws keyword is required only to convince compiler. Usage of throws keyword
doesnot prevent abnormal termination.


```java
class Test {
  public static void main(String[] args) throws InterruptedException {
    doStuff();
  }

  public static void doStuff() throws InterruptedException {
    doMoreStuff();
  }

  public static void doMoreStuff() throws InterruptedException {
    Thread.sleep(10000);
  }
}
```

In the above program if we remove at least one throws statement, then the code
will not compile.

**NOTE:** It is recommended to use try-catch over throws keyword.

#### Case 1:
We can use throws keyword for methods and constructor but not for classes.

```java
class Test {
  Test() throws Exception {
    //
  }

  public void m1() throws Exception {
    //
  }
}
```

#### Case 2:
We can use throws keyword only for Throwable types. If we are trying to use for
normal java classes, then we will get compile time error.

```java
class Test {
  public void m1() throws Test {
   // CE: incompatible types. found: Test required: java.lang.Throwable
  }
}
```

```java
class Test extends RuntimeException {
  public void m1() throws Test {
   // valid
  }
}
```

#### Case 3:

```java
class Test {
  public static void main(String[] args) {
    throw new Exception(); // checked
  }
}

// CE: unreported exception java.lang.Exception; must be caught or declared to be thrown
```

```java
class Test {
  public static void main(String[] args) {
    throw new Error(); // unchecked
  }
}

// RE: Exception in thread "main" java.lang.Error
//          at Test.main()
```

#### Case 4:
Within try block if there is no chance of raising an exception, then we cannot
write catch block for that exception. Otherwise, we will get compile time error
saying: Exception "xxx" is never thrown in the body of corresponding try block.
But this rule is applicable only for fully checked exception.


```java
class Test {
  public static void main(String[] args) {
    try {
      System.out.println("Hello");
    } catch (ArithmeticException e) { // unchecked exception
      //
    }
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    try {
      System.out.println("Hello");
    } catch (Exception e) {  // partially checked exception
      //
    }
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    try {
      System.out.println("Hello");
    } catch (java.io.IOException e) {  // fully checked exception
      // CE: exception j.io.IOException is never thrown in the body of corresponding try block
    }
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    try {
      System.out.println("Hello");
    } catch (InterruptedException e) {  // fully checked exception
      // CE: exception j.l.InterruptedException is never thrown in the body of corresponding try block
    }
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    try {
      System.out.println("Hello");
    } catch (Error e) {  // unchecked exception
      //
    }
  }
}
```

## Exception Handling Keywords Summary
1. try     --> to maintain risky code
2. catch   --> to maintain exception handling code
3. finally --> to maintain cleanup code
4. throw   --> to hand-over our created exception object to JVM manually
5. throws  --> to deletages responsibility of exception handling to the caller

## Various Possible Compile Time Errors in Exception Handling

1. Unreported exception xxx; must be caught or declared to be thrown
2. Exception xxx has already been caught
3. Exception xxx is never thrown in body of corresponding try block
4. Unreachable statement
5. Incompatible types found: Test required: java.lang.Throwable
6. try without catch or finally
7. catch without try
8. finally without try

## Customized or User Defined Exceptions
Sometimes to meet programming requirements we can define our own exceptions.
Such type of exceptions are called customized or user defined exceptions.

- TooYoungException
- TooOldException
- InsufficientFundException


```java
class TooYoungException extends RuntimeException {
  TooYoungException(String s) {
    super(s); // to make description available to default exception handler
  }
}

class TooOldException extends RuntimeException {
  TooOldException(String s) {
    super(s); // to make description available to default exception handler
  }
}

class CustExceptionDemo {
  public static void main(String[] args) {
    int age = Integer.parseInt(args[0]);

    if (age > 60) {
      throw new TooYoungException("plz wait some more time");
    } else if (age < 18) {
      throw new TooOldException("your age is already crossed marriage age");
    } else {
      System.out.println("you will get match details by email...");
    }
  }
}
```

**NOTE:** throw keyword is best suitable for user defined or customized
exceptions. But not for predefined exception.

**NOTE:** It is highly recommended to define customized exceptions as unchecked.
That is, we have to extend RuntimeException(C) but Exception(C). Otherwise, we
have to handle the exception to convince compiler.


## Top 10 Exceptions
Based on person who is raising an exception all exceptions are divided into two
categories. First one is JVM exceptions, second is programatic exceptions.

1. JVM Exceptions
2. Programatic Exceptions

### JVM Exceptions
The exceptions which are raised automatically by JVM whenever a particular event
occurs are called JVM exceptions.

- ArithmeticException,
- NullPointerException

### Programatic Exceptions
The exceptions which are raised explicitly either by programmer or by API
developer to indicate that something goes wrong are called programatic
exceptions.

- TooOldException
- IllegalArgumentException

#### Top 10 Exceptions
1. ArrayIndexOutOfBoundsException <-- IndexOutOfBoundsException <-- RuntimeEx
It is a child class of RuntimeException and hence it is unchecked.

Raised automatically by JVM whenever we are trying to access array element with out of
range index.

```java
int [] = new int[4];
System.out.println(x[0]); // 0
System.out.println(x[10]); // RE: ArrayIndexOutOfBoundsException
System.out.println(x[-10]); // RE: ArrayIndexOutOfBoundsException
```

2. NullPointerException
It is a child class of RuntimeException, and hence it is unchecked.

Raised automatically by JVM whenever we are trying to perform any operation on null.


```java
String s = null;
System.out.println(s.length()); // RE: NullPointerException
```

3. ClassCastException
It is a child class of RuntimeException, and hence it is unchecked.

Raised automatically by JVM whenever we are trying to type-cast parent object to
child type.

```java
String s = new String("selim");
Object o = (Object) s; // valid. child -> parent

Object o = new Object();
String s = (String) o; // RE: ClassCastException

Object o = new String("durga");
String s = (String) o; // valid. internal object is string
```

4. StackOverflowError
It is child class of Error. Hence it is unchecked.

Raised automatically by JVM whenever we are trying to perform recursive method
call.

```java
class Test {
  public static void main(String[] args) {
    m1()
  }

  public static void m1() {
   m2();
  }

  public static void m2() {
   m1();
  }
}

// RE: StackOverflowError
```

5. NoClassDefFoundError
It is child class of Error. Hence it is unchecked.

Raised automatically by JVM whenever JVM is unable to find required .class file.

```shell
$ java Test # if there is no Test.class file
# RE: NoClassDefFoundError : Test
```

6. ExceptionInInitializerError
It is child class of Error. Hence it is unchecked.

Raised automatically by JVM if any exception occurs while executing static
variable assignments and static blocks.

```java
class Test {
  static int x = 10/0;
}

// RE: ExceptionInInitializerError
// Caused by : java.lang.ArithmeticException : / by zero
```

```java
class Test {
  static {
    String s = null;
    System.out.println(s.length());
  }
}

// RE: ExceptionInInitializerError
// Caused by : java.lang.NullPointerException
```

7. IllegalArgumentException
It is a child of RuntimeException. Hence it is unchecked.

Raised explicitly either by programmer or API developer to indicate that a
method has been invoked with illegal argument.

The valid range of thread priority is 1 to 10. If we are trying to set a
priority with any other value, then we will get RE: IllegalArgumentException.

```java
Thread t = new Thread();
t.setPriority(7); // valid between 1 to 10
t.setPriority(15); // RE: IllegalArgumentException
```

8. NumberFormatException --> IllegalArgumentException --> RuntimeException
It is a direct child class of IllegalArgumentException, which is child class of
RuntimeException. Hence it is unchecked.

Raised explicitly either by programmer or by API developer to indicate that we
are trying to convert string to number and the string is not properly formatted.

```java
int i = Integer.parseInt("10");  // valid
int x = Integer.parseInt("ten"); // RE: NumberFormatException
```

9. IllegalStateException
It is a child class of RuntimeException. Hence it is unchecked.

Raised explicitly either by programmer or by API developer to indicate that a
method has been invoked at wrong time.

After starting a thread, we are not allowed to restart the same thread once
again. Otherwise, we will get RE: IllegalThreadStateException

```java
Thread t = new Thread();
t.start(); // valid
// .
// .
// .
t.start(); // RE: IllegalThreadStateException
```

10. AssertionError
It is a child class of Error. Hence it is unchecked.

Raised explicitly either by programmer or by API developer to indicate that the
assert statement fails.

```java
assert(x > 10);
// If x is not greater than 10, then we will get runtime exception.
// RE: AssertionError
```

Exception / Error                | Raised By
---------------------------------|-----------
ArrayIndexOutOfBoundsException   | Raised automatically by JVM
NullPointerException             | Raised automatically by JVM
ClassCastException               | Raised automatically by JVM
StackOverflowError               | Raised automatically by JVM
NoClassDefFoundError             | Raised automatically by JVM
ExceptionInInitializerError      | Raised automatically by JVM
IllegalArgumentException         | Raised explicitly by programmer
NumberFormatException            | Raised explicitly by programmer
IllegalStateException            | Raised explicitly by programmer
AssertionError                   | Raised explicitly by programmer


## 1.7V Enhancements with Respected to Exception Handling
As a part of 1.7V in exception handling the following two concept was introduced.

1. try with resources
2. multi-catch block

### try with Resources
Until 1.6V it is highly recommended to write finally block to close resources
which are open as a part of try block.


```java
BufferedReader br = null;
try {
  br = new BufferedReader(new FileReader("input.txt"));
  // use br based on requirement
} catch (IOException e) {
  // handling code
} finally {
  if (br != null) {
    br.close();
  }
}
```

The problems in this approach are:
  - Compulsory programmer is required to close the resources inside finally
    block. It increases complexcity of programming.
  - We have to write finally block compulsory, and hence it increases the length
    of the code and reduces readability.

To overcome above problems, SUN people introduced try-with-resources in 1.7V.
The main advantages of try-with-resources is whatever resources we open as a
part of try block will be closed automatically once the control reaches to end
of try block either normally or abnormally. And hence we are not required to
close explicitly. So that, complexcity of the programming will be reduced.

We are not required to write finally block so that length of the code will be
reduced and readability will be improved.

```java
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
   // use br based on requirements
   // br will be closed automatically once control reaches end of try block
   // either normally or abnormally and we are not responsible to close explicitly
} catch (IOException e) {
  // handling code
}
```

##### Conclusions
1. We can declare multiple resources but these resources should be separated
   with semicolon.

   ```java
   // syntax : try (R1; R2; R3)
   try (FileWriter fw = new FileWriter("out"); FileReader fr = new FileReader("in")) {
     //
   }
   ```

2. All resources should be AutoCloseable(I) resources. A resource is said to be
   AutoCloseable if and only if corresponding class implements
   java.lang.AutoCloseable interface. All IO related, database related, and
   network related resources all implemented AutoCloseable(I). Being a
   programmer we are not required to do anything, we should just aware the point.
   AutoCloseable(I) came in 1.7V, and it contains only one method: close().

3. All resources reference variables are implicitly final. And hence, within try
   block we cannot perform reassignment. Otherwise, we will get compile time
   error.

   ```java
   try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
     br = new BufferedReader(new FileReader("out"));
     // CE: auto-closeble resource bt may not be assigned
   }
   ```

4. Until 1.6V try should be associated with either catch or finally. But 1.7V
   onwards we can take only try with resource without catch or finally.

     ```java
     try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
       // only try block without catch or finally is valid in 1.7V
     }
     ```

The main advantage of try with resource is, we are not required to write finally
block explicitly because we are not required to close resources explicitly.
Hence until 1.6V finally block is just like hero, but from 1.7V onwards it is
dummy and becomes zero.

### Multi-catch Block
Until 1.6V even though multiple different exceptions having same handling code,
for every exception type we have to write a separate catch block. It increases
the lenght of the code and reduces the readability.

```java
try {
  //
} catch (ArithmeticException e) {
  e.printStackTrace();
} catch (IOException e) {
  e.printStackTrace();
} catch (NullPointerException e) {
  System.out.println(e.getMessage());
} catch (InterruptedException e) {
  System.out.println(e.getMessage());
}
```

To overcome this problem SUN people introduced multi-catch block in 1.7V.
According to this, we can write a single catch block that can handle multiple
different type of exceptions.

```java
try {
  //
} catch (ArithmeticException | IOException e) {
  e.printStackTrace();
} catch (NullPointerException | InterruptedException e) {
  System.out.println(e.getMessage());
}
```

The main advantage of this approach is, the length of the code will be reduced
and readability will be improved.


```java
class MultiCatchBlock {
  public static void main(String[] args) {
    try {
      System.out.println(10 / 0); // comment out
      String s = null;
      System.out.println(s.length());
    } catch (ArithmeticException | NullPointerException e) {
      System.out.println(e);
    }
  }
}
```

In the above example whether the raised exception is ArithmeticException or
NullPointerException, same catch block can listen/handle.


In multi-catch block there should not be any relation between types(either child
to parent or parent to child or same type). Otherwise we will get CE.

```java
try {
  //
} catch (ArithmeticException | Exception e) {
  e.printStackTrace();
}

// CE: Alternatives in a multi-catch statement cannot be related by subclassing.
```

## Exception Propegation
Inside a method if an exception is raised, and if we are not handling that
exception, then exception object will be propegated to the caller. Then caller
method is responsible to handle exception. This process is called 'Exception
Propegation'.

## Rethrowing Exception
We can use this approach to convert one exception tpye to another exception type.

```java
try {
  System.out.println(10/0);
} catch (ArithmeticException e) {
  throw new NullPointerException();
}
```
