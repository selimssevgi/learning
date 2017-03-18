# Coursera Prog-Fun

## Week1

### Programming Paradigms

- Imperative programming
- Functional programming
- Logic programming
- Object-oriented programming (orthogonal)

#### Imperative Programming

- Modifying mutable variables
- Using assignments
- And control structures such as if-then-else, loops, break, continue, return

- Mutable variables     ~= memory cells
- Variable dereferences ~= load instruction
- Variable assignments  ~= store instruction
- Control structures    ~= jumps

*PROBLEM:* Scaling up. How can we avoid conceptualizing programs word by word?

Pure imperative programming is limited by the "Von Neumann" bottleneck.

#### Functional Programming

- In a restricted sense, FP means programming without mutable variables,
  assignments, loops and other imperative control structures

- In a wider sense, FP means focusing on the functions.

- In particular, functions can be values that are produced, consumed, and composed

#### FP Language

- In a restricted sense, a FP language is one which does not have mutable
  variables, assignments, or imperative control structures.

- In a wider sense, a FP language enables construction of elegant programs that
  focus on functions.

- In particular, functions in FP language are first-class citizens. This means:
  * They can be defined anywhere, including inside other functions
  * They can be passed as parameters and returned as results like any other value
  * There exists a set of operators to compose functions as for other values.

*Some languages :*

In restricted sense:

- Pure Lisp(59), XSLT(99), XPath, XQuery(03), FP
- Haskell (without IO monad or UnsafePerformIO)

In wider sense:

- Lisp, Scheme, Racket, Clojure(07)
- SML, Ocaml(00), F#(05)
- Haskell(90) (full language)
- Scala(03)
- Smalltalk(78), Ruby, Javascript

#### Why FP

- Simpler reasoning principles
- Better modularity
- Good for exploiting parallelism for multicore and cloud computing

### Elements of Programming

#### Evaluation

- A non-primitive expression is evaluated as follows:

1. Take the leftmost operator
2. Evaluate its operands (left to right)
3. Apply the operator to the operands

A name is evaluated by replacing it with the right hand side of its definition.

The evaluation process stops once it results in a value.

```shell
(2 * pi) * radius
(2 * 3.14) * radius
6.28 * radius
6.28 * 10
62.8
```

```scala
def square(x: Double) = x * x
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
```

#### Evaluation of Function Application

Applications of parameterized functions are evaluated in a similar way as operators:

1. Evaluate all function arguments, from left to right
2. Replace the fuction application by the function's right-hand side, and at the
   same time
3. Replace the formal parameters(x,y) of the functions by the actual arguments(3,4)


```scala
sumOfSquares(3, 2 + 2)
sumOfSquares(3, 4)      // evaluate all function arguments
square(3) + square(4))   // replace function application and parameters
3 * 3 + square(4)
9 + square(4)
9 + 4 * 4
9 + 16
25
```

#### The Substitution Model

- This scheme of expression evaluation is called substitution model.
- The idea underlying this model is that all evaluation does is reduce an
  expression to a value.
- It can be applied to all expressions, as long as they have no side effects.
- The substitution model is formalized in the lambda-calculus, which gives a
  foundation for functional programming.

!! (c++) has side effect, cannot be expressed in substitution model.

#### Termination

Does every expression reduce to a value(in a finite number of steps)?

```scala
// NO, counter-example
def loop: Int = loop
```

#### changing the evaluation strategy

The interpreter reduces functions arguments to values before rewriting the
function application.

One could alternatively apply the function to unreduced arguments.

```scala
sumOfSquares(3, 2+2)
square(3) + square(2+2)
3 * 3 + square(2+2)
9 + square(2+2)
9 + (2+2) * (2+2)
9 + 4 * (2+2)
9 + 4 * 4
25
```

#### Call-by-name and call-by-value

The first evaluation strategy is known as call-by-value,

The second one is known as call-by-name.

Both strategies reduce to the same final values as long as:

