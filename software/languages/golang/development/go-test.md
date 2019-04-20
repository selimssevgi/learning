# go test

```shell
go test mylib

# run all tests also the ones in the subpackages
go test mylib/...

# run the tests that match the regex
go test -run Basic mylib/...

# verbose output
go test -v mylib/...

# get coverage report
go test -cover mylib/...
```
