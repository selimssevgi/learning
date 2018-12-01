# if Expression

- To branch procedure into two parts
- if predicate then_value else_value
- if expression is special form cus it does not evaluate all arguments
- then_value and else_value should be one S-exp
- For side effects, see 'begin'


```shell
; sum of geometric progression
(define (sum-gp a0 r n)
  (* a0
     (if (= n 1)
         n
         (/ (- 1 (expt r n)) (- 1 r)))))
```
