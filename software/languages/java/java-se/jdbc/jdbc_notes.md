# Java JDBC Overview

- What is JDBC?
- Features
- Database Support
- Architecture
- Development Process

## What is JDBC?
JDBC allows java applications to connect to a relational database.

[Java Application] <-- [JDBC] --> [local/network/cloud]

## Features
- Provides portable access to various databases
  - No need to develop code for different databases

- Call level interface to database
  - Supports ANSI SQL 2003

- You can build your own custom SQL statements
  - select, insert, update, delete
  - Complex SQL queries: inner/outer joins
  - Call stored procedures

## JDBC Architecture
- JDBC Driver
  - Provides connection to a database
  - Converts JDBC calls to for specific database

- JDBC Driver implementations
  - Provided by database vendor

#### JDBC Driver Manager
- DriverManager helps to connect an application based on the database connection string

- In JDBC 4.0. the JDBC drivers are automatically loaded based on the classpath

- Legacy JDBC 3.0 drivers have to be explicitly loaded with Class.forName(theDriverName)

#### JDBC API
- JDBC API is defined in the following packages 
  - java.sql and javax.sql

- Key classes
  - java.sql.DriverManager
  - java.sql.Connection
  - java.sql.Statement
  - java.sql.ResultSet
  - javax.sql.DataSource (for connection pooling)

#### Development Process
1. Get a connection to database
2. Create a Statement object
3. Execute SQL query
4. Process Result Set

##### Step 1: Get a connection to database
- In order to connect to database
  - Need a connection string in form of JDBC URL

- Basic syntax
```java
String DB_URL = "jdbc:<driver protocol>:<driver connection details>";
```

- Examples

Database      | JDBC URL
----------------------------------
MS SQL Server | jdbc:odbc:DemoDSN
Oracle        | jdbc:oracle:thin@myserver:1521:demodb
MySQL         | jdbc:mysql://localhost:3306/demodb

```java
import java.sql.*;
//...
String dbUrl = "jdbc:mysql://localhost:3306/demo";
String user  = "student";
String pass  = "student";

Connection conn = DriverManager.getConnection(dbUrl, user, pass);

// java.sql.SQLException: bad url or credentials
// java.lang.ClassNotFoundException: JDBC driver not in classpath
```

##### Step 2: Create a Statement object
- The Statement object is based on connection
  - It will be used later to execute SQLquery

```java
Statement stmt = conn.creaateStatement();
```

##### Step 3: Execute SQL Query
- Pass in your SQL query

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
```

##### Step 4: Process the Result Set
- Result Set is initially placed before first row

- Method: ResultSet.next();
  - moves forward one row
  - returns true if there are more rows to process

- Looping through a result set

```java
while (rs.next()) {
  // read data from each row
}
```

- Collection of methods for reading data
  - getXXX(columnName)
  - getXXX(columnIndex) (one-based)

```java
while (rs.next()) {
  sout(rs.getString("last_name"));
  sout(rs.getString("first_name"));
}
```
