# package

- Go operates in terms of packages rather than files

- We can split a package across as many files as we like.

- From Go's point of view if they all have the same package declaration, they
  are all part of the same package and no different than if all their contents
  were in a single file.

- A Go program or package's imports are first searched for under the GOPATH, then GOROOT

## Local Package

- Import paths are specified using unix-style "/", even on Windows

- Every local package should be stored in a directory with the same name as the package
