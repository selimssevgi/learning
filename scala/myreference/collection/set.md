# Scala Sets

- iterable collection type that contains no duplicate elements
- No search by index, but fast querying, unordered

- Sets typically are more mathematically powerful than Lists

```shell
- scala.collection
  - Set <<trait>>
    - scala.collection.immutable.Set <<trait>>
      - scala.collection.immutable.HashSet
    - scala.collection.mutable.Set <<trait>>
      - scala.collection.immutable.HashSet
```

```scala
val s = Set(1,2,3,4)  // set.apply(1,2,3,4)

println(o) // order is not preserved

val set2 = Set(1, 2, 3, 4, 5)
val set3 = Set(1, 2, 3, 4, 5, 6)
val set4 = Set(1, 2, 3, 4, 5, 6, 6, 7)

set2 diff set3                 // Set()
set3 diff set2                 // Set(6)
set2 union set3                // Set(1,2,3,4,5, 6)
set2 intersect set3            // Set(1,2,3,4,5)

set2 ++ set3                   // Set(1,2,3,4,5,6)
set2 ++ List(9, 10)            // Set(1,2,3,4,5,9,10)

set4 -- set2                   // Set(6,7)
set4 -- Set(4, 3)              // Set(1,2,5,6,7)
set2 - 3                       // Set(1,2,4,5)

set2(4)                        // true, test if exits
set2.apply(4)                  // true
set2.contains(4)               // true
set3(20)                       // false

val frameworks = Set() + "Akka" + "Lift"
val updated = frameworks - "Akka"

// mutable set: += or -=
var jetSet = Set("Boeing", "Airbus",)   // it is var
jetSet += "Lear"                        // shorthand: jetSet = jetSet + "Lear"
```

- One interesting subtrait of Set is SortedSet

```scala
Set(1, 2) ++ Set(3, 4, 5)               // Set(5, 1, 2, 3, 4)

import scala.collection.immutable.SortedSet
SortedSet(1, 2) ++ SortedSet(3, 4, 5)               // TreeSet(1, 2, 3, 4, 5)
```
