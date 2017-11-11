# Object Constructors

- Are the path to better object creation

- A constructor is quite similar to a function that returns an object

## Creating a Constructor

- The name of constructor function is a capital letter, not required, convention
- Does not return anything explicitly
- If explicitly something is returned(other than this), constructor will not return the object
  it's supposed to be constructing

```javascript
function Dog(name, breed, weight) {
  this.name = name;
  this.breed = breed;
  this.weight = weight;
  this.bark = function() {
     if (this.weight > 25) {
      console.log(this.name + ' says woof!');
    } else {
       console.log(this.name + ' says Yip!');
    }
  };
}

function Duck(type, canFly) {
  this.type = type;
  this.canFly = canFly;
}
```

## How to Use a Constructor

```javascript
var fido = new Dog('Fido', 'Mixed', 38);
var fluffy = new Dog('Fluffy', 'Poodle', 30);
```

## How Constructors work

- understand what 'new' operator is doing

1. The first thing 'new' does is create a new, empty object

2. Next, 'new' sets 'this' to point to the new object

3. With 'this' set p, calls the function constructor passing arguments

4. Next the body of the function is invoked, which customizes the properties

5. Finally, once the function constructor has completed its execution, returns 'this'

## Dont Forget to Use 'new'

- If you dont use 'new', a new object will never be created

- Any references to 'this' in constructor will refer to the global object

- Function constructor will return 'undefined'

*NOTE:* Global object is the top-level object, which is where global variables
get stored. In the browsers, this object is the window object
