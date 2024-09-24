# Preparing packaging for Git


```shell
docker run -it --name image-dev ubuntu:latest /bin/bash

# apt-get update
# apt-get -y install git
# git version
# exit
```

- git has been installed in a new layer on top of the ubuntu:latest image

- how do we know exactly what changes were made?

```shell
docker diff image-dev

# A - added, C - changed, D - deleted
```