* the reduced expression consists of pure functions, and
* both evaluations terminate.

Call-by-value has the advantage that it evaluates every function argument only
once.

Call-by-name has the advantage that a function argument is not evaluated if the
corresponsing parameter is unused in the evaluation of the function body.

**Example:**

```scala
def test(x: Int, y: Int) = x * x

test(2, 3)    // same # of steps of evaluation
test(3+4, 8)  // (3+4) * (3+4), call-by-name would have one step more
test(7, 2*4)  // call-by-value would have one step more(2*4)
test(3+4, 2*4)// same # of steps
```

*What if termination is not guaranteed?*

* If CBV evaluation of an expression e terminates, then CBN evaluation of e
  terminates, too.
* The other direction is not true.

*Question:* Find an expression that terminates under CBN but not under CBV.

```scala
def first(x: Int, y: Int) = x

first(1, loop) // Under CBN: terminates
first(1, loop) // Under CBV: will try to evaluate the loop. cannot terminate.
```

#### Scala's evaluation strategy

- Scala normally uses call-by-value(avoid more computation)
- But if the type of a function parameter starts with => it uses call-by-name.


```scala
def constOne(x: Int, y: => Int) = 1

constOne(2+3, loop)
// constOne(5, loop) , not gonna evaluate loop, that part is CBN
constOne(loop, 2+3)
// is gonna evaluate 'loop' because it is CBV, wont terminate.
```

### Conditional and Value Definitions

if-else is different; in Java it is a statement, in Scala it is an expression.

```scala
def abs(x: Int) = if (x >= 0) x else -x
```

- Short-circuit evaluation

### Value Definitions

- We have seen function parameters can be passed by value or by name.

- The same distinction applies to functions.

- The 'def' form is by-name, it is right-hand side is evaluated on each use.

- There is a 'val' for, which is by-value.

```scala
val x = 2
val y = square(x) // y refers to 4
```

The right-hand side of a val definition is evaluated at the point of the
definition itself. Afterwards, the name refers to the value.

The difference between val and def becomes apparent when the right-hand side
doesnot terminate.

```scala
def loop: Boolean = loop
def x = loop // is okay

val x = loop // will lead to infinite loop
```

*Exercise:* Write functions and and or such that for all argument expressions x
and y:

- and(x, y) == x && y
- or(x, y)  == x || y
- do not use || and && in your implementation
- What are good operands to test that the equalities hold?

```scala
def and(x: Boolean, y: => Boolean) = if (x) y else false
// and(false, loop)
def  or(x: Boolean, y: => Boolean) = if (!x) y else true
// or(true, loop)
```

*Exercise:*

```scala
object session {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) / x < 0.001

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIter(1, x)

  sqrt(4)
  sqrt(1e-3)
  sqrt(1e-30)
  sqrt(1e30)
  sqrt(1e45)
  sqrt(90000)
}
```

#### Nested Functions

- It's good functional programming style to split up a task into many small functions.
- In the previous exercise, isGoodEnough, improve, sqrtIter matter only for the
  implementation of sqrt, not for its usage.
- Normally we would not like users to access these functions directly.
- We can achieve this and at the same time avoid "name-space pollution" by
  putting the auxciliary functions inside sqrt.


```scala
object session {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def isGoodEnough(guess: Double, x: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    sqrtIter(1, x)
  }

  sqrt(4)
}
```

#### Blocks in Scala

- A block is delimited by braces {...}

```scala
{
  val x = f(3)  
  x * x
}
```

- It contains a sequence of definitions or expressions.
- The last element of a block is an expression that defines its value.
- This return expression can be preceded by auxciliary definitions.
- Blocks are themselves expressions, a block may appear everywhere an expression can.


```scala
val x = 0

def f(y: Int) = y + 1
val result = {
  val x = f(3) // shadows outside x, x = 4
  x * x        // 4 * 4 = 16
} + x          // outside x , 0

// result = 16
```

