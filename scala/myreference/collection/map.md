# Scala Maps

- Internally, maps are a collection of tuples, and can be operated on as such
- Symbols, are like Strings, but guaranteed to be interned, perfect for maps
- Mutable and immutable. Default version is immutable.
- by default it gives a hash map, you can also get a tree map

## Immutable Map

- Default map, no import necessary
- cus of immutability, sharing structure, not as inefficient as it seems

```scala
val m1 = Map.apply((1, "One"), (2, "Two"), (3, "Three"))

val m2 = Map((1, "One"), (2, "Two"), (3, "Three"))

val m  = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

m(1)                       // "1st"
m(5)                       // NoSuchElementException
m.get(5)                   // return Option
m.getOrElse(5, "Five")

// cannot update an immutable map
val newM = m + (3 -> "3rd", "4" -> "4rh")  // new values added
val corM = newM + ("4" -> "4th")           // updated a value
val delM = corM - 4                        // remove a pair by key

// iteration
for ((k, v) <- m) println(k ": ", v)  // pattern matching on tuples
for ((k, v) <- m) yield (v, k)        // reverse: same values overwrite eachother

m.keys
m.keySet
m.values
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

val scores = collection.mutable.Map("Alice" -> 30, "Bob" -> 10, "Cindy" -> 50)
scores("Bob") = 10  // updates
scores("Cin") = 25  // add a new pair
scores -= "Alice"   // remove a key and its value
scores -= "Alice"   // doesnt nothing, no error
```

- using symbols

```scala
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

```

*NOTE:* + is defined differently for mutable and immutable maps.

## TreeMap - SortedMap

- if you need to visit the keys in sorted order
- you may want to have a tree map if you don't have a good hash func for the keys

```scala
val score = scala.collection.immutable.SortedMap("Alice" -> 10, "Fred" -> 7, "Cindy" -> 8)
```

- if you want to visit keys in insertion order, use LinkedHashMap

```scala
val score = scala.collection.mutable.LinkedHashMap("Jan" -> 1, "Feb" -> 2)
```
