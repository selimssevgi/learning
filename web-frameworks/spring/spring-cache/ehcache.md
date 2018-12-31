# Caching with EhCache

- one of the most popular cache providers


```java
@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public EhCacheCacheManager ehCacheCacheManager(net.sf.ehcache.CacheManager cacheManager) {
    return new EhCacheCacheManager(cacheManager);
  }

  @Bean
  public EhCacheManagerFactoryBean ehCache() {
    EhCacheManagerFactoryBean ehCacheManagerFactoryBean =
        new EhCacheManagerFactoryBean();
    ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
    return ehCacheManagerFactoryBean;
  }
}
```

- Both Spring and Ehcache define a CacheManager type
- Ehcache's CacheManager is being injected into Spring's EhCacheCacheManager (implements Spring's CacheManager)
