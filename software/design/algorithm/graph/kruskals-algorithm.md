# Kruskal's Algorithm

- Used to find a minimum spanning tree(MST)
- It uses disjoint-set(Union-Find).
- https://www.youtube.com/watch?v=5xosHRdxqHA

## Algorithm

```shell
MST-KRUSKAL(V, E):
  A <- {} # empty set
  for v in V:
    MAKE-DISJOINT-SET(v)
  Sort E by weight increasingly
  for (v1, v2) in E:
    if FIND(v1) != FIND(v2):
      A = A + {(v1, v2)}
      UNION(v1, v2)

  return A
```
