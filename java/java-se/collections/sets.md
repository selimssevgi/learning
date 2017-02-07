# Set Implementations

- HashSet - based on HashMap
- TreeSet - based on TreeMap
- EnumSet -



```java
public boolean equals(Object o) {
  //...
  return Objects.equals(name, product.name);
}
public int hashCode() {
  return Objects.hash(field1, field2);
}
```

### Algorithmic Performance

XXXXXX  | add        | contains   | next 
--------|------------|------------|------
HashSet | O(N), D(1) | O(N), D(1) | O(Capacity/N)
TreeSet | O(logN)    | O(logN)    | O(logN)
EnumSet | O(1)       | O(1)       | O(1)

