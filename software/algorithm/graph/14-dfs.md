# Depth-First Search -  Topological Sort

- BFS search is good that it explores things layer by layer.
- Exploring layer by layer gives us shortest paths.
- If you cannot get from S to your vertex, then the shortest way to get there is
  infinity. And BFS is good for detecting that, it can tell you which vertices
  are unreachable from S.

- DFS can do what BFS does, but it is often used to explore the whole graph, not
  just the part reachable from S.

## DFS

- Recursively explore graph, backtracking as necessary
- Careful not to repeat

```python
parent = {s: None}

DFS-Visit(V, Adj, s):
  for v in Adj[s]:
    if v not in parent:
      parent[v] = s
      DFS-Visit(V, Adj, u)

DFS(V, Adj):
  parent = {}
  for s in V:
    if s not in parent:
      parent[s] = None
      DFS-Visit(V, Adj, s)
```
