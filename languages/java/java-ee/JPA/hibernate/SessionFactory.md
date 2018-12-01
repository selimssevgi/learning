# SessionFactory

- Thread-safe global factory class for creating Session

- SessionFactory is defined for one, and only one, database.

- We need different SessionFactory for different databases in an application

- SessionFactory maintains a second level of cache, which is available globally
  across all other components in the application. First level cache is
  maintained in the Session object

