# docker build

```shell
# Dockerfile in current working directory
docker build --tag ubuntu:git:auto .
docker images

# default is Dockerfile, but we provide a different file name
docker build -f BuildScript .

# supress output from the intermediate containers
docker build --quite ...

# for a full rebuild
docker build --no-cache
```
