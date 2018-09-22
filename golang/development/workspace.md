# Go Workspace

- We utilize a convention for the workspace inside of Go that allows us to not
  really need build files

- Go tools can infer all the dependencies without having you create any kind of
  build management system


```shell
cd ~
mkdir gows
cd gows
mkdir src
export GOPATH=~/gows
```

- Go and create project in GOPATH/src
