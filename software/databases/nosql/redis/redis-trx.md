# Redis Transactions

- Transactions in Redis are different from transactions that exist in more
  traditional relational databases.

```shell
MULTI                   # letting server know multiple commands are coming
<a series of commands>  # commands are buffered on redis server
EXEC                    # at this point commands will start to be executed
# or
DISCARD                 # do no execute those commands
```

- By using WATCH, MULTI/EXEC, and UNWATCH/DISCARD, we can ensure that the data
  that we're working with doesn't change while we're doing something important,
  which protects us from data corruption.

- Everything between the MULTI and EXEC commands will execute without other
  clients being able to do anything.

- In the case where we don't need transactions, but where we still want to do a
  lot of work, we could still use MULTI/EXEC for their ability to send all of
  the commands at the same time to minimize round trips and latency.

- We could pipeline a series of commands without wrapping them in MULTI/EXEC in
  order to reduce round trips to Redis server.
