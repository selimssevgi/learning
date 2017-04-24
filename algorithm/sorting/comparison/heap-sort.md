# Heap Sort

- see heaps.md

## Pseudo Code

- Build_max_heap from unordered array
- Find max element A[1]
- Swap elements A[n] with A[1], now the max element is at the end of the array
- Discard node n from heap, decrementing heap size
- New root may violate max-heap but children are max-heap, max-heapify(A, 1)
- Go to step 2


```shell
Heapsort(A):                      # O(nlgn)
  build_max_heap(A)               # O(n)
  for i = length(A) downto 2:     # n steps
    swap(A[1], A[i])              # O(1)
    heap_size(A) -= 1             # O(1)
    max-heapify(A, 1)             # O(lgn)
```
