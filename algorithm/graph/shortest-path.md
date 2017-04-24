# Shortest Paths

*Paths:*

- Consider digraph G = (V,E), with edge weights given by function w: E -> R

- path p = v1 -> v2 -> ... -> vk,
- has weight w(p) = sum([w(v_i, v_i+1) for i in range(k)])

## Shortest Path

- Is a path of minimum weight from u to v.
- It may not be a unique path, could be more than one.

## Shortest-path Weight

- from u to v is delta(u,v) = min{ w(p):p from u to v }, p is a path.
- It is the min over the weight of each path from u to v
- If there is no path from u to v, delta(u,v) = infinity

## Negative Edge Weights

- Some shortest paths may not exist
- If there is a circle, which has minimum weight in total
- Keeping moving in that circle, total weight will decrease infinitely.

## Optimal Substructure

- It is a dynamic programming property
- A subpath of a shortest path is also a shortest path.

- Proof: Cut & Paste
- If a shorter path existed, it had been there in the first place. CONTRADICTION

## Triangle Inequality

- For all vertices u,v,x in V:
- delta(u,v) <= delta(u,x) + delta(x,v)

## Single-source shortest paths problem

- From given a source vertex s in V,
- find shortest-path weights delta(s,v) for all v in V.

- Assume w(u,v) >= 0 for all u,v in V
- Shortest paths exist provided paths exist
- delta(u,v) >= -infinity

## Greedy

- Maintain set S of vertices whose shortest-path distance from s is known.
- at each step add to S the vertex v in V-S whose estimated distance from s is min
- update distance estimates of vertices adjacent to v.

- No negative weights, so cannot go from s to s faster than 0 distance.
