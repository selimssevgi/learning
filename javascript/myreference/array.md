# Arrays in JS

- If an item doesnot exist, trying to access it will result in a value of undefined
- a value of any type can be used for an array item

* Creating an array

```javascript
let emptyArr = [];

let arr = [1, 2, 3];

let arr = [1, 1.0, false, "str"];
```

* Adding Elements

```javascript
var arr = [];
var arr2 = new Array(3);

arr[0] = 0;
// if we mix up the last index either overwrite or sparse array

// a safer way of adding elements
arr.push(100);              // adding a new item into arr, return arr legth
arr.unshift(-100);          // add to at the beginning of arr
```

* Accessing elements

```javascript
for (var i = 0; i < arr.length; i++) {
  console.log(arr[0]);
}
arr.pop();                  // removes last item and returns it
arr.shift();                // removes the first item
arr.sort();
arr.reverse();
arr.join(',');

```
