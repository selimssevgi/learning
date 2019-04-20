# find

- search for files and directories

```shell
find <directory>              # look at the structure of directory
find . -empty                 # finds empty files in current directory

find <path_to_search> <options_to_use> <pattern_to_search_for>

find . -name model.rb         # finds files named model.rb
find . -name *model.rb        # finds file name ends with *model.rb
find . -iname "*.txt"         # ignore case

find / -name etc -type f
find . -name src -type d

find . -path "*session*"      # find files or dirs whose path matches the pattern
find . -path "nput*" -type f  # find only files
find . -path "nput"  -type d  # find only dirs

find . -path "str" -type f -name "str"              # path name AND file name

find . ( -name *.gemspec -or -name *.jpg ) -type f  # OR expression

find . -not -path *t* -type f      # files dirs that do NOT contain t

find . -mtime -1                   # last modified time was in the last 1 day
find . -mmin -5                    # modified in the last 5 mins
find . -size +200k                 # files whose size is greater than 200 kb

find . -type f -name "*.jpg" -maxdepth 1 # not from subdirs


find ./guides -type f -name \*.yml -print -delete
# find all the files ends with yml and delete them and printt deleted files path
```

Ack and Ag to search through a large code base to find files that contained certain query terms,
but what if we want to search for files using criteria other than the file’s contents?
