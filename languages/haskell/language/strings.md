# String in Haskell

- Strings are just lists. So list functions can be used with strings.


```haskell
"hello"

[ 'h', 'e', 'l', 'l', 'o' ]

str = "abcde"

str' = 'a' : 'b' : 'c' : 'd' : 'e' : []

[1,2] ++ [3,4]       -- [1,2,3,4] concatination operator

"haskell" ++ "curry" -- "haskell curry"

```

## Custom String Functions

```haskell
areStringEq :: [Char] -> [Char] -> Bool
areStringEq [] [] = True
areStringEq (x:xs) (y:ys) = x == y && areStringEq xs ys
```
