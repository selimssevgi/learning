# LIMIT

- allows us to specify exactly how many rows we want returned from result set


```sql
SELECT * FROM contacts LIMIT 5; -- return just 5 rows

SELECT * FROM contacts LIMIT 0,4; -- start from 0 and take 4

SELECT * FROM contacts ORDER BY age DESC LIMIT 1,1; -- second oldest
```
