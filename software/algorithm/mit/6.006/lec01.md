# 6.006 - Lecture 01

## Course Overview

- Efficient procedures for solving large scale problems
- Scalability
- Classic data structures & classical algorithms
- Real implementations of DS and algorithms in Python

## Content

- 8 modules
- Algorithmic thinking: peek finding
- Sorting and trees: even simulations
- Hashing: genome comparison
- Numerics: RSA encryption
- Graphs: Rubik's cube
- Shortest paths: Caltech -> MIT
- Dynamic Programming: Image compression
- Advanced topics

## Peek Finder

### One-dimensional version

- [a,b,c,d,e,f,g,h,i] # 1-D array
- [1,2,3,4,5,6,7,8,9] # indices
- a-i are numbers
- Position 2 is a peek if and only if b >= a and b >= c
- Position 9 is a peek iff i >= h

- *Problem:* Find a peek if it exists.

*Straight-forward algorithm:*

- Start from left
- 1,2,...,n/2,...,n-1,n
- If peek is in the middle, n/2
- Worst-case compexity: TETA(n)

- Can we do better than linear?

- Divide & Conquer, divide in half look at left hand side, then right hand side
- T(n) = T(n/2) + O(1) = O(logn)

### Two-dimensional version

- n rows, m columns matrix

```shell
+---+---+---+---+---+
|   | c |   |   |   |
+---+---+---+---+---+
| b | a | d |   |   |
+---+---+---+---+---+
|   | e |   |   |   |
+---+---+---+---+---+
|   |   |   |   |   |
+---+---+---+---+---+
```

- a is a 2D-peak iff a >= b, a >= c, a >= d, a >= e, is a hill

- Greedy Ascent algorithm
- Picks a direction, and follows it
- Teta(nm) complexity

- Divide and conquer version
- Pick middle column j = m / 2
- Find a 1D-peak at (i,j)
- Use (i,j) as a start to find a 1D-peak on row i
- This algorith doesnt work!
- problem: 2D peak may not exist on row i

- Recursive version
- Pick middle column j = m / 2
- Find global max on column j at (i,j)
- Compare (i,j-1), (i,j), (i,j+1)
- Pick left cols if (i,j-1) > (i,j), similary for right
- If (i,j) >= (i,j-1), (i,j+1) => (i,j) is a 2D peak
- Solve the new problem with half the number of cols
- When you have single column, find the global max, and done. Base case.
- T(n,m) = T(n,m/2) + O(n) # global max
- TETA(nlogm)
