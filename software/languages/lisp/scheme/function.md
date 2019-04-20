# Functions


## Using lambda special form

```scheme
(define <name>
  (lambda (<parameters>)
    (<body>)))

(define fhello
  (lambda ()
    "Hello World"))

(define hello
  (lambda (name)
    (string-append "Hello " name "!")))

(define sum3
  (lambda (x y z)
    (+ x y z)))
```

## Shorter Form


```scheme
(define (<name> <parameters>)
  (<body>))

(define (hi name)
  (string-append "Hi " name "!"))

(define (square x)
  (* x x))
```
