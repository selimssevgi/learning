# Sharing Volumes

- Just as there are two types of volume, there are two ways to share volumes between containers

## Host-dependent sharing

```shell
mkdir /tmp/logs-example

docker run --name plath -d \
  -v /tmp/logs-example:/data \
  dockerinaction/ch4_writer_a

docker run -rm \
  -v /tmp/logs-example:/reader-data:ro \
  alpine:latest \
  head /reader-data/logA
```

- Bind mount volumes therefore host-dependent sharing might cause problems or be
  too expensive maintain if you're working with a large number of machines

## Generalized sharing and the volumes-from flag

- 'docker run' provides a flag that will copy the volumes from one or more
  containers to the new container: --volumes-from

```shell
docker run --name fowler \
  -v ~/example-books:/library/PoEAA \ # bind mount volume
  -v /library/DSL \                   # docker-managed volume
  alpine:latest \
  echo "Fowler collection created"

docker run --name knuth \
  -v /library/TAoCP.vol1 \
  -v /library/TAoCP.vol2 \
  -v /library/TAoCP.vol3 \
  -v /library/TAoCP.vol4.a \
  alpine:latest
  echo "Knuth collection created"

docker run --name reader \
  --volumes-from fowler \  # copy volumes directly or transitively
  --volumes-from knuth \
  alpine:latest ls -l /library/
```

- Copied volumes always have the mount point. That means that you can't use
  --volumes-from in three situations

1. If the container being built needs are shared volume mounted to a different location.

It offers no tooling for remapping mount points. It will only copy and union the
mount points specified by the specified containers, cannot do /school/library

2. When the volume sources conflict with each other or a new volume
   specification. Only of the conflicting volumes will be available

3. Cannot use --volumes-from flag if write permission of a volume desired to be
   changed. Copies the fill volumes definition
