# docker create

- Is very similar to 'docker run', the primary difference being that the
  container is created in a stopped state

```shell
docker create nginx

CID=$(docker create nginx)
echo $CID
```

- CID can be easily overriden


```shell
docker create --cidfile /tmp/web.cid nginx
cat /tmp/web.cid

# /containers/web/customer1/web.cid
# /containers/web/customer8/web.cid
```
