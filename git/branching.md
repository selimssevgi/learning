# Branches

## Overview

- branches are cheap
  - try new ideas
  - isolate features or sections of work

- one working directory
- fast context switching

## Create Branch

```shell
git branch                   # list branches

git branch new-feature       # create a new branch
ls -al ./git/refs/heads

# at this moment HEAD points to same commit
# when there is a new commit in new branch then it changes
```

## Switch Branch

```shell
git checkout new-feature     # switched to another branch

# still refs/heads/master and ref/heads/new-feature points to same commit
# no changes in any branch, tips are still same
# switching between them, no files change in our directory
```


```shell
git checkout -b fix-login-form  # creates and checkouts to the new branch in 1

# new branch will be created off from the current branch and have those commits
```

* Do not have conflicting changes not saved/committed before switching branches

## Comparing Branches

```shell
git diff <branch-1> <branch-2>

git branch --merged    # show all branches are completely included in current branch
```

## Renaming Branch

```shell
git branch --move old-branch-name new-branch-name
git branch -m     old-branch-name new-branch-name
```

## Delete Branch

- cannot delete the branch using at that moment
- wanna cut off the branch you are on?

```shell
git branch --delete branch-to-delete
git branch -d       branch-to-delete


# git wont let you delete the branch until fully merged, or force it to delete
git branch -D branch-with-not-merged-commits
```
