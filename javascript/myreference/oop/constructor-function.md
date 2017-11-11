# Constructors

- JS doesnot have a 'class' statement for creating classes, unlike many OO languages

- JS uses special functions called 'constructor function' to define object and
  their features

- When a new object instance is created from a constructor function, the
  functionality is not all copied over to the new object like 'classic' OO languages

- In JS, the functionality is linked to via a reference chain called a prototype chain


*NOTE:* Not being "classic OOP" is not necessarily a bad thing. OOP can get very
complex very quickly, and JS has some nice ways to take advantage of OO features
without having to get too deep into it.


```javascript
// using constructor function
function createNewPerson(name) {
  var obj = {};

  obj.name = name;
  obj.greeting = function() {
    console.log('Hi! I\'m' + this.name + '.');
  }

  return obj;
}

var salva = createNewPerson('Salva');
console.log(salva.name);
salva.greeting();
```

*Problem with the above approach:*

- It works but is a bit longwinded
- We want to create an object, why do we need to explitly create a new empty
  object and return it?


* JS provides us with a handy shortcut, in the form of constructor function


```javascript
function Person(name) {
  this.name = name;
  this.greeting = function() {
      console.log('Hi! I\'m ' + this.name + '.');
  }
}

var p1 = new Person('Selim');
var p2 = new Person('Joe');

p1.greeting();
p2.greeting();
```

*NOTE:* A constructor function name usually starts with a capital letter. This
convention is used to make constructor functions easier to recognize in code.

*PROBLEM:* When we are calling our constructor function, we are defining
'greeting()' every time, which isn't ideal. To avoid this, we can define
functions on the prototype instead.
