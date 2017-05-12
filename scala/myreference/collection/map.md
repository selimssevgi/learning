# Scala Maps

- Maps are a table-like collection that stores keys and values
- Internally, maps are a collection of tuples, and can be operated on as such
- Symbols, are like Strings, but guaranteed to be interned, perfect for maps
- The structure is same as sets.
- Mutable and immutable. Default version is immutable.
- Provides HashMap as the standard mutable form

## Immutable Map

- Default map, no import necessary

```scala
val romanNumeral = Map(1-> "I", 5 -> "V", 10 -> "X")
```

## Mutable Map

```scala
// explicit type parameteration([Int, String]) is required
// compiler doesnt have values to infer the type

val tasks = scala.collection.mutable.Map[Int, String]()
tasks += (1 -> "Go home")   // 1.->("Go home")
tasks += (2 -> "Come back")
tasks += (3 -> "What are you doing?")
print(tasks(1)) // "Go home"
```

```scala
object Maps extends App {

  // with tuples
  val m  = Map.apply((1, "One"), (2, "Two"), (3, "Three"))
  val m2 = Map((1, "One"), (2, "Two"), (3, "Three"))

  val t:(Int, String) = 3 -> "Three"   // (3, Three)
  println(t)

  // a better way
  val m3 = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

  println(m3.get(1))     // Some(one)
  println(m3.apply(1))   // One
  println(m3(1))         // One
  println(m3.get(4))     // None
  // println(m3(4)) // Exception

  println(m3.toList) // List((1,One), (2,Two), (3,Three))
  println(m3.keys)   // Set
  println(m3.keySet) // Set
  println(m3.values.toList)

  val s  = new String("Key")
  val s2 = "Key"   // interned. SCP
  println(s == s2) // true
  println(s eq s2) // false

  val symbol  = Symbol("Key")
  val symbol2 = 'Key
  println(symbol == symbol2) // true
  println(symbol eq symbol2) // true

  val elements:Map[Symbol, String] = Map('TR -> "Turkish", 'EN -> "Englisj")
  println(elements.get('TR)) // Some(Turkish)

  for ((k, v) <- x) println(k + ": " v)
  val hm = HashMap(1 -> "hi", 2 -> "There")
  hm += (3 -> "bye")
  println(hm)
}
```

*NOTE:* + is defined differently for mutable and immutable maps.
