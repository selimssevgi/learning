# routing best practices

1. *keep URLs short*

2. *favor path parameters over query variables*
  - query variables: transient stateful data: search filter

3. *prefer to spell out words*
  - no abbreviation

4. *use hyphens when using multiple words*

5. *limit the use of secondary routes*

6. *carefully consider the correct guard to use for your use case*

7. *use feature modules so you can use lazy loading*

## route path naming strategy

- /products
- /products/:id
- /products/:id/edit
