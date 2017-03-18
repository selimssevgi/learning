# Dynamic Connectivity

* Given a set of N objects

- Union command : connect two objects
- Find/connected query: is there a path connecting the two objects?


```shell
union(4,3)     # connect 4 to 3
connected(1,5) # is there a path from 1 to 5 direct or indirect?
```

## Modeling the objects

* Applications involve manipulating objects of all types.
  - Pixels in a digital photo.
  - Computers in a network.
  - Friends in a social network.
  - Transistors in a computer chip.
  - Elements in a mathematical set.
  - Variable names in Fortran program.
  - Metallic sites in a composite system.

* When programming, convenient to name objects 0 to N-1
  - Use integers as array index
  - Suppress details not relevant to union find

## Modeling the connections

* We assume "is connected to" is an equivalence relation:
  - *Reflexive:*  p is connected to p.
  - *Symmetric:*  if p is connected to q, then q is connected to p.
  - *Transitive:* If p is connected to q and q is connecto to r, then p -> r
  
*Connected components,* maximal set of objects that are mutually connected.

```shell
{0} {1 4 5} {2 3 6 7}
# 3 connected components
```

Find query: Check if tow objects are in the same components.
Union command: Replace components containing two objects with their union.

```shell
union(2,5)
{0} {1 2 3 4 5 6 7}
# 2 connected components
```

## Union-find data type (API)

Goal. Design efficient data structure for union-find.
  - Number of objects N can be huge.
  - Number of operations M can be huge.
  - Find queries and union commands may be intermixed.

```java
public class UF {
  UF(int N)
  void union(int p, int q)
  boolean connected(int p, int q)
  int find(int p)
  int count()
}
```

## Dynamic-connectivity client

- Read in number of objects N from the standard input
- Repeat:
  - read in pair of integers from standard input
  - If they are not yet connected, connect them and print out pair

```java
public static void main(String[] args) {
  int N = StdIn.readInt();
  UF uf = new UF(N);
  while (!StdIn.isEmpty()) {
    int p = StdIn.readInt();
    int q = StdIn.readInt();
    if (!uf.connected(p, q)) {
      uf.union(p, q);
      StdOut.println(p + " " + q);
    }
  }
}
```

```shell
$ more tinyUF.txt
10
4 3
3 8
6 5
```

## Quick-find [eager approach]

Data structure.
  - Integer array id[] of size N
  - Interpretation: p and q are connected iff they have the same id.
  - iff: if and only if

```shell
     0 1 2 3 4 5 6 7 8 9
id[] 0 1 1 8 8 0 0 1 8 8

{0 5 6} {1 2 7} {3 4 8 9}
```

Find: Check if p and q have the same id.

Union: To merge components containing p and q, change all entries whose id
equals to id[p] to id[q].

```shell
     0 1 2 3 4 5 6 7 8 9
id[] 0 1 1 8 8 0 0 1 8 8

# after union of 6 and 6
id[] 1 1 1 8 8 1 1 1 8 8
```

Problem: many values can change

```java
public class QuickFindUF {

  private int[] id;

  public QuickFindUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }
}
```

### Quick-find is too slow

Cost model: number of array accesses (for read or write

algorithm | initialize | union | find
----------|------------|-------|------
quick-find| N          | N     | 1


Quick-find defect: union too expensive.

*Note:* Quadratic time(npow2) is much too slow. We cannot accept quadratic time 
algorithms for large problem. The reason is that they dont scale.

* Quadratic algorithm dont scale with technology.

- New computer may be as 10x as fast.
- But, has 10x as much memory => want to solve a problem that is 10x as big.
- With quadratic algorithm, takes 10x as long.

### Quick-Union [lazy approach]

Data structure:
  - Integer array id[] of size N.
  - Interpretation: id[i] is parent of i.
  - Root of i is id[id[id[id[...id[i]...]]]

```shell
     0 1 2 3 4 5 6 7 8 9
id[] 0 1 9 4 9 6 6 7 9 9

#   9      6
#  / \     |
# 2   4    5
#     |
#     3
# the root of 2 is 9.
# the root of 3 is 9.
# the root of 4 is 9.
# the root of 5 is 6.
```

Find: Check if p and q have the same root. (3 and 5 are not connected)

Union: To merge components containing p and q, set the id of p's root to the id
of q's root. (only one value changes)

```java
public class QuickUnionUF {

  private int[] id;

  public QuickUnionUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  private int root(int i) {
    if (i == id[i]) return i;
    else            return root(id[i]);
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }
}
```

algorithm   | initialize | union | find
------------|------------|-------|------
quick-find  | N          | N     | 1
quick-union | N          | N     | N

* Quick-find defect:
  - Union too expensive (N array accesses)
  - Trees are flat, but too expensive to keep them flat.

* Quick-union defect:
  - Trees can get tall.
  - Find too expensive(could be N array accesses)

## Weighted quick-union [improvement]

- Modify quick-union to avoid tall trees.
- Keep track of size of each tree (number of objects)
- Balance by linking root of smaller tree to root of larger tree.

Quick-union average distance to root: 5.11
Weight quick union avrg dstn to root: 1.52

### Java implementation

Same as quick-union, but maintain extra array sz[i] to count number of objects
in the tree rooted at i.

Find: identical to quick-union

Union: Link root of smaller tree to root of larger tree. Update sz[].

```java
public class WeightedQuickUnionUF {

  private int[] id;
  private int[] sz;

  public WeightedQuickUnionUF(int N) {
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  private int root(int i) {
    if (i == id[i]) return i;
    else            return root(id[i]);
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j) return;
    if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
    else               { id[j] = i; sz[i] += sz[j]; }
  }
}
```

### Weighted Quick-Union Analysis

* Running time:

- Find: takes time to proportional to depth of p and q
- Union: takes constant time, given roots.

Proposition: Depth of any node x is at most lgN.

algorithm   | initialize | union | find
------------|------------|-------|------
quick-find  | N          | N     | 1
quick-union | N          | N     | N
Weighted QU | N          | lg N  | lg N
