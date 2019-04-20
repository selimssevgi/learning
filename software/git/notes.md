# Notes on Git


## What is Git?

- Keeps track of changes
  - especially text changes
  - version 1, version 2, version 3
  - compare, see changes

- Version Control System (VCS)
- Source Code Management (SCM)
- Both terms are used interchangably

* Examples of version control (non-source code)
  - File naming (file_v1.txt, file_v2.txt)
  - Microsoft Word's track changes
  - Photoshop's history
  - Wikis
  - Undo: C+Z

## History

- Source Code Control System (SCCS)
  - 1972, closed source, free with Unix
  - keeps the original and snapshot of changes

- Revision Control System (RCS)
  - 1982, open source, works on pc too
  - faster, keeps most recent file, applying chances backwards for previous versions

* Problem with above approaches was that they could track only a single file at a time

- Concurrent Versions System (CVS)
  - 1986-1990, open source
  - store code in a remote repository, multiple people working on same code

- Apache Subversion (SVN)
  - 2000, open source
  - allows to save also non-textual file, images
  - watching a directory as a whole, not just files, snapshot of a directory
  - renaming a file, moving etc, no problem
  - transactional changes, big changes or not at all

- BitKeeper SCM
  - 2000, closed source, proprietary
  - distributed version control
  - "community version" was free
  - used for source code of the Linux kernel from 2002-2005
  - Controversial to use proprietary SCM for an open source project
  - April 2005: the CVersion not free anymore

- Git is born, April 2005, by Torvals
  - distributed version control
  - open source and free software
  - compatible with most of OSs
  - faster than other SCMs
  - better safeguards against data corruption

## Distributed Version Control

* Central Code Repository Model
  - one central place storing master copy of the code
  - check out a copy from the master repo to work with
  - Make changes, submit those changes back to central repo
  - Other people work in the same way with central repo
  - It is up to person to keep up-to-date with central repo

* Distributed Version Control
  - different users maintain their own repo, instead of working from a central repo
  - changes are stored as "change sets" or "patches"
    - tracks changes, not versions
    - different from CVS and SVN, which track versions
  - git encapsulating a change set as a discrete unit
  - change sets can be exchanged between repositories
  - No single master repository, just many working copies
    - Each with their own combination of change sets


* Example: image changes to a document as sets A, B, C, D, E, F
  - Repo 1: A, B, C, D, E, F
  - Repo 2: A, B, C, D
  - Two repositories with different set of changes
  - Repo 3: A, B, C, E
  - Repo 4: A, B, E, F
  - None of them is the master repository
  - They are just different repos
  - We can add a change any of them, and it doesnt have to go to a central repo
  - In CVS and SVN, changes have to be submitted to the central repo

  - By convention, a repository accepted as master repository
  - This is not built-in to Git, it is not part of Git's architecture

* Advantages of DSC
  - no need to communicate with a central server
    - faster
    - no network access required
    - no single failure point
  - encourages participation and "forking" of projects
    - developers can work independently
    - submit changes sets for inclusion or rejection

* There is no central repository, all repositories are considered equal by Git
