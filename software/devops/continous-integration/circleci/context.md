# circleci context

- https://circleci.com/docs/2.0/contexts/

- shared environment for the same projects in the same organization

- instead of defining same env variables again and again we can use a shared context

- go to circleci/organization-settings

- need to add them for each job individually

```shell
workflows:
  version: 2
  my-workflow:
    jobs:
      - run-tests:
          context: org-global
```
