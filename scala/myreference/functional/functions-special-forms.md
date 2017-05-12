# Special Function Forms

## Repeated Parameters

- Java's varargs
- Use * instead of ...

```scala
def echo(args: String*) = args.foreach(println)

val names = Array("Selim", "Ahmet")
echo(names) // ERROR: f: Array[String] r: String

// to solve above problem
echo(names: _*)
```

## Named Arguments

```scala
def speed(distance: Float, time: Float) = distance / time
speed(100, 10)
speed(distance = 100, time = 10)
speed(time = 10, distance = 100)
```

## Default Parameter Values

```scala
def printTime(out: java.io.PrintStream = Console.out) =
  out.println("time = " + System.currentTimeMillis())

printTime()
printTime(Console.err)

def greet(start: String, name: String = "World!") {
  println(start + ", " + name)
}

greet(start = "hello")
greet(start = "Hi", name = "Scala")
```
