# docker save/load

- Docker provides a command to load images into Docker from a file

- not a best way to distribute images

```shell
docker pull busybox:latest
docker save -o myfile.tar busybox:latest # -o to stream into a tar file
ls
docker rmi busybox:latest
docker load -i myfile.tar
docker images
```
