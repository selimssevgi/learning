# One-to-One

- Can be done in two ways

1. We can share the same primary key

```sql
CREATE TABLE CAR (
  CAR_ID int(10) NOT NULL,
  NAME varchar(20) DEFAULT NULL,
  COLOR varchar(20) DEFAULT NULL,
  PRIMARY KEY (CAR_ID)
)

CREATE TABLE ENGINE (
  CAR_ID int(10) NOT NULL,
  SIZE varchar(20) DEFAULT NULL,
  MAKE varchar(20) DEFAULT NULL,
  MODEL varchar(20) DEFAULT NULL,
  PRIMARY KEY (CAR_ID),
  FOREIGN KEY (CAR_ID) REFERENCES car (CAR_ID) -- connecting both PKs
)
```

2. Using FK

- Recommended

```sql
CREATE TABLE CAR_V2 (
  CAR_ID int(10) NOT NULL,
  ENGINE_ID int(10) NOT NULL,
  COLOR varchar(20) DEFAULT NULL,
  NAME varchar(20) DEFAULT NULL,
  PRIMARY KEY (CAR_ID),
  CONSTRAINT FK_ENG_ID FOREIGN KEY (engine_id) REFERENCES ENGINE_v2 (ENGINE_ID)
)

CREATE TABLE ENGINE_V2 (
  ENGINE_ID int(10) NOT NULL,
  MAKE varchar(20) DEFAULT NULL,
  MODEL varchar(20) DEFAULT NULL,
  SIZE varchar(20) DEFAULT NULL,
  PRIMARY KEY (ENGINE_ID)
)
```
