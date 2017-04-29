# Express

- A minimal and flexible Nodejs web framework
- Contains a middleware framework

* Some of core feautres:
  1. Allows to set up middlewares to respond to http requests
  2. Easy and flexible routing system
  3. Integrates with many templating engines


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

app.get('/', (req, res) => {
  // extracting values from GET form
  let name = req.query.name;
  let age  = req.query.age;
  console.log(name + age)

  res.end(JSON.stringify({name: name, age: age}));
});

app.post('/', (q, s) => console.log("POST /"));

app.delete('/', (q, s) => console.log("DELETE /"));


```

## Serving Static Files

- Pass the name of directory of static assets,

```javascript
app.use(express.static('public'));
```
