# Go Tools


```shell
go env
```

- cd $GOPATH/src/hello

```shell
# just runs the app
go run hello.go

# creates the binary: hello
go build hello.go

```


## Install

- if we have an executable or smth with main, it will install it
- It will place the executable in $GOPATH/bin directory

- If it doesn't have a main then it create a file which is basically the
  compiled file that is a library format that can be linked to and it will put
  it in a package directory

```shell
cd $GOPATH/com/selimssevgi/hw
go install
```
