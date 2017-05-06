# echo

```shell
greeting="hello"

# no quotes
echo $greeting, world \(planet\)!   # shell interpreters what it sees

# single quotes, strong quotes
echo '$greeting, world \(planet\)!' # nothing gets interpretered

# double quotes, middle way
echo "$greeting, world \(planet\)!"

echo # empty line

echo $VARIABLE

echo -n hello # no newline

echo -e "Inserting several blank lines\n\n\n" # enable backslash escape

echo 'use "man echo"'

echo >> <filename>                   # appends a new line !! dont use one >

echo text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER
text /home/me/ls-output.txt a b foo 4 me

echo "text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER" # suppressing some expansion
text ~/*.txt {a,b} foo 4 me

echo 'text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER' # suppressing all expansions
text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER

echo "first line
      second line
      third line" #will be printed as it is
```
