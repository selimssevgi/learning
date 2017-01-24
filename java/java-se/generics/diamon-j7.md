# Diamond Syntax

* Before Java 7, things inside <> can get ugly.

```java
List<Integer> list = new ArrayList<Integer>();

Map<Integer, Map<String, String>> usersLists =
             new HashMap<Integer, Map<String, String>>();
```

* with Java 7, the type on right side is inferred.

```java
List<Integer> list = new ArrayList<>();

Map<Integer, Map<String, String>> usersLists = new HashMap<>();
```
