# Scala String

```scala
// java static string method
val str = String.format("This is a %s", "test")
println(str)

val str2 = "This is a %s".format("test")
println(str2)
```

## Raw Strings


```scala
val escapes = "\\\"\'" // \'"
```

Because this syntax is awkward for strings that contain a lot of espace
sequences or strings that span multiple lines, Scala includes a special syntax
for raw strings.

- You start and end a raw string with three double quotation marks(""")

```scala
println("""Welcome to Ultamix 3000.
           Type "HELP" for help.""")
```

*PROBLEM:* Spaces are added for readability but it also shows up in output.

```scala
println("""|Welcome to Ultamix 3000.
           |Type "HELP" for help.""".stripMargin)
```


## String Interpolation

- Performs variable replacement
- Requires an s before a String
- Braces may be required for evalution
- Use f interpolator to use C/Java-style formatting: printf
- Works great with Scala Smart Strings

```scala
val total = 50
println(s"Total is ${total}")
println(s"Total plus 3 is ${total + 3}")

// no need curly if just one variable
println(s"Total is $total")

val pi = 3.14f
println(f"Pi is $pi%1.2f")

val cost = 50
println(f"The cost is $$$cost%1.2f")

val percent = 20
pritnln(f"percent is %n on a new line $percent%%")
```

## Smart Strings

- Scala String object is nothing but a representative of a java.lang.String
- Where did we get this new stripMargin method?
- scala.collection.immutable.StringLike
- Treating string as an immutable collection
- RichInt, RichBoolean, so on.

```scala
val multilineString = "line number 1, \n" +
                      "line number 2, \n" +
                      "line number 3, \n"
println(multilineString)

val smartMulti = """line number 1,
                   |line number 2,
                   |line number 3,""".stripMargin('|')
```
