# Object Prototypes

- are the mechanism by which JS objects inherit features from one another

- They work differently than inheritance mechanisms in classical OO languages

- JS is often described as a 'prototype-based language'

- Each object has a 'prototype object'

- Prototype object acts as a template object that inherits method and properties from

- Prototype object may also have a prototype object, and so on. This is often referred to as a 'prototype chain'

- In classic OOP, when object instances are created all the properties and
  methods defined on the class are copid over to the instance.

- In JS, they are not copied over, instead a link is made between the object
  instance and its prototype

- The properties and methods are found by walking up the chain of prototypes

*NOTE:* There is a distinction between an object's prototype (which is available
via Object.getPrototypeOf(obj), or via the deprecated __proto__ property) and
the 'prototype' property on constructor functions.

## The prototype property: Where inherited members are defined 

- The inherited methods and properties are the ones defined on the prototype property

- The prototype property's value is an object, which is basically a bucket for
  storing properties and methods that we want to be inherited by objects further
  down the prototype chain.
