search for files

Ack and Ag to search through a large code base to find files that contained certain query terms,
but what if we want to search for files using criteria other than the file’s contents?

find <directory> # look at the structure of directory

find PATH_TO_SEARCH OPTIONS_TO_USE PATTERN_TO_SEARCH_FOR

find <startdirectory> --option /pattern/ # by default searchs also subdirs

find . -name model.rb # finds files named model.rb

find . -name \*model.rb # finds file name ends with *model.rb

find . -iname "*.txt" #ignore case

find . -path \*session\* # find files or dirs whose path matches the pattern

find . -path \*session\* -type f # find only files

find . -path \*session\* -type d # find only dirs

find . -path \*session\* -type f -name \*mem\* # path name AND file name

find . \( -name \*.gemspec -or -name \*.jpg \) -type f # OR expression

find . -not -path \*t\* -type f # files dirs that do NOT contain t

find . -mtime -1 # last modified time was in the last 1 day.

find . -mmin -5 # modified in the last 5 mins

find . -size +200k # files whose size is greater than 200 kb

find ./guides -type f -name \*.yml -print -delete # find all the files ends with yml and delete them and printt deleted files path
