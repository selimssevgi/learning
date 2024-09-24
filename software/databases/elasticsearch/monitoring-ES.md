# Monitoring Elasticsearch


```shell
localhost:9200

http://localhost:9200/_cat/health?v
```

- status: green  -> all shards and replicas are available for reqests, cluster functional
- status: yellow -> some replicas may not be available, cluster still functional
- status: red    -> some shards not available(neither replicas), cluster NOT fully functional

```shell
http://localhost:9200/_cat/nodes?v
```
