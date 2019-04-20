## 1NF

1. Each row of data must contain atomic values

2. No repeating groups of data

- Each row of data must have a unique identifier, known as a Primary Key


```sql
-- violates RULE#1

INSERT INTO table (colors) VALUES ('white, green, blue');

-- violates RULE#2

INSERT INTO table (color1, color2, color3) VALUES ('white', 'green', 'blue');

toys(toy_id, toy);
colors(toy_id, color);
```
