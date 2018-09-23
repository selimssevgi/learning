# Godoc


```shell
# read doc for template package
go doc text/template

# by default it list only public, ask for internal
go doc -u text/template

# read doc for new method in template package
go doc text/template.new # case-insensitive, more targeted result

go doc cmd/doc
```

- go doc refers to 'godoc'

```shell
godoc -http=:6060
```

- go to localhost:6060 in order to view copy of golang.com 

- this does not show only std packages, but also other 3rd party packages in environment
