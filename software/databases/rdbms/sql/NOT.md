# NOT

- Can be used with other operator to change their meaning

- It should go after WHERE


```sql
WHERE NOT calories BETWEEN 30 AND 60;

WHERE NOT date_name LIKE 'A%'
AND NOT date_name LIKE 'B%';

WHERE main NOT IN ('soda', 'iced tea');
WHERE NOT main IN ('soda', 'iced tea');

WHERE NOT main IS NULL;
WHERE main IS NOT NULL;
```
