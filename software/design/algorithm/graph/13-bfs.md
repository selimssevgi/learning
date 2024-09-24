# Graph

- G = (V, E)

- V = set of vertices
- E = set of edges
  - UNDIRECTED e = {v, w} unordered pairs
  - DIRECTED   e = (v, w) ordered pairs

- There is no requirement to have edges in a graph. It can be without edges.

```shell
#        x1
#    x2
#              x3
```

- Two nodes/vertices xi,xj are *adjacent* if {xi, xj} is an edge.
- An edge e = {xi, xj} is *incident* to xi, xj. xi --e--xj
- The number of edges incident to a node is the *degree* of the node.
- A graph is simple if it has no loops & multiple edges.

```shell
#    a----b
#    |   /|
#    |  / |
#    | /  |
#    c----d

# UNDIRECTEd
# V = {a, b, c, d}
# E = { {a, b}, {b, c}, {c, d}, {a, c}, {b, d} } 
```

- What are the neighbors of a?
- You'd have to go through the entire edge list to figure out them. Linear time.
- A better representation adjacency table.

```shell
#       a
#     /   \
#    ^     v
#   /       \
#  b====<>===c

# DIRECTED
# E = { (a,c), (b,c), (c,b), (b,a) }
```

**Applications:**
- Web crawling - keep following links - BFS to priotirise
- Social networks - friends of friends
- Network broadcast
- Garbage collection - removes variables cannot be reached - BFS
- Model checking - states - BFS
- Solving puzzles & games


## Pocket Cube: 2x2x

- Configuration graph
  - Vertex for each possible state of cube. # vertices = 8! x 3^8 =~ 264 Million
  - Edge for each possible move - move is undoable. Undirected.

## Graph Representation

- Adjencency lists:
  - Array Adj of |V| linked linked
  - Adj[u] tells where you can go from u


```shell
Adj[b] = {a, c}
Adj[a] = {c}
Adj[c] = {b}
```

- Object-oriented way:
  - v is object
  - v.neighbors -> adj[v]

- Implicit representation:
  - adj(u) is a function
  - v.neighbors is a method

## Breadth-First Search (BFS)

- Goal: visit all nodes reachable from given node s
- O(V+E) time
- Look at the nodes reachable in 0 moves{s}, 1 moves{adj[s]}, 2 moves, 3 moves...
- Careful to avoid duplicates (cycle)

```python
def BSF(s, Adj):
  level = {s: 0}
  parent = {s: None}
  i = 1
  frontier = [s]
  while frontier:
    next = []
    for u in frontier:
      for v in Adj[u]:
        if v not in level:
          level[v] = i
          parent[v] = u
          next.append(v)

    frontier = next
    i += 1
```
