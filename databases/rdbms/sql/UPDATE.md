# Update Statement


```sql
UPDATE doughnut_ratings
SET
type = 'glazed'
WHERE type = 'plain glazed'
```

- one more than column value

```sql
UPDATE table_name
SET
first_column = 'new_value',
second_column = 'another_new_value'
WHERE <condition>; -- single or multiple row update
```

- Arithmetic operations can be done while setting new values

```sql
UPDATE drinks
SET cost = cost + 1
WHERE drink_name IN ('Blue Moon', 'B', 'C');
```

## From one colum to multiple columns

- interests: first, second, third, fourth

```sql
UPDATE contacts SET
interest1 = SUBSTRING(interests, ',', 1),
interests = SUBSTR(interests, LENGTH(interest1) + 2),
interest2 = SUBSTRING(interests, ',', 1),
interests = SUBSTR(interests, LENGTH(interest2) + 2),
interest3 = SUBSTRING(interests, ',', 1),
interests = SUBSTR(interests, LENGTH(interest3) + 2),
interest4 = interests;
```
