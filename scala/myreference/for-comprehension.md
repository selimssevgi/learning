# For Comprehension

- Scala's for expression is a Swiss army knife of iteration.

- is syntactic sugar for map, flatMap and filter operations on collections

- The general form is `for (s) yield e`

- `s` is a sequence of generators and filters
- `p <- e` is a generator
- `if f` is a filter
- use `{ s }` instead of `( s )` to use multiple lines without requiring semicolons
- `e` is an element of the resulting collection

- for (arg <- args){ println(arg) }
- arg is implicitly val, not a var.
- its value is changing for each iteration, but a new val is created each time.

* Conditional for loop(Filtering)
* Looping Multiple Variables(Nested Iteration)
* Producing New Collections
* with Pattern Matching
* Under the Hood

 
```scala
for (i <- 1 to 10) { println(i) }

for (file <- files) { println(file) }

for (i <- 0 to 2) { println(array(i)) }

val res = for (i <- 1 to 10) yield (i + 1)
println(res) // Vector(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

val res2 = (1 to 10).map(_ + 1)
println(res) // Vector(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

// two generators
val res3 = for (i <- List(1,2,3);
                j <- List(4,5,6)) yield (i, j)
println(res3) // List((1,4), (1,5), (1,6), (2,4), (2,5), (2,6), (3,4), (3,5), (3,6))

val res4 = List(1,2,3).flatMap(i => List(4,5,6).map(j => (i, j)))
println(res4) // List((1,4), (1,5), (1,6), (2,4), (2,5), (2,6), (3,4), (3,5), (3,6))
```

## Conditional for loop(Filtering)

- In case you dont want to iterate entire collection but some subset
- This can be done by adding a filter: if clause

```scala
for (i <- 1 to 10; if i % 2 == 0) println(i)

for (file <- files if file.getName.endsWith(".scala")) println(file)

// more filters
for (
  file <- files
  if file.isFile
  if file.getName.endsWith(".scala")
) println(file)
```

## Looping Multiple Variables(Nested Iteration)

- <- is called generator
- Multiple <- clauses means nested "loops"
- Use curly braces to leave off semicolons

```scala
for (x <- 1 to 5; y <- 1 to x) println("  " * (x - y) + x.toString * y)

for (
  file <- files
  if file.getName.endsWith(".scala");
  line <- fileLines(file)
  if line.trim.matches(pattern)
) println(file + ": " + line.trim)

// binding result to a val
// Use curly braces to leave off semicolons
for {
  file <- files
  if file.getName.endsWith(".scala")
  line <- fileLines(file)
  trimmed = line.trim
  if trimmed.matches(pattern)
} println(file + ": " + trimmed)
```

## Producing New Collections

- Above examples are imperative forms of for, specifying what it should do and
  doesnt return anything

- The form is called functional form, also called sequence comprehension
- In functional form, you tend to work with values rather than execute
  statements, and it does return a value

- Each time the body of the for expression executes it produces one value
- When for expression completes, the result will includes all of the yielded values.
- The type of the resulting collection is based on the kind of collections processed.
- for clauses yield body
- for (clauses) yield { body }

```scala
def scalaFiles =
  for {
    file <- files
    if file.getName.endsWith(".scala")
  } yield file

// Array[File] -> Array[Int]
val lineLengths =
 for {
  file <- files
  if file.getName.endsWith(".scala")
  line <- fileLines(file)
  trimmed = line.trim
  if trimmed.matches(".*for.*")
 } yield trimmed.length
```

## with Pattern Matching

- generator part of for-comprehensions uses pattern matching

```scala
val people = List(
  Person("fname", "lname"),
  Person("fname", "lname"),
  Person("fname", "lname"),
)

for (Person(first, last) <- people) yield first + " " + last
```

## Under the Hood

- For comprehension are just map, flatMap, withFilter, and foreach behind the scene
- They look like for loops, but are not, for one they can be assigned to a value
- They return collections like Lists, Sets...
- Any object with map, flatMap, withFilter, foreach can be used inside a for comprehensions

- filter vs withFilter
- strict vs non-strict
- Scala 2.8 onwards for-comps are non-strict

```scala
case class Artist(name: String, genre: String)

val artists = List(
  Artist("Pink Floyd", "Rock"),
  Artist("Led Zeppelin", "Rock"),
  Artist("Michael Jackson", "Pop"),
)

for (Artist(name, genre) <- artists; if (genre == "Rock")) yield name

// translated
artists withFilter {
  case Artist(name, genre)  => genre == "Rock"
} map { // yield
  case Artist(name, genre)  => name
}

for (Artist(name, genre) <- artist) println(name)

// imperative version translated in to foreach
artists withFilter {
  case Artist(name, genre)  => true; case _ => false;
} foreach {
  case Artist(name, genre)  => println(name)
}
```

```scala
case class Artist(name: String, genre: String)
case class ArtistWithAlbums(artist: Artist, albums: List[String])

for {
  ArtistsWithAlbums(artist, albums) <- artistsWithAlbums
  album <- albums
  if (artist.genre == "Rock")
} yield name

// translated to
artistsWithAlbums flatMap {
  case ArtistWithAlbums(artist, albums)  => 
    albums withFilter {
      album => artist.genre == "Rock"
    } map { case album => album }
}
```

### Translation Rules

A for-expression looks like a traditional for loop but works differently internally

`for (x <- e1) yield e2` is translated to `e1.map(x => e2)`

`for (x <- e1 if f) yield e2` is translated to `for (x <- e1.filter(x => f)) yield e2`

`for (x <- e1; y <- e2) yield e3` is translated to `e1.flatMap(x => for (y <- e2) yield e3)`

This means you can use a for-comprehension for your own type, as long
as you define `map`, `flatMap` and `filter`.

### Example 2

```scala
    for {
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)

// is equivalent to
    for (i <- 1 until n; j <- 1 until i if isPrime(i + j))
        yield (i, j)
```

// is equivalent to
    (1 until n).flatMap(i => (1 until i).filter(j => isPrime(i + j)).map(j => (i, j)))
```

