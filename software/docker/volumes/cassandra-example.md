# Cassandra Example with Volumes


```shell
# creating volume in a container
docker run -d \
  --volume /var/lib/cassandra/data \
  --name cass-shared \
  alpine echo Data Container

# inherit volume definitions
docker run -d \
  --volumes-from cass-shared \
  --name cass1 \
  cassandra:2.2

# run cassandra client in another container
docker run -it -rm \
  --link cass1:cass \
  cassandra:2.2 cqlsh cass

# look for a keyspace, returns an empty line, volume is empty
select * from system.schema_keyspaces where keyspace_name = 'docker_hello_world';

# create a keyspace
create keyspace docker_hello_world
with replication = {
  'class': 'SimpleStrategy',
  'replication_factor': 1
};

# look for same keyspace

# leave the cassandra client, client started with -rm
quit

docker stop cass1   # remove cassandra
docker rm -vf cass1

# at this point cassandra server and client is gone

# start another cassandra container
docker run -d \
  --volumes-from cass-shared \
  --name cass2 \
  cassandra:2.2

# start another client
docker run -it -rm \
  --link cass2:cass \
  cassandra:2.2 \
  cqlsh cass

# look for same keyspace
# you should have it still there, data live longer than the containers
```
