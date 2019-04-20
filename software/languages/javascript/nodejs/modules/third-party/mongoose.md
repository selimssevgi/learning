# mongoose

```javascript
npm install mongoose

let mongoose = require('mongoose').set('debug', true); // shows queries

mongoose.connect('mongodb://<dbuser>:<dbpassword>@ds125481.mlab.com:25481/ninja-todo');

// create a schema
let todoSchema = new mongoose.Schema({
  item: String
});

// a model with given schema
let Todo = mongoose.model('Todo', todoSchema);

// a new item of the model
let itemOne = Todo({item: 'buy flowers'}).save((err) => {
  if (err) throw err;
  console.log('item added');
});
```

## FindById

- Use model functions with callback, otherwise shows no effect
- No need to get bothered with ObjectId or \_id conversion etc

```javascript
app.delete('/things/:id', (req, res) => {
  let id = req.params.id
  console.log(id);
  Thing.findById(req.params.id).remove( (err, data) => {
    if (err) console.log("couldnt delete an error");
    res.json(data);
  });
});
```
