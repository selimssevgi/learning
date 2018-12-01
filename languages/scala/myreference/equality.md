# Equality in Scala

- == and equals() are same in Scala
- === can be used for reference equality 

```scala
1 == 2 // false
2 == 2 // true
1 != 2 // true
```

- These operations apply to all objects not just primitive types.

```scala
List(1, 2) == List(1, 2)   // true

// it works even when the types are different
1 == 1.0                   // true
List('h', 'e') == "he"     // false
List(1, 2, 3) == "Hello"   // false
```

- It work even with null. Check left-side first if it is not null, then calls equals method.

```scala
// it works even with null, no exception is thrown
List(1, 2) == null         // false
null == List(1, 2, 3)      // false
```

- SEE: 'eq' and 'ne'
