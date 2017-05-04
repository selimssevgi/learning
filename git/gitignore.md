# gitignore

- Tells Git what not to track

- very basic regular expressions
  - * ? [aeiou] [0-9]

- negate expressions with !
  - \*.php     - ignore all php files
  - !index.php - track index.php

- ignore all files in a directory with trailing slash
  - assets/videos

- comment lines begin with #

## What to ignore

- compiled source code
- packages and compressed files
- logs and databases
- operating system generated files
- user-uploaded assets (images, pdfs, videos)

## Global gitignore

- ignore files in all repositories
- settings not tracked in repository
- user-specific instead of repository-specific


```shell
git config --global core.excludesfile ~/.gitignore_global
```

## Ignore already tracked files

```shell
echo "file.txt" >> .gitignore

git rm file.txt               # would also remove file from hdd

git rm --cached file.txt      # leave the copy on hdd, take it out from index

git status
# now file.txt seems to be deleted, but still on hdd
```

## Tracking Empty Directories

- Git is designed to be a file-tracking system
  - tracks files
  - tracks directories it takes to get to files
  - ignores directories with no files

- create a tiny file, by convention is called: .gitkeep

```shell
touch .gitkeep
```
