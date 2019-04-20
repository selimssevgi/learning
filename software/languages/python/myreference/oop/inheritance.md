# Inheritance in Python3

```python
class AnimalActions:
  def quack(self): return self.strings['quack']
  def feathers(self): return self.strings.['feathers']
  def bark(self): return self.strings['bark']
  def fur(self): return self.strings['fur']

class Duck(AnimalActions):
  strings = dict(
    quack = "quaaa!",
    feathers = "the duck has gray and white feathers.",
    bark = "duck cannot bark",
    fur = "duck has no fur"
  )

class Person(AnimalActions):
  strings = dict(
    quack = "person imitates a duck",
    feathers = "something",
    bark = "person says woof",
    fur = "puts on a fur cuat"
  )

def in_the_doghouse(dog):
  print(dog.bark())
  print(dog.fur())

def in_the_forest(duck):
  print(duck.quack())
  print(duck.feathers())

def main():
  donald = Duck()
  john = Person()
  fido = Dog()

  print("- in the forest")
  for o in ( donald, john, fido ):
    in_the_forest(o)

  print("- in the doghouse:")
  for o in (donald, john, fido):
    in_the_doghouse(o)

if __name__ == "__main__": main()
```
