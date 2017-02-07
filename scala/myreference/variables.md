# Scala Variables

- Scala has two kinds of variables: var and val

- val are not reassignable, for value, final

- var are reassignable, for variable,

- var are rarely used

- Types on 'val' and 'var' are implied

- Types can always be explicity defined in declarations

- types are specified after variable names, separated by a colon.


```scala
// implicitly String
val msg = "Hello World!"

// explicitly String
val msg: String = "Hello World!"
```

## lazy val

- 'lazy val' will not be evaluated until referenced
- Any subsequent calls to the val will return the same value when initially called upon
- There is no such thing as a 'lazy var'
- lazy val can be forgiving if an exception happens


```scala
> lazy val a = { println("evaluated"); 5 }
> a
evaluated
res0: Int = 5
> a
res1: Int = 5

> var divisor = 0
> lazy val res = 10 / divisor
> a
java.lang.ArithmeticException: / by zero
> divisor = 1
> a
res4: Int = 10
```
