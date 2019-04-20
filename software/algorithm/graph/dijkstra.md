# Dijkstra Algorithm

- https://www.youtube.com/watch?v=xhG2DyCX3uA
- It is a greedy algorithm
- It is iterative
- Used to find shortest path
- Goes vertex by vertex
- Used with directed-graps

- It works with non-negative weights
- It doesnt work with negative weights: see bellman-ford


## PseudoCode

```shell
Dijkstra(G,W,s) # G: vertices, W: weights, s: starting vertex
  Initailize(G,s) # priorities are the d() values, others are infinity
  S <- null # (a set of vertices that we know the shortest paths to),
  Q <- V[G] # (a set of vertices need to be processed), Q is a priority queue
  while Q != EMPTY
    u <- EXTRACT-MIN(Q) # delete u from Q, d[x], estimates distance is the key
    S <- S U {u}
    for each vertex v in Adj[u]:
      Relax(u,v,w) # reconstruct Q, cus key increases, decrease key op

Initalize(G, s):
  d[s] <- 0 # d[x]: distance estimates from s to x
  for each v in (V - {s}):
    d[v] <- infinity

Relax(u, v, w):
  if d[v] > d[u] + w(u,v)
    d[v] = d[u] + w(u,v)
    pred[v] = u
```

## PlainText

- Get a starting point/vertex and set it to 0, A vertex, d[A] <- 0
- Set all other vertices to infinity
- S is empty => S <- {}
- Q has all vertices => Q <- {A, B, C, D, E}
- Extract-Min vertex from the Q, u <- A
- Add it to S => S <- {A}
- Relax the edges coming out of A
- Repeat until no vertix in Q

## Complexity

- Teta(V) inserts into the priority Queue
- Teta(V) extract-min operations
- Teta(E) decrease-key operations

- Time: Teta(V).T-extract-min + Teta(E).T-decrease-key

* Picking an ADT(Abstract Data Type)

                   | Arrays    |  Bin-Min-Heap      | Fibonacci Heap
------------------------------------------------------------------------
Teta(V) - extract  | Teta(V)   |  Teta(logV)        | Teta(logV)
Teta(V) - decrease | Teta(1)   |  Teta(logV)        | Teta(1)
Teta(E) - insert   | Teta(V^2) |  Teta(vlgv + ElgV) | Teta(VlgV + E)

* Teta(V.V + E.1) = Teta(V^2)
* O(E) = O(V^2); each vertex can have V-1 edges
