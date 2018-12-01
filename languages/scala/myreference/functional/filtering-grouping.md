# Filtering and Grouping


```scala
val pascal = Seq(1, 6, 15, 20, 15, 6, 1)

pascal map (n => n * 2)
pascal map (_ * 2)
pascal map (2 *)
pascal map 2.*

pascal reduce (_ + _)
pascal.sum
pascal.product

def isEven = (x: Int) => x % 2 == 0

pascal exists isEven     // any even exist in coll?
pascal forall isEven     // all are even?
pascal count isEven      // how many of them are even?
pascal find isEven       // find a even: Option: Some(6)

val even = pascal filter isEven
val odd  = pascal filterNot isEven

val (even, odd) = pascal partition isEven

// what if partitioning is more than two groups?
pascal groupBy (5.<) mkString (",") // false -> List(1,1), true -> List(6, 15, 20, 15, 6)
pascal groupBy (_ % 3) mkString (",") // 2 -> List(20), 1 -> List(1,1), 0 -> (6, 15, 15, 6)

pascal takeWhile (_ < 20)  // List(1, 6, 15)
pascal dropWhile (_ < 20)  // List(20, 15, 6, 1)

pascal span (_ < 20)  // (takeWhile, dropWhile)

pascal prefixLength (_ < 20) // takeWhile.length
pascal contains 15

pascal indexOf 15     // 2
pascal lastIndexOf 15 // 4

pascal indexWhere isEven // 1
pascal lastIndexWhere isEven

pascal startsWith Seq(1, 5)
pascal endsWith Seq(6, 1)

pascal containsSlice Seq(1, 6)
pascal indexOfSlice Seq(1, 6)

pascal.max
pascal.min

people maxBy (_.age)

pascal.sorted
people sortedBy (_.age)
pascal sortedWith (_ > _)

pascal.reverse
pascal.reverseMap (2.*)

pascal grouped(3) toList
pascal sliding(3)         // List(List(1, 6, 15), List(6,15, 20), List(15, 20, 15)...)

// find the first three consecutive elements whose sum is greater than 40?
pascal sliding(3) find (_.sum > 40)

pascal intersect Seq(1,5, 20)
pascal diff Seq(1,5,19,20)

Set(5, 2) subsetOf Set(1,2,4,5,6)
Set1,2,3).subsets.toList mkString ("\n")
Set(1,2,3).subsets(2)

pascal.combinations(2).toList
pascal.permutations.toList mkString ("\n")

pascal.distinct

val a = Seq(1, 2, 3)
val b = Seq(4, 7, 5)
(a corresponds b)(_ < _)
```

## One Liners

```scala
val pangram = "The quick brown fox jumps over the lazy dog"

// contain all letters?
('a' to 'z') forall (pangram.contains(_))

pangram.distinct.sorted

// how many times each letter appear?
pangram groupBy (_.toLower)

// frequency
pangram groupBy (_.toLower) mapValues (_.size)

// remove whitespace
val m = pangram filter(_.isLetter) groupBy (_.toLower) mapValues (_.size)

// sorting by freq
m.toSeq sortBy (_._2)

// most frequent first
m.toSeq sortWith (_._2 > _._2)

// only the letter more than once
m.filter(_._2 > 1).toSeq sortWith (_._2 > _._2) mkString("\n")

// all worlds with letter o
pangram.split(" ") filter(_.contains('o'))
(pangram split " ") filter (_ contains 'o')

// ploTing a horizontal chart
pascal map ("*" * _) mkString ("\n")
```
