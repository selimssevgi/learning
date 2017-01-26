# Scala Maps

- The structure is same as sets.
- Mutable and immutable. Default version is immutable.
- Provides HashMap as the standard mutable form


```scala
var x = Map(1 -> "hi", 2 -> "There")

for ((k, v) <- x) println(k + ": " v)

x = x + (3 -> "bye")

val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "IV")
println(romanNumeral(3))

val hm = HashMap(1 -> "hi", 2 -> "There")
hm += (3 -> "bye")
println(hm)
```

*NOTE:* + is defined differently for mutable and immutable maps.
