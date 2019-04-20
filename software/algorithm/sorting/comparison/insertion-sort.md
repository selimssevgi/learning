# Insertion Sort

## Algorithm


```shell
for i = 1,2,..n
  insert A[i] into sorted array A[0:i-1]
  by pairwise swaps down to the correct position
```


```shell
5  2* 4  6  1  3 # * -> key
2  5  4* 6  1  3
2  4  5  6* 1  3
2  4  5  6  1* 3
1  2  4  5  6  3*
1  2  3  4  5  6
```

## Analysis

- Teta(n) steps (key positions)
- Each step is Teta(n) compares & swaps
- Teta(n^2) algorithm
- Normal cases swap and comparison costs are same
- Comparison function could be expensive for records
- Left side of the array is sorted in any case, binary search could be used
- If comparison is more expensive, binary search could be used instead of pairwise swaps
- Binary search helps to reduces the number of compares, # swaps is same

## Code

```python
L = [5, 2, 4, 6, 1, 3]

for i in range(1, len(L)):
  key = L[i]
  j = i - 1
  while j >= 0 and key < L[j]:
    L[j+1] = L[j]
    j -= 1
  L[j+1] = key

print(L)
```
