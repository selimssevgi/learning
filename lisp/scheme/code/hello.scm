

; hello world as a variable
(define vhello "Hello World")

; hello world as a function
(define fhello (lambda ()
                 "Hello World"))

(define hello
  (lambda (name)
    (string-append "Hello " name "!")))

(define sum3
  (lambda (x y z)
    (+ x y z)))

; shorter form
(define (hi name)
  (string-append "hi " name "!"))

(define (square x)
  (* x x))

(define (inc x)
  (+ x 1))

(define (dec x)
  (- x 1))

(define (abs-of x)
  (if (< x 0)
      (- x)
      x))

(define (my-abs n)
  (* n
     if (not (positive? n) 1 -1)))

; reciprocal, number -> 1/number
(define (reciprocal x)
  (if (= x 0)
      #f
      (/ 1 x)))

(define (toASCII x)
  (if (or (< x 33) (> x 126))
           #f
           (integer->char x)))

(define (i2a n)
  (if (<= 33 n 126)
      (integer->char n)))

; returns their product if all of them are +ve
(define (p3 x y z)
  (and (> x 0)
       (> y 0)
       (> z 0)
       (* x y z)))

(define (all-positive? x y z)
  (and (> x 0)
       (> y 0)
       (> z 0)))

;return their product if one of them is -ve
(define (p-3 x y z)
  (if (not (all-positive? x y z))
    (* x y z)))


(define (fee age)
  (cond
    ((or (<= age 3) (>= age 65)) 0)
    ((<=  4 age 6)  0.5)
    ((<=  7 age 12) 1.0)
    ((<= 13 age 15) 1.5)
    ((<= 16 age 18) 2.0)
    (else 2.5)))

(define (grade score)
  (cond
    ((>= score 80) "A")
    ((<= 60 score 79) "B")
    ((<= 40 score 59) "C")
    ((< score 40) "D")
    (else "E")))
