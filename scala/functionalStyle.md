# Functional Style

- One important step in order to write code in functional style instead of
  imperative style is that you can start to get rid of vars in scala.

- One way to move toward a functional style is to try to program without vars.

- Challange while loops in your code in the same way you challange vars.


```scala
// imperative style
def printArgs(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}
```

```scala
// functional style
def printArgs(args: Array[String]): Unit = {
  for (arg <- args){
    println(arg)
  }
  // args.foreach(println)
}


// purely functional without side effects.
def formatArgs(args: Array[String]) = args.mkString("\n")
```
