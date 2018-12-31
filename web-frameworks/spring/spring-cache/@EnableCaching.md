# @EnableCaching

- it creates an aspect with pointcuts that trigger off of Spring's caching annotatins

- depending on the annotation used and the state of the cache, that aspect will
  fetch a value from the cache, add a value to the cache, or remote a value from the cache

```java
@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManager() {
    return new ConcurrentMapCacheManager();
  }
}
```

- ConcurrentMapCacheManager uses java ConcurrentHashMap as its cache store
- its simplicity makes it a tempting choice for development, testing, or basic applications

- it an ideal choice for larger production applications
