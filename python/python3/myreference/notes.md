# Python3 Notes
- Python is both interpreted and compiled similar to Java.
- No need to compile Python code expilicitly, it does by its own if necessary.
- .pyc extension means python code is compiled into an intermediate language.

### How to Run a Python Script

```python
#in hello_world.py
#!/usr/bin/env python3
print("Hello World!")
```

```shell
$ python3 hello_world.py
# or
$ chmod +x hello_world.py
$ ./hello_world.py
```
## Output

print("Hello World")
print(x, y) # on the same line
print("Nice to meet you" + name + "!")

## Input
name = input("What's your name? :")
age = int(input("Your age? : "))

## Conditions
if person == "french" or person == "French" :
    print("Préférez-vous parler français?")
elif person == "italian" or person == "Italian":
    print("Preferisci parlare italiano?")
else:
    print("You are neither Italian nor French,")
    print("so we have to speak English with each other.")

max = a if (a > b) else b

## Loops 

### While
while condition:
  statement_1
  ...
  statement_n
else:
  statement_1
  ...
  statement_n


### For Loop
- sequence: string, list, tuples, keys of dictionary

for <variable> in <sequence>:
  <statements>
else:
  <statements>

#### range
- range(10) == range(0,10) ; from 0 to 9
- range(start, end)
- range(start,end,step) 

for counter in range(1, n+1):
  print(counter)

## List
- A collection of objects
- An ordered group of items or elements
- Elements of a list can be accessed by an index
- Items in a list need not all have the same type.
- Lists can grow in a program run, while in C and Java arrays are fixed size

empty_list = []
integer_list = [1,2,3]
mixed_list = [1,2,"Istanbul", 3.14]
lst = ["Istanbul", "Izmir"]

len(lst) # 2

"Istanbul" in lst # true

lst.append("Bursa") # returns None

lst.pop(0) # removes and returns the element
lst.pop() # last element
lst.remove(i)
lst.index("Istanbul") # return 0, if not ValueError
lst.insert(index,object)
