# Primary

- one solution to NuUniqueBeanDefinition

```java
@Component
@Primary
public class IceCream implements Dessert {}
```

- or with method

```java
@Bean
@Primary
public Dessert iceCream() {
  return new IceCream();
}
```

- if there are two @Primary, now we have the same problem

- see @Qualifier
