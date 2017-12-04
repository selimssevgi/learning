# Self Join

- use a self-join to simulate having two tables

```sql
-- a clown has a clown boss

SELECT c1.name, c2.name AS boss
FROM clown_info c1
INNER JOIN clown_info c2
ON c1.boss_id = c2.id;
```
