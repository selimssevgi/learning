# Conditional Beans

```java
@Bean
@Conditional(MagicExistsCondition.class)
public MagicBean magicBean() {
  return new MagicBean();
}
```

```java
public interface Condition {
  boolean matches(ConditionContext ctxt, AnnotatedTypeMetadata metadata);
}
```


```java
public class MagicExistsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext ctxt, AnnotatedTypeMetadata metadata) {
      Environment env = ctxt.getEnvironment();
      return env.containsProperty("magic");
    }
}
```

```shell
@Conditional(ProfileCondition.class)
public @interface Profile {}
```
