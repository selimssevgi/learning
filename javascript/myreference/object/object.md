# Objects in JS

- 6 other primitive types + object(reference type)
- An object is a collection of properties
  entities.

- object > properties > key + value

```javascript
let user = new Object(); // object constructor

let user = {}; // object literal syntax

let user = {
  name: "John", // key = name = identifier
  age: "30",
  "likes bird": true, // multi word keys must be quoted
}

// get field of object via dot notation
alert( user.name );
user.isAdmin = true;

// if key is multi word? Square Bracket notation
user["likes bird"] = false;

// remove a property
delete user.age;

let Car = {
  maxSpeed: 70;
  drive: function () { console.log("driving"); }
};
```

* Iterating over properties of a function

```javascript
for (var prop in obj) {
  console.log(prop + ': ' + obj[prop]);
}
```

## Constructor Function

```javascript
let Car = function (maxSpeed, driver) {
  this.maxSpeed: maxSpeed;
  this.driver: driver;
  this.drive: function () {
    console.log("driving..");
  }
}

let aCar = new Car(70, "abc");
```
