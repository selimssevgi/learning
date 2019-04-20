# docker images

- listing repositories

```shell
docker image --help

docker image ls
```

## Build Image

```shell
# Dockerfile in current working directory
docker image build --tag ubuntu:git:auto .
docker image ls

# default is Dockerfile, but we provide a different file name
docker image build -f BuildScript .

# supress output from the intermediate containers
docker image build --quite ...

# for a full rebuild
docker image build --no-cache .

docker image history image-name
```

## Legacy Commands

```shell
docker images

docker images -a # to see indermediate images to <none>
```
