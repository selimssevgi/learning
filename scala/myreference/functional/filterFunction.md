# Filter Function

- Filters out elements that meet a predicates criteria
- 'exists' tests if something exists in collection based on a function


```scala
object Filters extends App {

  val a = 1 to 10
  println(a.filter(x => x % 2 == 0))
  println(a.filterNot(x => x % 2 == 0))
  println(a.exists(_ % 2 == 0))

  def filterVowels(s:String) =
    s.toLowerCase.filter(c => Set('a', 'e', 'i', 'o', 'u').contains(c))

  println(filterVowels("selim")) // ei

  val colors = Set("Red", "Orange", "Blue", "Green")
  println(colors.filter(s => filterVowels(s).size > 1))
  // Set(Orange, Blue, Green)

  val m = Map(1 -> "One", 2 -> "Two", 3 -> "Three", 4 -> "Four")
  println(m.filterKeys(_ % 2 == 0)) // Map(2 -> Two, 4 -> Four)
}
```
