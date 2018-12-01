# Polymorphic Function

- it is also known as parametric polymorphism

- monomorphic functions operate on only one type of data

- following abs functions is specific to arguments of type Int

```scala
def abs(x: Int): Int = {
  if (x < 0) -x
  else x
}
```

- while writing HOFs, we should write code that works for any type

- HOFs work for any types called polymorphic functions

- polymorphic functions sometimes called generic functions

- abstracting over the types

```scala
// monomorphic
def findFirst(e: String, arr: Array[String]): Int = {
  @annotation.tailrec
  def loop(index: Int): Int = {
    if (index >= arr.length) -1
    else if (arr(index) == e) index
    else loop(index + 1)
  }
  loop(0, e, arr)
}

// polymorphic
def findFirst[A](arr: Arr[A], p: A => Boolean): Int = {
  @annotation.tailrec
  def loop(index: Int): Int = {
    if (index >= arr.length) -1
    else if (p(arr(index))) index
    else loop(index + 1)
  }
  loop(0)
}
```
