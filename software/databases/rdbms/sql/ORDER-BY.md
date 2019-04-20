# ORDER BY

- SELECT something and ORDER the data it returns BY another column from the table

- ORDER BY allows you to alphabetically order any column

- Numbers show up 'before' text characters

- NULL show up before anything

- UPPERCASE characters show up 'before' lowercase characters

- Oldest dates comes first

- Dates are sorted by year, month, daye

- by default, ORDER BY is ASCENDING (A-Z, 1-100)

- ORDER BY column_name ASC|DESC

```sql
SELECT title, category
FROM movie_table
WHERE
category = 'family'
ORDER BY title; -- A-Z
```

- the titles that have numerics in the beginning will come first

## Order with many columns

- Data will be ordered by category first, then by purchased date

```sql
SELECT title, category, purchased
FROM movie_table
ORDER BY category, purchased;
```

## Reverse the order

```sql
SELECT title, purchased
FROM movie_table
ORDER BY title ASC, puchased DESC;
```
