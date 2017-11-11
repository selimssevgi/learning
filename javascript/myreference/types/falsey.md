# Truthy and Falsey

- JS is kind of loose about true and false

- There are values in JS that are not true or false
- These values are nevertheless treated as true or false in a conditional
- These values are called truthy or falsey


* Concentrate on knowing what is falsey, and then everything else you can consider truthy


```javascript
if (undefined) {}

if (null) {}

if (0) {}

if ("") {}

if (NaN) {}
```

## There are 5 falsey values in JS

- undefined
- null
- 0
- empty string
- NaN


* truthy
  - []
  - 1
