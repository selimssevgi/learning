# Cache Through

- (Hibernate cache)

- Application ask cache to give something

- If it is a cache miss, cache will fetch data from database, return, put in the cache

- If it is a cache hit, it returns

- The application does not talk to the db, the responsibility is now belong to cache
