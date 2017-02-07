# High Order Functions in Haskell

```haskell
times4 :: Int -> Int
times4 n = n * 4

listTimes4 = map times4 [1,2,3,4,5]

multBy4 :: [Int] -> [Int]
multBy4 [] = []
multBy4 (x:xs) = times4 x : multBy4 xs
```

```haskell
doMult :: (Int -> Int) -> Int -- expecting an Int->Int function, returns Int

doMult func = func 3
num3Times4 = doMult times4

getAddFunc :: Int -> (Int -> Int)
getAddFunc x y = x + y
adds3 = getAddFunc 3
fourPlus3 = adds3 4

treePlusList = map adds3 [1,2,3,4]
```
