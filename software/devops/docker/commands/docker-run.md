# docker run

- legacy command, use docker container run

```shell
docker run hello-world
```

## What Happens

- Docker looks for the image on this computer
- Is it installed? No
- Docker searches Docker Hub for the image
- Is it on the Docker Hub? Yes
- Docker downloads the image
- The image layers are installed on this computer
- Docker creates a new container and starts the program
- The container is running

* Understand that the running state of a container is directly tied to the state
  of a single running program inside the container

## Running nginx

```shell
docker run --detach --name web nginx
# output unique identifier of the container that was just created

# Injecting environment variables into container, -e for short
docker run --env MY_ENV_VAR="this is a test" busybox env

# removes the container after exiting
docker run -rm -name auto-exit-test busybox echo Hello World
```

- --detach started the program in the background

```shell
docker run --interactive --tty --link web:web --name web_test busybox:latest /bin/sh

# wget -O - http://web:80/
```

- --interactive|-i keep the standard input from stdin open for the container
  even if no terminal is attached

- --tty option tells Docker to allocate a virtual terminal for the container,
  which will allow you to pass signals to the container

- It is possible to create an interactive container, manually start a process
  inside that container, and then detach your terminal. You can do so by holding
  down the CTRL key and pressing P and then Q. This will work only when you've
  used the -tty option.

- the link mechanism injects IP addresses into dependent containers, and
  containers that aren't running dont have IP addresses. If you tried to start a
  container that has a dependency on a container that isn't running, Docker
  wouldnt have an IP address to inject

