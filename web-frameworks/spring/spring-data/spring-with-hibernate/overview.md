# Overview

- SessionFactory encapsulates Entities

- in Spring use LocalSessionFactoryBean

- Spring container, or application context, will be managing the SessionFactory
- It will be created as a Spring bean at runtime

- Configure the data soruce separately using a third party library DBCP
- DBCP stands for Databasae Connection Pooling
- CP allows the application to keep alive a specified number of db connections
- This approach boosts the performance since db connections take time to establish

- We let Hibernate grab the configuration settings for our data source
- With Spring, data source can be configured as a Spring bean

- Data access components call data access objects(DAO)
- Service components sit between Controllers and DAOs
