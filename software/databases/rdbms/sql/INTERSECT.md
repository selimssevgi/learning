# INTERSECT

- return only those columns that are in the first query and also in the second one

```sql
SELECT title FROM job_current
INTERSECT
SELECT title FROM job_desired;
```
