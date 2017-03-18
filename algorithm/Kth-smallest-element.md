# Order Statistics

- Given n elements in n array
- Find Kth smallest element(element of rank k)

- *Naif algorithm:* Sort the the array, return A[k]
- It will be O(nlgn) in best case with merge or heap sort.

- Finding the minimum element K=1, easy n steps in worst case
- Finding the maximum element K=n, easy n steps in worst case
- Finding the median is tricky: k=floor(n+1/2), k=ceiling(n+1/2)


## Randomized Divide & Conquer

- Use randomized quicksort method.
- The value returned from partition method is the rank of that value.
- We can use that value to find Kth smallest element


```shell
rand-select(A, p, q, i) { // smallest ith element in A[p..q]
if p=q then return A[p]
r <- rand-partition(a,p,q)
k <- r - p + 1
if i = k then return A[r]
if i < k then 
  return rand-select(A, p, r - 1, i)
else 
  return rand-select(A, r + 1, q, i - k)
}
```
