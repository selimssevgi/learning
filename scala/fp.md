# Functional Programming in Scala

- Scala supports functions as first-class values
- Functions can be put into vars or vals
- => 
- In Scala, functions are just values
- Functions can return functions


```scala
val doubler = (x : Int) => { x * 2 }

val adder = (n : Int) => { (x : Int) => x + n }
val plus2 = adder(2)
println(plus2(3)) // 5
```
