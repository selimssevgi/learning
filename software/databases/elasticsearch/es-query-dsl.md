# Elasticsearch Query DSL

1. Know of the document's existence (manually specified documents to index)

2. Index the document for lookup (ES creates the IIndex behind the scenes)

3. Know how relevant the document is (Applies a scoring algorithm for each document for each term)

4. Retrieve ranked by relevance (retrieves documents using a Query DSL)

### Query DSL

- A flexible, expressive search language

- exposes most of the power of Lucene through a simple JSON interface

- you should be using to write your queries in production

- make your queries more flexible, more precise, easier to read, and easier to debug

### Two Contexts of Search

- *How well* does this document match this query? (score), Query Context

- *Does* this document match this query clause? (yes/no), Filter Content

#### Query Content

- *Included or not:* determine whether the document should be part of the result

- *Relevance score:* calculated for every search term the document maps to

- *High score, more relevant:* more relevant documents, higher in the search rankings

#### Filter Content

- *Included or not:* yes/no determines whether included in the result

- *NO scoring:* no additional relevance ranking in the search results

- *Structed data:* exact matches, range queries

- *Faster:* only determine inclusion in results, no scoring to consider

### Query Terms Specification

1. Search terms as URL query parameters

2. Search terms within the URL request body

#### Search terms as URL query parameters

- search 'wyoming' in documents indexed under 'customers'

```shell
curl -XGET 'localhost:9200/customers/_search?q=wyoming&pretty'

curl -XGET 'localhost:9200/customers/_search?q=wyoming&sort=age:desc&pretty'

curl -XGET 'localhost:9200/customers/_search?q=state:kentucky&sort=age:desc&pretty'
```

** Stateless searches: elasticsearch maintains 'no open cursor or session' for
your search.

**NOTE:** Query params options are a subset of options available in the request
body. The standard way is to use the request body for easy maintenance and
debugging of your queries.
