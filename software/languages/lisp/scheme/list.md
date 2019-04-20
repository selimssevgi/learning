# Scheme Lists

- basic list operators: cons, car, cdr, list, quote

## Cons Cells

- cons: construction
- cons cells are memory spaces which storage two addresses
- Function cons allocates memory space for two addresses


```shell
(cons 1 2)   ;takes only two argument

(cons 1 (cons 2 3))  ;can be nested

;can store different kinds of data
(cons #\a "hello")

;recursively
(cons obj list)
```

## Empty List

- () is empty list
- '() ; single quote says "DO NOT EVALUATE!"
- check if is empty: (null? lst), (null? '())

## car and cdr functions

- car: head of the list
- cdr: tail; rest of the list

```shell
(car '(1 2 3)) ;1
(cdr '(1 2 3)) ;(2 3)
```

## list function

- make a list consisting of several elements
- Function list takes arbitrary number of argumnets and return a list of them

```shell
(list)     ;()
(list 1 2 3) ;(1 2 3)
```
