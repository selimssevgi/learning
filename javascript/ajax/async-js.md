# Asynchronous Javascript


## Async Flow Control

- Callbacks  - good
- Promises   - better
- Generators - awesome (ES6)


## AJAX Requests

- Communicate with a server by making a http request
- No need to reload the page
- Asynchronous JavaScript And XML

### Callbacks

```javascript
let fruits = ["apple", "banana", "pear"];

fruits.forEach(function(val) {
  console.log(val);
});

function callback(val) {
  console.log(val);
}

fruits.forEach(callback);
console.log("done"); // it is synchronous

$.get(link, function(data) {
  console.log(data);
});
console.log("done"); // it is asynchronous
```

### Promises

- A alternative to callback hell

```javascript
function get(url) {
  return new Promise((resolve, reject) => {

    let xh = new XMLHttpRequest();
    xh.open('GET', url, true);

    xh.onload = function() {
      if (xh.status === 200) {
        resolve(JSON.parse(xh.response));
      } else {
        reject(xh.statusText);
      }
    };

    xh.onerror = function() {
      reject(xh.statusText);
    };

    xh.send();

  });
}

let promise = get(url);

promise.then((jsonData) => {
 console.log(jsonData);
 return get(anotherURL);
}).then((data) => {
  console.log(data);
}).catch((err) => { console.log(err); });
```

```javascript
// jQuery Promise
$.get('data/tweets.json').then(function() {
  console.log(tweets);
  return $.get('data/friends.json');
}).then(function(friends) {
  console.log(friends);
  return $.get('data/videos.json');
}).then(function(videos) {
  console.log(videos);
});
```

### Generators

