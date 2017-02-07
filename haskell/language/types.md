# Haskell Types

## Haskell's Type System

### Type Systems

Static Types                       | Dynamic Types
-----------------------------------|-----------------------------
C/C++, Java, C#                    | Javascript, Ruby, Python
More errors caught at compile time | More run-time errors
Write lots of types(verbose)       | Never write a type
Repeated code for different types  | Same code works for many types

- Statically typed
  - Lots of compile-time errors
  - Few run-time errors

- Types are inferred
  - Dont have to write out explicit types
  - Explicit types communicate with people, checked by compiler

- Same code can work for many different types. max(Object[]), max(double[])

## Explicit Type

```haskell
str :: [Char]
str = "Hello"

foo :: Int -> Int
foo x = 2 * x + 1

add3 :: Int -> Int -> Int -> Int
add3 x y z = x + y + z
```

**When to use Explicit Types**

- Communicating with people
- Documentation reasons
- Commnets could be used, but comments are not checked by the compiler
- Tracking down compiler errors
- Helping compiler (occasionally)
- Optimizing (only when necessary)

```haskell
mystery :: [Char] -> Int
```


## Type Inference

```haskell
square x = x * x

nonsense = square "hello" -- compile time error. f: String, r: Num

squareTwice x = square (square x)

brokenShowSquare x = "The square is: " ++ square x -- compile time ERROR
```

## Functions

- a -> b
- Functions takes a as a parameter, and returning type b

```haskell
lines :: [Char] -> [Char]            -- String lines(String)
greet :: [Char] -> [Char] -> [Char]  -- String greet(String, String)
-- partially applied function
```

## Int
- Int is for whole numbers, but is bounded. It has minimum and max value

```haskell
-- Maximum integer
maxInt = maxBound :: Int
minInt = minBound :: Int
```

- Integer is also for integers, but is NOT bounded. Is for really big numbers.

- [Char] == String

- Char, Int, Double, Float, Bool

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
