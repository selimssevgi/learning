# Atomic Data

- smallest pieces of data that can't or shouldn't be divided

- Pizza delivery need street and address together

```sql
order | address
125   | 59 N.Ajax Rapids
```

- A realtor may need street number to query all houses on a street

1. What is one thing your table describes?
2. How will you use the table to get at the one thing?
3. Do your columns contain atomic data to make your queries short and to the
   point?

- Accurate table(no duplicates) and faster queries

## Rules

1. A column with atomic data can't have several values of the same type of data
   in that column

```sql
INSERT INTO contacts (INTERESTS) VALUES ('hiking, biking')

food_name | ingredients
salad     | lettuce, tomato, cucumber
```

2. A table atomic data can't have multiple columns with the same type of data

```sql
drink | main | amount1 | second | amount2 | description

-- main and second are the same type of data

teacher | student1 | student 2 | student3
```
