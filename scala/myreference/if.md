# Scala IF

- if is not a statements as in Java, in scala it is an expression
- returns a value, like ternary operator. ( condition ) ? "true" : "false"
- If statements can be used in a functional fashion and assigned to a val or var


```shell
scala> val res = if (5 < 9) 4
res: AnyVal = 4

scala> val res = if (5 > 9) 4 // scalac adds "else ()"
res: AnyVal = ()

# common parent of Int and Unit is AnyVal

scala> val res = if (5 > 9) "hi"
res: Any = hi

# common parent of String and Unit is Any

```

```scala
// normal if statement with mutable variable
var filename = "default.txt"
if (!args.isEmpty)
  filename = args(0)
```

```java
val filename =
  if (!args.isEmpty) args(0)
  else "default.txt"
```

```scala
// old IF statement
val a = 10
var result = ""

if (a < 10)      result = "Less than 10"
else if (a > 10) result = "Greater than 10"
else             result = "It is 10"

println(result)
```

```scala
// new IF statement
val a = 10
var result = if (a < 10)      "Less than 10"
             else if (a > 10) "Greater than 10"
             else             "It is 10"

println(result)
```
