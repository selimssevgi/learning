# MongoDB

- It is a document database.

- It uses JSON format.

- MongoDB natively supports scaling out through its sharding feature.

- y axis: Scalability & Performance: memcached, key-value store
- x axis: Depth of Functionality: RDBMS
- MongoDB somewhere in the middle

- MongoDB does not supports 'joins'.
- Joins scales poorly when you want to scale out to multiple nodes.

- Another piece of functionality missing in MongoDB is 'transactions'.
- You can access documents atomically, so smth that might require multiple
  updates within a relational system can be handled within a single atomic
  transaction within a single document. No transaction across multiple documents

- MongoDB omits 'joins' and 'transactions' in order to retain scalability.
