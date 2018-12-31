# Type-safe configuration

- @ConfigurationProperties turns all of your application configuration into typesafe POJOs

- @ConfigurationProperties

- Define getters&setters

- Annotate with @Component

- Can also use @EnableConfigurationProperties

```java
@ConfigurationProperties(prefix = "my")
public class MyConfig {
  @Getter @Setter
  private Boolean featureEnabled;
}
```

- Could be activated in two ways:

1. Add @Component to your config class, component scan should cover this config class too

2. If component scan does not cover that, you can add this:

```java
@Configuration
@EnableConfigurationProperties(MyConfig.class)
public class SomeConfigClass {
  
}
```

* NOTE: can be part of auto-configuration

## Validating Your Configuration

- Simply annotate your instance variables with JSR-303 annotations

- @NotNull, @Pattern, @Max, @Min, @Digits and more
