# Functions in Haskell

- All Haskell functions are pure.
  - Cannot modify state.
  - Cannot depend on state.
  - Given the same arguments, always returns the same output.

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

## Function Operators
- (.) - function composition
- ($) - function application

#### Function Composition (.)

- Order is important, right to left
- Both functions should have only one argument

```haskell
stringLength = length . show  -- applied right to left
stringLength 120 -- 3

stringLength' x = length (show x)

notNull = not . null
notNull' xs = not (null xs)
```

#### Function Application ($)

- Takes a function and value, and applies the function to the value
- Common usage is to replace parenthesis
- Can be used in highorder functions

```haskell
f $ x = f x

f $ g x = f (g x)

f $ g $ h $ k x = f (g (h (k x)))

-- apply functions to a value
map (\f -> f 3) [(+1), (\x -> 2*x + 3), (*2)] -- [4,9,6]
map ($3) [(+1), (\x -> 2*x + 3), (*2)] -- [4,9,6]

-- a list of function zip list of values
zipWith ($) [(+1), (\x -> 2*x + 3), (*2)] [1,2,3] -- [2, 7, 6]


```

## Polymorphic Functions

- A function with a type variable
- Not object-oriented polymorphism
- Similar to C#/Java generics or C++ templates
- Type variables always start with lower case; a, b, x, foo, hello_124
- Concrete types start Upper case; Int, Integer, Char, Double
- Repeated type variables always represent the same type

```haskell
length_ints :: [Int] -> Int
length_ints [] = 0
length_ints (x:xs) = length_ints xs + 1

length_chars :: [Char] -> Int
length_chars [] = 0
length_chars (x:xs) = length_chars xs + 1

-- polymorphic version
-- length function for any type
-- infers: length :: [a] -> Int
length [] = 0
length (x:xs) = length xs + 1

empty_list :: [a]
empty_list = []

head :: [a] -> a
head (x:xs) = x
```
