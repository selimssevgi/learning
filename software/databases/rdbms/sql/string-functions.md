# String Functions

- Text values and values stored in CHAR or VARCHAR columns are known as strings

- String functions do NOT change the data stored in your table; they simply
  return the altered strings as a result of your query

### Select a specified number of characters from a column

```sql
-- take to chars of location column counting from RIGHT side

SELECT RIGHT(location, 2) FROM contacts;

SELECT LEFT(location, 2) FROM contacts;
```

### Select everything until a character 

```sql
-- select all characters until the first comma

SELECT SUBSTRING_INDEX(location, ',', 1) FROM contacts;
```


```sql
-- (str, start_position, length)

SELECT SUBSTRING('Relation', 5, 4); -- tion

SELECT UPPER('rdbms'); -- RDBMS

SELECT REVERSE('lqs'); -- sql

SELECT RTRIM('food  ')
```
