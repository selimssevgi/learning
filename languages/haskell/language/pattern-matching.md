# Pattern Matching in Haskell


```haskell
fst' (a,b) = a
snd' (a,b) = b

null' [] = True
null' (x:xs) = False

head' (x:xs) = x
head' [] =       -- ERROR: use (x:xs)
head' [] = error "head of empty list" -- runtime error

doubleEachItem [] = []
doubleEachItem (x:xs) = (x*2) : (doubleEachItem xs)
```

```haskell
lucky :: (Integral a) => a -> String
lucky 7 = "LUCKY NUMBER SEVEN!"
lucky x = "Sorry, you are out of luck, pal!"
```

- The patterns will be checked from top to bottom and when it conforms to a
  pattern, the corresponding function body will be used.

```haskell
sayMe :: (Integral a) => a -> String
sayMe 1 = "One!"
sayMe 2 = "Two!"
sayMe 3 = "Three!"
sayMe 4 = "Four!"
sayMe 5 = "Five!"
sayMe x = "Not between 1 and 5"
```

- Without pattern matching, we'd have to make a pretty convoluted if then else tree.

```haskell
factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial n = n * factorial (n -1)
```

- When making patterns, we should always include a catch-all pattern
  so that our program doesnt crash if we get some unexpected input. Switch-case?
