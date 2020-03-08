# component stereotypes

- on some methods the annotations are longer than the method prototype

- many methods, will have repeating annotations over and over

- stereotype annotation consolidates a set of annotations into one annotation

```java
@Produces @SessionScoped @AuthenticatedUser @Named
public User getCurrentUser() {}

@SessionScoped
@AuthenticatedUser
@Named
@Stereotype
@Target({TYPE. METHOD, FIELD})
@Retention(RUNTIME)
public @interface CurrentUser {}

@Produces @CurrentUser
public User getCurrentUser() {}
```

- you can't include other annotations such as those from jpa or ejb within stereotype

- cdi ships with a built-in stereotype: @Model
