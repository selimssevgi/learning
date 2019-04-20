# CHECK

- Check doesnot enforce data integrity in MySQL, it ignores them!

```sql
-- coins: penny, nickels, dimes, quarter

CREATE TABLE piggy_bank (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  coin CHAR(1) CHECK (coin IN ('P', 'N', 'D', 'Q'))
);
```


```sql
ALTER TABLE contacts
ADD CONSTRAINT CHECK gender IN ('M', 'F');
```

- You can use all conditions that can be used in WHERE clause

```sql
CREATE TABLE table (
  column1 INT(4) CHECK (column1 > 200),
  column2 CHAR(1) CHECK (column2 NOT IN ('x', 'y', 'z')),
  column3 VARCHAR(3)
    CHECK ('A' = SUBSTRING(column3, 1, 1) AND '9' = SUBSTRING(column3, 2, 1))
);
```
