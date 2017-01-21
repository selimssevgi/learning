# Why Java8?

1. Advances in processing power
  - Powerful multicores
  - Parallel processing architures
  - Big data applications

2. Passing behavior
  - Code as data
  - Passing methods to methods
  - Anonymous classes, callbacks
  - FP support

3. Enhancing the libraries
  - Libraries need makeover
  - Backward compatibility
  - Interface unlocking

## What are lambdas?

- Everything is an object
  - Class is the foundation
  - Object is everything
  - Methods are tied to a class
  - Mutability is inherent
  - Anonymous classes are functions

- Lambdas
  - Anonymous functions
  - Compact, concise, expressive and elegent
  - Represents behavior
  - Pass them to other methods

- Lambda Syntax
  - Input arguments, body and a return
  - (input arguments) -> body
  - Left hand side is inputs
  - Right hand side is logic
  - Arrow token is separator
  - i -> i+i;
  - a -> notify(a);

- Simple Lambdas
  - (s1, s2) -> s1 + s2;
  - (num) -> num * num;
  - (trades) -> { persist(trades); notify(); }

## Why Lambdas?

- Enables functional programming
- Readable and concise code
- Easier-to-use APIs and libraries
- Enables support for parallel processing

```java
codeBlock = public void sayHi() {
  System.out.println("Hello");
}

// public: a piece of code doesnot belong a class or anything
// void  : compiler can figure out what is being returned
// sayHi : there is always a name: codeBlock

() -> { System.out.println("Hello"); }
// If there is single line
() -> System.out.println("Hello");
```

```java
doubleNumberFunction = public int double(int a) {
  return a * 2;
}

(int a) -> a * 2;
// no need for return keywork if there is just one line

addFunction = (int a, int b) -> a + b;

safeDivideFunction = (int a, int b) -> {
  if (b == 0) return 0;
  return a / b;
}
```

##

```java
interface MyLambda {
  void foo();
}

// main
MyLambda myLambdaFunc = () -> System.out.println("Hello");
```


```java
public interface Greeting {
  void greet();
}

// main
Greeting helloWorldGreeting = new HelloWorldGreeting(); // a class implementing interface
Greeting lambdaGreeting = () -> System.out.println("Hello Lambda!");
Greeting innerClassGreeting = new Greeting() {
  @Override
  public void perform() {
    System.out.println("Hello Inner Class!");
  }
}
```


```java
interface StringLengthLambda {
  int getLength(String s);
}

// main
StringLengthLambda myLambda = (String s) -> s.length();
sout(myLambda.getLength("Hello Lambda"));

// Type Inference
// Compiler can infer the return and argument type
StringLengthLambda myLambda = (s) -> s.length();
sout(myLambda.getLength("Hello Lambda"));

// If there is just one argument, no need for parantheses
StringLengthLambda myLambda = s -> s.length();
sout(myLambda.getLength("Hello Lambda"));
```

## Functional Interface

- Ensures that there wont be added another method declaration in interface.

```java
@FunctionalInterface
public interface Runnable {
  public abstract void run();
}

Runnable runnable = () -> System.out.println("Hello");
Callable callable = () -> "Hello"; // return "Hello";
```

```java
@FunctionalInterface
public interface greeting {
  void perform();
}
```
## Functions

- java.util.functions

## Lambda Exception Handling
- Wrapper methods

## Lambda Scoping

- It is same as enclosing method.

## Closures

## this Keyword in Lambdas
- Refers to this as using it outside of lambda


## Method Referencing

- Shorthand for delegating
- Can be used for static and instance methods
- Class::method
- (p) -> System.out.println(p)
- System.out::println
- collection.forEach()


## Constructor Referencing

- String[]::new
