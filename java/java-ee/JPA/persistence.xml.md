# persistence.xml

- How does the server know which database it is supposed to save/update/query the entity objects?
- How do we configure the underlying orm engine and cache for better performance
  and trouble shooting?

- persistence.xml gives you complete flexibility to configure the EntityManager

- persistence.xml file is a standard configuration file in JPA

- It has to be included in the META-INF inside the JAR that contains the entity beans

- must define a persistence-unit with a unique name in the current scoped classloader
