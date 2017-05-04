# Git

## Init

- Creates .git directory in project directory
- Remove .git if you dont want to have git tracking your changes
- Do not edit things in .git directory except maybe 'config'

```shell
# mkdir and cd into project
git init
```

## Commit

- short single-line summary (less than 50 characters)
- optionally followed by a blank line and a more complete description
- keep each line to less than 72 characters
- write commit messages in present tense
- bullet points are usually asterisks or hyphens

```shell
echo "hello" > first.txt
git add .
git commit -m "initial commit"

# two steps in one go:
git commit -am "message" # just simple modification, doesnt include new or delete
```

## Log

```shell
git log                         # see log list
git log -n 5                    # last 5 commits

git log --since=2017-05-03
git log --until=2017-12-20
git log --since="2 weeks ago"
git log --since=2.weeks

git log --author="selim"
git log --grep="init"

git log --oneline

git log -p avse134.. index.html
git log --stat --summary

git log --graph
git log --oneline --graph --all --decorate

git show {sha}

git log master --oneline -3
```

## Status

```shell
git status
```

## Diff

- git uses less command to show diff, use -S or -s to chop or wrap long lines

```shell
git diff                     # all changes: working tree vs staging index tree
git diff afile.txt           # changes in a file
git diff --color-words a.txt # different way of showing diff

git diff --staged            # changes in staged items
```

## Delete, Rename, Move

```shell
rm deleted                # or move to trash
git rm deleted.txt        # now remove from staging index tree

# or directly: in one step
git rm another.txt        # uses unix rm to delete file from hdd and rm from stage

#----------------------
mv first.txt primary.txt
# two changes in git status: deleted, new file
git add primary.txt
git rm first.txt
# git now sees one change in git status: renamed, %50 data diff treshold

# in one step
git mv first.txt primary.txt  # let git handle for small changes

git mv a.txt adir/a.txt
```

## Undo Changes

- undo modification

```shell
# did some deleting or changes in file.txt
# working tree changed, however repository tree has the original version
git diff file.txt

git checkout file.txt      # CAREFUL: checkout also used with branches

# lets undo changes in resource directory
git checkout resource      # What if there is also a branch called 'resource'?

# to not have such problem, and be explicit about file checkout
git checkout -- file.txt   # stay on this branch, checkout this file
```

- unstage files

```shell
git add file.txt                 # staged

git reset HEAD file.txt          # unstaged that file.txt
```

- change last commit
- other commits cannot be changed, it will break the chain
- each commit id is parent of next commit id, having a sha1 based on that
- therefore it is only possible to change last commit,therefore sha1, cus commit
  id is not being used yet

```shell
# change something in file.txt
git add file.txt
git commit -m "add some changes"

# then immediately changing something else in file.txt
# not to have a separate commit, include in the previous one
git add file.txt
git commit --amend -m "some more changes"

# or change commit message
git commit --amend -m "a better descriptive message"
```

## Revert

```shell
git revert {a-part-of-commit-id}
```

## Reset

- using reset to undo many commits
- powerful, dangerous
- lets us specify where HEAD should point
- record audio, rewind back 10 mins, start recording, overriding!
- Git reset always moves the HEAD pointer

- there options:
  - soft: does not change staging index or working directory
  - mixed(default): changes staging index to match repository
                    does not change working directory
  - hard: changes staging index and working directory to match repository

## Clean

- easier way to remove junk, that is not in our staging or repository
- throw away the untracked files

```shell
git clean                     # wont do anything
git clean -n                  # tell us what will happen
git clean -f                  # do it!
```
