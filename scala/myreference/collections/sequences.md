# Sequences

- Array, List, Vector, Buffer, and Range

## Array

```scala
val a = Array(1,2,3,4)

val b: Array[String] = Array("selim", "scala")

b(0)  // [] are used for generics
b(0) = 99

val c = Array.fill(100)(0) // Array[Int], size: 100, initialize all with 0
val d = Array.fill(10)(math.random) // using call-by-name so each value is diff

val e - Array.tabulate(10)(i => i*i)
```

## List


```scala
val l = List(1,2,3,4)   // List[Int]
val i = List(1.0,2, 3)  // List[Double]
val s = List(1, "hi")   // List[Any]
val t = List(true, 1)   // List[AnyVal], common parent
```

## Vector

- scala.collection.immutable.Vector
- tree, mutating adds new node

```scala
val v = Vector(1,2,3)
```

## Buffer

- scala.collection.mutable.Buffer

## Range

- 1 to 10
- 1 to 10 by 2
- 10 to 1 by -1
