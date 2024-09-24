# docker inspect

- can used to view the metadata of either a container or an image

- displays all the metadata (a JSON document) that docker maintains for a container

- The format option transforms that metadata

```shell
docker inspect --format "{{.State.Running}}" wp # prints true or false
```
