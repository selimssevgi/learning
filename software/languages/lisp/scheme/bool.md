# Boolean

- False is represented by #f
- True  is represented by #t
- True is any value except false

## not

- Function not is available to negate predicates

## and, or functions

- are special forms
- They do not return #f or #t but returns one of given arguments

### and
- and take arbitrary number of arguments,
- evaluate from left to right
- it return #f if one of the arguments is false
- And the other arguments wont be evaluated(short-circuet)
- If none of the arguments is #f, then it returns the value of the last argument

```shell
(and #f 0)    ;#f
(and 1 2 3)   ;3
(and 1 2 3 #f);#f
```

### or

- works similar to and

```scheme
(or #f 0)   ;0
(or 1 2 3)  ;1
(or #f #f)  ;#f
```
