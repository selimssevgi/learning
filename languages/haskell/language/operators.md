# Operators in Haskell

- All operators are functions
- Can be used as functions in parenthesis (+)

Operator | Name            | Example
---------|-----------------|------------------------------
==       | Equality        | 5 == 5, "hel" == "hel"
/=       | Not equal       | 5 /= 4
++       | Concatenation   | "hello" ++ name, both side has to be list
:        | Cons operator   | 1 : 2 : [], adding indivual elements
!!       | Index           | [1, 2, 3,] !! 1 -- 2
::       | Type of         | 'a' :: Char
=>       | Class contraint | Num a =>
^        | Power           | 2^3 = 8
$        | F. Application  | (y - x) => $ y - x
.        | F. Composition  | notNull = not . null


## ++ vs :

- (++) operator requires both operands to be lists
- (:) single element

```haskell
"hello" ++ "w"
[1,2,3] ++ [3]

'h' : "ello"
1 : [1,2,3]
```

```shell
+ : add
- : subtract
* : multiply
/ : division

# @
  xs@(x:y:ys)
  keeping a reference to the whole thing, while using pattern matching

```

## Operator Definitions

```haskell
(a,b) .+ (c,d) = (a + b, c + d)
```
