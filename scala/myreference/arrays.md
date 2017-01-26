# Scala Arrays

- Array is a genunie generic type
- Array access uses round brackets
- parameterize array
- array itself is mutable, so we can its value


```scala
def main(args : Array[String]) {
  println(args(0))

  // array(1)       // access second element in the array
  // array.apply(1) // is being transformed to this

  val greetString = new Array[String](2)
  val greetString: Array[String] = new Array[String](2)
  greetString(0) = "Hello"
  greetString(1) = " World! "
  greetString.update(0, "Hello") // transformed version of above
}
```
- A better way to create and initialize array in scala

```scala
val numNames = Array("zero", "one", "two") // it will be infered as array of strings
// val numNames = Array.apply("zero", "one", "two")
```
