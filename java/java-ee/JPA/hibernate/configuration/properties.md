# Hibernate Properties

- any properties in the XML file take precedence over those in properties file

```xml
<!-- autogenerate schema, create if doesnt exist, or update ->
<property name="hbm2ddl.auto">update/validate/create/create-drio</property>
```

Property                       | Values                     | Notes
-------------------------------|----------------------------|--------------------
hibernate.show_sql             | true/false                 | shows sql statements
hibernate.jdbc.fetch_size      | >=0                        | set the JDBC fetch size
hibernate.jdbc.batch_size      | >=                         | used to batch the statements
hibernate.connection.pool_size | >=1                        | connection pool size
