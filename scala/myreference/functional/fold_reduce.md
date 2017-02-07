# Fold and Reduce

- 'foldLeft' and 'foldRight' will perform a reduction operation with a seed value
- reduceLeft and reduceRight will perform a reduction operation without a seed
- 

```scala
object FoldAndReduce extends App {

  val foldLeftResult = (1 to 10)
    .foldLeft(0)((total:Int, next:Int) => total + next)
  println(foldLeftResult)

  val foldLeftResult1 = (1 to 10)
    .foldLeft(0){(total:Int, next:Int) =>
      println(s"Total: $total, Next: $next")
      total + next}
  println(foldLeftResult1)

  val foldRightResult = (1 to 10)
    .foldRight(0){(next:Int, total:Int) =>
      println(s"Total: $total, Next: $next")
      total + next}
  println(foldLeftResult1)

  println((1 to 10).sum)
  println((1 to 10).product)
  println((1 to 10).mkString(","))
}
```
