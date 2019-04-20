# Select

- * mean that give back values from 'all' of the columns

```shell
SELECT * FROM my_contact
WHERE first_name = 'Anne';
```


```shell
WHERE second = "orange juice"; -- use single quotes

WHERE amount2 < '1'; -- RDBMS treats it DEC or INT anyway
```

## Format the data type correctly

- CHAR: single quotes
- VARCHAR: single quotes
- INT or DEC: no quotes
- DATE: single quotes
- DATETIME/TIME/TIMESTAMP: single quotes
- BLOB: single quotes

## Select Specific Columns

```sql
SELECT drink_name, main, second
FROM easy_drinks
WHERE main= 'soda';
```

## Combining Queries


```sql
SELECT location
FROM doughnut_ratings
WHERE type = 'plain glazed'
AND rating = 10;
```

## Comparison Operators


```sql
-- equal =
-- not equal <>
-- <, >
- <=, >=
```

- Text comparison works alphabetically


```sql
-- drink names that start with C and other letters following C
SELECT * FROM drinks WHERE drink_name >= 'C';
```
