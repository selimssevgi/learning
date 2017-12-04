# Functions

- SQL has some special keywords, called functions


## SUM

```sql
SELECT SUM(sales) FROM cookie_sales
WHERE first_name = 'Nicole';
```

## AVG


```sql
SELECT first_name, AVG(sales)
FROM cookie_sales
GROUP BY first_name;
```

## MIN

```sql
SELECT min(sales)
FROM cookie_sales;
```

## MAX

```sql
SELECT max(id)
FROM table_name;
```

## COUNT

- Return the number of rows in a column

- If the value is NULL, it isn't counted

```sql
SELECT COUNT(test_chars)
FROM ordering;

SELECT COUNT(DISTINCT sale_date)
FROM cookie_sales;
```

## DISTINCT

- not function, is a keyword, no need for parentheses

```sql
SELECT DISTINCT sale_date
FROM cookie_sales
ORDER BY sale_date;
```
