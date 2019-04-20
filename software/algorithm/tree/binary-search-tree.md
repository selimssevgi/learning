# Binary Search Tree(BST)

- Fast insertion in a sorted array

- node x: key(x)
- binary tree has pointers unlike heap
- Pointers: parent(x), left(x), right(x)

- heap is an array, visualized as tree

- h: height of the BST
- h: height of the longest path from root to leaf

## Invarient

- BST property:
- For all nodes x:
  - if y is in the left subtree of x: key(y) <= key(x)
  - if y is in the right subtree of x: key(y) >= key(x)

- In heap we just look at the children, in BST all subtree

## Operations

- insert
- delete
- find-min: keep going left till hit a leaf, O(h) complexity
- find-max: keep going right
- next-larger(x): successor
- next-smaller(x): predecessor
- in-order-traversal

## Insert

- h: height of the tree
- insertion with or without check(constraint) takes O(h) time

```shell

```

## Augment the BST Structure

- an extra information to the node, e.g, subtree-size how many nodes are underneath
- do normal insert, an increase that number as you come across while finding
  insertion point

## Problem

- when it is not balanced
- see balanced BSTs
