# Date

```javascript
var birthday = new Date(1985, 0, 11, 10, 15, 25);

birthday.getMonth(); // 0-11
birthday.getFullYear(); //YYYY
birthday.getDate(); // 1-31
birthday.getDay(); // 0-6
birthday.getHours(); // 0-23
birthday.getTime();  // since 1st Jan 1970

let bday1 = new Date(1985, 0, 11, 10, 15, 25);
let bday2 = new Date(1985, 0, 11, 10, 15, 25);

if (bday1 === bday2) {
  // different object false
}

if (bday1.getTime() === bday2.getTime()) {
  // true
}
```