```scala
// x is visible in other functions scope, passing it around is redundant
object session {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1)
  }

  sqrt(4)
}
```

#### Semicolons

- Are optional.

```scala
val x = 1;
val a = 5

// more than one statement on a line
val y = x + 1; y * y

someLongExpression
+ someAnotherExpression

// would be interpreted by scala compiler as follows;
someLongExpression;
+ someAnotherExpression

// to overcome this problem
(someLongExpression
+ someAnotherExpression)

// or
someLongExpression +
someAnotherExpression


```

#### Tail Recursion

```scala
def gcd(x: Int, y: Int): Int =
  if (y == 0) x else gcd(y, x % y)

gcd(14, 21)
```

```shell
if (21 == 0) 14 else gcd(21, 14 % 21)
if (false) 14 else gcd(21, 14 % 21)
gcd(21, 14 % 21)
gcd(21, 14)
if (14 == 0) 21 else gcd(14, 21 % 14)
gcd(14, 7)
if (7 == 0) 14 else gcd(7, 14 % 7)
gcd(7, 0)
if (0 == 0) 7 else gcd(0, 7 % 0)
7

```


```scala
def factorial(x: Int): Int =
  if (x == 0) 1 else x * factorial(x - 1)

factorial(4)
```

```shell

if (4 == 0) 1 else 4 * factorial(4 - 1)
4 * factorial(3)
4 * (3 * factorial(2))
4 * (3 * (2 * factorial(1)))
4 * (3 * (2 * (1 * factorial(0))))
4 * (3 * (2 * (1 * 1)))
24
```

If a function call itself as its last action, the function's stack frame can be 
reused. This is called *tail recursion*.

Tail recursive functions are iterative processes.

In general, if the last action of a function consists of a calling a function
(which maybe the same), one stack frame would be sufficient for both functions.
Such calls are called tail-calls.

- else gcd(y, x % y) : is tail-recursive.
- else x * factorial(x - 1) : is not tail-recursive. There is still work to be done after calling a function.

##### Tail recursion in Scala

- In Scala, only directly recursive calls to the current function are optimized.

- One can require that a function is tail-recursive using a @tailrec annotation.

```scala
@tailrec
def gcd(a: Int, b: Int): Int = {}
```

- If the annotation is given, and the implementation of gcd were not tail
  recursive, an error would be issued.

*Exercise:* Design a tail-recursive version of factorial.

```scala
def fact(n: Int): Long = {
  def tailRecursiveFact(acc: Long, n: Int): Long =
    if (n == 0) acc else tailRecursiveFact(acc * n, n - 1)

  tailRecursiveFact(1, n)
}

fact(31)
```


## Week2 - Higher Order Functions

### L2.1 - Higher-Order Functions

- FLs treat functions as first-class values.
- A function can be passed as a parameter and returned as a result like any other value.
- This provides a flexible way to compose programs.
- Functions that take other functions as parameters or that return functions as
  results are called *higher order functions*.

*Example:* Take the sum of the integers between a and b:

```scala
def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b)
```

*Example:* Take the sum of cubes of all integers between a and b:

```scala
def cube(x: Int) = x * x * x

def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
```

*Example:* Take the sum of the factorials of all integers between a and b:

```java
def sumFactorials(a: Int, b: Int): Int =
  if(a > b ) 0 else fact(a) + sumFactorials(a + 1, b)
```

#### Summing with Higher-Order Functions

```scala
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f, a + 1, b)

def sumInts(a: Int, b: Int)       = sum(id, a, b)
def sumCubes(a: Int, b: Int)      = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(fact, a, b)

def id(x: Int): Int   = x
def cube(x: Int): Int = x * x * x
def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)

```

#### Function Types
The type A => B is the type of a functions that takes an argument of type A and
returns a result of type B.

#### Anonymous Functions
Passing functions a parameters leads to the creation of many small functions.

Sometimes it is tedious to have to define(and name) these functions using def

Compare to strings: We do not need to define a string using def. Instead of

