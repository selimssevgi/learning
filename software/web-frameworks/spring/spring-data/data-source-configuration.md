# DataSource Configuration

- spring offers several options for configuring data-source beans:
  - data sources that are defined by a JDBC driver
  - data sources that are looked up by JNDI
  - data sources that pool connections

### JNDI


```xml
<jee:jndi-lookup id="dataSource" jndi-name="jdbc/myDS" resource-ref="true" />
```

- if the application is running in a Java application server, you will want to
  set the resource-ref property to true so that the value given in jndi-name
  will be preprended with 'java:/comp/env/'

```java
@Bean
public JndiObjectFactoryBean dataSource() {
  JndiObjectFactoryBean jndiObjectFb = new JndiObjectFactoryBean();
  jndiObjectFb.setJndiName("jdbc/myDS");
  jndiObjectFb.setResourceRef(true);
  jndiObjectFb.setProxyInterface(javax.sql.DataSource.class);
  return jndiObjectFb;
}
```

### pooled data source

- Apache Commons DBCP (BasicDataSource)
- c3p0
- Hikari

### jdbc driver-based data sources

- the simplest data source can be configured is one of that defined through JDBC driver

- spring offers three such data-source classes to choose from

- org.springframework.jdbc.datasource

1. DriverManagerDataSource
  - returns a new connection every time a connection is requested
  - connections are not pooled

2. SimpleDriverDataSource
  - works like DriverManagerDataSource, it works with driver directly to
    overcome classloading issues may raise in certain environment (OSGI container)

3. SingleConnectionDataSource
  - returns the same connection every time
  - not pooled, but can be thought as data source with a pool of exactly one connection

* They are not recommended for production, use pooled data sources
