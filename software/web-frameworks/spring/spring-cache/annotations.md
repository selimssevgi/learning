# Annotations

- all annotations can be placed either on a method or on a class

- on a method, the caching behavior applies only to that method

- on a class, the caching behavior applies to all methods in that class

### @Cacheable

- indicates the Spring should look in a cache for the method's return value before invoking the method

- if the value found, return the value from cache
- if not found, invoke the method, put the value in cache, and return it

### @CachePut

- indicates that Spring should put the method's return value in a cache

- the cache isn't checked prior to method invocation

- the method is always invoked

* @Cacheable and @CachePut share a common set of attributes

attribute      | type       | description
-------------------------------------------------------------------
value          | String[]   | the names of caches to use
condition      | String     | SpEL, if evaluates to false, results in caching not being applied to the method call
key            | String     | SpEL, to calculate a custom cache key
unless         | String     | SpEL, if evaluates to true, prevents the return value from being put in the cache

### @CacheEvict

- indicates that Spring should evict one or more entries from a cache

### @Caching

- a gouping of annotation for applying multiples of the other caching annotations at once

### Usage

```java
@Cacheable("spittleCache")
public Spittle findOne(long id) {
  try {
    return jdbcTemplate.queryForObject(
        SELECT_SPITTLE_BY_ID,
        new SpittleRowMapper(),
        id);
  } catch (EmptyResultDataAccessException e) {
    return null;
  }
}
```

- if @Cacheable is put on an implementation method, that will only for that implementation
- instead we can place @Cacleable on interface method

```java
@CachePut("splittleCache")
Spittle save(Spittle spittle);
```

- default cache key is based on the parameters to the method

- the cache key and value would the same object in the above example

- we could customize the key to use the Id but the Id will be available in returned object


* Spring offers several SpEL extensions specifically for defining cache rules

expression           | description
-------------------------------------------------
\#root.args          | the arguments as an array
\#root.caches        | the caches this method is executed against, as an array
\#root.target        | the target object
\#root.targetClass   | shortcut for root.target.class
\#root.method        | the cached method
\#root.methodName    | shortcut for root.method.name
\#result             | return value from the method call (not available with @Cacheable)
\#Argument           | #argName, #a0, #p0


```java
@CachePut("splittleCache", key = "#result.id")
Spittle save(Spittle spittle);
```

### conditional caching

- by using annotations, spring creates a caching aspect around that method

- there may be cases where you'd rather have caching turned off

- @Cacheable and @CachePut offer two attributes for conditional caching

- on the surface, it may seem that 'unless' and 'condition' accomplish the same thing
- there is a subtle difference:
  - unless: cache is searched before invocation, but result is not put
  - condition: no cache searching, no putting results in cache


- do not cache results that have message property contains 'NoCache'

```java
@Cacheable(value = "splittleCache", unless = "#result.message.contains('NoCache')")
Splittle findOne(long id);
```

- do not search or place the ones have id less than 10

```java
@Cacheable(
  value = "splittleCache",
  unless = "#result.message.contains('NoCache')",
  condition = "#id >= 10")
Splittle findOne(long id);
```

- unless works with the result
- condition works with the arguments

### removing cache entires

- @Cacheable and @CachePut requires a non-void return value
- @CacheEvict can be used on methods with void return type

```java
@CacheEvict("splittleCache")
void remove(long splittleId);
```
