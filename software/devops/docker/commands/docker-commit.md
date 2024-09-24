# docker commit

- create an image from a modified container

- best practise to use the -a flat that signs the image with an author string

```shell
docker commit -a "@selimssevgi" -m "add git" image-dev ubuntu-git
```
