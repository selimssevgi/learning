# Scopes

- There are 5 scopes

* Valid in any configuration

1. Singleton (default)
2. Prototype

* Valid only in web-aware Spring projects

3. Request (created on each request)
4. Session (for whole user session)
5. Global (for all users of the application)

## Singleton

- One instatiation
- Default bean scope
- Single instance per Spring container

```java
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public CustomerService {}

@Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public AnInterface anInterface() {}

// psvm
CustomerService s1 = appContext.getBean(CustomerService.class)
CustomerService s2 = appContext.getBean(CustomerService.class)
sout(s1 == s2);
```

## Prototype

- Prototype design pattern guarantees a unique instance per request

- Each time you request a bean from the container, you are guaranteed a unique instance

- It is essentially the opposite of a singletion
