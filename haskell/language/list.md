# List in Haskell

- Singly linked list
- Only able to add in front of the list
- Lists in Haskell must be homogeneous, same type
- Lists within a list can be different lengths but they cant be of different types.

```haskell
-- Creating List

x = [1,2,3]         -- create a list

empty = []

y = 0 : x            -- [0,1,2,3] ':' prepend command

a  = 1 : 2 : 3 : []  -- construct a list

b = 1 : (2 : (3 : []))

c = 1 : 2 : 3 : []

z = [1] ++ [2]      -- concatinate lists [1,2]

w = x ++ [4]        -- [1,2,3,4]

multiList = [[1,2], [4,5,6]]

-- Accessing List Element

thirdElement = [1,2,3] !! 2     -- list[2], 3
```

## List Functions

```haskell
head [1,2,3] -- returns 1

tail [1,2,3] -- return [2,3]

head (tail [1,2,3])

last [1,2,3] -- returns the last element. 3

init [1,2,3] -- returns everything except its last element. [1,2]

length [1,2] -- returns its length. 2

null []    -- true -- testing for empty list
null [2,3] -- false

reverse [1,2,3] -- [3,2,1]

take 3 [1,2,3,4] -- from the beginning. [1,2,3]

drop 3 [1,2,3,4] -- from the beginning. [4]

4 `elem` [3,4,5,6] -- True

elem 4 [1,2,3,4] -- True

maximum [1,2,3] -- 3

minimum [1,2,3] -- 1

sum [1, 2, 3]    -- 6

product [1, 2]   -- 2

zeroToTen  = [1..10]
evenList   = [2,4..20]
letters    =  ['A', 'C'..'Z']
infinite   = [10,20..]

many2s = take 5 (repeat 2) -- [2,2,2,2,2]
many3s = replicate 5 3     -- [3,3,3,3,3]
cycleL = take 5 (cycle [1,2]) -- [1,2,1,2,1]

listTimes2 = [x * 2 | x <- [1..10]]

-- [, filter]
divideBy5N7 = [x | x <- [1..500], mod x 5 == 0, mod x 7 ==0]

sorted = sort [1,5,3,7,2,10]

sumOfList = zipWith (+) [1,2,3] [4,5,6]

biggerThan5 = filter (>5) [3,5,6,7] -- [6,7]

evensUpTo20 = takeWhile (<=20) [2,4..]

mulOfList = foldr (*) 1 [1,2,3]
```

## Custom List Functions

```haskell
getListItems :: [Int] -> String
getListItems []       = "Your list is empty!"
getListItems (x:[])   = "Your list starts with " ++ show x
getListItems (x:y:[]) = "Your list contains " ++ show x ++ ", " ++ show y
getListItems (x:xs)   = "First item is " ++ show x ++ ", rest is: " ++ show xs
```
