# Prim's Algorithm

*Idea:*

- Maintain V-A as a priority queue: Q
- Key each vertex in Q with weight of the least weight edge connecting it to a
  vertex in A.

## Algorithm

```shell
MST-PRIM(G,w,s): # G: graph, w: weight, s: starting vertex
  for v in V:
    key[v]  <- infinity
    pred[v] <- NIL

  key[s] <- 0 # for an arbitrary s in V
  Q      <- V # a set of vertices
  while Q != EMPTY
    u <- EXTRACT-MIN(Q)
    for v in Adj[u]:
      if v in Q and w(u,v) < key[v]:
        key[v]  <- w(u,w) # implicit decrease-key operation
        pred[v] <- u
  return {(v, pred[v])}
```

## Analysis

- First loop: Teta(V)
- While loop: V
- How many implicit decrease-key? Handshaking: sum of degrees: Teta(E)
- Time: Teta(V.T_extract-min + E.T_decreased-key)

## Possible Data Structures

Q           | T_extract-min | T_decreased-key | Total
---------------------------------------------------------
Array       | O(V)          | O(1)            | O(V^2)
Binary Heap | O(lgV)        | O(lgV)          | O(ElgV)
Fib Heap    | O(lgV)        | O(1)            | O(E + VlgV)

* Total of amortized cost is an upper bound on the true costs(worst case)
