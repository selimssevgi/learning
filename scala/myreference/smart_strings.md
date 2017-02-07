# Smart Strings


```scala
val multilineString = "line number 1, \n" +
                      "line number 2, \n" +
                      "line number 3, \n"
println(multilineString)

val smartMulti = """line number 1,
                   |line number 2,
                   |line number 3,""".stripMargin('|')
```