```scala
def str = "abc"; println(str)

// we can write directly:
println("abc")
```

Because strings exist as literals. Analogously we would like function literals,
which let us write a function without giving it a name.

These are called *anonymous functions*.

#### Anonymous Functions Syntax

```scala
(x: Int) => x * x * x
```

The type of the parameter can be omitted if it can be inferred by the compiler from the context.

If there are several parameters, they are separated by commas.

```scala
(x: Int, y: Int) => x + y
```

Anonymous functions are syntactic sugar.

#### Summation with anonymous functions

```scala
def sumInts(a: Int, b: Int) = sum(x => x, a, b)
def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
```

Tail-recursive sum function:

```scala
def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}

sum(x => x, 1, 5)
```

### L2.2 - Currying

```scala
def sumInts(a: Int, b: Int)       = sum(x => x, a, b)
def sumCubes(a: Int, b: Int)      = sum(x => x * x * x, a, b)
def sumFactorials(a: Int, b: Int) = sum(fact, a, b)
```

*Question:* 'a' and 'b' get passed unchanged from sumInts and sumCubes into sum.
Can we be even shorter by getting rid of these parameters?

#### Functions Returning Functions

```scala
def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)

  sumF
}
```

sum is now a function that returns another function.

The returned function sumF applies the given function parameter 'f' and sums the results.

```scala
def sumInts  = sum(x => x)
def sumCubes = sum(x => x * x * x)
def sumFacts = sum(fact)

sumInts(1, 6)
sumCubes(1,3)
```

#### Consecutive Stepwise Applications

Can we avoid the sumInts, sumCubes, middlemen?

```scala
sum (cube) (1, 10)
```

- sum(cube) applies sum to cube and then returns the sum of cubes functions.
- sum(cube) is therefore equivalent to sumCubes.
- This function is next applied to the arguments (1, 10)

Generally, function application associates to the left:

- sum(cube)(1, 10) == (sum(cube))(1, 10) 

#### Multiple Parameter Lists

The definition of functions that return functions is so useful in FP that there
is a special syntax for it in Scala.

The following definition of 'sum' is equivvalent to the one with the nested sumF
function, but shorter:

```scala
def sum(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)
```

#### Expansion of Multiple Parameter Lists

#### More function Types

```scala
def sum(f: Int => Int)(a: Int, b: Int): Int = {}

// the type of above function:
(Int => Int) => (Int, Int) => Int
```

*NOTE:* Functional types associate to the right.

- Int => Int => Int
- is equivalent to
- Int => (Int => Int)

*Exercise:* 

* Write a 'product' function that calculates the product of the values of function
for the points on given interval.

```scala
def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product (f) (a + 1, b)
}

product (x => x + 1) (1, 3)
```
* Write 'factorial' in terms of 'product'

```scala
def factorial(n: Int) = product(x => x) (1, n)
factorial(5)
```
* Can you write a more general function , which generalizes both 'sum' and 'product'?

```scala
def add(x: Int, y: Int) = x + y
def mul(x: Int, y: Int) = x * y

def gen(f: Int => Int, op: (Int,Int) => Int, unit: Int)(a: Int, b: Int): Int =
  if (a > b) unit else op(f(a), gen(f, op, unit)(a + 1, b))

gen (x => x + 1, add, 0) (1, 10)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)
             (a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b)

def product(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)
```

### L2.3 - Example: Finding Fixed Points

A number is called a 'fixed point' of a function f if

f(x) = x

We can locate the fixed points by starting with an initial estimate and then
applying f in a repetitive way:

x, f(x), f(f(x)), f(f(f(x)))...

until the value does not vary anymore or small change.

x => 1 + x / 2 fixed point: (x=2)

```scala
object FixedPoint {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x / 2)(1)
}
```

#### Return to Square Roots

A specification of the sqrt function:

- sqrt(x) = the number y such that y = x * x

Or, by dividing both sides of the equation with y:
  
