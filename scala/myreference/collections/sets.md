# Scala Sets

- Sets are collections with no duplicate elements
- No search by index, but fast querying, unordered

- Sets typically are more mathematically powerful than Lists

- There are both mutable and immutable sets in scala.
- By default, scala gives you immutable version. If u want otherwise, u need to
  import mutable set.


```scala
object Sets extends App {

  val s = Set(1,2,3,4)
  val o = Set.apply(1,2,3,4)

  println(o) // order is not preserved

  val set2 = Set(1, 2, 3, 4, 5)
  val set3 = Set(1, 2, 3, 4, 5, 6)
  val set4 = Set(1, 2, 3, 4, 5, 6, 6, 7)

  println(set2 diff set3)                 // Set()
  println(set3 diff set2)                 // Set(6)
  println(set2 union set3)                // Set(1,2,3,4,5, 6)
  println(set2 intersect set3)            // Set(1,2,3,4,5)

  println(set2 ++ set3)                   // Set(1,2,3,4,5,6)
  println(set2 ++ List(9, 10))            // Set(1,2,3,4,5,9,10)

  println(set4 -- set2)                   // Set(6,7)
  println(set4 -- Set(4, 3))              // Set(1,2,5,6,7)
  println(set2 - 3)                       // Set(1,2,4,5)

  println(set2(4))                        // true, test if exits
  println(set2.apply(4))                  // true
  println(set3(20))                       // false

  var jetSet = Set("Boeing", "Airbus",)
  jetSet += "Lear"
}
```
