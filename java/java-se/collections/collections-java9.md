# Java 9 Collections Enhancements

- Collections are at "arm's length" from the Java language
  - many other languages have collections built-in
  - Java's only built-in aggregation constructs are arrays and classes
  - higher-level collection features are delegated to libraries
  - binding language and collection libraries too tightly created design discomfort

### Convenience Factory Methods for Collections

- Library only alternative to collection literals

- Main goals:
  - convenience and brevity
  - space efficiency
  - immutability


```java
List.of();
List.of(e1);
List.of(e1, e2);        // overloads up to ten elements
List.of(elements...);

Set.of();
Set.of(e1);
Set.of(e1, e2);         // overloads up to ten elements
Set.of(elements...);

Map.of();
Map.of(k1, v1);
Map.of(k1, v1, k2, v2); // overloads up to then key-value elements
                        // no var-args

Map.of(entry(k1,v1), entry(k2,v2), ...); // varargs
```


```java
// Java 8
List<String> stringList = Arrays.asList("a", "b", "c");
Set<String>  stringSet  = new HashSet<>(Arrays.asList("a", "b", "c"));
Map<String, Integer> stringMap = new HashMap<>();
stringMap.put("a", 1);
stringMap.put("b", 2);
stringMap.put("c", 3);

// Java 9
List<String> stringList = List.of("a", "b", "c");
Set<String>  stringSet  = Set.of("a", "b", "c"));
Map<String, Integer> stringMap = Map.of("a", 1, "b", 2, "c", 3);
```

## Immutability

- Collections returned by the new static factory methods are immutable
- "Conventional" immutability, not "immutable persistent"
  - attemps to add, set or remove throws UnsupportedOperationException
- Immutability is good.
  - common case: collection initialized from known values, never changed
  - automatically thread-safe
  - provides opportunities for efficiency, especially space

- No general-purpose immutable collections exist in JDK.
  - unmodifiable wrappers are a poor substitute

### Randomized Iteration Order
- make iteration order predictably unpredictable
- iteration order will be stable within a JVM instance
- but will change from one run to the next
- Applies only to new collections implementations
