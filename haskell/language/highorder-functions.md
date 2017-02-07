# High Order Functions in Haskell

- Functions with function arguments
- Create functions on the fly
  - Partial function application
  - Lambda expressions
  - Function composition

- map, filter, foldl, foldr, zip, zipWith

```haskell
times4 :: Int -> Int
times4 n = n * 4

listTimes4 = map times4 [1,2,3,4,5]

multBy4 :: [Int] -> [Int]
multBy4 [] = []
multBy4 (x:xs) = times4 x : multBy4 xs

pass3 f = f 3
add1 x = x + 1
pass3 add1 -- 4
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

## Partial Application

- In javaa, all arguments of a method must be supplied while calling
- Arguments given in order

```haskell
foo x y z = x + y + z
foo_1_2 = foo 1 2 -- partial

foo_1_2 3 -- 6
```

## Partially Applying Operators

```haskell
plus3 = (+) 3
plus3' = (+3)
plus3'' = (3+)
times4 = (*) 4
```

## Map

```haskell
lengths = map length ["haskell", "is", "awesome"]
increseOne = map (+1) [1,2,3,4]
double = map (*2)
```

## Filter

```haskell
notNull xs = not (null xs)
notNullLists = filter notNull ["", "selim", "", "haskell"]

isEven x = mod x 2 == 0
removeOdd = filter isEven

map snd (filter fst
          [(True, 1), (False, 11), (True, 15)])

```

## Fold

- Combines all values in a list
- Two versions(foldr, foldl)
- For some functions foldr and foldl will end up in different results.(-)
- foldl slight faster. tail recursive. compiler optimize

```haskell
foldl (+) 0 [1,2,3,4] -- function, seed value, list from left
foldr (+) 0 [1,2,3,4] -- function, seed value, list from right
```

## Zip / ZipWith

- Default is for 2 lists
- zipWith3, zipWith4...

```haskell
zipped = zip [1,2,3] [4,5,6] -- [(1,4), (2,5), (3,6)]

zipped' = zip [1,2] [4,5,6]  -- [(1,4), (2,5)]

zippedWith = zipWith (+) [1,2,3] [4,5,6] -- [5,7,9]

plus3 x y z = x + y + z
zipWith3 plus3 [1,2] [3,4] [5,6] -- [9,12]
```

## Lambda Expression

