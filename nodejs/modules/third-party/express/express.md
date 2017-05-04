# Express

- A minimal and flexible Nodejs web framework
- Contains a middleware framework

* Some of core feautres:
  1. Allows to set up middlewares to respond to http requests
  2. Easy and flexible routing system
  3. Integrates with many templating engines


## Init

```javascript
let express = require('express');

let app = express();

// send method figures out content-type
app.get('/', (req, res) => res.send("This is home page"));

app.get('/contact', (req, res) => res.send("This is a contact page"));

app.get('/profile/:id', (req, res) => res.send("Profile id is " + req.params.id));

app.listen(3000);
```

## Routing

```javascript

app.get('/', (req, res) => console.log("GET /"));

app.get('/:id', (q, s) => console.log(q.params.id));

app.post('/', (q, s) => console.log("POST /"));

app.delete('/', (q, s) => console.log("DELETE /"));
```

## Query Strings (GET method)

- key-value pairs after ?

```javascript
app.get('/news', (req, res) => {
  // news?page=2
  console.log(req.query.page); // {page: 2}
  res.render('news', {qs : query});
});

app.get('/', (req, res) => {
  // extracting values from GET form
  let name = req.query.name;
  let age  = req.query.age;
  console.log(name + age)

  res.end(JSON.stringify({name: name, age: age}));
});
```

## POST Request

- npm install body-parser

```javascript
let bodyParser = require('bodyParser');

let urlencodedParser = bodyParser.urlencoded({ extends: false });

app.post('/contact', urlencodedParser, (req, res) => {
  console.log(req.body); // {username: 'express', password: 'asdasd'}
});
```

## Serving Static Files

- Pass the name of directory of static assets,

```javascript
app.use(express.static('public')); // serve assert under public directory

app.use(express.static(path.join(__dirname, 'public')));
```
