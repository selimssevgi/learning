# CompositeCacheManager

- there is no reason to think that we must choose one and only one cache manager

- if we have valid technical reasons for choosing more than one cache manager,
  we can try Spring's CompositeCacheManager

```java
@Bean
public CacheManager cacheManager(
  net.sf.ehcache.CacheManager cm,
  javax.cache.CacheManager jcm) {

  CompositeCacheManager ccm = new CompositeCacheManager();
  List<CacheManager> managers = new ArrayList<>();
  managers.add(new JCacheCacheManager(jcm));
  managers.add(new EhCacheCacheManager(jcm));
  managers.add(new RedisCacheManager(redisTemplate()));
  ccm.setCacheManagers(managers);
  return cacheManager;
}
```
