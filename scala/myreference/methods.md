# Scala Methods

- Return types of methods are type-inferred(= tells compiler to infer)

- No need of braces if body is just single statement(or expression)

- Scala doesnt have the 'static' keyword.

- static methods(in Java) must live in 'object'(singleton) construct

- The concept of method calls is central to Scala

- Scala doesnt have operators in Java sense

- Scala is more flexible than Java about which characters can appear in method names

- Some operator characters(+) may be legal in Scala method names


```scala
// most verbose method
def add(x: Int, y: Int): Int = {
  return x + y;
}

// if it has one statement, no need of curly
// no need to have return keyword
// no need to have return type, last evaluated statement will be returned
def add(x: Int, y: Int) = x + y
```

* Return type inference

- Types returned from a method are inferred
- Type inferencer will make the best judgement
- If types are different it will find a common ancestor


```scala
// add(Int,Int):Any
def add(x: Int, y: Int) = {
  if (x > y)  (x + y).toString
  else x + y
}

// add(Int, Int):AnyVal
def add(x: Int, y: Int) = {
  if (x > y)  println(x + y) // return Unit
  else x + y
}
```

* Reasons to include return types

- Make intentions clear
- Type inferencer inferred the wrong type
- Method will be called recursively
- Method is overloaded

## Special Cases

- when a method takes one parameter, we can call it without dot or parentheses

```scala
// to is a method take one integer,
0 to 2 // 0.to(2)
1 +  2 // 1.+(2)
```

## Local Functions

- A function that is defined (and only in scope) within another function
- A simple way to have helper functions

```scala
def fact2(base : Int) : Int = {
  def factHelper(n : Int) : Int = {
    return fact2(n-1)
  }

  if (base <= 0)
    return 1
  else
    return base * factHelper(base)
}

def fact(n: BigInt) = {
  @tailrec
  def factorial(n:BigInt, acc: BigInt): BigInt = {
    if ( n <= 0 ) 1
    else factorial(n - 1, n * acc)
  }

  factorial(n, 1)
}
```

## Parameterized types on Methods

- Parameterized Types maintain type consistency
- Parameterized Types use [] not <>
- Nearly equivalent to Java's generics and C++'s templates

```scala
def decide[T](b: Boolean, x: T, y: T): T = if (b) x else y
```

## Named and Default Arguments


```scala
// named arguments
def processNumbers(b: Boolean, x: Int, y: Int) = if (b) x else y
println(processNumbers(x = 10, y = 15, b = false))
```

```scala
// default argument
def add(x: Int, y: Int = 10) = x + y
println(add(3, 4)) // 7
println(add(3)     // 13
```

```scala
def processNumbers(b: Boolean = true, x: Int, y: Int) = if (b) x else y
println(processNumbers(x = 10, y = 15, b = false))

println(processNumbers(4,5))  // b -> 4, x -> 5, y -> ? ERROR
println(processNumbers(x = 4, y = 5))
```
## Method Overloading

- Same as in Java
