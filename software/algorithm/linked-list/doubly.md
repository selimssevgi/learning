# doubly linked list

- holds references both for next and prev

- in order to avoid some special cases when operating on borders, introduce dummy nodes
  - header
  - tailer
  - in empty list header and tailer refers to each other
  - header and tailer nodes never changes, just nodes in between
  - insertion/deletion will be handled always same, as they will always have neighbour nodes
