# isInstanceOf and asInstanceOf

- asInstanceOf will convert object to a certain type(casting)

```scala
3.isInstanceOf[Int]           // true
3.isInstanceOf[Boolean]       // false
"3".isInstanceOf[String]      // true
"3".isInstanceOf[Any]         // true
```


```scala
val g: Any = "something"
val str: String = g     // ERROR: narrowing Any -> String

val str: String = g.asInstanceOf[String]
```
