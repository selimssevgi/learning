# Database Connection in Tomcat

1. Download JDBC Driver JAR file
2. Define connection pool in META-INF/context.xml
3. Define resource reference in WEB-INF/web.xml
4. Get connection pool reference in Java code


#### Download JDBC Driver JAR file

1. MySQL JDBC Driver
2. Place the JAR file in your app's WEB-INF/lib

#### Define connection pool in META-INF/context.xml

- WebContent/META-INF/context.xml

```xml
<Context>
  <Resource name="jdbc/student_tracker"
            auth="Container" type="javax.sql.DataSource"
            maxActive="20" maxIdle="5" maxWait="10000"
            username="demo" password="demo"
            driverClassName="com.mysql.jdbc.Driver"
            url="jdbc:mysql//localhost:3306/student_tracker" />
</Context>
```

#### Define resource reference in WEB-INF/web.xml

```xmlo
<resource-ref>
  <description>Student Tracker Datasource</description>
  <res-ref-name>jdbc/student_tracker</res-ref-name>
  <res-type>javax.sql.DataSource</res-type>
  <res-auth>Container</res-auth>
</resource-ref>
```

#### Get connection pool reference in Java code
- Various options to get connection pool
  1. resource injection with Servlets, etc.
  2. Java Naming Directory Interface (JNDI)
