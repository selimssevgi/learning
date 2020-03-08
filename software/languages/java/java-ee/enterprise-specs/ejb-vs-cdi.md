# ejb vs cdi

- cdi-managed bean other than lifecycle, DI, and context management, has no
  enterprise services such as trx management

- when cdi sees the @Inject, it looks for any object that implements the
  interface and injects it
