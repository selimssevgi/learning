# Scala While

- while/do-while statements exist like other languages
- while/do-while are underused
- There usually is a functional equivalent to using while/do-while


```scala
// imperiative style
var a = 100
var result = ""
while (a > 0) {
  result = result + a
  if (a > 1) result = result + ","
  a = a - 1
}

println(result)
```


```scala
// functional style
val result  = (1 to 100).reverse.mkString(",")
println(result)


val result2 = (100 to 0 by -1).mkString(",")
```
