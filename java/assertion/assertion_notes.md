# Assertions (1.4V)

- Introduction
- assert as a keyword & identifier
- Types of assert Statements
- Various possible Runtime Flags
- Appropriate & Inappropriate use of Assertions
- AssertionError


## Introduction
Very common way of debugging is usage of sout statement. But the problem
with sout is, after fixing the bug, compulsory we have to delete sout
statements. Otherwise, these souts will be executed at runtime for every
request, which creates performance problems and disturbs server logs.

To overcome this problem SUN people introduced assertions concept in 1.4V.

The main advantage of assertions when compared with sout is, after fixing the
bug, we are not required to remove assert statements. Because they wont be
executed by default at runtime. Based on our requirement we can enable and
disable assertions. And by default assertions are DISABLED.

Hence, the main objective of assertion is to perform debugging.

Usually we can perform debugging in development and test environments but not in
production environment. Hence, Assertion concept is applicable for development
and test environments but not for production.

Assertion -> for debugging
Assertion -> alternative to sout statements

## assert as a Keyword and Identifier
assert keyword introduced in 1.4 version. Hence from 1.4 version onwards we
cannot use assert as identifier. Otherwise we will get compile time error.


```java
class Test {
  public static void main(String[] args) {
    int assert = 10; // using it as identifier
    System.out.println(assert);
  }
}
```


```shell
javac Test.java   # current version
CE: as a release 1.4, 'assert' is a keyword, and may not be used as an identifier
(use -source 1.3 or lower to use 'asser' as an identifier)

javac -source 1.3 Test.java
# code compiles fine but with a warning

java Test
10
```

```shell
javac -source 1.2 Test.java
# code compiles fine but with a warning

javac -source 1.3 Test.java
# code compiles fine but with a warning

javac -source 1.4 Test.java
CE: as a release 1.4, 'assert' is a keyword, and may not be used as an identifier
(use -source 1.3 or lower to use 'asser' as an identifier)

javac -source 1.5 Test.java
CE: as a release 1.4, 'assert' is a keyword, and may not be used as an identifier
(use -source 1.3 or lower to use 'asser' as an identifier)
```

**NOTE:** If we are using assert as identifier and if we are trying to compile
according to old version(1.3 or lower), then the code compiles fine with the
warning.

*NOTE:* We can compile a java program according to a particular version by using
'-source' option.

## Types of assert Statements
There are two types of assert statements:

1. Simple Version
2. Augmented Version

### Simple Version

```java
assert(b);
```

- b should be boolean type.
- if b is true, then our assumption is satisfied. Hence the rest of the program
  will be executed normally.
- if b is false, then our assumption fails, that means, somewhere something goes
  wrong. Hence the program will be terminated abnormally by raising
  AssertionError. Once we got AssertionError, we will analyse the code and we
  can fix the problem.


```java
class Test {
  public static void main(String[] args) {
    int x = 10;
    ;;;;;;;;;;;;;
    assert( x > 10 );
    ;;;;;;;;;;;;;
    System.out.println(x);
  }
}
```

```shell
javac Test.java # compiles fine
java Test
10
java -ea Test
RE: AssertionError
```

*NOTE:* By default assert statements wont be executed because assertions are
*disabled* by default. But we enable assertion by using '-ea' option.

### Augmented Version
We augment some description with assertion error by using augmented version.

```java
assert(b): e;
```

- b should boolean type.
- e can be any type but mostly String type.

```java
class Test {
  public static void main(String[] args) {
    int x = 10;
    ;;;;;;;;;;;;;
    assert( x > 10 ): "x value should be > 10 but it is not";
    ;;;;;;;;;;;;;
    System.out.println(x);
  }
}
```

```shell
javac Test.java # compiles fine
java Test # assertion disabled by default
10
java -ea Test
RE: AssertionError: x value should be > 10 but it is not
```

##### Conclusion 1:

```java
assert(b): e;
```

e will be executed if and only if first argument(b) false. That is if b is true,
then second argument will not be evaluated.

```java
class Test {
  public static void main(String[] args) {
    int x = 10;
    ;;;;;;;;;;;;;
    assert( x == 10 ): ++x;
    ;;;;;;;;;;;;;
    System.out.println(x);
  }
}
```

```shell
javac Test.java
java Test # assertion disabled by default
10
java -ea Test # +xx wont be evaluated
10
```

##### Conclusion 2:

```java
assert(b): e;
```

For the second argument we can take method call, but void return tpye method
call is not allowed. Otherwise we will get compile time error.(Misuse of syntax:
if it is void then use simple version)

```java
class Test {
  public static void main(String[] args) {
    int x = 10;
    ;;;;;;;;;;;;;
    assert( x > 10 ): m1();
    ;;;;;;;;;;;;;
    System.out.println(x);
  }

  public static int m1() {
    return 777;
  }
}
```

```shell
javac Test.java
java Test # assertion disabled by default
10
java -ea Test
RE: AssertionError: 777
```

If m1 return type is void, then we will get CE: void type not allowed here.

*NOTE:* Among two versions of assertions, it is recommended to use augmented
version. Because it provides more information for debugging.

