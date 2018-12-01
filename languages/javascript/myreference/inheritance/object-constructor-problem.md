# Object Constructor Problem


```javascript
function Dog(name, breed, weight) {
  this.name = name;
  this.breed = breed;
  this.weight = weight;
  this.bark = function() {
    if (this.weight > 25) {
       console.log(this.name + ' says Woof!');
    } else {
       console.log(this.name + ' says Yip!');
    }
  }
}
```

- Every dog can have its own custom values and a consistent set of properties

- Every dog comes complete with a bark method

- We are totally resuing code across all the dogs

* Every dog gets the same code from the constructor, saving us lots of code
  headaches if things change in the future

```javascript
var fido = new Dog('Fido', 'Mixed', 38);
var fluffy = new Dog('Fluffy', 'Poodle', 30);
var fido = new Dog('Spot', 'Chihuaua', 10);
```

- Each object has a reference to the bark function

- Each dog has its own individual bark function, they all do the same thing, but
  each dog has its own copy of the function

- At a code level we've got reuse, but at the runtime it looks like we get a new
  duplicate function with every dog

* See 'prototype' to solve this problem
