# Case Statements in Bash
a more elegant solution to multiple if statements

### Syntax
```bash
case word in
  patterns ) commands ;;
esac
```

### Example

```bash
echo -n "Enter a number between 1 and 3 inclusive > "
read character
case $character in
  1 ) echo "You entered one."   ;;
  2 ) echo "You entered two."   ;;
  3 ) echo "You entered three." ;;
  * ) echo "You did not enter a number between 1 and 3."
esac
```

- case selectively executes statements if word matches a pattern.
- You can have any number of patterns and statements.
- Patterns can be literal text or wildcards.
- You can have multiple patterns separated by the "|" character.

```bash
echo -n "Type a digit or a letter > "
read character

case $character in
  [[:lower:]] | [[:upper:]] ) echo "You typed the letter $character" ;;
  [0-9] )                     echo "You typed the digit $character"  ;;
  * )                         echo "You did not type a letter or a digit"
esac
```
