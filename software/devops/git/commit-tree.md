# Navigating the Commit Tree

- referencing commits

- tree-ish
  - full SHA-1 hash
  - short SHA-1 hash
  - HEAD pointer
  - branch reference, tag reference
  - ancestry
    - parent commit: HEAD^ | HEAD~ | HEAD~1 # parent of HEAD
    - gparent: HEAD^^, abcde532^^, master^^ | HEAD~2


```shell
git ls-tree HEAD
git ls-tree master
git ls-tree master /src
git ls-tree master^ /src
git ls-tree abc1234
```

## Comparing Commits

```shell
git diff {sha}
git diff {sha}..{sha}

git diff <branch-1> <branch-2>
```
