# persistence.xml

- How does the server know which database it is supposed to save/update/query the entity objects?

- How do we configure the underlying ORM engine and cache for better performance
  and trouble shooting?

- persistence.xml gives you complete flexibility to configure the EntityManager

- persistence.xml file is a standard configuration file in JPA

- It has to be included in the META-INF inside the JAR that contains the entity
  beans (resources/META-INF/persistence.xml)

- must define a persistence-unit with a unique name in the current scoped classloader

- The persistence.xml file configures at least one persistence unit

## Example

```xml
<?xml version="1.0" encoding="UTF-8"?>

<persistence
        version="2.1"
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
http://xmlns.jcp.org/xml/ns/persistence_2_1.xsd" >

    <persistence-unit name="tododb">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <!-- disable scanning for mapped classes
        <exclude-unlisted-classes>true</exclude-unlisted-classes>
        -->
        <!-- entities in another jar, path relative to this jar file -->
        <jar-file>xyz.jar</jar-file>

        <properties>
            <property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/tododb" />
            <property name="hibernate.connection.username" value="root" />
            <property name="hibernate.connection.password" value="root" />
            <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.use_sql_comments" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```
