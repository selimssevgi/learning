# Quick Sort

- Quicksort is also divide-and-conquer algorithm like mergesort.
- Merge is heartt of mergesort, partition is heart of quicksort.
- If n is not too big, merge sort has some overhead, in those cases quicksort is faster.
- 

## Partioning


```shell
partition(A,p,r) { # Array with p and r boundaries
  x = A[r];  # last element as pivot
  i = p - 1; # pointer for numbers less than pivot
  for (j = p to (r-1)) {
    if (A[j] <= x) {
      i = i + 1;
      swap(i, j)
    }
  }
  swap(i+1, r)
  return i+1;
}
```
