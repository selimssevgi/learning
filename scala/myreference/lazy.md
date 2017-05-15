# lazy

- to declare a type whose value gets calculated based on some time-consuming
  operation

- u may not want to initialize when declaring the variable

- In such cases the keyword 'lazy' can be helpful

- By default Scala evaluates the value assigned to var or val when it's declared

- lazy keyword is only allowed with val

```scala
val a = 1              // a: Int = 1
lazy val b = 1         // b: Int = <lazy> # inteferring type without evaluating

var c = 1
lazy val d = c + 2

c = 5
println(b)             // 5 + 2 = 7, uses the latest value of c
```
