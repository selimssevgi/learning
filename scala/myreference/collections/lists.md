# List

- Scala lists are immutable, duplicates allowed
- Operations dont change the values or list, but creates and returns a new list
- 'Nil' is an empty list
- Lists have many of the same functional properties as other collections


```scala
object Lists extends App {

  val a = List(1, 2, 3)
  val b = List.apply(1, 2, 3) // companion object
  val c = 1 :: 2 :: 3 :: Nil

  // emtpy list
  val emptyList = Nil
  val emptyList = List()

  print(a.head) // 1
  print(a.tail) // 2, 3
  print(a.last) // 3
  print(a.init) // 1, 2

  println(a(2));
  println(a.apply(2)) // class object
  println(a.min)
  println(a.max)
  println(a.isEmpty)
  println(a.nonEmpty)

  println(a.mkString(","))
  println(a.mkString("[", ",", "]"))
}
```

- List doesnt offer an append operation. Cus it takes more time to add an element
  to the end, prepending an element is contant time. Either call reverse on a list
  or use ListBuffer, which is mutable list.
