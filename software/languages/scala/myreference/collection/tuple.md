# Tuples

- Like lists, tuples are also immutable.
- Difference from the List is that they can contain different types of elements.
- Accessing tuples is different than Lists, cus list apply method returns the same
  type. But tuples has to return different types for different elements in it.

- Tuples are 1 based cus of a tradition set by other languages. Haskell and ML.

- They are useful when u want to return multiple object from a method
- Tuples are dummy containers
- Tuples are types
- Tuples go all the way up to Tuple22
- Tuple2 has a swap method

```scala
  val t1                              = (1, "Tuple", 40.0)
  val t2: (Int, String, Double)       = (1, "Tuple", 40.0)
  val t3: Tuple3[Int, String, Double] = (3, "Tuple", 22.0)

  println(t._1) // t _1
  println(t._2)
  println(t._3)

  val pair = (99, "Balls")
  println(pair._1)
  println(pair._2)
```

## Tuples with Pattern Matching

- to get components of a tuple

```scala
val t = (1, 2.0, "String")
val (first, second, third) = t

val (fst, snd, _) = t // not interested in the third value
```

## Zipping

- to bundle together values so that they can processed together
- commonly done with zip method

```scala
val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts) // Array((<,2), (-,10), (>,2))

for ((s, n) <- pairs) print(s * n)

// keys.zip(values).toMap
symbols.zip(counts).toMap // Map(< -> 2, - -> 10, > -> 2)

```
