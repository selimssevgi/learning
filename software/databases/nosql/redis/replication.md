# Redis Replication

- Master receives the write commands

- Master keeps slaves in sync for new data

- All read operations are done through slaves

- When a slave connects to the master, the master starts a BGSAVE operation

```shell
SLAVEOF host port # connect to master as slave
SLAVEOF no one    # stop being slave
```


- Because there is nothing particularly special about being a master or a slave
  in Redis, slaves can have their own slaves, resulting in master/slave chaining.

** By combining replication and AOFs, we can configure Redis to be resillient
against system failures.
