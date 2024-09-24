# Collection Factory Methods

- All collection factorty methods return immutable collections.

* List.of

```java
List<Integer> ints = List.of(1, 2, 3);
// ints.add(5); // throws UOE
System.out.println(ints.getClass());
System.out.println(List.of().getClass());
System.out.println(List.of(1).getClass());
```

* Set.of

```java
Set<String> strings = Set.of("a", "b");
// Set.of("a", null); // NPE
// Set.of("a", "a"); // IAE: duplicate element
```

* Map.of

```java
Map<String, Integer> map = Map.of("one", 1, "two", 2);
System.out.println(map.getClass());

// Map.of("one", 1, "one", 2); // IAE: duplicate key

Map<String, String> map1 = Map.ofEntries(Map.entry("a", "b"));
System.out.println(map1.getClass());
```
