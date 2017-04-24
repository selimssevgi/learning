# Strings

- In Python 3, all strings are represented in Unicode.
- In Python 2, they are stored internally as 8-bit ASCII.
- String are immutable.
- A sequence of case sensitive characters
- can compare strings with ==, >, <
- len() function to retrieve the length

* In Python, there is no char type, it is a character long string.

```python3
var1 = 'Hello world!'
var2 = "Python Programming"

var3 = """multiple line
          line string\n escape characters works
          single quotes can be used too
       """

var4 = r"raw string\nstay as they are"
```

## Indexing

- Square brackets used to perform indexing
- Starting from 0
- Negative numbers can be used as well, -1 is the last character
- s[20]: string index out of range

## Slicing

- can slice strings using [start:stop:step]
- s[::] -> [0:len(s):1]
- s[::-1] -> [-1:-(len(s)-1):-1] -> inverse of the string

## Immutable

- Cannot be modified
- s[0] = 'y' # error
- s = 'y' + s[1:len(s)]    # binds to new string

## Loops

```python
s = "abcdefg"
for index in range(len(s)):
  if s[index] == 'i' or s[index] == 'u':
    print("There is an i or u")

# more pythonic
for char in s:
  if char == 'i' or char == 'u'
    print("There is an i or u")

```

## Escape Characters

- \n, \\, \", \'
