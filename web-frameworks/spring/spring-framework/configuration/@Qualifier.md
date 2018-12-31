# Qualifying autowired beans

- @Primary is not enough to solve ambiguity when there are two @Primary

```shell
@Component
public class IceCream implements Dessert {}
```

```java
@Autowired
@Qualifier("iceCream") // refers to IceCream default bean ID
public void setDessert(Dessert dessert) {
  this.dessert = dessert;
}
```

- what if IceCream is refactored to something else?

- use @Qualifier on the component side to be on the safe side

```shell
@Component
@Qualifier("cold")
public class IceCream implements Dessert {}
```

```java
@Autowired
@Qualifier("cold")
public void setDessert(Dessert dessert) {
  this.dessert = dessert;
}
```

- what if another component is qualified in the same way?

```java
@Component
@Qualifier("cold")
public class Popsicle implements Dessert {}
```

- we are back to the same problem

- java versions before 8 does not allow repeated annotations
  - @Qualifier("creamy")
  - @Qualifier("fruity")

- we may create our own qualifer annotation

```java
@Target({CONSTRUCTOR, FIELD, METHOD, TYPE})
@Retention(RUNTIME)
@Qualifier
public @interface Cold {}

@Target({CONSTRUCTOR, FIELD, METHOD, TYPE})
@Retention(RUNTIME)
@Qualifier
public @interface Frutiy {}
```

```java
@Component
@Cold
@Fruity
public class Popsicle implements Dessert {}

@Component
@Cold
@Creamy
public class IceCream implements Dessert {}

@Autowired
@Cold
public void setDessert(Dessert dessert) {
  this.dessert = dessert;
}
```
