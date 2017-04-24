# Balanced Search Tree

Search tree data structure maintaining dynamic set of n elements using a tree of
height logn.

Examples:
- AVL trees
- 2-3 trees
- 2-3-4 trees
- B-tree trees
- Red-black trees
- Skiplists
- Treaps

## Red-Black Trees
BST data structure with extra color field for each node satisfying:

Red-black properties:
1. Every node is either red or black.
2. The root and & leaves(nil's) are all black.
3. Every red node has black parent.(no two reds consecutive)
4. All simple paths from a node x to a descendant leaf of x have same:
   #black nodes = black-height(x) (doesnt count x itself)

## Height of red-black tree
Red-black tree with n keys(not nodes, excluding nils) has height: h < 2lg(n+1)

Proof Sketch: 

* Merge each red node with its black parent(2-3-4 tree)
* After 1 step every internal node has either 2,3 or 4 children
* Every leaf has same depth namely black-height(root), cus of property 4

Every leaves being at the same level means that the tree is balanced!

h  :normal height of tree
h' :height of red-merged tree

IF every node has exactly 2 children.
The number of leaves in a tree is n + 1. n is # of internal nodes.

In 2-3-4 tree: 2^h' <= # leaves <= 4^h' (replaces # leaves)

2^h' <= n + 1 (take log of both sides)

h' <= log(n + 1)

Property 3 says there is a same number of red and black nodes. From root to leaf
at most the number of red nodes is the half of nodes.

h <= 2h' or h' >= h/2 cus at most half of the nodes on any root-leaf path are red.

h <= 2log(n+1)

### Corollary(result)
Queries(Search, Min, Max, Successor, Predecessor) run in O(logn) time in a RBT.

Updates(insert, delete) must modifies the tree:
- BST operation
- Color changes
- Restructuring of links via rotations

### Rotation

- right-rotate(node)
- left-rotate(node)
- Preserves Binary-ST property: left child <= parent <= right child
- Takes constant time: O(1) (constant number of links are changing)

### Red-black Insert

- Tree-Insert(x)
- Color node red
- Problem: parent might be red => violate property 3
- Adding red node doesnt change the black-hights(property 4)
- fix p3: move violation up the tree via recoloring until we can fix violation
  via rotation & recoloring.
