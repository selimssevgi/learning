# Objects in JS

- 6 other primitive types + object
- Objects are used to store keyed collections of various data and more complex
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
```