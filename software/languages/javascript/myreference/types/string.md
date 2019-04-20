# String

- Types always belong to one of two camps: primitive type or an object

- primitive types are simple
- objects have state and behavior

- A string is always a primitive unless you create it using object constructor

```javascript
var str = "dfasdgdf";

str.length;
str = str.trim();
str = str.toUpperCase();
str.charAt(0);
```

- with JS you can create a string that is primitive, and also one that is object

- JS interpreter will create string objects for you

```javascript
var name = "John";      // primitive string
var phone = "123-456";  // primitive string

var index = phone.indexOf('-'); // behind the scenes JS temporarily converts
                                // phone to a string object
```

- efficiency of primitives
- capabilities of objects
- no need to keep track of when a string is what
