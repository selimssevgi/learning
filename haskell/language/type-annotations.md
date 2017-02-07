# Type Annotations in Haskell

- Type annotations are a way of explicitly saying what the type of an expression
  should be. We do that by adding :: at the end of the expression and then specifying a type.

- Not used so much

```haskell
x = 3 :: Int

y  = (3 :: Int) + (2.1 :: Double) -- ERROR. no implicit conversion
y' = 3 + 2.1 -- 5.1

Read "5" :: Int -- read it as int, casting
```
