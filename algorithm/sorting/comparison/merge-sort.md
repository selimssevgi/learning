# Merge Sort

- It is a divide & conquer algorithm.
- It is a recursive algorithm
- Real work(sorting) is done at merge part.
- Split in half in each step until cannot: len(L) == 1
- Merge steps assumes the inputs are two sorted arrays

- Need an extra space Teta(n)
- In-place merge sort is also O(nlgn), but is smaller than regular one.


## Analysis & Complexity

- Teta(nlgn)


- T(n) = c1 + 2T(n/2) + c.n
- T(n) = divide + recursion + merge

- cn(full), half + half, 4 quarter,.... (a tree)
- n leaves, single item represents on leaves
- level of the tree: 1 + logn
- the work done on each level: cn + constant
- total work: logn * n

- Needs Teta(n) auxiliary/extra space
- In-place sort need O(1) extra space(insertion)

- Coding trick: can throw the extra half of items


## Code
