# Java Config for Properties


```java
@Configuration
@PropertySource("application.source")

@Service
public CustomerService {
  @Value("${key}")  
  private String key;
}
```
