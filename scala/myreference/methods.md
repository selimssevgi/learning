# Scala Methods

- Return types of methods are type-inferred(= tells compiler to infer)
- No need of braces if body is just single statement(or expression)

- Scala doesnt have the 'static' keyword.

- static methods(in Java) must live in 'object'(singleton) construct

- Scala language runtime is quite heavyweight compared to groovy(, clojure)

- The concept of method calls is central to Scala

- Scala doesnt have operators in Java sense

- Scala is more flexible than Java about which characters can appear in method names

- Some operator characters(+) may be legal in Scala method names


```scala
def fact(base : Int) : Int = {
  if (base <= 0)
    return 1
  else
    return base * fact(base - 1)
}
```
## Special Cases
- when a method takes one parameter, we can call it without dot or parentheses

```scala
// to is a method take one integer, 
0 to 2 // 0.to(2)
1 +  2 // 1.+(2)
```

## Local Functions

- A function that is defined (and only in scope) within another function
- A simple way to have helper functions

```scala
def fact2(base : Int) : Int = {
  def factHelper(n : Int) : Int = {
    return fact2(n-1)
  }

  if (base <= 0)
    return 1
  else
    return base * factHelper(base)
}
```
