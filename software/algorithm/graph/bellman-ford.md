# Bellman-Ford Algorithm

- Used to find shortest path in negative weighted graphs
- It is a polynomial time algorithm

## General Shortest Path Algorithm

```shell
for v in V:
  d[v] <- infinity
  pred[v] <- NIL

d[s] <- 0 # starting vertex
Repeat: select edge [somehow]
  Relax edge (u,v,w)
  until you cannot relax any more
```

## Problems with above algorithm:

1. Complexity could be exponential time (even for positive edge weights)
   - Relaxtion would be exponential

2. Will not even terminate  if there is a negative weight cycle reachable from
   the source.

- Dijsktra solves the problem number 1
- Bellman-ford solves also the problem number 2

## PseudoCode

```shell
Bellman-Ford(G,W,s)
  Initialize()
  for i = 1 to (|V| - 1)
    for each edge (u,v) in E
      Relax(u,v,w)

  # check
  for each edge (u,v) in E
    if d[v] > d[u] + w(u,v)
      then report negative cycle exists

Relax(u,v,w)
  if d[v] < d[u] + w(u,v)
    d[v] = d[u] + w(u,v)
    pred[v] = u
```

## Complexity

- O(VE) + O(E) => O(VE); E = O(V^2); could be O(V^3)!!
- We dont have requirements like Dijkstra and priority queue

- Use dijkstra if you can!
