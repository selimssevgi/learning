# NaN: Not a Number

- it is number type
- typeof(NaN);     // number

- JS uses the value NaN to represent numeric results that cannot be represented

- It is the only value in JS that is NOT equal to itself!

```javascript
NaN === NaN; //false

var a = 0/0;      // NaN

var b = 'food' * 1000;  // NaN

var c = Math.sqrt(-9);  // NaN, imaginary number cannot be represenet in JS

Infinity - Infinitiy;   // NaN

Number("a");            // NaN; cannot convert the string into number
```


```javascript
if (a === NaN) {
  // not a good to test NaN!!
}

isNaN(NaN);      // true
isNaN("NaN");    // true, string is not a number

if (isNaN(a)) { // 
  // could work
}
```
