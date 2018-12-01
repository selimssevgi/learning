

(define (fac n)
  (if (= n 1)
      1
      (* n (fac (- n 1)))))

(define (list*2 lst)
  (if (null? lst)
      '()
      (cons (* (car lst) 2)
            (list*2 (cdr lst)))))

(define (my-length ls)
  (if (null? ls)
      0
      (+ 1 (my-length (cdr ls)))))

(define (sum ls)
  (if (null? ls)
      0
      (+ (car ls) (sum (cdr ls)))))

(define (my-rm ls x)
  (cond
    ((null? ls) '())
    ((= (car ls) x) (my-rm (cdr ls) x))
    (else (cons (car ls)
          (my-rm (cdr ls) x)))))

; remove the first x, #f if not exist
(define (rm ls x)
  (cond
    ((null? ls) #f) ;?
    ((= (car ls) x) (cdr ls))
    (else (cons (car ls)
                (rm (cdr ls) x)))))

;;; TAIL recursion ;;;
(define (fac-tail n)
  (fac-rec n n))

(define (fac-rec n p)
  (if (= n 1)
      p
      (let ((m (- n 1)))
        (fac-rec m (* p m)))))

(define (my-reverse ls)
  (my-reverse-rec ls '()))

(define (my-reverse-rec ls rls)
  (if (null? ls)
      rls
      (my-reverse-rec (cdr ls)
                      (cons (car ls) rls))))

(define (sum ls)
  (sum-rec ls 0))

(define (sum-rec ls acc)
  (if (null? ls)
      acc
      (sum-rec (cdr ls) (+ acc (car ls)))))

(define (s2i str)
  (l2i (string->list str) 0))

(define (l2i ls num)
  (if (null? ls)
      num
      (let ((digit (- (char->integer (car ls)) 48)))
        (l2i (cdr ls) (+ (* num 10) digit)))))

(s2i "1234")
