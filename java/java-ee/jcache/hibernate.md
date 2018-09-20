# Caching in Hibernate

- Hibernate has 1st level cache, in the same session, it has to return the same
  object for the same id.

```shell
boat1 = session.get(Boat.class, id);
boat2 = session.get(Boat.class, id);
boat1 == boat2 # is true
```

## 2nd level cache

- 4 strategies

1. ReadOnly
2. ReadWrite
3. NonStrictReadWrite
4. Transactional
