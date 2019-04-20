# cond Expression

- cond expression can be used when there are more than two option

```shell
(cond
  (predicate_1 clauses_1)
  (predicate_2 clauses_2)
  (predicate_3 clauses_3)
  (else        clauses_n))
```

- Can be more than one S-exp in one clause,
- The value of S-exp is the value of the clause.
