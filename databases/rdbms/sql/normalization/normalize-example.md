# Normalization Example

- ALTER, SELECT, UPDATE can be used to normalize an existing table

```sql
CREATE TABLE xcontacts (
  location VARCHAR(50)
);

INSERT INTO xcontacts (location) VALUES
  ('Seattle, WA'),
  ('Natchez, MS'),
  ('Las Vages, NV'),
  ('Palo Alto, CA'),
  ('NYC, NY');

SELECT * FROM xcontacts;

-- if we want to query by state or city name, we need to normalize this table

ALTER TABLE xcontacts
  ADD COLUMN city VARCHAR(30),
  ADD COLUMN state VARCHAR(20);

UPDATE xcontacts SET state = RIGHT(location, 2); -- from right take two char

-- take characters until first comma

UPDATE xcontacts SET city = LTRIM(substring_index(location, ',', 1));

-- no need to use WHERE clause, we want to change all columns
```
