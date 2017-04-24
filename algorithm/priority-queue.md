# Priority Queue

- Implements a set S of elements
- Each of elements associated with a key.

## Operations

- insert(S,x): insert element x into set S

- max(S): return element of S with the largest key

- extract-max(S): return element of S with the largest key and remove it

- increase-key(S,x,k): increase the value of x's key to the new value k

### Insert

```shell
heap-insert(A,x):
  heap-size[A]++
  i = heap-size[A]
  while i > 1 and A[Parent(i)] < x:
    A[i] = A[Parent(i)]
    i = Parent(i)
  A[i] = x
```

### Max

```shell
max(S):
  return S[1]
```

### ExtractMax

```shell
extract-max(A):
  if heap-size[A] < 1: ERROR
  max = A[1]
  A[1] = A[heap-size[A]]
  heap-size[A]--
  max-heapify(A, 1)
  return max
```
