# let Expression

- Local variables can be defined using the 'let' expression
- let binds body
- [binds] -> ((p1 v1) (p2 v2))
- Bindings/variables are available in body

```scheme
(let ((i 1) (j 2))
  (+ i j))

(let ((i 1))
  (let ((j (+ 1 i)))
    (* i j)))

(let ((i 1) (j (+ 1 i)))
  (* i j)) ; ERROR: i is not defined in the scope of j

(let* ((i 1) (j (+ 2 i)))
  (* i j)) ; 3

; let* expression is avaliable to refer variables defined in the same binding
; let* expression is a syntax sugar of nested let expression
```
