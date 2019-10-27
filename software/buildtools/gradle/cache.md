# gradle cache

- modules are cached
  - file based
  - meta data and files stored separately
  - repository caches are independent

- dependencies can be refreshed: *--refresh-dependencies* flag

- can delete .gradle all together, it will be regenerated

```shell
ls ~/.gradle/caches/module-2/files-2.1
```
