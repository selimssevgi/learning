# Scala Arrays

- Arrays in Scala are converted to a primitive array on the JVM
- Behavior wise Scala arrays are similar to Lists
- Array is a genunie generic type
- Array itself is mutable, so we can its value


```scala

object Arrays extends App {

  val a:Array[Int] = Array(1,2,3,4)   // int[]
  val numNames = Array("zero", "one") // it will be infered as array of strings
  val greetString = new Array[String](2)
  val greetString: Array[String] = new Array[String](2)

  // can be treated as a list
  println(a.head)      // 1
  println(a.tail)      // [2,3,4]
  println(a.init)      // [1,2,3]
  println(a.last)      // 4
  println(a.apply(2))  // 3
  println(a(2))        // 3
  println(a.max)       // 4
  println(a.isEmpty)   // false

  greetString(0) = "Hello"
  greetString(1) = " World! "
  greetString.update(0, "Hello") // transformed version of above
}
```
- A better way to create and initialize array in scala

```scala
```
