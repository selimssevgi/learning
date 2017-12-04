# No Join

- Simplest kind of join

- It has several different names
  - Cartesian join,
  - Cartesian product,
  - Cross product,
  - Cross join,

- A Cartesian join is a type of inner join

```sql
toys(toy_id, toy)
boys(boy_id, boy)

SELECT t.toy, b.boy FROM toys AS t
CROSS JOIN boys AS b;

-- 5 * 4 = 20 results

-- another syntax for the same thing
SELECT toys.toy, boys.boy FROM toys, boys;

SELECT b1.boy, b2.boy FROM boys AS b1 CROSS JOIN boys AS b2;
```

