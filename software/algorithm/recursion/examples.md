# examples of recursion

- the greatest common divisor
- binary search
- fibonacci
- factorial, permutation (N!)
- file system
- english ruler

### factorial

```java
int factorial(int n) {
  if (n < 0) {
    throw someException();
  } else if (n == 0) { // base case
    return 1;
  } else {
    return n * factorial(n - 1);
  }
}
```

### binary search

- mid = floor( (low + high) / 2)
- while (low <= high)


```java
boolean binarySearch(int[] data, int target, int low, int high) {
   if (low > high) {
      return false;
   } else {
      int mid = (low + high) / 2;
      if (target == data[mid]) {
        return true;
      } else if (target < data[mid]) {
        return binarySearch(data, target, low, mid - 1);
      } else {
        return binarySearch(data, target, mid + 1, high);
      }
   }
}
```
