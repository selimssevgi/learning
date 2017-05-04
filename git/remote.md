# Remotes

- 'master' on remote named origin
- 'origin/master' on our computer: a mirroring branch of remote master
- 'master' on our computer

```shell
git remote                # shows the list of remotes

git remote add <alias> <url>

git remote add origin <URL>

git remote -v             # verbose

cat ./git/config

git remote rm origin      # remove a remote

git push -u <remote-name> <branch-name>
git push -u origin master

cat ./git/refs/remotes/origin

git branch -r              # see remote branches
git branch -a              # see all branches
```

## Cloning

```shell
git clone URL/repo_name.git       # clones into directory:repo_name
git clone URL/name.git new-dir-name
```

## Pushing

```shell
git diff origin/master..master
git push
```

## Fetching

- fetch synchronizes origin/master with whatever is on remote repo

- fetch before you work, to see up-to-date changes from collabrators
- fetch before you push, solve early if any conflics
- fetch often

```shell
git fetch origin    # goes on internet and fetch changes on origin remote

git fetch           # if there is only one remote

# updates origin/master, local cached copy of remote

git log --oneline -5 origin/master
git log --oneline -5 master         # wont show commits from remote


# merge origin/master with master
git branch -a
git diff origin/master..master
git merge origin/master             # merging fetched local cache of origin/master
```

## Pull

- git pull = git fetch + git merge
- it is a short cut when you understand the details

## Checkout remote branches

- Git doesnt want us get into the way by switching and making changes on remote
  branches

- We should create our own branches from remote branches

```shell
git branch                    # local branches
git branch -r                 # remote branches
git branch -a                 # all branches

git branch new-branch HEAD    # branch out from HEAD by default

git branch new-branch origin/remote-branch
git checkout -b new-branch origin/remote-branch
```

## Delete remote branch

```shell
git push origin --delete a-branch-name
```
