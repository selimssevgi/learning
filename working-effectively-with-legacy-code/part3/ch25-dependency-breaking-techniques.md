# ch25 - dependency-breaking techniques

- they can be used to decouple classes well enough to get them under test

- technically, these techniques are refactorings, each of them preserves behavior

- unlike most refactorings written up in the industry so far, these refactorings
  are intended to be done without tests, ot get tests in place.


## Adapt Parameter

- there are times Extract Interface does not work.
  - Parameter is already interface (with lots of methods: HttpServletRequest)

```java
public void populate(HttpServletRequest request) {
  //
}
```

- use Adapt Parameter when you can't use Extract Interface on a parameter's
  class or when a parameter is difficult to fake

- we could use a mocking library

* move toward interface that communicate responsibilities rather than
  implementation details. This makes code easier to read and easier to maintain

```java
public void populate(ParameterSource source) {
  //
}
```

- FakeParameterSource and ServletParameterSource implementations

- Adapt Parameter is one case in which we don't Preserve Signatures. Use extra care

- Safety first. Once you have tests in place, you can make invasive changes much more confidently

## break out method object

- if the method is large or does use instance data and methods, consider using "break out method object"

- the idea: move a long method to a new class

- new class has a constructor of same signature as the large method

- if method uses instance variables from original class, pass 'this' as first argument

- create an instance of method object and delegate work from the original method

## definition completion

- declare a type in one place and define it in another: c/c++

## encapsulate global references

- if several globals are always used or are modified near each other, they
  belong in the same class

- when you encapsulate them, start with data or small methods. More substantial
  methods can be moved to the new class when more tests are in place.

## expose static method

- when a method does not use any instance data or method, we can turn it into a static method

- when it is static, we can get it under test without having to instantiate it

## extract and override call

- it is an ideal way to break dependencies on global variables and static methods

## extract and override factory method

- hard-coded initialization work in constructors can be very hard to work around in testing

```java
public class WorkflowEngine {
  public WorkflowEngine() {
    this.tm = // initialization code
  }
}

//
public class WorkflowEngine {
  public WorkflowEngine() {
    this.tm = makeTm();
  }

  protected TransactionManager makeTm() {
    // initialize it here
  }
}

public class TestWorkflowEngine extends WorkflowEngine {
  protected TransactionManager makeTm() {
    return new FakeTransactionManager();
  }
}
```

## extract and override getter

- create a getter method for dependeny

- change code to this.tm to this.getTm()

```java
public TransactionManager getTm() {
  return this.tm;
}
```

- and return fake implementation in subclass

```java
public TransactionManager getTm() {
  // use lazy getter
  if (fakeTm == null) {
    fakeTm = new FakeTransactionManager();
  }
  return fakeTm;
}
```

- the downside is that someone might use field not get it through getter

- if there is only problematic usage: extract and override call
- if there are many problematic usage: extract and override getter

## extract implementer

- Extract Interface is a handy technique, but one part of it is hard: naming

- to extract an implementer of a class, we turn the class into an interface by
  subclassing it and pushing all of its concrete methods down into that subclass

## extract interface

* when you extract an  interface, you don't have to extract all of the public
  methods on the class you are extracting from.

## introduce instance delegator

```java
public class BankingServices {
  public static void updateAccountBalance(int userId, Money amount) {}
}
```

```java
public class SomeClass {
  public void someMethod() {
    BankingServices.updateAccountBalance(id, sum);
  }
}
```

- from static to instance method

```java
public class BankingServices {
  public static void updateAccountBalance(int userId, Money amount) {}

  public void updateAccountBalance(int userId, Money amount) {
    updateAccountBalance(userId, amount);
  }
}
```

```java
public class SomeClass {
  public void someMethod(BankingServices services) {
    services.updateAccountBalance(id, sum);
  }
}
```

- when you use this technique, you can get an object seam in place easily and
  substitute different behaviors under test

## introduce static setter

- global data is evil

- singletons make testing hard(cannot create an instance for test)

