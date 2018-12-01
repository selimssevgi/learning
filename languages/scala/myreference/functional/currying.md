# Scala Currying

- is a technique for transforming a function that takes multiple parameters into
  a function that takes a single parameter

- allows to turn generalized functions into specialized ones

- It is similar how DI works in OOP

- Can also turn existing methods to curried functions using an underscore

- A curried function is applied to multiple arguments lists, instead of just one

```scala
def plainOldSum(x: Int, y: Int) = x + y

def curriedSum(x: Int)(y: Int) = x + y

def first(x: Int) = (y: Int) => x + y

val second = first(1)

val res = second(2) // 1 + 2

val onePlus = curriedSum(1)_
onePlus(2) // 1 + 2
```

- when you invoke curriedSum, you actually invoke get two traditional function invocations back to back

