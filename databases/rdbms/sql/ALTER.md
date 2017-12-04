# ALTER

- Can be used to make changes to an existing table

- allows you to change almost everything in the table without having to reinsert data

* CHANGE: name and data type of a column
* MODIFY: data type of a column
* DROP COLUMN
* RENAME TO: rename table name

```sql
ALTER TABLE clown_info
  ADD COLUMN id INT NOT NULL AUTO_INCREMENT FIRST,
  ADD PRIMARY KEY (id);
```

- FIRST, make the column the first one
- Adds id to existing records

## Add a new column

- adds at the end

```shell
ALTER TABLE contacts
ADD COLUMN phone VARCHAR(10);
```

- after specified column

```sql
ALTER TABLE contacts
ADD COLUMN phone VARCHAR(10)
AFTER first_name;
```

## Rename table

```shell
ALTER TABLE projekts
RENAME TO project_list;
```

## Change a column

```sql
ALTER TABLE project_list
CHANGE COLUMN number -- number INT,
  project_id INT NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY(project_id);
```

```shell
ALTER TABLE project_list
CHANGE COLUMN descriptionofproject
  project_desc VARCHAR(100),
CHANGE COLUMN contractoronjob
  contractor_name VARCHAR(50);
```

- Carefult when changing the data type, may result in losing data
- VARCHAR(10) -> CHAR(1) : 'Bob' -> 'B'

## Change data type of a column

- can use CHANGE COLUMN with giving same column name
- easier to use MODIFY COLUMN

```sql
ALTER TABLE project_list
    CHANGE COLUMN project_desc project_desc VARCHAR(120);

ALTER TABLE project_list
    MODIFY COLUMN project_desc VARCHAR(100);
```

*NOTE:* Cannot change the order of columns after table is created. Though can
specify the order of columns in result while querying. SELECT c3, c2 ...

- Can use many ALTER operation by separating them by comma

```sql
ALTER TABLE project_list
  ADD COLUMN phone_number VARCHAR(10),
  ADD COLUMN start_date DATE,
  ADD COLUMN est_cost DEC(3,2);
```

## Drop a column

- remove unnecessary column to save up space and increase speed

```sql
ALTER TABLE project_list
DROP COLUMN start_date;
```
