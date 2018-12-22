# ch22 - i need to change a monster method and i can't write tests for it

- long methods are a pain, but monster methods are worse

### varieties of monsters

- monster methods come in a couple of varieties
- these are not necessarily distinct types

#### bulleted methods

- a method with nearly no indentation

- cannot extract methods with separated parts, have variables defined on top used down

#### snarled methods

- a method dominated by a single large, indented section


- if you have refactoring tools for extracting methods, good.
- if not, you have to place tests before touching anything.


##### manual refactoring

* introduce sensing variable

```java
private boolean added= false;

public void m1() {
  // complicated logic in some branch
  added = true;
}

public boolean getAdded() {
  return added;
}
```

- now we can use this variable in our tests

* extract what you know

- extract parts that have fewer variables dependencies
- the ones manipulates object state usually have zero-count parameter and safest to move around
