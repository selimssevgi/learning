# Case Expression in Haskell

- Can be used in pattern matching
- No guards in case expressions

```haskell
doubleEachItem nums = case nums of
  []       -> []
  (x : xs) -> (2 * x) : (doubleEachItem xs)

anyEven nums = case (removeOdd nums) of -- returning list has evens
  []       -> False -- no element left, no evens
  (x : xs) -> True  -- elements left, which are evens
```
