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

## Functional Interface

```java
@FunctionalInterface
public interface Runnable {
  public abstract void run();
}

Runnable runnable = () -> System.out.println("Hello");
Callable callable = () -> "Hello"; // return "Hello";
```

## Lambda Scoping

- It is same as enclosing method.

## Method Referencing

- Shorthand for delegating 
- Can be used for static and instance methods
- Class::method

## Constructor Referencing

- String[]::new
