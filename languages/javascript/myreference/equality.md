# Equality in JS

- ==  (equality)
- === (strict equality)

- Both works same when comparing object types

## ==

```javascript
var a = 99;

if (a == "99") { // wtf?  }

var b = "99";

if (b == 99) { // wtf?  }

99 <= 100; // true

0 < true;  // true, true is converted to 1
```

- takes the types of its operands into account when it does comparison

#### Case 1 : If operands have the same type

- just compare them

#### Case 2 : If operands have different types

- try to convert them into the same type and compare them
- more than once conversion may happen in a single comparison

### How == converts its operands

* CASE 1: comparing a number and a string
  - the string is converted into a number
  - empty string is converted into number 0

* CASE 2: comparing a boolean with any other value
  - the boolean is converted into a number
  - true is converted to 1
  - false is converted to 0

* CASE 3: comparing null and undefined
  - evaluates to true
  - null means no object
  - undefined mean no value

## === (strict equality)

- Two values are strictly equal only if they have the same type and the same value
