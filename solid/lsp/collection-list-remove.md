# JDK Liskov Substitution Violation

- Collection#remove(Object o);

- List#remove(int index);

```java
Collection<Integer> list = new ArrayList<Integer>() {
  {
    add(1); add(2); add(3);
  }
};

sout(list); // [1, 2, 3]
list.remove(1);
sout(list); // [2, 3]
```

```java
var list = new ArrayList<Integer>() {
  {
    add(1); add(2); add(3);
  }
};

sout(list); // [1, 2, 3]
list.remove(1);
sout(list); // [1, 3]
```
