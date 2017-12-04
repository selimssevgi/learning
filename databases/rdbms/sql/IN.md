# IN Operator


```sql
SELECT date_name FROM black_book
WHERE
rating = 'innovative'
OR
rating = 'fabulous'
OR
...;
```

- Instead of many ORs, IN operator can be used


```sql
SELECT date_name FROM black_book
WHERE rating IN ('innovative', 'fabulous', 'delightful');
```

- NOT IN 

```sql
SELECT date_name FROM black_book
WHERE rating NOT IN ('innovative', 'fabulous', 'delightful');
 
```
