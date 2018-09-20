# General Stuff

- The only two characters that cannot appear in a filename are the / and null
  - Slash character: separates the filenames that form a pathname
  - Null character: terminates a pathname

- For portability, POSIX.1 recommends restricting filenames: [a-zA-Z0-9\.-\_]

- Two filenames are automatically created whenever a new directory is created
  - dot (.)
  - dot-dot (.)
