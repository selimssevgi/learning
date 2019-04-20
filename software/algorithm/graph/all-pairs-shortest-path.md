# All Pairs Shortest Path

- [MIT Lecture] (https://www.youtube.com/watch?v=NzgFUwOaoIw)
- dynamic programming
- maxtrix multiplication
- Floyd-Warshall algorithm
- Johnson's algorithm
- difference constraint

## Recall

- Single-source shortest paths
- given directed graph G = (V,E), vertex s in E, edge weights w: E -> IR
- find delta(s,v) = shortest path weight s -> v

Situation             | Algorithm      | Time        | E=V      | E=V^2 |
----------------------|----------------|-------------|----------|--------
unweighted            | BFS            | O(V+E)      | O(V)     | O(V^2)
nonnegative weight    | Dijkstra       | O(VlgV + E) | O(VlgV)  | O(V^2)
general               | Bellman-Ford   | O(VE)       | O(V^2)   | O(V^3)
DAGs                  | topo. sort + BF| O(V+E)      |

## All-Pairs Shortest Path

- given G = (V,E,w) find delta(u,v) for all u,v in V
- all shortest path between two points are precomputed
- googlemaps, internet routing

- to solve all-pairs shortest paths is just run the single source algorithm V times, once for each source

Situation             | Algorithm      | Time        | E=V      | E=V^2 |
----------------------|----------------|-------------|----------|--------
unweighted            | BFS            | O(V+E) X V  | O(V)     | O(V^2)
nonnegative weight    | Dijkstra       | O(VlgV+E)x V| O(VlgV)  | O(V^2)
general               | Bellman-Ford   | O(VE) X V   | O(V^2)   | O(V^3)
general               | Johnson's      | O(V^2lgV+VE)| O(V^2)   | O(V^3)

## Dynamic Programming

1. subproblems : delta(u, v) = weight of shortest path u -> v using max m edges
2. guessing    : what's the last edge?
3. recurrence
4. acyclic(topological order)
5. original problem

- if dvv(diagonal in nxn matrix) is negative, that means there is a
  negative-weight cycle
