# Serializer

- when an entry is saved to Redis key-value store, both the key and value are
  serialized using a Redis serializer

- Spring Data Redis comes with several such serializers

* GenericToStringSerializer - serializes using a Spring conversion service
* JacksonJsonRedisSerializer - serializes objects to JSON using Jackson 1
* Jackson2JsonRedisSerializer - serializes objects to JSON using Jackson 2
* JdkSerializationRedisSerializer - uses java serialization
* OxmSerializer - uses marshalers and unmarshalers from Spring's O/X mapping for XML serialization
* StringRedisSerialzer - serializes String key and values

- All of these serializers implement RedisSerializer interface
- you can implement your own if existing ones do not suit your needs

- RedisTemplate uses JdkSerializationRedisSerializer
- StringRedisTemplate uses StringRedisSerialzer


```java
@Bean
public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
  RedisTemplate<String, Product> redis = new RedisTemplate<>();
  redis.setConnectionFactory(cf);
  redis.setKeySerializer(new StringRedisSerializer());
  redis.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
  return redis;
}
```
