## binary search

- on sorted items

- do we want to sort the items whenever we search?
- or keep the items sorted whenever add/remove items?
  - binary search tree


```shell
lowIndex = 0;
highIndex = length - 1;
middleIndex = (lowIndex + highIndex) / 2 // rounds down

lowIndex = middleIndex + 1;
highIndex = middleIndex - 1;

```


```shell
binarySearch(key, array[], min, max)
  if (max < min):
    return -1
  else:
    midpoint = findMidPoint(min, max);

  if (array[midpoint] < key):
    binarySearch(key, array, midpoint + 1, max)
  else if (array[midpoint] > key):
    binarySearch(key, array, min, midpoint - 1)
  else:
    return midpoint
```
