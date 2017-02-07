# application.properties


```shell
# JPA
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# Logging
logging.level=DEBUG

# Hibernate properties
spring.jpa.properties.hibernate.hbm2ddl.import_files=init.sql
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

# Datasource
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=springtest
spring.datasource.password=test
```
