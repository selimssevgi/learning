# How to Use a Driver

- Have a database already on the machine(for local usage)
- Find the driver on maven repository and add dependency to build file

## In Java Application

0. As Java 6, The driver is automatically registered via the SPI, and
   manual loading of the driver class is generally unnecessary.

```java
Class.forName("com.mysql.jdbc.Driver");
```

1. Information need for a connection:

```java
// database URL
private static final String DB_URL = "jdbc:mysql://localhost/test";

// database credentials
private static final String DB_PASS = "root";
private static final String DB_USER = "root";
```

2. Get database connection. Throws SQLException.

```java
Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
```

3. Execute a query.
```java
Statement stmt = conn.createStatement();
String    sql  = "SELECT * FROM Cars";
ResultSet rs   = stmt.executeQuery(sql);
```

4. Extract data from the result set
```java
while (rs.next()) {
  int id      = rs.getInt("id");
  String name = rs.getString("name");
  int cost    = rs.getInt("cost");

  System.out.println(String.format("%5d %10s %8d", id, name, cost));
}
```

### Statement Interface
- Use for general-purpose access to your database. Useful when you are using
  static SQL statements at runtime. The Statement inteface cannot accept parameters.

### PreparedStatement Interface
- Use when you plan to use the SQL statements many time The PreparedStatement
  interface accepts input parameters at runtime.

### CallableStatement Interface
- Use when you want to access the database stored procedures. CallableStatement
  interface can also accept runtime input parameters.
