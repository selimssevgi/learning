# Scala String


```scala
// java static string method
val str = String.format("This is a %s", "test")
println(str)

val str2 = "This is a %s".format("test")
println(str2)
```


## String Interpolation

- Performs variable replacement
- Requires an s before a String
- Braces may be required for evalution
- Use f interpolator to use C/Java-style formatting
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
