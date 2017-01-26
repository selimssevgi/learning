# List

- Scala list are immutable
- Operations dont change the values or list, but creates and returns a new list


```scala
val oneTwoThree = List(1, 2, 3)  // immutable reference: val

// ::: list concationation operator
val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val OneTwoThreeFour = oneTwo ::: threeFour

// :: cons operator. prepends a new element to the beginning of an existing list
val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree

// Another way to create a list
// :: is right associative. right side has to be a list
val oneTwoThree = 1 :: 2 :: 3 :: Nil

// emtpy list
val emptyList = Nil
val emptyList = List()

// If a operator ends with colon, it is called on its right operand.
thoTree.::(1)
```






- List doesnt offer an append operation. Cus it takes more time to add an element
  to the end, prepending an element is contant time. Either call reverse on a list
  or use ListBuffer, which is mutable list.
