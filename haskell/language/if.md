# If-Else-Then in Haskell

- In Haskell else part in if statement is mandatory!

- In Haskell if statement is an expression, it returns a value.

```haskell
doubleEvenNumber y =
  if (mod y 2 /= 0)
    then y
    else y * 2


getClass :: Int -> String

getClass n = case of n
  5 -> "Go to 5"
  6 -> "Go to 6"
  _ -> "Go home"
```
