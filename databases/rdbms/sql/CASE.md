# Case

- Two UPDATE statements may change the same column's value. Order matters

```sql
UPDATE table_name
SET new_colum =
  CASE
    WHEN column1 = somevalue1
      THEN newvalue1
    WHEN column2 = somevalue2
      THEN newvalue2
    ELSE newvalue3
  END;
```

- If there is a match found, others are skipped
```sql
UPDATE movie_table
SET category =
  CASE
    WHEN drama = 'T' THEN 'drama'
    WHEN comedy = 'T' THEN 'comedy'
    WHEN action = 'T' THEN 'action'
    WHEN cartoon = 'T' AND rating = 'G' THEN 'action'
    ELSE 'misc'
  END;
```

- WHERE clause can be added after END in CASE

- CASE can be used with other statements like SELECT, INSERT, DELETE