- add a static setter to the singleton to replace the instance, and then make the constructor protected

- you can then subclass the singleton, create a fresh object, and pass it to the setter

## link substitution

- in OO we can easily substitute one object for another if they implement same interface or have same superclass

- in procedural languages like C dont have that option

- can also be used in Java. create classes with the same names and methods, and
  change the classpath so that calls resolve to them rather than the classes
  with bad dependencies.

## parameterize constructor

- here we hard-code the dependency

```java
public class MailChecker {
  public MailChecker(int checkPeriodSeconds) {
    this.receiver = new MailReceiver();
    this.checkPeriodSeconds = checkPeriodSeconds;
  }
}
```

- instead we can have possibility of injecting from outside or the default

```java
public class MailChecker {
  public MailChecker(int checkPeriodSeconds) {
    this(new MailReceiver(), checkPeriodSeconds);
  }

  public MailChecker(MailReceiver receiver, int checkPeriodSeconds) {
    this.receiver = receiver;
    this.checkPeriodSeconds = checkPeriodSeconds;
  }
}
```

- the downside is that it opens the door of other code to be dependent on the
  parameter, but it can be a small concern for the win.

## parameterize method

- we have a method that creates an object internally, and we want to replace the
  object to sense or separate.


```java
public void run() {
  TestResult tr = new TestResult();
  // operations
}

public void run(TestResult tr) {
  // operations
}

public void runWithTestResult(TestResult tr) {
  // operations
}
```

## primitivize parameter

- leaves code in a rather poor state

- overall, it is better to add the new code to the original class or to use
  Sprout Class to build some new abstraction that can serve as a base for further work

## pull up feature

- sometimes you have work with a cluster of methods on a class, and the
  dependencies that keep you from instantiating the class are unrelated to the cluster

- by "unrelated" means that the methods you want to work with don;t directly or
  indirectly reference any of the bad dependencies

- we could do Expose Static Method or Break Out Method Object repeatedly

- or we could pull up the cluster of methods, the feature, into an abstract superclass

- we can subclass it, and create instances in our tests

## push down dependency

- create an abstract class from existing one

- push down the problematic parts(ui, db interaction) to subclass

- create test classes from abstract class

## replace function with function pointer

- in procedural language, we dont have many options

- we can use Encapsulate Global References or Subclass and Override Method

- we can use Link substitution or Definition Completion

- but often they are overkill, can use function pointers if language supports(C)

## replace global reference with getter

- one way to get past dependencies on globals in a class is to introduce getters
  for each of them in the class

- when you have the getters, you can Subclass and Override Method

```java
public class RegisterSale {
  public void addItem(Barcode code) {
    Item newItem = Inventory.getInventory().itemForBarcode(code);
    items.add(newItem);
  }
}
```

- use getter to access global data

```java
public class RegisterSale {
  public void addItem(Barcode code) {
    Item newItem = getInventory().itemForBarcode(code);
    items.add(newItem);
  }

  // now we can override this for testing
  protected Invetory getInventory() {
    return Inventory.getInventory();
  }
}
```

## subclass and override method

- the central idea is that you can use inheritance in the context of a test to
  nullify behavior that you don't care about or get access to behavior that you do care about

## supersede instance variable

- C++ does not allow the override in the constructor

- a method called in constructor in superclass, and overridden in subclass,
  during construction the one in the superclass will be called.

- overridden methods can be called from constructors in java(not recommended)

```java
public void supersedeParameter(Parameter newParameter) {
  this.parameter = newParameter;
}
```

- can call supersedeParameter when we need to put in a sensing object
- having setter for manipulating the objects state makes understanding the code harder

## template redefinition

- C++, template parameter

## text redefinition

- some of the interpreted languages give you a very nice way to break dependencies

- when they are interpreted, methods can be redifined on the fly.

```ruby
class Account
  def report_deposit(value)
    ...
  end

  # other operations
```

```ruby
# AccountTest.rb
require "runit/testcase"
require "Account"

class Account
  def report_deposit(value)
    # do nothing
  end

# tests start here
```
