# MongoDB in Action


## Chapter 1 - A db for the modern web

- With MongoDB, the object defined in the programming language can be persisted
  "as is", removing some of the complexity of object mappers.

## MongoDB's key features

* The document data model

- Article(title, comments, tags etc) all in one single file/document.
- In relational db most of those things make up an article will be in separate tables.

- A document-oriented data model naturally represents a data in an aggregate
  form, allowing you to work with an object holistically, all the data
  representing a post, from comments to tags, can be fitted into a single db
  object.

- In document data model there is no schema. In relation db, there is a strict
  schema specifying which columns and types are permitted.

- The lack of schema brings flexibitly in application development, specifially
  when at the beginning you dont know full specification.

- Application empose this structure, not the db. Therefore it grows dynamically.

**Ad hoc queries**

- A system supports ad hoc queries is to say that it's not necessary to define
  in advance what sorts of queries the system will accept.

- Relation DBs have this property; they will execute any well-formed SQL query
  with any number of conditions.

- not all DBs support dynamic queries. ex: key-value stores are queryable on one
  axis only: the value's key.

```sql
SELECT * FROM posts
  INNER JOIN posts_tags ON posts.id = posts_tags.post_id
  INNER JOIN tags ON posts_tags.tag_id == tags.id
  WHERE tags.text = 'politics' AND posts.vote_count > 10
```

```shell
# using a document as a matcher
db.posts.find({'tags': 'politics', 'vote_count': {'$gt': 10}});
```
- Ad hoc queries alone aren't enough. Once your data set grows to a certain
  size, indexes become necessary for query efficiency. Any system that supports
  ad hoc queries should also support secondary indexes.

**Secondary indexes**

- database indexes analogy: a cookbook and lots of pears.
  - search all recipes to find all contains pears.
  - check book's index for entry 'pear'

- Secondary indexes are implemented as B-trees.

- The kind of indexes: asc, desc, unique, compound-key, geospatial

**Replication**

- Topology knows as a 'replica set'
- Replica set distribute data across machines for redundancy and automate failover
- Primary -> 2 Secondary
- Primary fails, one of the secondary becomes primary
- Original primary recovers as secondary
- For intensive read, secondaries can be used as their read-only.

**Speed and Durability**

- RAM is fast, disk is slow
- Durability: how much of the data will be recoverable if electricy goes off
  while writing big volume of data to db?
- Memcached writes to RAM, is fast but volatile.
- Speed vs Durability: pick one

- fire-and-forget is sending data to db but not waiting for response.
- Journaling is a way to restored to consistent state in mongoDB.

**Scaling**

- Easiest way to upgrade the hardware.
- Single node's hardware for scale is known "vertical scaling" or "scaling up"
- Upgrading hardware till some point could be possible
- Distributing database across multiple machines known as "horizantally" or "scaling out"
- Multiple machines also solves the problem of single point failure.
