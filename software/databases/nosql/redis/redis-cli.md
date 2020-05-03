# redis-cli

- start redis server

```shell
redis-server
```

- connect to redis server

```shell
redis-cli
```

## Usage

```shell
set hello world
# OK
get hello
# 'world'
del hello
# (integer) 1 // tells how many items were deleted
get hello
# (nil)
```

- list all of the keys:

```shell
KEYS '*'
```
