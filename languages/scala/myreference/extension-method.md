# Extension methods (2.10)

- value classes and implicit classes can be combines to produce allocation-free extension methods

- equivalent to using an object with static helper methods

- a simple mechanical transformation performed by the compiler


```scala
// earlier
implicit class IntOps(n: Int) {
   def stars = "*" * n
}

5.starts

// equivalent to
new IntOps(5).stars

// object creation!?
```

```scala
// with extension methods
implicit class IntOps(val n: Int) extends AnyVal {
   def stars = "*" * n
}

5.starts

// equivalent to
object IntOps {
   def stars(n: Int) = "*" * n
}

IntOps.stars(5)
```
