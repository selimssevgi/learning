# Options

- Scala programmers dont like 'null'
- Options are modeled as Some or None
- Some contains answer to be extracted(someVal.get())
- Extracting the answer can be done by calling get(), getOrElse(), pattern
  matching or functions

- Scala still uses null to inter-operate with Java

* Option[T] : Abstract
  * Some[T]
  * None[T]

```scala
var x : Option[String] = None

x.get                     // java.util.NoSuchElementException: None.get in

x.getOrElse("default")    // "default"

var x = Some("Now it has something")

x.get                     // "Now it has something"

x.getOrElse("default")    // "Now it has something"
```


```scala
def getTempDir(tmpArg: Option[String]) : java.io.File = {
  tmpArg.map(name => new java.io.File(name))
        .filter(_.isDirectory)
        .getOrElse(new java.io.File(System.getProperty("java.io.tmpDir")))
}

def sayHi(name: Option[String]) : Unit = {
  // if it is None, for wont run
  for (n <- name) {
    println("Hi, " + name)  
  }
}
```
