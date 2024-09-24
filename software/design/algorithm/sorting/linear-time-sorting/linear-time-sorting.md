# Linear Time Sorting

- comparison model
- lower bounds
  - searching: omega(lg n)
  - sorting:   omega(n lg n)
- O(n) sorting algorithms
  - Counting sort
  - Radix sort

## Comparison Model

- All input items are black boxes(ADTs)
- Only operations allowed comparisons(<,>,<=,>=, ==).
- Mergesort, heapsort, BST,
- Time cost: # of comparisons


## Decision Tree

- Any comparison algorithm can be viewed as a tree of all possible comparisons
  and their outcomes, and resulting answer.

decision tree | algorithm
--------------|--------------------
Internal node | Binary decision(comparisons)
Leaf          | Found answer
Root-to-leaf  | Algorithm execution
Path length   | Running time
Height of tree| worst-case running time

## Searching Lower Bounds

- n preprocessed items
- finding a given item among them in comparison model
- Model requires omega(lg n) in worst case

**Proof:**

- Decision tree is binary and must have >=n leaves, one for each answer
- height >= lg n (worst-case running time)

## Sorting Lower Bounds

- omega(nlgn)
- Decision tree is binary
- Number of leaves >= # possible answers = n!(if all items are distinct)

- height >= lg(n!)
- lg(n!) ~= nlgn

## Liean-time Sorting(Integer Sorting)

- Assumption is to sorting integers, or mapping other things to integers
- Assume n keys sorting are integers {0,1,2....,k-1}
- Each fits in a word
- Word in RAM can be manipulated in constant time
- Can do a lot more than comparisons 
- For k (not too big) can sort in O(n) time

### Counting Sort

- O(n + k)
- If k is too big, then it would be worse than nlgn

### Radix Sort

- Imagine each integer as base b
- # digits = d = logb_k
- Sort integers by least significant digit
- Sort integers by second significant digit
- .
- .
- Sort integers by most  significant digit

- We will first find the number of digits in the biggest number
- If there are N digits in the biggest number then we will need to perform N passes.
- Pad the remaining numbers with leading zeros so they all have N digits.
- Then we will take 10 buckets labeled 0 to 9 and sort the numbers.
- Remove leading zeros after sorting.

- O(kn), k: # of digits in longest numbers, n: # of items
- Throwing coefficient? We dont know how big k can be.
- If k is smaller, is fast, for large numbers k is too big and slower.
- Least Significant Digit(LSD) Radix sort, starting from right
- Most Significant Digit(MSD) Radix sort, a little completed
