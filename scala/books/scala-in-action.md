# Scala in Action

- Covers Scala 2.10
- by NilanJan Raychaudhuri
- 2013

## Part1 - Scala: the basics

### Chapter 1: Why Scala

#### Scala as an object-oriented language

Most will agree a pure object-oriented language should have the following
characteristics:

- Encapsulation/information hiding
- Inheritance
- Polymorphism/dynamic binding
- All predefined types are objects
- All operations are performed by sending messages to objects
- All user-defined types are objects

Scala supports all these qualities and uses a pure OO model similar to that of
Smalltalk(pure, 1980): 1 + 2 => 1.+(2)

Along with the pure OO features, Scala has made some innovations on OOP space:

- *Modular mixin composition* -- Traits, abstract + interface

- *Self-type* -- A mixin doesnt depend on any methods or fields of the class
  that it's mixed into, but sometimes it's useful to use fileds or methods of
  the class it's mixed into, and this feature of Scala is called self-type.

- *Type-abstraction* -- There are two principle forms of abstraction in
  programming languages: parameterization and abstract members. Scala supports
  both form of absraction uniformly for types and values.

**A mixin** is a class that provides certain functionality to be inherited by a
subclass and isn't meant for instantiation by itself. A mixin could also be
viewed as an interface with implemented methods.

#### Scala as a functional language

FP is a programming paradigm that treats computation as the evaluation of
mathematical functions and *avoids state and mutable data*.

The building blocks of FP are neither objects nor procedures (C programming
style) but functions.

Another aspect of FP is that it doesnt have *side effects* or mutabilitiy.

Functional programs are easier to understand, reason about, and test.

Another huge benefit of FP is ease of *concurrent programming*.


- input  - function - output
- domain - function - codomain
- f(x) = y
- For given input the function should *always return the same output.*

Interesting property of a mathematical function is *referential transparency*,
which means that an expression can be replaced with its result.

FP languages provide at least some of the following features:

- Pattern matching
- Single assignment (val a = 5, assigning just once)
- Lazy evaluation
- Type inference
- Tail call optimization
- List comprehensions
- Mondadic effects

*Side effect:* A function might:

- modify a global or a static variable,
- modify one of its arguments,
- raise an exception,
- write data to a display or file,
- read data,
- call other functions having side effects.

**Is Scala a pure functional language?**

- No,it is not pure functional language
- Scala supports both types of variables: val and var
- Haskell is a pure functional language.
- Scala is a FL in the sense that functions are *first-class values*

#### Scala as a multi-paradigm language

- The goal of multi-paradigm computing is to provide a number of problem-solving
  styles so a programmer can select the solution that best matches the
  chracteristics of the problem to be solved.

- Scala supports both OOP(objects as building blocks), FP(functions as blocks)
- In Scala, functions are treated as objects.

**Functions as Objects:**

Scala treats functions as values, and all values are objects, functions are
objects.

```scala
List(1, 2, 3, 4).map((x: Int) => x + 1)
// scalac replaces function parameter with object
List(1, 2, 3, 4).map(new Function1[Int, Int] { def apply(x: Int): Int = x + 1 })
```

#### Scala as a scalable and extensible language

- Scala is suitable for use as a scripting language, as well as for large
  enterprise applications.

- Defining new constructs:

```scala
def loopTill(cond: => Boolean)(body: => Unit): Unit = {
  if (cond) {
    body
    loopTill(cond, body)
  }
}

var i = 10

loopTill (i > 0) {
  println(i 
  i -= 1
}
```

*Closure*  is a first-class function with free variables that are bound in the
lexical environment.

Extending a language with a library is much easier than extending the language
itself. There wont be need to worry about backward compatibility. First actor
implementation in Scala library didnt scale well, and later another
implementation added without breaking anything.

#### Scala runs on the JVM

- Scala is a JVM languages, integrates well with Java ecosystem.
- At the byte-code level, Scala and Java code is same. (javap)
- Scala has the JVM strength out of box.

#### The current crisis

##### End of Moore's law

- Speed comes with multicore processors

##### Programming for multicores

- Multicode -> concurrency -> exploit the CPU throughputs
- Traditional thread-based concurrency-model, each thread operates on shared memory
- This leads to hard-to-find race conditions, deadlock issues
- Not threads but shared memory is the root of all concurrency problems.

- Scala takes a totally different approach to concurrency: the Actor model.
- Its shared-nothing architecture and asynch message-passing techniques make it
  an easy alternative to existing thread-based solutions.

- Parallel collections to take advantage of multicores

#### Transitioning from Java to Scala

- Java is awesome but bloated
- Improve productivity using 3rd party libraries or using a more productive
  programming language?

##### Scala improves productivity

- Developers need a language that can scala and grow with them
- It will make more productive, and allow to *do more with less code*

##### Scala does more with less code

```java
boolean hasUpperCase = false;
for (int i=0; i < name.length(); i++) {
  if (Character.isUpperCase(name.charAt(i))) {
    hasUpperCase = true;
    break;
  }
}
```

```scala
val hasUpperCase = name.exists(_.isUpper)
```


```java
// a pojo class, getter and setters
public class Programmer {
  private String name;
  private String language;
  private String favDrink;
  //...
}
```

```scala
class Programmer(var name: String, var language: String, var favDrink: String)
```

##### Coming from a dynamic language
##### Case for static typing, the right way

