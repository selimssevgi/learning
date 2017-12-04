# Insert

- The values in the second set of parentheses have to be in the same order as
  the column names


```sql
INSERT INTO table_name (column_name1, column_name2)
VALUES (value_1, 'value_2');
```

## Variation on an INSERT Statement

1. Changing the order of columns


```sql
INSERT INTO table_name (column_name2, column_name1)
VALUES ('value_2', value_1);
```

2. Omitting column names

- there must be all values, in same column order

```sql
INSERT INTO table_name VALUES (value_1, 'value_2');
```

3. Leaving some columns out


```sql
INSERT INTO table_name (column_2)
VALUES ('value_2');
```
