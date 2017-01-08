# Bash for Loop
- There are two types of bash for loops available.
  1. One using the “in” keyword with list of values,
  2. Another using the C programming like syntax.

## Syntax
In essence, for assigns a word from the list of words to the specified variable,
executes the commands, and repeats this over and over until all the words have been used up.

```shell
for variable in words; do
  commands
done
```

### Examples
```shell
for num in {1..10}

for num in {1..10..2}

for ((i=1, j=10; i <= 5 ; i++, j=j+5))

for (( i=1; i <= 5; i++ ))

for i in $(ls)

for day in Mon Tue Wed Thu Fri Sat Sun

for day in $weekdays

for day in "$@" # all command line arguments

for i in ${arr[@]} # iterate over arr array

for i in "${!arr[@]}" # ! gets the keys of ass. array and "" used cus key might have spaces
```

Here is an example: with static values

Caution : The list of values should not be separated by comma (Mon, Tue, Wed, Thu, Fri).
Caution : The list of values should not be enclosed in a double quote. (“Mon Tue Wed Thu Fri”).

```shell
i=1
for day in Mon Tue Wed Thu Fri
do
   echo "Weekday $((i++)) : $day"
done
```

[Variable for the list]
weekdays="Mon Tue Wed Thu Fri"
for day in $weekdays

*NOTE:* As a best practice, you should always quote the bash variables when you are referring it.
There are few exceptions to this best practice rule. This is one of them.
If you double quote the variable in this for loop, the list of values will be treated as single value.
Lot of people fall into this trap. Be careful and do not double quote your variable in the for loop.

Construct the list of words using command substitution:

```shell
count=0
for i in $(cat ~/.bash_profile); do
  count=$((count + 1))
  echo "Word $count ($i) contains $(echo -n $i | wc -c) characters"
done
```

### Usage of $@ with for loop
The shell variable "$@" contains the list of command line arguments.
This technique is often used to process a list of files on the command line.

It can use the positional parameters as the list of words:

```shell
for i in "$@"; do
  echo $i
done
```

```shell
for filename in "$@"; do
  result=
  if [ -f "$filename" ]; then
    result="$filename is a regular file"
  else
    if [ -d "$filename" ]; then
      result="$filename is a directory"
    fi
  fi
  if [ -w "$filename" ]; then
    result="$result and it is writable"
  else
    result="$result and it is not writable"
  fi
  echo "$result"
done

```
