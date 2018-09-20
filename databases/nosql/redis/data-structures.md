# Redis Data Structures

- Redis allows us to store keys that map to any one of five different data
  structure types:

1. STRING (Strings, integers, or floating point values)
2. LIST   (Linked list of strings, both ends)
3. SET    (Unordered collection of unique strings)
4. HASH   (Unordered hash table of keys to values)
5. ZSET   (Ordered mapping of string members to floating-points)(unique to Redis)

## Strings

- Strings like in other programming languages
- Other key-value stores (memcached)

- We can GET, SET, DEL values

```shell
# redis-cli

set hello world
# OK
get hello
# 'world'
del hello
# (integer) 1 // tells how many items were deleted
get hello
# (nil)
```

## List

- It supports a linked-list structure

- Can operate on both ends

- LPUSH/RPUSH, LPOP/RPOP, LINDEX, LRANGE

```shell
# redis-cli

rpush mylist item1
# (integer) 1 // current length of the list

rpush mylist item2
# (integer) 2

lrange mylist 0 -1
1) "item1"
2) "item2"

lindex mylist 1
"item2"

lpop mylist
"item" // makes it no longer available
```

## Set

- Use a hash table to keep all strings unique

- Redis SETs are unordered

```shell
# SADD - adds the item to the set
# SMEMBERS - returns the entire set of items
# SISMEMBER - checks if an item is in the set
# SREM - removes the item from the set, if it exists
# SINTER - interaction of sets
# SUNION
# SDIFF

# redis-cli
sadd cities ankara
sadd cities istanbul
smembers cities
sismember citieis ankara # returns 1
sismember citieis gdansk # returns 0
```

## Hash

- is like a row in relational db

```shell
hset hash-key sub-key1  value1
hset hash-key sub-key2  value1

hgetall hash-key

hdel hash-key sub-key2
```
