# Discovering AOP

- there are 'concerns' of a system.

- Specific requirements of a system is 'core concerns', because they form the
  core functionality of the system.

- Other concerns, such as security, logging, resource pooling, caching,
  performance monitoring, concurrency control, and transaction management, and
  many other modules. We call these functionalities 'crosscutting concerns'.

- For core concerns, OOP does a good job.

- You can't do crosscutting concerns with OOP alone. It forces you to fuse the
  implementation of these functionalities in many modules. This is where AOP helps.

- AOP is a methodology that provides separation of crosscutting concerns by
  introducing a new unit of modularization, an 'aspect'.

## Life without AOP

- An implementation with crosscutting concern also breaks the Single
  Responsibility Principle.

- If you need to change the invocation of the code related to crosscutting
  concerns, you must change each class that includes such an invocation. Doing
  so breaks the Open/Close Principle.

## Code Tangling

- Code tangling is caused when a module is implemented to handle multiple
  concerns simultaneously.

## Code Scattering

- Code scattering is caused when a single functionality is implemented in
  multiple modules.

## Anatomy of an AOP Language

- The 'language specification' describes the language constructs and syntax to
  express implementation of the core and crosscutting concerns.

- The 'language implementation' verifies the code's adherence to the language
  specification and translates the code into an executable form.

## Fundamental concepts in AOP

- To implement a crosscutting concern, an AOP system may include many of the
  following concepts:

* "Identifiable points in the execution of the system" -- The system exposes
  points during the execution of the system; execution of methods, creation of
  objects, throwing exceptions. Such identifiable points in the system are
  called *Join Points*. 

* "A construct for selecting join points" -- A pointcut may use another pointcut
  to form a complex selection. Pointcuts also collect context at the selected
  points. The concept of join points and the pointcut construct together form an
  AOP system's *join point model*

* "A construct to alter program behavior" -- After a pointcut selects join
  points, you must augment those join points with additional or alternative
  behavior. The 'advice' construct in AOP provides a facility to do so.

* "Constructs to alter static structure of the system": add a logger field in
  classes

* "A module to express all crosscutting construct" -- Because the end goal of
  AOP is to have a module that embeds crosscutting logic, you need a place to
  express that logic. The 'aspect' construct provides such a place. An aspect
  contains pointcuts, advice, and static crosscutting constructs.

