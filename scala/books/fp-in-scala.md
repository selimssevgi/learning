# Functional Programming in Scala
  
## C1 - What is functional programming?

- FP using only pure functions

- pure functions have no side effects

- Side effects:
  - modifying a variable
  - modifying a data structure in place
  - setting a field on an object
  - throwing an exception or halting with an error
  - printing to the console or reading user input
  - reading from or writing to a file
  - drawing on the screen

- fp is a restriction on how we write program, but not on what programs we can express

- two important FP concepts: referential transparency, substitution model

- A => B : reads a function from A to B or A arrow B

- function in a sense should be already pure, without side effects
- Procedure is often used to refer to some parameterized chunk of code that may have side effects

- this idea of pure functions can be formalized using the concept of Referential Transparency (RT)

- RT is a property of 'expressions' in general and not just functions

- 2 + 3 is 5 every time. + is a pure function

- 2 + 5 can be replaced by 5 in a program without changing the meaning of program

- An expression e is referentially transparent if, for all programs p, all
  occurrences of e in p can be replaced by the result of evaluating e without
  effecting the meaning of p.

- If an expression or a function is RT, then we can substitute it with its result

- Purity, Referential Transparency, Substitution Model


```scala
val x = "Hello"

val r1 = x.reverse             // olleH

val r2 = x.reverse             // olleH

// replace x with its definition

val r1 = "Hello".reverse       // olleH
val r2 = "Hello".reverse       // olleH

// x is RT, r1 and r2 are RT too
```


```scala
val x = new StringBuilder("Hello")

val y = x.append(", World")

val r1 = y.toString        // Hello, World
val r2 = y.toString        // Hello, World

// replace y with its definition
val r1 = x.append(", World").toString       // Hello, World
val r2 = x.append(", World").toString       // Hello, World, World

// StringBuilder.append is not a pure function
```

- A pure function is modular and composable because it separates the logic of
  the computation itself from "what to do with the result" and "how to obtain
  the input"; it is a black box

## C2: Getting started with FP in Scala

- object also know as module

- (the: Int) reads as 'the has type Int', colon is pronounced 'has type'

- "left hand side" | "signature" = "right hand side" | "definition"

- Scala is usually able to infer the return types of methods, so they can be omitted

- it is generally considered good style to explicitly declare the return types
  of methods that you expect others to use

- return type of private methods can be omitted

- An object whose primary purpose is giving its members a namespace is sometimes
  called a 'module'

- polymorphic functions vs monomorphic functions

- polymorphic functions also known as parametric polymorphism

- polymorphic functions are sometimes called generic functions

- [A] is a 'type parameter' list, A is a type variable

```scala
// polymorphic
def findFirst[A](arr: Arr[A], p: A => Boolean): Int = {
  @annotation.tailrec
  def loop(index: Int): Int = {
    if (index >= arr.length) -1
    else if (p(arr(index))) index
    else loop(index + 1)
  }
  loop(0)
}
```


## C2 - Functional data structures

- A functional data structure is operated on using only pure functions

- a pure function must not change data in place or perform other side effects

- functional data structures are by definition immutable

- 3 + 4 = 7 # operands are left unchanged

- List(1, 2) ++ List(3, 4) = List(1, 2, 3, 4) # operands are left unchanged


```scala
sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
```

- in general a data type is introduced with the 'trait' keyword
- Nil and Cons are 'data constructor'

- Just as functions data types can be polymorphic as well


### Data Sharing in Functional Data Structures

- val a = List(1, 2, 3)
- val b = 1 :: a // List(1, 1, 2, 3)
- we dont have to copy a to get a List b
- because List is guaranteed to be immutable, it can be shared with others
- this reusing of data is called 'data sharing'

- removing an element from front: xs.tail
- functional data structures are persistent, meaning existing references are
  never changed by operations on the data structure

- list and tree exercises, ADT

## C4 - Handling errors without exceptions

- throwing exceptions is a side effect

- if exceptions are not used, then what is used?

### the good and bad aspects of exceptions

- Why do exceptions break RT?

- Another way of understanding RT is that the meaning of RT expression 'does not
  depend on context' and may be reasoned about locally

- meaning of non-RT expressions is context-dependent and requires more global reasoning

- 42 + 5 doesnt depend on the context, it is 47 every time
- 42 + ((throw new Exception(("Fail!")): Int)) depends on which catch block is run

