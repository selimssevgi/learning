# Scala Arrays

- A Scala array is mutable sequence of objects that all share the same type.
- Array itself is mutable, so we can change its values
- Arrays in Scala are converted to a primitive array on the JVM
- Behavior wise Scala arrays are similar to Lists
- Array is a genunie generic type
- Arrays are accessed with parentheses in Scala, not arr[0] like in Java.
- arr(0), Scala turns this into method invocation. arr.apply(0)

## Array Creation

```scala
// more concise way
val numNames = Array("One", "Two", "Three")
val numOther = Array.apply("Four", "Five")  // factory method in companion object

// more like java
val explicitArray: Array[String] = new Array[String](3)
val strings = new Array[String](3)
```

## Accessing Elements

```scala
strings(0) = "Hello"     // transformed to: strings.update(0, "Hello")
strings(1) = ", "        // transformed to: strings.update(1, ", ")
strings(2) = "World!\n"  // transformed to: strings.update(2, "World!\n")
```

## Iterating Arrays

```scala

for (i <- 0 to 2) {
  print(strings(i)) // transformed to: strings.apply(i)
}

for (str <- strings) { print(str) }

strings.foreach(str => print(str))
strings.foreach(print)

```

## Arrays as List

```scala
// can be treated as a list
println(a.head)      // 1
println(a.tail)      // [2,3,4]
println(a.init)      // [1,2,3]
println(a.last)      // 4
println(a.apply(2))  // 3
println(a(2))        // 3
println(a.max)       // 4
println(a.isEmpty)   // false
```