## Various possible Runtime Flags

1. -ea | -enableassertions : to enable assertions in every non-system class(our
   own classes).

2. -da | -disableassertions : to disable assertions in every non-system class.

3. -esa | -enablesystemassertions : to enable assertions in every sytem
   class(predefined classes).

4. -dsa | -disablesystemassertions : to disable assertions in every system class.

*NOTE:* WE can use above flags simultenously, then JVM will consider these flags
from left to right.


```shell
java -ea -esa -ea -dsa -da -esa -ea -dsa Test

// non-system  system
// enable      enable
// enable      disable
// disable     enable
// enable      disable
// at the end assertions will be available in non-system class
// and disable in every system class.
```

#### Case Study

- pack1
  |--- A.class
  |--- B.class
  |--- pack2
       |--- C.class
       |--- D.class


```shell
// to enable assertion only in B class
java -ea:pack1.B

// to enable assertion both B and D classes
java -ea:pack1.B -ea:pack1.pack2.D

// to enable assertions in every class of pack1
java -ea:pack1...

// to enable assertions in every class of pack1 except B class
java -ea:pack1... -da:pack1.B

// to enable asssertions in every class of pack1 except pack2 classes
java -ea:pack1... -da:pack1.pack2...
```

*NOTE:* We can enable and disable assertions either class wise or package wise.


## Appropriate & Inappropriate use of Assertions

#### Case 1:
It is always Inappropriate to mix programming logic with assert statements.
Because there is no guarantee for the execution of assert statements always at
runtime.

```java
// appropriate way
public void withdraw(double amount) {
  if (amount < 100) {
    throw new IllegalRequestException();
  } else {
    // process the request
  }
}
```


```java
// inappropriate way
public void withdraw(double amount) {
  assert(amount >= 100)
  // process request
}
```

#### Case 2:
While performing debugging in our program if there is any place where the
control is not allowed to reach, that is the best place to use assertions.

```java
// x should be a valid month number
switch(x) {
  case 1:
    System.out.println("JAN");
    break;
  case 2:
    System.out.println("FEB");
    break;
  //...
  case 12:
    System.out.println("DEC");
    break;
  default:
    assert(false); // RE: AssertionError
}
```

#### Case 3:
It is always inappropriate for validating public method arguments by using
assertions because outside person doesnot aware whether assertions are enable or
disable.

#### Case 4:
It is always appropriate for validating private method arguments by using
assertions because local person can aware whether assertions are enable or
disable in our system.

#### Case 5:
It is always inappropriate for validating command line arguments by using
assertions because these are arguments to main method, which is public.


```java
class Test {
  int z = 5;

  public void m1(int x) {
    assert(x > 10)  ; // inappropriate public method

    switch(x) {
      case 10:
        System.out.println(10);
        break;
      case 11:
        System.out.println(11);
        break;
      default:
        assert(false); // appropriate, should not reach here
    }
  }

  private void m2(int x) {
    assert(x < 10); // appropriate in private method
  }

  private void m3() {
    assert(m4()); // inappropriate, contains programming logic, changing z value
  }

  private boolean m4() {
    z = 6;
    return true;
  }
}
```

##### Question

```java
class One {
  public static void main(String[] args) {
    int assert = 10; // using it as identifier
    System.out.println(assert);
  }  
}

class Two {
  public static void main(String[] args) {
    int x = 10;
    assert(x > 10); // using it as keyword
  } 
}
```

```shell
javac -source 1.3 One.java
// compiles fine with a warning: assert is a keyword in future versions

javac -source 1.4 One.java
// CE: assert is keyword, cannot be used as identifier

javac -source 1.3 Two.java
// CE: cannot find symbol: assert

javac -source 1.4 Two.java
// compiles with error and warning
```

##### Question 2

```java
class Test {
  public static void main(String[] args) {
    boolean assertOn = false;
    assert(assertOn): assertOn = true;

    if (assertOn) {
      System.out.println("assertOn");
    }
  }  
}
```


```shell
# if assertions are not enabled?
# no output: assert statement wont be executed.

# if assertions are enabled?
# RE: AssertionError: true
```

##### Question 3

```java
class Test {
  public static void main(String[] args) {
    boolean assertOn = true; // CHANGED!
    assert(assertOn): assertOn = false;

    if (assertOn) {
      System.out.println("assertOn");
    }
  }  
}
```


```shell
# if assertions are not enabled?
# o/p: assertOn

# if assertions are enabled?
# assert statement will be executed. But no RE cus the argument is true.
# o/p : assertOn
```

## AssertionError

- It is a child class of Error.
- It is unchecked.
- If assert statement fails(that is, argument is false), then we will get
  AssertionError.

Even though it is legal to catch AssertionError but it is not a good programming
practise.

```java
class Test {
  public static void main(String[] args) {
    int x = 10;
    //...
    try {
      assert(x > 10);
    } catch (AssertionError e) {
      System.out.println("I am stupid, because I am catching AssertionError");  
    }

    //...
    System.out.println(x);
  }  
}
```

*NOTE:* In the case of web applications if we run java program in debug mode,
automatically assert statements will be executed.
