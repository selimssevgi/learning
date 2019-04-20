# Heap

- It is an implementation of a priority queue.
- It is an array
- It is visualized as a nearly complete binary tree


```shell
 1  2  3  4  5  6  7  8  9  10
+--+--+--+--+--+--+--+--+--+--+
|16|14|10|8 |7 |9 |3 |2 |4 |1 |
+--+--+--+--+--+--+--+--+--+--+
```

- Draw it as tree: index 1 is root, 2 is left, 3 is right.
- i, 2i, 2i+1

- you have a tree representation of an array

## Heap as a Tree

- Root of tree: first element (i=1)
- parent(i): i/2
- left(i): 2i
- right(i): 2i+1

- There are particular types of heaps that are max-heaps and min-heaps.

## max-heap Priority

- The key of a node >= the keys of its children

## min-heap Priority

- The key of a node <= the keys of its children

## Heap Operations

- build-max-heap: produces a max heapfrom an unordered array

- max-heapify: correct a single violation of the heap property in a subtree's root


### max-heapify

- Assume/precondition that the trees rooted at left(i) and right(i) are max-heaps
- max-heapify(A,i): a:array, i:index
- Bottom up works as expected, cus leaves are max-heap by themselves.

#### PseudoCode

```shell
Max_Heapify(A,i):
  L = Left(i)  # get the index of left child
  R = Right(i) # get the index of right child
  if L <= heap_size(A) and A[L] > A[i]:
    largest = L
  else:
    largest = i
  if R <= heap_size(A) and A[R] > A[largest]:
    largest = R
  if largest != i:
    swap(A, i, largest)
  Max_Heapify(A, largest)
```

#### Complexity

- Visualization is complete binary tree, the height of the tree is bounded by lgn
- In the worst case an element at the top of three would take lgn step to go
  down at the bottom

### build-max-heap 

- Convert an array A[1..n] into a "max"-heap

#### PseudoCode

```shell
build_max_heap(A):
  for i = n/2 downto 1:
    max_heapify(A, i)
```

- Why starting at n/2 and going downto 1?
- Elements A[(n/2+1)..n] are all leaves, true for all arrays.
- Everytime we call max_heapify in this way, we satify precondition of it, which
  was left and right subtrees assumed to be max-heaps, leaves are max-heaps.

#### Complexity

- O(nlogn) would be an upper bound as a simple analysis.
- Can we do better analysis, a tighter bound?
- One level above leaves, there will be one operation
- Two level above leaves, there will be two operation
- As we go up, there will be fewer nodes and more operations

- Observe max-heapify takes O(1) for nodes that are one level above leaves
- And in general O(L) time for nodes that are L level above the leaves
- n/4 nodes with level 1, n/2 with level 2,..., 1 node logn level

- Total amount of work in the for loop:
- n/4(1c) + n/8(2c) + n/16(3c) + ... + 1(log(n)c)
- Set n/4 = 2^k
- c2^k(1/2^0 + 2/2^1 + 3/2^2 + ... + (k+1)/2^k)
- Convergent series, and bounded by a constant between 2-3
- 2^k is left out when we take out constant
- Finally n/4, and n
- The total work done in for loop in n

- build-max-heap is now bounded TETA(n)
