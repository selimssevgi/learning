# Try-Catch

- Catch block is different than Java's
- All exceptions in Scala are RuntimeException
- No checked exception

```scala
try {
  new Employee("", "lastName")
} catch {
  case iae: IllegalArgumentException => println(iae.getMessage)
}

try {
  val f = new FileReader("input.txt")
} catch {
  case ex: FileNotFoundException => // handle missing file
  case ex: IOException           => // handle IO error
} finally {
  f.close()
}
```

- throw is an expression that has a result type.
- An exception throw has type Nothing.

```scala
val half =
  if (n % 2 == 0)
    n / 2
  else
    throw new RuntimeException("n must be even")
```

## Yielding a value

- As with most other Scala control structures, try-catch-finally results in a value.
- Do not override or change things set in try or catch blocks.
- Best to not return values from finally block, use it just for side-effects.

```scala
def urlFor(path: String) = {
  try {
    new URL(path)
  } catch {
    case ex: MalformedURLException => new URL("http://google.com")
  }
}
```
