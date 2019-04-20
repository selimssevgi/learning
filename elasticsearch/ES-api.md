# Elasticsearch API

- Data is sent to and received from the server in JSON form

```shell
curl locahost:9200/_cat/indices?v
```

## Create indicies in ES

- 'todos' is the names of the index, we want to create

```shell
curl -XPUT 'localhost:9200/todos?&pretty'

curl -XGET 'localhost:9200/_cat/indices?v'
```

- status could be yellow, if the ES is running as a single node, there will not be replicas of the index

## Adding documents to an Index

- add a new document under 'products' index with 'mobiles' category with the id of '1'

```shell
curl -XPOST 'localhost:9200/products/mobiles/1?pretty' -d'{ "name": "iphone 7", "camera": "12MP" }'
curl -XPOST 'localhost:9200/todos/8?pretty' -d'{ todo-json }
# creates a document with type '8' and auto-generated id
```

- 'mobiles' is the type of the document

## Retrieve documents

- whole content of the document
- has 'found' field(boolean), and 'source' field containing document

```shell
curl -XGET 'localhost:9200/products/mobiles/1?pretty'
```

- retrieving whole content of the document could be costly

```shell
curl -XGET 'localhost:9200/products/mobiles/1?_source=false'
curl -XGET 'localhost:9200/products/mobiles/1?_source=name,reviews'
```
