# Functions

## Local Functions

- private method in a class in Java works in Scala too
- Additionally to narrow down the scope in Scala functions can be local, inside
  another function.

- Local functions can access outer scope variables. In this case we can get rid
  of some parameters passing from one method to another.

## First-class functions

- Write down functions as unnamed *literals* and the pass them around as *values*
- A *function literal* is compiled into a class
- When instantiated at runtime is a *function value*
- Class(source code), objects(runtime)
- function literal -> function value

- Function values are objects, so you can store them in variables
- They are functions, too, so you can invoke them using the usual parentheses
  function-call notation.

```scala
// store it like a variable
val succ = (x: Int) => x + 1

// call it like a function
succ(10) // succ.apply(10), 11
```

## Shorten Functions

- target typing

```scala
val aList = List(1, 2, 3, 4, 5)
aList.filter((x: Int) => x + 1)

// compiler knows it is integer
// and no need for parentheses for only one argument
aList.filter(x => x + 1)
```

- Placeholder syntax
- Underscore as a blank to be filled with each value
- Multiple underscores mean multiple parameters, not reuse of same parameter

```scala
aList.filter(_ > 3)

val f = (_: Int) + (_: Int)
f(10, 15)
```

## Partially Applied Function

- Entire parameter list can be replaced with an underscore.
- A partially applied function is an expression in which you dont supply all of
  the arguments needed by the function.
- Instead some, or none of the arguments are supplied.

- Is a way to transform def into a function value

```scala
nums.foreach(println _)

// is short form of
nums.foreach(x => println(x))
```

```scala
def sum(a: Int, b: Int, c: Int) = a + b + c
// apply function sum to the arguments 1,2,3
sum(1, 2, 3)

// partially applied
val partialSum = sum _ // partialSum refers to function value object.
partialSum(1, 2, 3,)
partialSum.apply(1, 2, 3)

val partialSomeSum = sum(1, _: Int, 3)
partialSomeSum(2)
```


```scala
aList.foreach(println _)
// can be written shorter
aList.foreach(println)
// because foreach is expecting a function, underscore can be left off

val a = sum _
// cannot be written shorter
val b = sum // ERROR
```
