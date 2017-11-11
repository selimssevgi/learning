# Position Filters

- The first index in a set of element is always 0
- even and odd are related to the index of the elements within the set, not their position
- even indexes (0, 2, so on)
- n can be negative, to go backward

Selector | Description |
---------|-------------|
:first   | first match within the context, li a:first
:last    | li a:last, last anchor that's a descendant of a list item
:even    | li :even, returns every even indexed list item
:odd     | li :odd
:eq(n)   | selects the nth matching element
:gt(n)   | selects the elements after the nth matching element (n excluded)
:lt(n)   | before the nth matching element (the nth element is excluded)
