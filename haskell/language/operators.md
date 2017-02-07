# Operators in Haskell

Operator | Name            | Example
---------|-----------------|------------------------------
==       | Equality        | 5 == 5, "hel" == "hel"
/=       | Not equal       | 5 /= 4
++       | Concatenation   | "hello" ++ name
:        | Prepend         | 1 : 2 : []
!!       | Index           | [1, 2, 3,] !! 1 -- 2
::       | Type of         | 'a' :: Char
=>       | Class contraint | Num a =>
^        | Power           | 2^3 = 8
$        |                 | (y - x) => $ y - x



```shell
+ : add
- : subtract
* : multiply
/ : division

# @
  xs@(x:y:ys)
  keeping a reference to the whole thing, while using pattern matching

```
