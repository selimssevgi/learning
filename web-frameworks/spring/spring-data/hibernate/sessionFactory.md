# Hibernate Session Factory

- main interface for working with Hibernate is org.hibernate.Session

- the standard way to get a reference to a Hibernate Session is through an
  implementation of Hibernate's SessionFactory interface

- among other things SessionFactory is responsible for opening, closing, and
  managing Hibernate Sessions

- org.springframework.hibernate5.LocalSessionFactoryBean


```java
@Repository
public HibernateRepository implements MyRepository {
  public HibernateRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
```
