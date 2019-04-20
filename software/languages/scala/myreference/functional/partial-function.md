# Partial Functions

- is a function that's only defined for a subset of input values

- it is different from the definition of pure function

- pure function is defined for all input parameters

- partial function is only defined for a subset

- partial functions are defined by trait PartialFunction[-A, +B] and exnted
  scala.Function1 trait

- PartialFunction defines the apply method and an additional method
  - def isDefinedAt(a: A): Boolean

- easiest way to create a partial function is by defining an anon function with
  pattern matching

- provides two interesting combinatory methods called orElse and andThen

- orElse lets you combine one partial function with another, like if-else
- andThen lets you compose transformation functions with a another

**NOTE:** Be aware of the performance penalty. When composing partial functions,
always remember that the isDefinedAt method of each composing partial function
might get invoked multiple times

- throwing exceptions from a function or a method could be considered a partial
  function. The function that's throwing an exception isnt defined for the case
  that raises the exception

- Instead of throwing an exception, could consider making the function partial
  and combining it with some other function that knows how to handle the
  exception case

- partial functions are powerful when it comes to function composition

```scala
def intToChar: PartialFunction[Int, Char] = {
  case 1 => 'a'
  case 3 => 'c'
}

// tranlated
new PartialFunction[Int, Char] {
  def apply(i: Int) = i match {
    case 1 => 'a'
    case 3 => 'c'
  }

  def isDefinedAt(i: Int): Boolean = i match {
    case 1 => true
    case 3 => true
    case _ => false
  }
}
```
