# Repeated Parameters

- Repeated Parameters use an Array to hold possible extra parameters


```scala
def repeatedParamMethod(x:Int, y:String, z:Any*) {
  println(z)   // WrappedArray
  "%d. %s and %s".format(x, y, z.mkString(","))
}

repeatedParamMethod(1, "smth", "another", "one more")
repeatedParamMethod(3, "smth")
```
