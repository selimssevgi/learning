# Functions in Haskell

- Function names cannot begin with uppercase letters.

- Functions in Haskell dont have to be in any particular order.
  Is not like in C that they have to define somewhere up before calling.

- If a function doesnt take any parameters, it is a definition(or a name).
  Because they are not changable.

```haskell
sayHelloWorld = "Hello World"
sayHello name = "Hello" ++ name
```

- Function application(calling a function) by putting a space after it and then
  typing out the parameters

- Function application has the highest precedence of them all.

```haskell
-- both of the following are equal:
succ 9 + max 5 4 + 1
(succ 9) + (max 5 4) + 1

succ 9 * 10   -- is 10 * 10 = 100
succ (9 * 10) -- is 91
```

- Functions also have types. When writing our own functions, we can choose to give
  them an explicit tpye declaration.

```haskell
addThree :: Int -> Int -> Int -> Int
```

- Return type is the last item in the declaration.

- Every function must return something


```haskell
-- funcName param1 param2 = operations (returned value)

addMe :: Int -> Int -> Int
addMe x y = x + y

-- Haskell will infer the types
-- in this case in ghci: Num a => a -> a -> a
sumMe x y = x + y

addTuples :: (Int, Int) -> (Int, Int) -> (Int, Int)
addTuples (x,y) (x2,y2) = (x+x2, y+y2)

whatAge :: Int -> String
whatAge 16 = "You can drive"
whatAge 18 = "You can vote"
whatAge 21 = "You are an adult"
whatAge x  = "Nothing important" -- or whatAge _ = "Nothing important"
```
