# Java 8 Changes in Collections

### Iterable Interface(java.util)

- forEach(Consumer) : Convience method to replace for-loop
- spliterator() : useful if you are writing parallel recursive decomposition lib
- Does not include stream() or parallelStream(): would restrict return type to Stream
- Both methods include default implementations that should be overridden

### Collection Interface

```java
// java 7
for (Iterator<String> it = coll.iterator(); it.hasNext(); ) {
  String str = it.next();
  if (str.startsWith("A")) {
    it.remove();
  }
}

// java 8
coll.removeIf(str -> str.startsWith("A"));

// Collection.java
// default boolean removeIf(Predicate<? super E> filter)
// removeAll -> removeIf(c::contains)
// retainAll -> removeIf(((Predicate<E>) c::contains).negate())
// default Stream<E> stream()
// default Stream<E> parallelStream()
```

### List Interface

- Transforms each element in-place

```java
// Java 7
for (ListIterator<String> it = list.iterator() ; it.hasNext() ; ) {
  it.set(it.next().toUpperCase());
}

for (int i=0; i < list.size(); i++) {
  list.set(i, list.get().toUpperCase());
}

// Java 8
list.replaceAll(String::toUpperCase);

// List.java
// default void replaceAll(UnaryOperator<E> operator)
// default void sort(Comparator<? extends E> c)
// default Spliterator<E> spliterator() // Spliterator.ORDERED
```

##### List.sort

- Sorts a list in-place

- Why is this better than Collections.sort?
  - Old Collections.sort used three steps:
    1. copy into temporary array
    2. sort the array
    3. copy back to the list

- List.sort
  - default does exactly the above
  - ArrayList.sort overrides the sorts in-place - no copying.
  - Collections.sort now just calls list.sort

### Map Interface


```java
// Java 7
for (Map.Entry<String, String> entry : map.entrySet()) {
  sout(entry.getKey() + entry.getValue());
}

// Java 8
map.forEach((k, v) -> sout(k + v));

// Map.java
// default forEach(BiConsumer<? extends K, ? extends V> action)
// default replaceAll(BiFunction)
// some methods from ConcurrentMap
// default V putIfAbsent(K, V)  // no mapping or mapped to null
// default boolean remove(K, V) // specified key mapped to specified value
// default boolean replace(K, V, V)
// default T getOrDefault(K key, V defaultValue)
```

### Comparator Interface

- Anybody enjoy writing comparators?
- Comparators are difficult because there are lots of conditionals and repeated code.
- Java 8 adds static methods to Comparator that:
  - avoid repeated code
  - allow composition of arbitrary comparators to make more complex ones
  - easily create non-friendly comparators

- Comparator Example: 

two-level sort: sort by last name, then by nullable first name, null first

```java
students.sort(comparing(Student::getLastName)
             .thenComparing(Student::getFirstName),
                            nullsFirst(naturalOrder())));
```

* Two key ideas:

1. Extraction: Extract Comparable from a more complex type

```java
Comparator.comparing(Student::getLastName);
Comparator.comparingInt(Student::getAge);
```

2. Composition/Sequencing: Chain comparisons for total ordering

```java
comparator.thenComparing(Student::getFirstName());
```

Given a list of students, sort by age and sub-sort by last name and then first
name.

```java
list.sort(comparingInt(Student::getAge))
    .thenComparing(Student::getLastName)
    .thenComparing(Student::getFirstName);
```
