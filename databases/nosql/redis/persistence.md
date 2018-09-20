# Redis Persistence Options

- There are 2 different ways of persisting data to disk.

1. snapshotting: takes the data as it exists at one moment in time and writes it
   to disk.

2. append-only file (AOF): it works by copying incoming write commands to disk
   as they happen


```shell
# snapshotting persistence options
save 60 1000
stop-writes-on-bgsave-error no
rdbcompression yes
dbfilename dumb.rdb

# append-only file persistence options
appendonly no
appendfsync everysec
no-appendfsync-on-rewrite no
auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb

# common option
dir ./            # where to store snapshot or aof
```

## Persisting to disk with snapshots

- Any Redis client can initiate a snapshot by calling the BGSAVE command.

- A Redis client can also initiate a snapshot by calling the SAVE command, which
  causes Redis t stop responding to any/all commands until the snapshot completes.

- 'save 60 10000', redis will automatically trigger a BGSAVE if 10,000 writes
  have occurred within 60 seconds since the last succussful save has started.
  When multiple 'save' lines are present, any time of the rules match, a BGSAVE
  is triggered.

- When Redis receives a request to shut down by the SHUTDOWN command, or it
  receives a standard TERM signal, Redis will perform a SAVE.


** When using only snapshots for saving data, you must remember that if a crash
were to happen, you'd lose any data changed since the last snapshot.

** In case of big data, having automatic 'save' may cause delays and problems.
Redis will fork itself, and fight withself for resources. It could be better to
turn off auto-save and trigger SAVE command to have a pause but not fight for
resources.

- Data loss while taking snapshots may not be acceptable for some applications.

## Append-only file persistence

- Append-only log files keep a record of data changes that occur by writing each
  change to the end of the file.

```shell
# sync options - appendfsync
always - every write, slows down redis
everysec - once per second, explicity syncs write commands to disk
no - lets operating system control syncing to disk
```

- The log file can get too big, not leaving space on disk
- On start-up Redis consumes the AOF, and if the file is too big, start-up time
  will be long
