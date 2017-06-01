# Type Inference

- val and var cause a variable to infer its type from the value being assigned
- Type inference involves method declarations
- If = is omitted, scalac assumes that it is a method that returns Unit

```scala
// scalac infers return type of this method is Int
def len(obj : AnyRef) = {
  obj.toString.length
}
```

## Limitation

There are two main areas where type inference is limited:

1. *Parameter types in a method declarations:* Parameters to methods must always
   have their types specified.

2. *Recursive function:* scalac is unable to infer the return type of a
   recursive function.

## Improve type inference for HOFs

- Scenario 1: we have to help compiler to figure out the kind of obvious type

```scala
def dropWhile[A](as: List[A], p: A => Boolean): List[A] = as match {
  case h :: t if p(h) => dropWhile(t, p)
  case _ => as
}

// dropWhile(List(1, 2, 3, 4, 5), x => x < 4) // missing parameter type

dropWhile(List(1, 2, 3, 4, 5), (x: Int) => x < 4)
```

- Scenario 2: group parameters so compiler will figure it out

```scala
def dropWhile[A](as: List[A])(p: A => Boolean): List[A] = as match {
  case h :: t if p(h) => dropWhile(t)(p)
  case _ => as
}

dropWhile((1 to 10).toList)(x => x < 6)
```

- inference goes from left to right, so it know what what function takes
