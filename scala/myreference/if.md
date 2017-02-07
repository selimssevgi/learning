# Scala IF

- if is not a statements as in Java, in scala it is an expression
- returns a value, like ternary operator. ( condition ) ? "true" : "false"
- If statements can be used in a functional fashion and assigned to a val or var


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
