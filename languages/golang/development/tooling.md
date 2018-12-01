# Go Tooling

- GOROOT is where go is installed. (default is /usr/local)

## GOPATH

- GOPATH is user workspace (default is ~/go)

- We are likely to develop our own Go programs and packages in our own directory

- This can be easily accommodated by setting the GOPATH env variable to two (or
  more) colon-separated paths

```shell
GOPATH=$HOME/app/go:$HOME/go
```

## Structuring

- Every piece of Go code exists inside a package, and every Go program must have
  a 'main' package with a main() function which serves as the entry point.

## go build

- Two steps are required to build Go programs: compiling and linking

- Go tool handles both

## go install

- Does the same as 'go build' only it puts the executable in a standard location

- Standard location is $GOPATH/bin

- Adding the standard location to the PATH, all the Go programs that we install
  will conveniently be in the PATH
