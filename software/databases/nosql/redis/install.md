# Redis Installation

- [Redis Releases](https://github.com/antirez/redis/releases)


```shell
sudo apt-get update
sudo apt-get install make gcc python-dev

# extract tar
# cd into extracted redis directory
make
make test
sudo make install
```

## Start redis Server

```shell
redis-server
```

## redis-cli

- Comes with redis

```shell
redis-cli # start interacting with redis
```

## Test with Python client

```shell
sudo pip install redis hiredis

python3

>> import redis
>> conn = redis.Redis()
>> conn.set('hello', 'world')
True
>> conn.get('hello')
'world'
```
