# Git Concepts and Architecture

## The Three Trees Architecture

### Two-tree Architecture

- two trees: (other scm)
  - repository
  - working

- working    -- commit   --> repository
- repository -- checkout --> working

### Three-tree Architecture

- three trees: (git)
  - repository
  - staging index
  - working

- working -- add --> staging index -- commit --> repository
- repository -- (checkout) --> working

## Git Workflow

- a file being created and change A is made to it in 'working' tree
- 'git add' makes change A available in 'staging index' tree
- 'git commit' makes change A available in 'repository' tree

## Referring to Commits

- A is change set, might be made changes in multiple files
- Git generates a checksum for each change set
  - checksum algorithms convert data into a simple number
  - same data always equals same checksum

- data integrity is fundamental,
  - changing the data changes the checksum

- Git uses SHA-1 hash algorithm to create checksums
  - 40-character hexadecimal string

- each commit has some metadata
  - parent (commit sequence)
  - author
  - message

## HEAD pointer

- Git maintains a reference variable called HEAD
- Points to a specific commit in the repository

- pointer to 'tip' of current branch in repository
- last state of repo, what was last check out
- points to parent of next commit
