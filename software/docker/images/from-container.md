# Building Docker Images From a Container

- Any changes that you make to the file system inside a container will be
  written as new layers that are owned by the container that created them

- Three steps to create an image from a container:

1. create a container from an existing image
2. modify the file system of the container
3. commit those changes

```shell
# modify the container
docker run --name hw_container ubuntu:latest touch /HelloWorld

# commit change to new image
docker commit hw_container hw_image

# remove change container
docker rm -vf hw_container

# examine file in new container
docker run --rm hw_image ls -l /HelloWorld
```

## Reviewing file system changes

- see packaging-git-example.md

```shell
docker run --name image-dev busybox:latest rm /bin/vi

docker diff image-dev

# A - added, C - changed, D - deleted
```

## Committing a new image


```shell
docker commit -a "@selimssevgi" -m "add git" image-dev ubuntu-git

docker images
```

## Configurable image attributes

- docker commit, commits a new layer to an image

- the file system snapshot isn't the only thing included with this commit

- each layer also includes metadata describing the execution context

* All environment variables
* The working directory
* The set of exposed ports
* All volume definitions
* The container entrypoint
* Command and arguments

- If above values weren't specifically set for the container, the values will be
  inherited from the original image
