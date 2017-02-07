# Tuples

- Tuples are dummy containers
- Tuples are types
- Tuples go all the way up to Tupp22
- Tuple2 has a swap method
- Tuples are immutable

```scala
object Tuples extends App {
    val t = (1, "Tuple", 40.0)
    val t2:(Int, String, Double) = (1, "Tuple", 40.0)
    val t3:Tuple3[Int, String, Double] = (3, "Tuple", 22.0)

    println(t._1)
    println(t._2)
    println(t._3)
}

```
