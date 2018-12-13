# Unit of Work

- Maintains a list of objects affected by a business transaction and coordinates
  the writing out of changes and resolation of concurrency problems

- A Unit of Work keeps track of everything you do during a business trx that can
  affect the db. When you're done, it figures out everything that needs to be
  done to alter the db as a result of your work.

- The key thing about Unit of Work is that, when it comes time to commit, the
  UoW decides what to do.
