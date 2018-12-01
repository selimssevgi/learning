# Lambda In Haskell

- Functions dont have a name
- Use backlash(\)
- Use anonymous functions/lambdas instead of defining little functions

```haskell
double1to10 = map (\x -> x * 2) [1..10]

(\ x y z -> x + y + z) -- plus3 x y z = x + y + z
```

### When to use Lambda Expressions

- Too simple: partial application
- Too complex: named functions

```haskell
(\ x -> x + 1) -- instead of this: too simple
(+1)           -- use this partial application function
```
