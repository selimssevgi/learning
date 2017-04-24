# Built-in Functions

## eq?

- Compares the address of two objects

```shell
(eq? "hello" "hello") ;address comp, #f

(define str "hello")
(eq? str str) ;#t
```

## eqv?

- Compares types and values of two objects
- This function cannot be used for seq such as lists and strings
- Because the value stored in the first address are diff even the seq looks same

## equal?

- Used to compare sequences such as list and string

```scheme
(equal? (list 1 2) (list 1 2))   ;#t
(equal? (list 1 (list 2)))       ;#f
(equal? (list) '())              ;#t

(equal? "hello" "hello") ;#t
(equal? "hello" "Hello") ;#f
```

## Number Comparison Functions

- These functions take arbitrary number of arguments
- =, <, >, <=, >=

```scheme
(= 1 2 3)    ;#t
(= 1 1.0)    ;#t

(< 1 2 3)    ;#t
(< 1)        ;#t
(<)          ;#t

(< 1 2 3.1)  ;#t
```

- odd?, even?, positive?, zero?

## Character Functions

- char=?, char<?, char>?, char<=?, char>=?

## String Functions

- string=?, string-ci=?
- (string-append "hi " "selim" "!") ;hi selim!

## List Functions

- (reverse (list 1 2 3))

## Type Convertion Functions


```scheme
(char->integer #\0) ;48 to get int value

(integer->char 45)        ;#\

(string->list "1234");

(exact->inexact (/ 1 2))  ;1/2 -> 0.5
```
## Type Checker Functions

- *pair?* returns #t if the object consist of cons cell
- *list?* returns #t if the obj is list, '() is a list but not a pair
- *null?* returns #t if obj is '()
- *symbol?*
- *char?*
- *string?*
- *number?*
- *complex?*
- *real?*
- *rational?*
- *integer?*
- *exact?*
- *inexact?*
