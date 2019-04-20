# Recursion in Haskell



```haskell
factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial (n - 1)

prodFact n = product [1..n]

sum :: Int -> Int
sum 0 = 0
sum n = n + sum (n - 1)

sum [1..n]
```
