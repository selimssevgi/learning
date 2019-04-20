# Balanced Binary Search Trees

- h: height of the tree
- h: log(n): balanced tree

- If all to-be-inserted element are in order, we have a problem!
- 1, 2, 3, 4, 5
- Each item is going to be inserted on the right of last item
- there will be a linked-list! not a tree
- So height wont be logn but n

- The tree will be balanced if h = TETA(logn)

- Height of a node: length of longest path from it down to a leaf
- height of a node: max{height(left child), height(right child)} + 1
