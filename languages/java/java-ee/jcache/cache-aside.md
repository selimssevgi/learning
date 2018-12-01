# Caching aside Pattern

- Request comes, application ask cache if it has it

- If it is a cache hit, serves from the cache

- If it is a cache miss, it goes to database, writes to cache, and serves.

## Cach aside Conclusions

- Solution most seen out there: Spring, Play, Grails

- Most often based on annotations

- Tricky to get the concurrency and / or atomicity right
  - Two requests comes, both goes to db, one of them read stale data and write into cache
  - Especially when rolling your own
  - does not resolve doing multiple real invocations when warming cache
