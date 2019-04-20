# Iterators


```scala
case class TempData(day: Int, year: Int, precip: Double,
                    aveTemp: Int, maxTemp: Int, MinTemp: Int)

def parseLine(line: String): TempData = {
  val p = line.split(",").map(_.trim)
  TempData(p(1).toInt, p(4).toInt, p(5).toDouble, p(6).toInt, p(7).toInt,
  p(8).toInt)
}

val pwd = new java.io.File(".").getAbsolutePath()
val source = io.Source.fromFile("abc.txt") // Iterator[Char]
val lines = source.getLines // Iterator[String]

// skip lines
lines.next
lines.next

val data = lines.map(parseLine).toArray

val maxTemp = data.map(_.maxTemp).max

source.close
```
