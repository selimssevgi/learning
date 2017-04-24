# File IO


```python
fh = open("a.txt", "r")

# r is default option
fh = open("a.txt")

for line in fh:
  print(line.rstrip()) # strip off whitespaces and new lines


# writing
fh = open("b.txt", "w")
fh.write("lien1\n")

fh.close()
```


```python
# closes the file automatically after indented block
with open("a.txt", "w") as fh:
  fh.write("line1\nline2\n")

with open("b.txt") as fh:
  for line in fh:
    print(line.rstrip()
```


```python
lines = open("a.txt").readlines() # a list of lines

content = open("a.txt").read() # a string
```

```python
# open an existing file for reading and writing
fh = open("a.txt", "r+") # wont delete the content

# open a file for reading and writing
```
