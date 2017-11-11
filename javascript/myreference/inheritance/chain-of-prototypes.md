# Chain of Prototypes

- Rather than having an instance that inherits properties from just one
  prototype, there might be a chain of one or more prototypes the instance can
  inherit from


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

 +-------------------+
 | ShowDog Prototype |
 +-------------------+
 | league: "Webville"|
 +-------------------+
 | stack()           |
 | bait()            |
 | gait()            |
 | groom()           |
 +-------------------+
```


```javascript
var aDog = new Dog(); // an object that inherits from the dog prototype
```
 
```javascript
function ShowDog(name, breed, weight, handler) {
  // this.name = name;
  // this.breed = breed;
  // this.weight = weight;
  // Dog constructor knows how to do this work
  Dog.call(this, name, breed, weight);
  this.handler = handler;
}

ShowDog.prototype = new Dog(); // just take the properties defined on prototype
ShowDog.prototype.constructor = ShowDog;

ShowDog.prototype.league = "Webville";

ShowDog.prototype.stack = function() {
  console.log("Stack");
}

ShowDog.prototype.bait = function() {
  console.log("Bait");
}

```

```javascript
var fido = new Dog('Fido', 'Mixed', 38);
var scotty = new ShowDog('Scotty', 'Scottish Terrier', 15, 'Cookie');

if (fido instanceof Dog) {} // true

if (fido instanceof ShowDog) {} // false

if (scotty instanceof Dog) {} // true

if (scotty instanceof ShowDog) {} // true

fido.constructor; // function Dog
scotty.constructor; // function Dog
```

* scotty does not have 'constructor' property
  - look up in the prototype: we did not define it
  - it comes from the Dog prototype

* Even though, constructor property would change how ShowDog works, is best
  practise to set up correctly

* call is a built-in method that you can use on any function
  - can be used to control what the value of 'this' is
