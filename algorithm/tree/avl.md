# AVL Trees

- Height of a node: length of longest path from it down to a leaf
- height of a node: max{height(left child), height(right child)} + 1

- Augmenting a binary tree by also keeping track of heights of the nodes.
- So we can use the height information to keep tree balanced

- For non-existing left or right child, we can have their height as -1
