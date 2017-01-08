# grep Command
search sub-strings in files

- grep is found on almost all Unix/Linux systems,
- whereas ack or ag may need to be installed.
- ack or ag both support more modern APIs than grep.
- ack or ag are faster than grep; ag is significantly faster.

## Some Example Usage of grep

```shell
# search a given string in a single file
grep "literalstring" filename
grep Pack README.md # search for Pack in README file
```

```shell
# search a given string in multiple files
grep "literalstring" demo_*
# demo_file:this line is the 1st lower case line in this file.
grep rails README.md RELEASING_RAILS.rdoc # searching specific files
grep gem *.rb # search in all files ends with rb
```

```shell
# case insensitive search
grep -i "string" FILE
grep -i rails README.md # ignore-case
```

```shell
# match regex in files
grep "REGEX" FILE
grep "t[a-k]" demo
grep "r..y" README.md # search for words starts with r, any two characters, ends with y
```

```shell
# checking for full word, not for sub-string
grep -w "is" demo # doesnot match his, this etc, just " is "
```

```shell
# displaying lines before/after/around match using -A, -B, -C
grep -A 3 "this" demo.txt
grep -B 2 "this" demo.txt
grep -C 2 "this" demo.txt # -C(-A && -B)
```

```shell
# search recursively
grep -r "string" PATH
grep -R "Read" . # search in current directory recursively
```

```shell
# invert match
grep -v "this" demo
```

```shell
grep -c ruby README.md # counting occurences. output : number
grep -v -c ruby file # how many line does not match
```

```shell
# just prints the file names
grep -l this demo_*
```


```shell
# show out only matched string not line
grep -o "is..." demo.txt
```

```shell
# show line number
grep -n "this" demo.txt
grep -n Ruby README.md # displaying the line numbers of the results
```





grep -R --include="*.yml" "Read" . # search for the term only in yml files

grep -v "a" README.md # search for all the lines in the file that do NOT contain the letter a. inVert search

grep -v "^$" README.md | grep -v "a" # get all non-blanks lines then search for ones that do not contain the letter a 
