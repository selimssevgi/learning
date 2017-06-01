# Value Classes (2.10)

- are used to avoid object allocation (conditions apply)

- the type safety of custom data types wout the runtime overhead

- ex: Celsius, Weight, Height, Age etc

- only primary constuctor with exactly one val parameter

- only methods(def). no var, val, lazy val, nested classes, traits, or objects

- may not define equals and hashCode methods

- cannot be extended by another class

```scala
class class Age(age: Int) extends AnyVal

val age = Age(18)
```

- at compile time age is of type Age, but at runtime it is an Int

- age + 1 // error: type mismatch
