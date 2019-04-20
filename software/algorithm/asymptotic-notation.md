# 

- A problem
- Lots of solutions(algorithms)
- Which one is better? (time, memory)

## Big(O):

- upper bound: g(n): worst case
- n0 is the point where two functions meet and g(n) is always bigger in time
- f(n) <= c x g(n)
- n >= n0
- c > 0, n0 >= 1
- therefore, f(n) = O(g(n))


Ex:

- f(n) = 3n + 2, g(n) = n
- f(n) = O(g(n))
- assume
- f(n) <= c x g(n)
- c > 0, n0 >= 1
- 3n + 2 <= c x n
- c = 4
- 3n + 2<= 4n
- n >= 2
- n, n^2, n^3: are all upper bound, but go for tighest upper bound.

## Big Omega

- lower bound: g(n): best case
- n0 is the point where two functions meet and f(n) is always bigger
- f(n) >= g(n), n <= n0, c > 0, n0 >= 1

Ex:

- f(n) = 3n + 2, can bound g(n)?

## Big Theta

- need both upper(c2 x g(n)) and lower bound(c1 x g(n)): average case
- f(n) = theta(n)
- c1 x g(n) <= f(n) <= c2 x g(n)
- c1,c2 > 0
- n >= n0
- n0 > 1
