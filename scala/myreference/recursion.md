# Recursion in Scala

- Result type must be specified for recursion methods
- Recursive methods have a limited stack space


```scala
def fact(base : Int) : Int = {
  if (base <= 0)
    return 1
  else
    return base * fact(base - 1)
}

println(fact(100)) // overflows

// Int can be simply replaced with BigInt
def fact(base: BigInt): BigInt = {
  if (base <= 0) 1
  else base * fact(base - 1)
}
```

## Tail Optimized Recursivon

- Recursive methods may run out of stack memory
- Tails recursive methods after evaluation must be returned
- @scala.annotation.tailrec can be used for assistance

```scala
@tailrec
def fact(base: BigInt, acc: BigInt): BigInt = {
  if (base <= 0) 1
  else fac(base - 1, base * acc)
}

println(fact(10, 1))
println(fact(1000, 1))
println(fact(100000, 1))

def factorial(n:Int) = fact(n, 1)

println(factorial(10))
println(factorial(1000))
println(factorial(100000))
```
