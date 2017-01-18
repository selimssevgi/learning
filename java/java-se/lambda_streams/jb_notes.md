# Java 8 Lambda Notes

- Understanding lambdas
- Using lambdas
- Functional interfaces
- Method references
- Collections improvements

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

- Ensure that there wont be added another method declaration in interface.

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

## Closures

## this Keyword in Lambdas
- Refers to this as using it outside of lambda

## Method Reference

- (p) -> System.out.println(p)
- System.out::println
- collection.forEach()

## Streams
