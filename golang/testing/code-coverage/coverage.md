# Code Coverage

```shell
// just outputs the percent
go test mymath -cover

go test mymath -coverprofile=cover.out

go tool cover -func=cover.out

go tool cover -html=cover.out
```
