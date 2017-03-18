# Immutable vs Mutable

## Advantages of Immutable Objects

- Easier to reason about, they do not have complex spaces that change over time.
- Pass them around quite freely, instead of defensive copies
- No state curroption or race condition problems in multi-threaded environment
- Safe hash table keys, (no access in case of mutated key)

## Disadvantage of Immutable Objects

- They sometimes require that a large object graph be copied where otherwise an
  update could be done in place. Mutable alternatives, String, StringBuilder.
