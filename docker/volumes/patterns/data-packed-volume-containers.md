# Data-packed volume container

- A data-packed volume container is built from an image that copies static
  content from its image to volumes it defines

- At container-creation time the data is copied into the volume and is
  accessible to any containers that use this volume container

```shell
docker run --name dpvc \
  -v /config \
  dockerinaction/ch4_packed /bin/sh -c 'cp /packed/* /config/'

docker run --rm --volumes-from dpvc \
  alpine:latest ls /config

docker run --rm --volumes-from dpvc \
  alpine:latest cat /config/packedData

docker rm -v dpvc
```
