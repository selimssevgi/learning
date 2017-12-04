# EXCEPT

- returns only those columns that are in the first query, but NOT in the second one


```sql
SELECT title FROM job_current
EXCEPT
SELECT title FROM job_desired;
```
