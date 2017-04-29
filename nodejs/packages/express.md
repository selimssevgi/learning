# Express

- Easy and flexible routing system
- Integrates with many templating engines
- Contains a middleware framework


```javascript
let express = require('express');

let app = express();

// send method figures out content-type
app.get('/', (req, res) => res.send("This is home page"));

app.get('/contact', (req, res) => res.send("This is a contact page"));

app.get('/profile/:id', (req, res) => res.send("Profile id is " + req.params.id));

app.listen(3000);
```
