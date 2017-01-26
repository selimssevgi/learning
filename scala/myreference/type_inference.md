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
