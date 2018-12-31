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
- not ideal for mutable types

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

- It is essentially the opposite of a singleton

## Session Scope

- if the shopping cart is a singleton, then all users will be adding products to the same cart

- if it is prototype-scoped, then products added to the cart in one area of the
  application may not be available in another part of the application where a
  different prototype-scoped shopping cart was injected.

- session scope makes the most sense, it is most directly attached to a given user

```java
@Bean
@Scope(
  value = WebApplicationContext.SCOPE_SESSION,
  proxyMode = ScopedProxyMode.INTERFACES)      // ??
public ShoppingCart cart() {}
```

#### ScopedProxyMode

```java
@Component
public class StoreService {

  @Autowired
  public void setShoppingCard(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

}
```

- on application start-up, Spring needs a ShoppingCart but does not have it yet

- so we are instructing Spring to inject a proxy of ShoppingCart instead

- so whenever we will use that proxy in the StoreService, method calls will be
  delegated to the session-scoped object

- if ShoppingCart is interface, then ScopedProxyMode.INTERFACE
- if ShoppingCart is class, CGLIB with then ScopedProxyMode.TARGET_CLASS
