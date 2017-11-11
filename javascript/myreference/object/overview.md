# Object in JS

- An object is a collection of related data and/or functionality

- variables -> properties
- functions -> methods

- An object is made up of multiple members, each of which has a name and value

- An object like person is called 'object literal'

```javascript
var person = {
  name: ['Bob', 'Smith'],
  age: 32,
  gender: 'male',
  interests: ['music', 'skiing'],
  bio: function() {
    console.log(this.name[0] + ' ' + this.name[1] + '...');
  },
  greeting: function() {
    console.log('Hi! I\'m ' + this.name[0] + '.');
  }
}
```

- The object name (person) acts as an 'namespace'
- Also it is possible to have 'sub-namespace'

```javascript
var person = {
  name: {
    first: 'Bob',
    last: 'Smith'
  }
}

person.name.first
```

## Dot and Bracket Notation

```javascript
person.name.first       // dot notation
person['name']['first'] // bracket notation
```

- Because of bracket notation usage, objects are also called associative arrays

## Get, Set, Create

```javascript
person.name.first = 'Selim';
person.name.middleName = 'Sirri';  // creating a new member
```
