# Aligning Resource State

- Two consumers can retrieve a resource, and make changes one after another.

- The last change will be tried to make a stale resource state.

- ETag, If-Match, If-None-Match conditional headers can be used

- Or cheaper versions: Last-Modified, If-Modified-Since, If-Unmodified-Since
