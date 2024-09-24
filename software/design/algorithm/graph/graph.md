# Graphs

*Digraph: Directed Graph*

- G = (V, E)
- Set V of vertices (singular: vertex)
- Set E <=(subset of) VxV of edges

*Undirected Graph*

- E contains unordered pairs


- |E| = O(V^2) # |E| => # of edges, |V| => # of vertices
- G connected => |E| > |V| - 1
- Connected: there is a path from any vertex to any other vertex
- lg|E| = Teta(lgV) => polynomially related

## Graph Representations

- Adjacency Matrix(better for dense graphs)
- Adjacency List(better for sparse graphs)

- Adjacency is a relation between two vertices.
- Incidence is a relation between a vertex and an edge.

*Adjacency matrix*

- G = (V, E), where V = {1,2,...,n}, is the nxn matrix A given by:
- A[i,j] = {1 if (i,j) in E, 0 if (i,j) not in E}
- If there is an edge between i and j, put 1; otherwise 0.
- In case of weighted graphs, replace 0 or 1 with weights of the edge.

```shell
V = {1, 2, 3, 4}

E = ((1,2), (2,3), (1,3), (4,3))

A | 1 2 3 4
-----------
1 | 0 1 1 0
2 | 0 0 1 0
3 | 0 0 0 0
4 | 0 0 1 0

Storage => O(V^2) => dense representation
```

- Linkedlist is sparse graph.
- A tree is sparse graph.
- Complete graph is dense graph.

*Adjacency list*

- It is better than matrix in terms of storage for sparse graphs.
- Adjacency list of v in A is the list Adj[v] of vertices adjacent to v

```shell
Adj[1] = {2, 3}
Adj[2] = {3}
Adj[3] = { }
Adj[4] = {3}

Storage: |Adj[v]| = { degree(v) (undirected) }
                    { out-degree(v) (directed) }
```

## Handshaking Lemma:

- Undirected graph
- Dinner party, host tries to find out how many handshaking took place.
- One handshake, two persons. Each person will count it as one handshake.
- V.map(v -> degre(v)).sum = 2|E|
- One edge connects two vertices.

- For undir-graph, that implies that the adjacency list representation uses:
  - Teta(V + E) storage. adj[1] -> v, and edges
- Same asymtotically for digraphs.
- V.map(v -> out-degre(v)).sum = E
- Amortized analysis.

- Sparse representation is often better than adjacency matrix.
- Imagine WWW were done with adj matrix as opposed to, adj list type repr.
- logV bits could be used to represent adj in lists.

* CLSR - Appendix B