- There are two main problems with exceptions:

1. exceptions break RT and introduce context dependence

2. exceptions are not type-safe, signature of functions doesnt tell us anything
   about any exception, no forcing to handle them. they may occur at run time

- Java's checked exceptions at least force a decision to do smth with ex
- however they result in boilerplate for callers.

- Exceptions dont work for HOFs
- cannot wrap in lots of catch block for all exception that f could throw

- instead of throwing an ex, return a value indicating that an exceptional condition occured

- this idea is similar to return codes in C to handle exceptions

- unlike C, they are type-safe, less boilerplate

```scala
def mean(xs: Seq[Double]): Double =
  if (xs.isEmpty)
    throw new ArithmeticException("mean of empty list!")
  else xs.sum / xs.length
```

- mean function is partial function
- it is not defined for some inputs
- a func is typically partial cus it makes some assumps about its input that arent implied by input type

- using exceptions
- returning xs.sum / xs.length for all xs, 0.0 / 0.0 is Double.NaN
- or some other sentinel value
- or return null in other situations
- all above solutions are bad

- it allows errors to silently propogate
- boilerplate code using if statement for checking the result
- it is not applicable to polymorphic code
- special treatment of such functions, HOFs treat all arguments uniformly

### Option data type

- the solution is to represent explicitly in the return type that a function may not always have an answer

```scala
def mean(xs: Seq[Double]): Option[Double] = {
  if (xs.isEmpty) None
  else Some(xs.sum / xs.length)
}
```

- now return type reflects the possibility that the result may not always be defined
- still returning a result of declared type (Option[Double])
- mean is now a 'total function'
- it takes each value of the input type to exactly one value of the output type

- using a sentinel value could work same way, but we wont have type-safety,
  compiler checking, and error-handling

- Option can be thought of like a List that can contain at most one element

- many of List funcs have analogous on Option

### Usage

- Although we can explicitly pattern match on an Option, we will almost always
  use the HOFs defined on Option type

### The Either Data Type


- Option doesnt tell us anything about what when wrong in case of None
- What if we want to know more about what was the exceptional case?

- sometimes just knowing whether a failure occcured is sufficient, in which case we can use Option 

- if we want to track a reason for the failure, we can use Either

- Either has only two cases, just like Option
- the essential difference is that both cases carry a value

```scala
sealed trait Either[+E, +A]

case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]
```

## C5 - Strictness and laziness

- purely functional data structures, singly linked list

- some bulks operations on lists; map, filter, foldLeft, foldRight, zipWith...

- each of these operations makes its own pass over the input and constrcuts a fresh list for the output

- a number of list, adding 10 to each and take even ones, multiply by three

```scala
List(1, 2, 3, 4).map(_ + 10).filter( _ % 2 == 0 ).map(_ * 3)
List(11, 12, 13, 14).filter( _ % 2 == 0 ).map(_ * 3)
List(12, 14).map(_ * 3)
List(36, 42)
```

- each transformation produce a temporary list that only ever gets used as input
  to the next transformation

- can we fuse sequences of transformations into a single pass and avoid creating
  temporary data structures?

- we could rewrite the code into a while loop by hand, losing high-level concepts

- we can accomplish this kind of automatic loop fusion through the use of
  non-strictness (or, less formally, laziness)

### Strict vs non-strict functions

- non-strictness is a property of a function

- non-strict func means that it may choose not to evaluate one or more of its args

- a strict func always evaluates its arguments


```scala
def square(x: Double) Double = x * x

square(41.0 + 1.0) // funct will receive 42.0
square(sys.error("failure"))  // it wont reach the square body
```

- short-circuting Boolean functions && and || are non-strict

```scala
false && { println("!!"); true } // doesnt print anything
true || { println("!!"); false } // doesnt print anything
```

- another example of non-strictness is the if control construct

```scala
val result = if (input.isEmpty) sys.error("empty input") else input
```

- we can have an if construct

```scala
def if2[A](cond: Boolean, onTrue: () => A, onFalse: () => A]): A = {
  if (cond) onTrue() else onFalse()
}

if2(a < 22,
  () => println("a"),
  () => println("b")
)
```

- unevaluated form of expression is caLed a 'thunk'
- we can force the the thunk to evaluate the expression by passing an empty argument list

- scala provides a nicer syntax for thunk

```scala
def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A = {
  if (cond) onTrue else onFalse  
}
```

