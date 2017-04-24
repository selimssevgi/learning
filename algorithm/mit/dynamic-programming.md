# Dynamic Programming (DP)

* Memoization & subproblems
* Fibonacci
* Shortest path
* Guessing & DAG view

- General, powerful algorithm design technique

- Short path, optimation, etc

- Exhaustive search, usual bad thing: exponential time
- By using DP you get polynomial time.

- DP ~ "careful brute force"
- DP ~ subproblems + "re-use"

- There are lots of problems where essentially the only know polynomial time
  algorithm is via DP.


## Fibonacci Numbers

- F1 = F2 = 1
- Fn = Fn-1 + Fn-2

- Goal: Compute nth Fibonacci number.

**Naive Recursive Algorithm**

```shell
fib(n):
  if n <= 2: f = 1
  else: f = fib(n-1) + fib(n-2)
  return f
```

- Bad algorithm: exponential time!!!

**Memoized DP Algorithm:**

```shell
memo = {} # dict
fib(n):
  if n in memo: return memo[n]
  if n <= 2: f = 1
  else: f = fib(n-1) + fib(n-2)
  memo[n] = f
  return f
```

- fib(k) only recurses the first time it is called
- memoized calls cost O(1)
- # non-memoized calls is n: fib(1), fib(2)...fib(n)
- non-recursive work per call = O(1)
- time => O(n)

### DP =~ recursion + memoization
- memoize (remember) & re-use solutions to sub-problems that help solve the problem

- time = #subproblems . (time / subproblems) = n . O(1)

- Ignore recursive calls! Dont count recursion. Memozation recursion. 

### Bottom-up DP algorithm:

```shell
fib = {}
for k in range(1, n+1):
  if k <= 2: f = 1
  else: f = fib[k-1] + fib[k-2] # map calling not function call
  fib[k] = f
return fib[n]
```

- Exactly same computation as memoization,
- topological sort of subproblem dependency DAG
- Need to know fn-1 and fn-2 to compute fn-3

- Can save storage, we just need last two values.
- More obvious that it takes O(n)
