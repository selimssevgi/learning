# Hibernate Configuration

- Programatic(Configuration().setProperty("name", "value"))
- VM arguments(-Dhibernate.username=root)
- hibernate.cfg.xml(take predence over properties if both exist)
- hiberbate.properties
- These are the default names Hibernate looks for in classpath and loads if found

## Configuration Properties
Property | Values | Notes
---------|--------|--------
show_sql | true/false | prints of sql statements
jdbc.fetch_size | >=0 | set the jdbc fetch size
connection.pool_size | >=1 | connection pool size
hbm2ddl.auto | validate/update/create/create-drop | schema options

*NOTE:* Never use the hbm2ddl.auto property in production. You must create a
schema with all the table definitions and deploy to production via a proper
release process.

## XML

- hibernate.cfg.xml

```xml
<hibernate-configuration>
  <session-factory>
    <property name="connection.url">jdbc:mysql://localhost/JH</property>
    <property name="connection.connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="connection.username">root</property>
    <property name="connection.password">root</property>
    <property name="dialect">org.hibernate.dialect.MYSQL5Dialect</property>
    <property name="show_sql">true</property>

    <!-- tables automatically created or updated -->
    <property name="hbm2ddl.auto">update</property>

    <!-- consists of details on how a Movie object is mapped to a MOVIE table-->
    <mapping resource="Movie.hbm.xml" />
    <mapping resource="Account.hbm.xml" />
    <mapping resource="Trade.hbm.xml" />

    <!-- annotated classes -->
    <mapping class="com.selimssevgi.jh.domain.Employee"/>
  </session-factory>
</hibernate-configuration>
```

- Movie.hbm.xml

```xml
<hibernate-mapping>
  <class name="com.selimssevgi.jh.domain.Movie" table="MOVIES">
    <id name="id" column="ID">
      <generator class="native"/>
    </id>
    <property name="title"    column="TITLE"/>
    <property name="director" column="DIRECTOR"/>
    <property name="synopsis" column="SYNOPSIS"/>
    <property name="minute"/> <!-- name and column are same -->
    <property name="rate" type="string"/> <!-- HB use reflection for types -->
  </class>
</hibernate-mapping>
```

#### generator
- Our choice of identifier generation strategy
- assigned short for: org.hibernate.id.Assigned class.

- assigned, native, sequence, identity. All implements IdentifierGenerator.


```xml
<generator class="assigned" />
```
## Properties

- hiberbate.properties
```shell
hibernate.connection.driver_class = com.mysql.jdbc.Driver
hibernate.connection.url = jdbc:mysql://localhost/JH
hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```
