# Package object

- The only thing you can put in a package are classes, traits, and objects

- With the help of package object, any kind of definition can be put in a
  package

- For example, an helper method in a package object that will be available to
  all memebers of the package

- Each package allowed to have one package object

- Package object can be put in a package.scala file

```scala
package object bar {
  val minimumAge = 13
  def verifyAge = {}
}
```

- verifyAge method now can be used anywhere in the bar package
