# Haskell Types

- Most of the time, the types of our values are not written down in the program.
  Haskell will work out what the types are for you,
  however, Haskell lets you write them down if you'd like to.
  34 :: Integer
  5 :: Integer

- Int is for whole numbers, but is bounded. It has minimum and max value

```haskell
-- Maximum integer
maxInt = maxBound :: Int
minInt = minBound :: Int
```

- Integer is also for integers, but is NOT bounded. Is for really big numbers.

- [Char] == String

- Char, Int, Double, Float, Bool

```haskell
flag = True
```

- Tuple is a type but also it depends on its length.

- [a] -> a, a is a type variable. it let fucntions be generic.

## Bool

- Values are : True, False

```haskell
trueAndFalse = True && False
trueOrFalse  = True || False
notTrue = not(True)

notTrue2 = not True
notFalse = not False
notAnd =  not (True && False)
```
