# Spring and JPA

- configure an entity manager factory as a bean

- use implementation of EntityManagerFactory to get an instance of an EntityManager

- jpa specification defines two kinds of entity managers:

1. application-managed
  - entity managers are created when application directly request one from an enttiy manager factory
  - application is responsible for opening/closing or involving the entity manager in transactions
  - this type is most appropriate for use in standalone applications that dont run in a Java EE container

2. container-managed
  - entity managers are created by a Java EE container
  - the application does not interact with the entity manager factory at all
  - entity managers are obtained directly through injection or from JNDI

- PersistenceProvider#createEntityManagerFactory()
- PersistenceProvider#createContainerEntityManagerFactory()

- Spring plays both roles of application and container in certain cases

- LocalEntityManagerFactoryBean produces an application-managed one
- LocalContainerEntityManagerFactoryBean produces an container-managed one

### configuring application-managed jpa

- with spring supports for jpa, you will never deal directly with the PersistenceProvider

- it seems silly to extract configuration information into persistence.xml

- do so prevents you from configuring the EntityManagerFactory in Spring

### configuring container-managed jpa

```java
@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory(
    DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

  LocalContainerEntityManagerFactoryBean emfb =
    new LocalContainerEntityManagerFactoryBean();
  emfb.setDataSource(dataSource);
  emfb.setJpaVendorAdapter(jpaVendorAdapter);
  emfb.setPackagesToScan("com.selimssevgi.domain")
  return emfb;
}
```

- EclipseLinkJpaVendorAdapter
- HibernateJpaAdapter
- OpenJpaVendorAdapter

- setPackagesToScan eliminates the need to declare them explicity in persistence.xml
- DataSource in injected, no need to configure details in persistence.xml
- after all, we dont need an persistence.xml


- for spring-free implemention preferred way over JpaTemplate

```java
@Repository
@Transactional
public class JpaRepository implements MyRepository {

  @PersistenceUnit
  private EntityManagerFactory emf;

  public void save(Item item) {
    emf.createEntityManager().persist(item);
  }
}
```

- in every method we will call createEntityManager, could we inject EntityManager instead?
- EntityManager is not thread-safe

```java
@Repository
@Transactional
public class JpaRepository implements MyRepository {

  @PersistenceContext //!!
  private EntityManager em;

  public void save(Item item) {
    em.persist(item);
  }
}
```

- @PersistenceContext doesn't inject an EntityManager, not exactly

- instead of giving the repository a real EntityManager, it gives a proxy to a real EntityManager

- real EntityManager either is one assiciated with the current transaction or,
  if one doesnot exist, creates a new one, this way you work with a thread-safe EntityManager

- @PersistenceContext and @PersistenceUnit are from JPA specification
- PersistenceAnnotationBeanPostProcessor knows them
