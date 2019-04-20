# Red-Black Tree

* Binary Search Tree
  - Every node has at most two children node
  - Property: left children <= node <= right children

```shell
# valid and balanced binary tree
        2
      /   \
     1     3
```

```shell
# valid binary search. but operations are not logn, but O(n)
         1
          \
           2
            \
             3
              \
               4
```

To solve this kind of problem, we have red-black tree, AVL trees, B-trees.

## Property of Red-black Tree

1. Every node is RED or BLACK
2. Every nil node is BLACK
3. Every RED node has two BLACK child nodes / If a node is RED, the parent must be black
4. Every path from node x down to a leaf node has the same number of BLACK nodes
5. The root node is always BLACK

6. A new node is always RED node.(not to change number of BLACK nodes)
