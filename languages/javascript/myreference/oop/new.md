# What does 'new' do?

```javascript
function Person(saying) { // function constructor
  this.saying: saying
}

Person.prototype.talk = function() {
  console.log(this.saying);
}

var p1 = new Person('Hellloooo');
p1.talk()
```

- it creates a new fresh object, plain object, no properties

- It is going to set new object's prototype

- Calls the function constructor: this === 'new object'

- return the new object it created in the first step

* Creating our own new

```javascript
var p1 = new(Person, 'Im Bob')

function new(constructor) {
  var obj = {};
  Object.setPrototypeOf(obj, constructor.prototype);
  // var argsArr = Array.from(arguments); //ES6
  var argsArr = Array.prototype.slice.apply(arguments); // ES5
  constructor.apply(obj, argsArr.slice(1));
  return obj;
}
```
