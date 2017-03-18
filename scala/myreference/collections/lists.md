# List

- Scala lists are immutable, duplicates are allowed
- Operations dont change the values or list, but creates and returns a new list
- 'Nil' is an empty list
- Lists have many of the same functional properties as other collections

- Lists have a recursive structure(linked list), whereas arrays are flat.
- List type in Scala is covariant. List[Object] is subtype of List[String]

## Empty Lists

- Empty list has type List[Nothing].
- Nil represents the empty list.

```scala
val xs: List[String] = List()
```

## Constructing Lists

- All lists are built from two fundamental building blocks: Nil and ::
- x :: xs
- val c = 1 :: 2 :: 3 :: Nil

```scala
object Lists extends App {
  val a = List(1, 2, 3) // List.apply(1, 2, 3), companion object
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

## Cons operator (::)

- Prepends a new element to the beginning of an existing list.
- It is a right associative operator.
- List doesnt offer an append operation. Cus it takes more time to add an element
  to the end, prepending an element is contant time. Either call reverse on a list
  or use ListBuffer, which is mutable list.

*NOTE:* If the method name ends with in a colon, the method is invoked on the
right operand.

```scala
val fourFive    = List(4, 5)
val onefourFive = 1 :: fourFive // a new List(1, 4, 5)
// fourFive.::(1)

val oneTwoThree = 1 :: 2 :: 3 :: Nil
```

## Concatenation Operator (:::)

```scala
val oneTwo = List(1, 2)
val sixTen = List(6, 10)
val all    = oneTwo ::: sixTen // a new List(1, 2, 6, 10)
```
