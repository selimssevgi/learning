# Unit

- Unit doesnt give anything back
- A result type of Unit indicates the function returns no interesting value.
- Unit is actually an object
- Subtype of AnyVal
- Unit has one value: ()
- Analogous to Java's void
- Methods with the result type of Unit are only executed for their side effects.

```scala
val g = () //  g: Unit
def greet() = println("Hello!")
```

**NOTE:** void has no value whereas Unit has a value that signifies "no value".
An empty wallet and a wallet with a bill labeled "no dollars"
