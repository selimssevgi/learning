# Python Command Line Arguments

- sys module provides access to any cl arguments via the sys.argv

- sys.argv is a list

- the first argument is the script name


```python
# python3 test.py arg1 arg2

import sys

print("Number of args:", len(sys.argv))
print(type(sys.argv))

if __name__ == "__main__":
  main(sys.argv[1:])
```
