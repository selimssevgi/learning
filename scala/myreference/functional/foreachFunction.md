# foreach Function

- 'foreach' is a method that takes a function that takes each element and return Unit
- Perfect if you want to take an element and perform a side effect, like print

```scala
object ForEach extends App {

  val a = 1 to 3
  println(a.map(x => println(x)))
  a.map(x => println(x))
  // def map[B](f: (A) -> B): List[B]
  // def foreach(f: (A) -> Unit): Unit

  a.foreach(x => println(x))
  a.foreach(println(_))
  a.foreach(println _) // one argument, no need of parenthesis
  a foreach (println _)
  a foreach (println)  // remove if _ is only argument
  a foreach println
}
```
