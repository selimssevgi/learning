# Volume Types

- There are two types of volume

- Every volume is a mount point on the container directory tree to a location on
  the host directory tree, but the types differ in where that location is on the host

1. Bind mount volumes

Any user-specified directory or file on the host operating system

2. Managed volume

Locations that are created by the Docker deamon in space controller by the
daemon, called Docker managed space.

## Bind mount volumes

- Is useful when the host provides some file or directory that needs to be
  mounted into the container directory tree at a specific point

- Is useful if you want to share data with other processes running outside a container

```shell
# create index.html in /tmp/example-docs
docker run -d --name bmweb \
  -v /tmp/example-docs:/usr/local/apache2/htdocs \
  -p 80:80 \
  httpd:latest

# -v <absolute-path-on-host>:<mount-point-inside-the-container>
```

- An important feature of volumes: when you mount a volume on a container file
  system, it replaces/overrides the content that the image provides at that location

- Even the most trusted container may be vulnerable, it is best to minimize the
  impacct of an attack on the provided data, volume can be mounted as read-only

```shell
docker run --name bmweb_ro \
  --volume /tmp/example-docs:/usr/local/apache2/htdocs/:ro \
  -p 80:80 \
  httpd:latest
```

```shell
docker run -rm \
  -v /tmp/example-docs:/tstspace:ro \
  alpine \
  /bin/sh -c 'echo test > /tstspace/test'

# /bin/sh: can't create /tstspace/test: Read-only file system
```

- If the specified host directory does not exist, Docker will create it for you
- Better to have control over than surprises, be sure that you have the directory

#### Mounting a file

- Instead of a directory a single file can be mounted as weel
- Intead of replace the whole directory in the container, Docker will replace that single file
- Be sure to have file on the host before doing anything, otherwise Docker
  assumes that as a directory and moves on

** Disadvantages **

- They tie portable container descriptions to the file system of a specific host

- If a container description depends on content at a specific location on the
  host file syste, then that description isn't portable to hosts where the
  content is unavailable or available in some other location

- The other problem is that they create an opportunity for conflict with other
  containers. It would be a bad idea to start multiple instances of Cassandra
  that all use the same host location as a volume

- Bind mount volumes are appropriate for some specialized concerns, better to
  avoid these kinds of specific bindings in generalized platforms

- You can take advantage of volumes in a host-agnostic and portable way with
  Docker-managed volumes

## Docker-managed volumes

- Docker daemon creates managed volumes in a portion of the host's file system
  that's owned by Docker

- Using managed volumes is a method of decoupling volumes from specialized
  locations on the file system

- Managed volumes are created when you use the -v option (--volume) on 'docker
  run' but only specify the mount point in the container directory tree

```shell
docker run -d \
  -v /var/lib/cassandra/data \ # just specifying mount point inside container
  --name cass-shared \
  alpine echo Data Container

docker inspect cass-shared | grep -iC 5 "volume"
```

- In larger systems where specific locality of the data is less important,
  managed volumes are a much more effective way to organize your data

- Using them decouples volumes from other potential concerns of the system

- "I need a place to put some that that I'm working with"


