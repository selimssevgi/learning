# Create Table

- DESC table_name: shows the properties of columns as a table
- 'SHOW CREATE TABLE table_name': show exact script used to create the table

```sql
CREATE TABLE doughnut_list (
  doughnut_name VARCHAR(10),
  doughnut_type VARCHAR(6)
);
```

- Some columns must not have null values.

```sql
-- can say contact_id is PRIMARY KEY on the same line, too

CREATE TABLE my_contacts (
  PRIMARY KEY (contact_id),
  contact_id INT NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL,
  birthday DATE NOT NULL,
  profession VARCHAR(50),
  location VARCHAR(50),
  status VARCHAR(50) NOT NULL,
  interests VARCHAR(100),
  seeking VARCHAR(100)
);
```

```sql
CREATE TABLE drinks (
  drink_name VARCHAR(20) NOT NULL,
  main VARCHAR(20) NOT NULL,
  amount1 DEC(2, 1) NOT NULL,
  second VARCHAR(20) NOT NULL,
  amount2 DEC(2, 1) NOT NULL,
  directions VARCHAR(50) NOT NULL
);
```

## Null

- null is undefined
- cannot be compared to anything else, even itself
- if none value is provided, default value is null

## Default Values

- if not specified, all default values are NULL
- Even so, better to document them to be more specific, add DEFAULT NULL

```sql
CREATE TABLE doughnuts (
  doughnut_type VARCHAR(50) NOT NULL,
  doughnut_cost DEC(3,2) NOT NULL DEFAULT 1.00
);
```

## Foreign Key

- DESC interests

- MUL means that multiple occurrences of the same value may be stored in this
  column. This is what allows use to keep track of MULtiple interest for each
  contact_id in contacts table

```sql
CREATE TABLE interests (
  interest_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  interest VARCHAR(50) NOT NULL,
  our_fk INT NOT NULL, -- add a normal column
    CONSTRAINT parenttable_columnname_fk FOREIGN KEY (our_fk)
    REFERENCES parenttable (parenttable_column)
);
```

```sql
CREATE TABLE interests (
  interest_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  interest VARCHAR(50) NOT NULL,
  contact_id INT NOT NULL,
    CONSTRAINT contacts_contact_id_fk FOREIGN KEY (contact_id)
    REFERENCES contacts (contact_id)
);
```
