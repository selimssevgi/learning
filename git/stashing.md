# Stashing

- Storing changes temporarily without having to commit them
- Put them into a drawer to save it for later
- not part of the three-tree, it is a special fourth are

- might be used while switching between branches
- have changes in the branch, but not ready to commit
- stash them so you can safely switch to other branches

```shell
git stash save "description of the change"

git stash list     # show the list of stashed in any branch

git stash show stash@{0}

git stash show -p stash{0} # more details on change

git stash pop              # applies and removes
git stash apply            # just apply and leave the stash

git stash pop stash{0}
git stash pop stash{1}

git stash drop stash{1}

git stash clear            # delete all stashes
```

