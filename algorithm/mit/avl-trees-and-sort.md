# AVL Trees and AVL Sort

* Balanced BSTs

- The importance of being balanced
- AVL trees: definition, rotations, insert
- Other balanced trees
- Data structures in general
- Lower bounds

## Binary Search Tree(BST)

- rooted binary tree
- each node has
  - key
  - left pointer
  - right pointer
  - parent pointer
- BST property: all left nodes <= node <= all right nodes
- A node can have none, one or two children.

## BST Operations

- Supports insert, delete, min, max, next larger(successor),
  smaller(predecessor) in O(h), h: height of BST
- h is always not logn, if is not balanced
- h is length of longest path from root to leaf

- a tree is balanced if height is O(logn)

**Height of a node:**
- = the length of longest path from it down to a leaf
- = max(height(leftChild), height(rightChild)) + 1
- height of leaves might be assumed -1 for convience.


## AVL Trees

- Require height of left & right children of every node to differ by at most +-1
