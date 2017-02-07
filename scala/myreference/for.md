# Scala for Loop

- for (arg <- args){ println(arg) }
- arg is implicitly val, not a var.
- its value is changing for each iteration, but a new val is created each time.


```scala
for (i <- 0 to 10) println(i)

for (i <- 0 to 2) { println(array(i)) }
```


```scala
val xs = List(1,2,3,4)
var result = List[Int]() // (2,3,4,5) : no var!!
for (a <- xs) {
  result = result :+ (a+1)
}

println(result)
```

```scala
// functional for loops
val xs = List(1,2,3,4)
val result = for (a <- xs) yield (a+1)
println(result)
```

## Conditional for loop

```scala
for (i <- 1 to 10; if i % 2 == 0) println(i)
```

## Looping Multiple Variables

```scala
for (x <- 1 to 5; y <- 1 to x) println("  " * (x - y) + x.toString * y)
```
