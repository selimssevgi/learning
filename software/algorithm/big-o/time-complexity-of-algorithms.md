# Time Complexity Analysis of Programs

- f(n) is a time functions of a program
- It is not exact time of a program, but just a approximation

* Algorithms

1. Iterative (for, while loop)
2. Recursive (function calling itself)

*NOTE:* If the program doesnt contain loops or recursion, its time doesnt depend
on the input size. It is always constant time.

## Time Complexity Analysis of Iterative Programs

```scala
for(i <- 1 to n) println("Hello")   // O(n)

for(i <- 1 to n; j <- 1 to n)
  println("Hello")                 // O(n^2)
```

## Time Complexity Analysis of Recursive Programs

* Back Substitution

```shell
T(n) = n + T(n-1), T(1) = 1

T(n-1) = n - 1 + T(n-2)
T(n-2) = n - 2 + T(n-3)

// substitute
T(n) = n + T(n-1)           // replace T(n-1)
     = n + (n-1) + T(n-2)   // replace T(n-2)
     = n + (n-1) + (n-2) + T(n-3)
     = n + (n-1) + (n-2)..+..(n-k) + T(n-(k+1)) // get rid of T using base condition

n - (k+1) = 1  // find K
k + 1 = n - 1
k = n + 2

T(n) = n + (n-1) + (n-2)..+..(n-(n+2)) + 1
T(n) = n + (n-1) + (n-2)..+..(2) + 1

T(n) = (n * (n+1)) / 2
T(n) = O(n^2)
```

* Recursion Tree Method

```shell
T(n) = 2T(n/2) + c, n>1, T(1) = c
```

* Master's Theorem

- Not applicable for all recursive functions
