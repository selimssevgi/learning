# Programmatic Configuration

- properties and xml file are declarative modes

```java
Configuration cfg = new Configuration()
  .setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect")
  .setProperty("hibernate.connection.username", user);
  .setProperty("hibernate.connection.password", password);
  .setProperty("hibernate.connection.url", "jdbc:derby:memory:JH;create=true")
  .setProperty("hibernate.order_updates", "true");
```