*Static typing* is a typing system where the values and the variables have
types. A number variable can't hold anything other than a number. Types are
determined and inforced at compile time or declaration time.

*Dynamic typing* is typing system where values have types but the variables
don't. It's possible to succesively put a number and a string inside the same
variable.

- big complex programs
- compile time vs runtime errors
- Refactoring

*Type inference* is a technique by which the compiler determines the type of a
variable or function without the help of a programmer. The compiler can deduce
that the variable s in s = "Hello" will have the type string. Type inference
ensures the absence of any runtime type errors without putting a declaration
burden on the programmer.

##### For the programming language enthusiast

- Sytanx similar to Java/C#
- Pure OO similar to Smalltalk
- Universal nesting and uniform access principles from Algol/Simula, Eiffel
- FP constructs similar to ML family of languages
- Scala's actor library influenced by Erlang's Actor model

*Compile  Macros:* Scala 2.10 release adds experimental support for compile-time
macros. This allows programmers to write macro defs: functions that are
transparently loaded by the compiler and executed during compilation. This
realizes the notion of compile-time metaprogramming for Scala.

### Chapter 2 - Getting Started

#### Basic Types

- Byte, Short, Int, Long, Float, Double, Char, Boolean

- scala.Predef implicitly being import into every scala app:
  - java.lang.\_
  - scala.\_
  - scala.Predef.\_

- lazy keywords can be used with vals when it should be initialized later

- lazy val b = a + 1

- val first :: rest = List(1, 2, 3)

#### Defining Functions

- In Scala if the last argument of a functions is of a function type, you can
  pass it as closure. This syntax sugar is useful in creating DSLs.


```scala
def breakable(op: => Unit) {
  try {
    op
  } catch { case _ => }
}

def install = {
  val env = System.getenv("SCALA_HOME")
  if (env == null) break
  printn("found scala home")
}

breakable(install)

// pass it as a closure
breakable {
  val env = System.getenv("SCALA_HOME")
  if (env == null) break
  printn("found scala home")
}
```

### Chapter 3 - OOP in Scala

- An object is always evaluated lazily, which means that an object will be
  created when its first memmer is accessed.


### Chapter 5: Functional programming

- FP is a programming paradigm that models computation as the evaluation of expressions

- Expressions are built using functions that dont have mutable state and side effects

- FP started around 1930 when Alonzo Church introduced lambda calculus

- A lambda calculus is a formal mathematical system to investigate functions,
  function application, and function recursion

- In lambda calculus all the functions are anonymous and reprepsented by the
  lambda symbol (hence the name lambda)

- Lambda calculus is the main inspiration behind FP
- FP languages implement lambda calculus with some constraints and types

#### What is FP?

- A function provides the predictability that for a given input you will always
  get the same output

```scala
def add(a: Int, b: Int): Int = a + b
```

- There are functions that depend on some external state and dont return the
  same result all the time

- They are functions but they are not pure functions
- A pure function doesnt have side effects

- Any observal behavior change after the function finishes is considered a side
  effect

- Some side effects:
  - Updating global or static variables
  - writing data to the filesystem
  - displays on screen
  - calling other "side-effecting" functions
  - throwing exceptions

- You are also not allowed to mutate the arguments to the function

- What is the value of programming with pure functions?
- The value is "referential transparency"
- Referantial transparency is a property whereby an expression could be replaced
  by its value without aaffecting the program


```scala
val v = add(10, 10) + add(5, 5)
```

- Because add is a pure function, can replace the function call add(10, 10) with
  its result, which is 20, without changing the behavior of the program

#### The benefits of referential transparency

- RT provides the ability to reason about your code

- You can provide proof that your program works correctly by replacing pure
  functions with their values and reducing a complex expression to a simpler ex

- This ability to reason about code helps programmers to debug and solve complex
  problems easily

- The essence of FP is RT

- It is safety net that allows you to easily find and fix problems

- A pure function program is a single referentially transparent expression

- An expression is constructed with a combination of subexpressions

- If you can start thinking about your program as a collection of subexpressions
  combined into one signle referentially transparent expression, you have
  achieved a purely functional program

- Referential transparency is a criterion of a good desing

#### Moving from OOP to FP

##### Pure vs impure programming

- Typically, OO-style applications are built around the idea of mutable
  state(produces side effects), managed by various objects inside the application

- OO solutions are modeled around classes and objects where data tends to carry
  collections of methods, and these methods share and at times mutate the data

- A FP style only deals with values where problems are solved by the application
  of functions to data

- data is only represented by value, each application of a function results in a
  new value without any side effects

- FP raises abstraction level over OOP
- OOP sometimes feels machine-dependent
- if you only work with values, then how function program is interpreted and
  executed becomes irrelevant
- You can compute the result of a purely FProgram using pen and paper

- Unlike Haskell and Clojure, in Scala it is your responsibility as a developer to make
  sure you dont rely on mutable data defined inside the class


```scala
class Square(var side: Int) {
  def area = side * side
}
```

- side property is mutable. area function depends on some external state

- Succersor Value pattern, or functional object
- each change of state returns a copy of itself with the new state

```scala
class PureSquare(val side: Int) {
  def newSide(s: Int): PureSquare = new PureSquare(s)
  def area = side * side
}
```

- Java String class is an example of a Functional Object pattern

CHECK: 5.2.2 and 5.2.3 again
