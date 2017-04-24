# 6.006 - Lecture 05 - BSTs, BST Sort

- Scheduling & Binary Search Trees
- Runway reservation system
  - Define
  - How to solve with arrays/lists
- Binary Search Tree and operations


## Runway Reservation System

- Airport with a single runway:
- Reservations for future landings
- Reserve request specifies landing time t
- Add t to the set R if no other landings are scheduled within k mins

- Insert operation with constraint check(k mins)
- Remove from set R after the plane lands

- We want to do it in |R| = n, O(lgn) time

*Example:*

- Timeline: 37(now)  41.2     49      56.3 -->
- for 53 can schedule: OK
- 44: now allowed, 41.2 + 3 = 44.2
- 20: now allowed in the past
- time is continous for this example

- Represent R as unsorted list/array:?
  - insert:O(1) without check, check: O(n)

- Represent R as sorted array:?
  - find insertion point, binary search: O(lgn)
  - compare left and right of insertion point: O(1)
  - Actual insertion(shifting): O(n)

- Represent R as a sorted list:?
  - find insertion point, linear: O(n)
  - insertion(changing pointers): O(1)

- Represent R as heaps:?
  - find element that is <=k or >= k from t: O(n)
  - while heapifying it wont be able to check other side of the "tree"
  - so have to check one by one

*We need:*
- Fast insertion into a sorted array!

## Binary Search Tree

- see tree/bst.md

* new request: Rank(t), how many planes are scheduled to land at time <= t?

- We can augment the BST structure.