- scala wont (by default) cache the result of evaluating an argument

```scala
def maybeTwice(b: Boolean, i: => Int) = if (b) i + i else 0

val x = maybeTwice(true, { println("hi"); 1 + 41 })
// hi
// hi // evaluates i two times
// 84

// cache the value of used more than once
def maybeTwice(b: Booelan, i: => Int): Int = {
  lazy val j = i
  if (b) j + j else 0
}
```

### lazy lists

#### smart constructor

- data constructor of Stream will evaluate thunk more than once

- Avoid such problems by providing smart constructors

- function for constructing a data type that ensures some additional invariant or
  provides a slightly different signature than the real constructors used for pattern matching

- by convention, smart constructors typically lowercase the first letter of corresponding data constructor

- memoizing the by-name arguments for the head and tail of the Cons

- this common trick ensures that our thunk will only do its work once, when forced for the first time

```scala
def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
   lazy val head = hd
   lazy val tail = tl
   Cons(() => head, () => tail)
}
```

### Separating program description from evaluation

- A major theme in fp is separation of concerns

- we want to separate the description of computations from actually running them

- function capture some computation on their bodies but only execute it once they receive their their arguments

- Option captures an error occured, decision of what to do become a separate concern

- laziness let us separate the description of an expression from the evaluation of that expression

```scala
def exists(p: A => Boolean): Boolean = {
  this match {
    case Cons(h, t) => p(h()) || t().exists(p)
      case _ => false
  }
}
```

- exists has the ability to terminate early thanks to || non-strictness

- tail of the Stream is lazy val, so it also never evaluate the tail

```scala
def exists(p: A => Boolean): Boolean = {
  foldRight(false)((a, b) => p(a) || b)
}

// f's second argument is caLy-by name, it may not evaluate it
// if f chooses not to evaluate its 2nd arg, this terminates the traversal early
def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
  case Cons(h, t) => f(h(), t().foldRight(z)(f))
  case _ => z
}
```

- if our foldRight cAn terminate early, we can build other function on top of it
- in original list implementation we could terminate early
- laziness make our code more reusable

- map, filter, flatMap implementations on Streams are incremental
- they dont full generate their answers until terminating operation
- cus of incremental nature we can pipe this functions without fully instantiating the intermediate result

- it will take one element at a time can move through all piped functions
- streams might be called 'first claS loops'

- incremental nature of stream transformations also has important conseqs for mem usage
- no intermediate streams and when a elements not taken into a final result can be already collected before waiting final result

#### Infinite streams and corecursion

- stream funcs are incremental so they can work on infinite streams

```scala
val ones: Stream[Int] = Stream.cons(1, ones)
```

## C6 - Purely functional state

- how to make any stateful API purely functional

### Generating random numbers using side effects

- val rand = new scala.util.Random

- rand.nextDouble
- rand.nextInt

-  we can say rand object has some internal state that gets updated after each
   invocation

- otherwise we will get the same value each time 

- cus state updates are performed as a side effect, these methods are not RT

- not being RT implies that they arent as testable, composable, modular, and
  easily paralleized as they could be

### Purely functional random number generation

- the key to recovering RT is to make the state updates 'explicit'

```scala
trait RNG {
  def nextInt: (Int, RNG)
}
```

- we separate the concern of computing what the next state is from the concern
  of communicating the new state to the rest of the program

- now we can reproduce the same value of we call a RNG implementation, next RNG
  will generate a diFerent value

### Making stateful APIs pure

- this problem of making seemingly stateful APIs pure and its solution (having
  the API compute the next state rather than actuaLy mutate anything) arent
  unique to random number generation

```scala
def double(rng: RNG): (Double, RNG) = {
   val (x, g) = noNnegative(rng)
   ((x / (Int.MaxValue.toDouble + 1)), g)
}
```

## A better API for state actions

- the implementation may have  a common pattern like RNG => (A, RNG) for functions

- such function are called 'state action' or 'state transitions'

- they transform RNG states from one to the next

- these state actions can be combined using 'combinators'

- combinators are higher order functions

- since it's preTy tedious and repetitive to pass the state along ourselves, use
  combinators to pass the state from one action to the next automatically

- to make the type of actions convenient to talk about, and to simplify our
  thinking about them, make a type alias for RNG state action data type:

```scala
type Rand[+A] = RNG => (A, RNG)
```
