# Spring Data Redis

- there arent too many kinds of queries that you can perform against a hash map or a key-value store

- you can store a value at a particular key, and you can fetch the value for a particular key

- Consequently, Spring Data's automatic repository support doesn't make a lot of sense when applied to Redis

- Spring Data Redis comes witha couple of template implementations for storing
  data to and fetching it from a Redis database

## Connecting to Redis

- Spring Data Redis comes with connection factories for Redis client implementations

1. JedisConnectionFactory
2. LettuceConnectionFactory

```java
@Bean
public RedisConnectionFactory redisCf() {
  return new JedisConnectionFactory();
}
```

## RedisTemplate

- Spring Data Redis offers a higher-level data access option with templates

1. RedisTemplate
2. StringRedisTemplate

- in recognition of the fact that keys and values are frequently Strings,
  StringRedisTemplate extends RedisTemplate to have a String focus


```java
RedisConnectionFactory cf = ...;
RedisTemplate<String, Product> redis = new RedisTemplate<>();
redis.setConnectionFactory(cf);
```

- if we know that that we will be working with both String keys and values

```shell
RedisConnectionFactory cf = ...;
StringRedisTemplate redis = new StringRedisTemplate(cf);
```

- if those templates are going to be used frequently, we could define them as beans

```java
@Bean
public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
  RedisTemplate<String, Product> redis = new RedisTemplate<>();
  redis.setConnectionFactory(cf);
  return redis;
}

@Bean
public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf) {
  return new StringRedisTemplate(cf);
}
```

#### sub-APIs

method           | sub-API interface          | description
----------------------------------------------------------------------
opsForValue()    | ValueOperations<K, V>      | working simple values
opsForList()     | ListOperations<K, V>       | working list values
opsForSet()      | SetOperations<K, V>        | working set values
opsForZSet()     | ZSetOperations<K, V>       | working zset(sorted set) values
opsForHash()     | HashOperations<K, HK, HV>  | working hash values
boundValueOps(K) | BoundValueOperations<K, V> | simple values bound to a given key
boundListOps(K)  | BoundListOperations<K, V>  | list values bound to a given key
