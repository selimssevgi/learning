# Arithmetic Operations

- +, -, * , /
- These functions accept arbitrary number of arguments

- quotient, remainder or modulo, sqrt
- exp, log, expt
- sin, cos, tan, asin, acos, atan

```shell
(+)       ;0
(+ 1)     ;1
(+ 1 2)   ;3
(+ 1 2 3) ;6

(- 10 5 3) ;2

(* 5 4 3)  ;60

(/ 9 4)     ;9/4
(/ 9 4 2)   ;9/8

(exact->inexact (/ 9 4)) ;2.25; fractional number -> float-point number
```

## Other Arithmetic Ops

- quotient;
- remainder or modulo;
- sqrt;

```shell
(quotient 7 3)  ;2, integer division

(remainder 19 7) ;5
(modulo 18 7)    ;5

(sqrt 8) ;2.828...

(exp (/ 2 3)) ;exponential
(log 100)     ;logarithm
(expt 3 4)    ;81


```
