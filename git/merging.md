# Merge

```shell
git checkout <branch-to-receive-changes>

git diff current-branch..to-be-merged-branch

git merge to-be-merged-branch

git diff current-branch..to-be-merged-branch
git branch --merged  # to see who is fully incorporated
```

## Fast-forward merges vs Real merges

- Fast-forward

```shell
            Head
A - B - C - D
  new branch \
              E

A - B - C - D - E
```

```shell
git merge --no-ff <branch>   # make it obvious in commits there was a merge

git merge --ff-only <branch> # merge it only if you can make it fast-forward
```

## Merge Conflicts

```shell
master
<span>Git is great.</span>
        |                  \
        |                   \
        |                    \
        |                     \
        |                      \ new_style
<strong>Git is great</strong>   <em>Git is great.</em>
        |                        /
        |                       /
        |                      /
        |                     /
        |                    /
        |  -----------------/
        | /
        ??
```

### Resolving Merge Conflicts

1. abort the merge
   - git merge --abort
2. resolve the conflicts manually
3. use a merge tool

- manually

```shell
git merge a-branch     # informs about conflict
git status             # show conflicted file/s

# get into the file and make necessary changes for that file

git add file.txt
git commit             # it has commit message for this already
```

### Strategies for Reducing Merge Conflicts

- keep lines short
- keep commits small and focused
- beware stray edits to whitespace, no unnecessary changes
- merge often, smaller merges, smaller conflicts
- track changes to master, be in sync with master
