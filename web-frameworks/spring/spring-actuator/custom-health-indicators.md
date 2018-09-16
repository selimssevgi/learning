# Custom HealthIndicator


```java
@Component
public class ProjectHealthIndicator implements HealthIndicator {
  
  @Autowired
  private ProjectProperties properties;

  @Override
  public Health health() {
    if (!properties.getGifLocation().canWrite()) {
      return Health.down().build();  
    }
    return Health.up().build();  
  }
}
```
