# ch20 - this class is too big and i dont want it to get any bigger

- need to make a little change, and do it as an addition to the class itself,
  soon enoguh that class is going to be huge

* what are the problems with big classes?

- the first is confusion: which method does what? how many places will be affected if changing this field?

- big classes are a pain to test

- this first issue to confront when we have big class is this: How can we work
  without making things worse?

- the key tactics we can use here are Sprout Class and Sprout Method

- the key remedy for big classes is refactoring. it helps to break down classes
  into sets of smaller classes.

- the biggest issue is figuring out what the smaller classes should look like: SRP

* Every class should have a single responsibility: it should have a single
  purpose in the system, and there should be only one reason to change it


### seeing responsibilities

- "why is this method here?"

- "what is it doing for the class?"

- group methods by answers

###### heuristic #1: group methods

- look for similar method names.

- write down all of the methods on a class, along with their access types (public, private...)

- try to find ones that seem to go together

###### heuristic #2: look at hidden methods

- pay attention to private and protected methods.

- if a class has many of them, it often indicates that there is another class in
  the class dying to get out.



- "How do i test private methods?"
- if you have the urge to test a private method, the method shouldnt be private
- if making a method public bothers you, chances are, it is because it is part
  of a separate responsibility. It should be another class

###### heuristic #3: look for decision that can change

- for decision that you have already made

- is there some way of doing smth (talking to a db, talking to another set of
  object and so on) that seems hard-coded? Can you imagine it changing?

- extract methods if possible, and see again if you can group another class

###### heuristic #4: look for internal relationships

- between instance variables and methods

- are certain instance variables use by some methods and not others?

- draw "feature sketches": variables and methods, draw lines between interaction

- we can see the clustering from sketches, find a name for that group and extract a new class

###### heuristic #5: look for the primary responsibility

- try to describe the responsibility of the class in a single sentence

- there are two ways to violate the SRP.

1. it can be violated at the interface level
2. it can be violated at the implementation level

- SRP violation that we care most about is violation at the implentation level

- we care whether the class really does all of that stuff or whether it just
  delegates to a couple of other classes.

- if it delegates, we dont have a large monolithic class, we just have a class that is facade.

###### heuristic #6: when all else fails, do some scratch refactoring

###### heuristic #7: focus on the current work

- pay attention to what you have to do right now

- if you are providing a different way of doing anything, you might have
  identified a responsibility that you should extract and then allow substitution for


### moving forward

- you identified different responsibilities in a large class, now you have two other issues

1. strategy

- take time to break all down into little bits

- risky, system can be unstable for a while

- identify responsibilities, make sure everyone understands them, then break
  down the class on an as-needed basis


2. tactics

- introducing SRP at the interface level requires more work

- extract responsibilities, and delegate them
