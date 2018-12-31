# RedisCacheManager

- cache is a key-value pair
- Redis is a key-value store

- Spring Data Redis offers RedisCacheManager, an implementation of CacheManager

- RedisCacheManager works with a Redis server via a RedisTemplate to store cache entries

```java
@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManager(RedisTemplate redisTemplate) {
    return new RedisCacheManager(redisTemplate);
  }

  // JedisConnectionFactory and RedisTempleta bean should exist in context
}
```
