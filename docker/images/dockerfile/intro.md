# Dockerfile Into

- A Dockerfile is a file that contains instructions for building an image

- Prefer Dockerfile builds to hand-made images

```shell
FROM ubuntu:latest # must be first instruction

MAINTAINER "selimssevgi@gmail.com"

RUN apt-get update && apt-get install -y git

ENTRYPOINT ["git"]
```

- A new layer is being added to the resulting image after each step in the build

- The docker builder can aggressiely cache the results of each step

- If a problem with the build script occurs after several other steps, the
  builder can restart from the same position after the problem has been fixed

## Dockerfile Instructions

- FROM, MAINTAINER
- RUN
- ENV
- LABEL
- WORKDIR
- EXPOSE
- ENTRYPOINT
- COPY
- ADD
- VOLUME
- CMD
- USER
- ONBUILD

#### ENV

- sets environment variables for an image
- similar to the --env flag on docker run/create

- Environment variables declared in the Dockerfile are made available to the
  resulting image but can be used in other Dockerfile instructions as substitutions

```shell
ENV APPROOT="/app" \
    APP="mailer.sh" \
    VERSION="0.6"

# using ENV for each would result in the creation of three layers
```

#### LABEL

- is used to define key/value pairs that are recorded as additional metadata
- --label on docker run/create

```shell
LABEL base.name="Mailer Archetype" \
      base.version="${VERSION}"
```

#### WORKDIR

- result of the WORKDIR will be an image with the default working directory
- setting WORKDIR to a location that doesn't exist, it will be created

```shell
WORKDIR $APPROOT
```

#### EXPOSE

- creates a layer that opens TCP port

```shell
EXPOSE 33333
```

#### ENTRYPOINT

- sets the executable to be run at container startup

- has two forms:

1. shell form: executed as an argument to the default shell: /bin/sh -c 'exec git'
   if the shell form is used, then all other arguments provided by the CMD
   instruction or at runtime as extra arguments to docker run will be ignored.
   This makes the shell form of ENTRYPOINT less flexible

2. exec form

```shell
ENTRYPOINT ["git"]
```

#### COPY

- copy files from the file system where the image is being built into the build container

- takes at least two arguments, ["source1", "source2", "last-one-destination"]

- any files copied will be copied with file ownership set to root

- better to delay any RUN instructions to change file ownership until all the
  files that you need to update have been copied into the image

```shell
COPY ["./log-impl", "${APPROOT}"]
```

#### VOLUME

- --volume flag

- each value in the string array argument will be created as a new volume
  definition in the result layer

- defining volumes at image build time is more limiting than at runtime

- You have no way to specify a bind-mount volume or read-only volume at image build time

```shell
VOLUME ["/var/log"]
```

#### CMD

- represents an argument list for the entrypoint

- the default entrypoint for a container is /bin/sh


```shell
CMD ["/var/log/mailer.log"]
```

#### ADD

- operates similarly to the COPY instruction with two important differences:

- feth remote resource files if a URL is specified (not best practice)
- Extract the files of any source determined to be an archive file

```shell
ADD ["./live-impl", "${APPROOT}"]
```

#### USER

- sets the user and group in the same way docker run/create

#### ONBUILD

- Defines instructions to execute if the resulting image is used as a base for another build

```shell
# upstream dockerfile
ONBUILD COPY [".", "/var/myapp"]
ONBUILD RUN go build /var/myapp
```

- They are not executed when their containing Dockerfile is built

- These instructions are recorded in the resulting image's metadata under ContainerConfig.OnBuild

- The metadata is carried forward until the resulting image is used as the base
  for another Dockerfile build

- When a downstream Dockerfile uses the upstream image in a FROM instruction,
  those ONBUILD instructions are executed after the FROM instruction and before
  the next instruction in a Dockerfile


```shell
# upstream Dockerfile: base.df
FROM busybox:latest
WORKDIR /app
RUN touch /app/base-evidence
ONBUILD RUN ls -al /app
```

```shell
FROM dia/ch8_onbuild
RUN touch downstream-evidence
RUN ls -al .
```

```shell
docker build -t dia/ch8_onbuild -f base.df .
docker build -t dia/ch8_onbuild_down -f down.df .
```
