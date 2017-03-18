# Scala Collections

## Abstract
- Traversable[A]
  - Iterable[A]
    - Set[A] <- BitSet[A], SortedSet[A]
    - Seq[A] <- IndexedSeq[A], LinearSeq[A]
    - Map[A,B]

## scala.collection.immutable

- Set[A] <- HashSet[A], List[A]
- SortedSet[A] <- TreeSet[A]

- IndexedSeq[A] <- NumericRange[T], StringOps, PagedSeq[A], Range, Vector[A]
- LinearSeq[A] <- List[A], Queue[A], Stack[A], Stream[A]

- Map[A,B] <- HashMap, IntMap, LongMap, ListMap
- SortedMap <- TreeMap
