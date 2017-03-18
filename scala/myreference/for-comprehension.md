# Scala for Loop(for expressions)

- Scala's for expression is a Swiss army knife of iteration.


- for (arg <- args){ println(arg) }
- arg is implicitly val, not a var.
- its value is changing for each iteration, but a new val is created each time.


```scala
for (file <- files)
  println(file)

for (i <- 0 to 10)
  println(i)

for (i <- 0 to 2) {
  println(array(i))
}
```


```scala
val xs = List(1,2,3,4)
var result = List[Int]() // (2,3,4,5) : no var!!
for (a <- xs) {
  result = result :+ (a+1)
}

println(result)
```

```scala
// functional for loops
val xs = List(1,2,3,4)
val result = for (a <- xs) yield (a+1)
println(result)
```

## Conditional for loop(Filtering)

- In case you dont want to iterate entire collection but some subset.
- This can be done by adding in for expression by adding a filter: if clause

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

- <- is called generator.
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
