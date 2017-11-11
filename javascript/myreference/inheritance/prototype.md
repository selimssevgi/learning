# Prototype

- JS objects can inherit properties and behavior from other objects

- The object you're inheriting behavior from is called the 'prototype'


```shell
                           +-------------------+
                           |  Dog Prototype    |
                           +-------------------+
                           | species: "Canine" |
                           +-------------------+
                           | bark()            |
                           | run()             |
                           | wag()             |
                           +-------------------+

 +-------------------+     +-------------------+      +-------------------+
 |       Dog         |     |       Dog         |      |       Dog         |
 +-------------------+     +-------------------+      +-------------------+
 | name: "Fido"      |     | name: "Fluffy"    |      | name: "Spot"      |
 | breed:"Mixed"     |     | breed:"Poodle"    |      | breed:"Chihuahua" |
 | weight: 38        |     | weight: 30        |      | weight: 10        |
 +-------------------+     +-------------------+      +-------------------+
 |                   |     |                   |      |                   |
 +-------------------+     +-------------------+      +-------------------+
```

* Wehn you call a method on an object instance and that method isn't found in
  the instance, you check the prototype for that method, same for properties


```javascript
function Dog(name, breed, weight) {
  this.name = name;
  this.breed = breed;
  this.weight = weight;
}

Dog.prototype.species = 'Canine';

Dog.prototype.bark = function() {
  if (this.weight > 25) {
    console.log(this.name + ' says Woof!');
  } else {
     console.log(this.name + ' says Yip!');
  }
}

Dog.prototype.run = function() {
  console.log("Run!!");
}

Dog.prototype.wag = function() {
  console.log('Wagg!');
}

var spot = new Dog('Spot', 'Chihuahua', 10);

// override prototype method
spot.bark = function() {
  console.log(this.name + ' says WOOF!');
}
```

* Later on we can add new properties or methods for all dogs

- There is a catch while adding and using new properties from prototype

```javascript
Dog.prototype.sitting = false;

Dog.prototype.sit = function() {
  if (this.sitting) { // first time this value comes from prototype
     console.log(this.name + ' is already sitting...');
  } else {
    this.sitting = true; // now the dog instance got a new property
    console.log(this.name + ' is sitting now...');
  }
}
```

## Instance Property or Prototype Property

- Every object has 'hasOwnProperty' method

- 'hasOwnProperty' returns true if a property is defined in an object instance

```javascript
spot.hasOwnProperty('species'); // false
fido.hasOwnProperty('species'); // false

spot.hasOwnProperty('sitting'); // false
spot.sitting = true;
spot.hasOwnProperty('sitting'); // true
```
