# XMLHttpRequest

- The keystone of AJAX is the XMLHttpRequest object
- All modern browsers have a built-in XMLHttpRequest object


```javascript
let xh = new XMLHttpRequest();

xh.open('GET', 'animal.json', true);

// methods
xh.abort();
xh.open(method, url[, async][, username][, password])
xh.send();
xh.send("name=John&age=35"); // post method
xh.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xh.getAllResponseHeader();
xh.getResponseHeader('Last-Modified');

// properties
xh.onreadystatechange; // whenever readystate changes callback is called
xh.readyState;         // 0: init, 1: connect, 2: received, 3: processing 4: finish
xh.responseText;       // response data as String
xh.response;           // response data as String
xh.responseXML;        // response as XML
xh.status;             // 200: OK, 403: Forbidden, 404: Not Found ...
xh.statusText;         // "OK", "Not Found"
```


```javascript
// vanilla js

const link = 'http://www.filltext.com?rows=5&content={string}'

window.onload = function () {

  let xh = new XMLHttpRequest();

  xh.onreadystatechange = () => {
    if (xh.readyState === 4 && xh.status === 200) {
      console.log(JSON.parse(xh.response));
    }
  };

  xh.open('GET', link, true); // true for async
  xh.send();

};
```

```javascript
let link = 'https://learnwebcode.github.io/json-example/animals-1.json';

var ourRequest = new XMLHttpRequest();

ourRequest.open('GET', link);
ourRequest.onload = function () {
  // console.log(ourRequest.responseText);
  // var data = ourRequest.responseText;
  // console.log(data[0]); // interpretes as simple plain text, data[0] -> [

  var jsonData = JSON.parse(ourRequest.responseText);
  console.log(jsonData[0]);
  doSomethingWithData(jsonData);
};

ourRequest.onerror = function () {
  console.log("something went wrong!");
};

ourRequest.send();
```
