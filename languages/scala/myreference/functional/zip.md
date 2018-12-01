# zip Function

- Scala defines a 'zip' method that convert two collections into a single collection of pairs.
- Zip result will be the size of the shorter collection

## Examples

```scala
val a = List(1,2,3)
val b = List(4,5,6)
println(a zip b) // List((1,4), (2,5), (3,6))

println((1 to 5) zip (6 to 9)) // Vector((1,6), (2,7), (3,8), (4,9))
println((1 to 2) zip (6 to 9)) // Vector((1,6), (2,7))
```

```scala
val languages = Iterable("Scala", "Java")
val versions = Iterable(2.12, 9)

languages.iterator zip versions.iterator map {
  case (language, version) => language + " : " + version
} foreach println
```

```scala
// check if list is ascending order
val L = List(1 to 10:_*)
L zip L.tail forall { p => p._1 <= p._2 }
```

```scala
// zipwithindex
"selim" zip List(0 to 5:_*)
"selim".zipWithIndex
```


```scala
// find all position of a char
for {
  (c, i) <- "scala".zipWithIndex
  if c == 'a'
} yield i
```
