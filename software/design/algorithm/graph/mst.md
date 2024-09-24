# Minimum Spanning Trees

- One of the world's most important algorithms.
- It is important in distributed systems, one of the first things that almost
  any DS tries to find is a MST of the nodes that happened to be alive at any point.


## Problem

*Input:*

- Connected, undir-graph G = (V,E) with weight function w: E -> R
- For simplicity, assume all edge weights are distinct.
- w function is injective. one to one.

*Output:*

- A spanning tree T (connects all vertices) of minimum weight.
- w(T) = T.getEdges.map((u,v) -> w(u,v)).sum

Ex: https://www.youtube.com/watch?time_continue=1&v=FPEMBWg_WlY&t=30

- Optimal Substructure CHECK
- Overlapping Subproblems CHECK (remove different edges creates similar subproblems)
- These properties suggest that DP could be used.

- BUT, it turns out that MST exhibits an even more powerful property.

*Hallmark for greed algorithms:*

- Greedy-choice property: A locally optimal choice is globally optimal.
- If this third property exists, greedy algorithm approach is better than DP.

* See: Prim's and Kruskal's algorithm.
