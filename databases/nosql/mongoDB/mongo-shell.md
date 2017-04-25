# Mongo Shell

- database < collection < document < JSON
- JSON is the way we express data inside Mongo
- Mongo Shell is an interactive JS interpreter.
- \_id is immutable.
- ObjectId: current time + machine identifier +  process id + global counter

```shell
$ mongo

> help

> show databases

> use test    # creates db if it doesnt exist

> show collections # in a db

# imagine there is a collection called 'things'
# save a very small document in 'things'
> db.things.save( { a: 1, b: 2, c: 3 } )

# db: standary keyword inside shell
# things: collection
# save: a command

> db.things.find() # show every document in the collection

> db.things.save( { a:3, b: 4, c: 5, d: 100 } )
# mongo is schema-less, these documents can co-exist in the same collection

> db.things.find( { a: 1 } )

> db.users.find().pretty()

# change schema of an existing document
> db.user.insert( {'name': "selim", 'city_of_birth': 'aplace'} )

> var j = db.user.findOne( {'name': 'selim'} )
> j.favorite_color = "acolor"
> db.users.save(j)

```

## CRUD

```shell
> db.people.insert( {"name": "Selim", "age": "25", "profession": "eng"} )

> db.people.find() # shows all documents in people collection

> db.people.findOne() # a random document

> db.people.findOne({"name": "jones"}) # get the document 'WHERE name = jones'

> db.people.findOne({"name": "jones"}, {"name": true, "_id": false}) # just include name field

> db.scores.find({"type": "essay", "score": 50}, {"student": true, "_id": false})

```

## Operators

- $gt, $lt, $gte, $lte can be applied both numbers and strings
- $exists, $type, $regex
- $or, $and

```shell
> db.scores.find( { "score" : { $gt : 50 } } )

> db.scores.find( { "score" : { $gt : 50, $lte : 96 }, "type": "essay" } )

> db.users.find( { name : { $gt : "F", $lte : "Q" } } )

> db.people.find( { profession : { $exists : true } } )

> db.people.find( { name : { $type : 2 } } ) #numeric encoding of the type in BSON

> db.people.find( { name : { $regex : "a$" } } ) # names end with 'e'

> db.users.find( { name : { $regex : "q" }, email : { $exists : true } } )

> db.people.find( { $or : [ { name : { $regex : "e$" } }, { age : { $exists : 1 } } ] } )

> db.people.find( { $and : [ { name : { $gt : "C" } }, { name : { $regex : "a" } } ] } )
> db.people.find( { name : { $gt : "C", $regex : "a" } } )

> db.scores.find( {score: {$gt: 50}, score: {$lt: 60} } ) # last one wins

# queries are polymorphic: same for field value or array value
# favorites : ["pretzels", "beer"] # matches if one of the value is matched
# not recursive
> db.accounts.find( { favorites : "pretzels" } )

# matches all in any order, equal or subset array
> db.accounts.find( { favorites : { $all : ["pretzels", "beer"] } } )

> db.accounts.find( { name : { $in : ["Howard", "John"] } } )

> db.scores.count( { type: "exam" } )
```

```javascript
// bulkinsert
for (i=0; i<1000; i++) {
  names = ["essay", "exam", "quiz"];
  for (j=0; j<3; j++) {
    db.scores.insert( {"student": i, "type": names[j], "score": Math.random() *
    100} );
  }
}
```

## Dot Notation

```shell
> db.users.insert(
  { name: "richard", email: { work: "work@g.co", personal: "personal@g.co" } } )

> db.users.insert( { email: { work: "work@g.co", personal: "personal@g.co" } } )
# exact match, even the order has to be same

> db.users.insert( { email: {personal : "personal@g.co", "work": "work@g.co"} } )
# no matches

> db.users.insert( { email: { work: "work@g.co" } } )
# no matches: not an exact match

> db.users.insert( { "email.work" : "work@g.co" } )
# matches, dot notation doesnt care what is around or not, existence is enough
```

## Cursor

```shell
> cur = db.people.find(); null; # null to avoid egarly printing

> cur.hasNext();

> cur.next();

> while (cur.hasNext()) printjson(cur.next());

> cur.limit(5); # fetch 5 results when asked

> cur.sort( { name: -1 } ) # reverse order by name

## ordering and limiting works on server-side,
## therefore call them before processing items by calling next

> cur.sort( { name: -1 } ).limit(5).skip(2); null;
# sort, skip and limit are processed in this order like in SQL
```

## Update

```shell
> db.people.update( {name: "Smith"}, { name: "John", salary: "5000" } )
# replace what was in the document(removing other fields), dont use it!

> db.people.update( {name: "Alice"}, {name: "Alice", age: 30} )
# i need to know all other fields of Alice, so i wont discard them, not useful

> db.people.update( {name: "Alice"}, { $set : {age: 30} } )
# add or update the field named 'age'

> db.people.update( {name: "Alice"}, { $inc : { age : 1 } } )
# increment by 1, adds and start from 0 if field doesnt exist

> db.people.update( {name: "John"}, { $unset : { profession : 1 } } )
# $unset, remove the field from the document, useful for schema changes

## ARRAY

> db.arrays.insert( { "_id": 0, a : [1, 2, 3, 4] } )

> db.arrays.update( { "_id": 0 }, { $set : { "a.2" : 1 } } )

> db.arrays.update( { "_id": 0 }, { $push : { a : 6 } } ) # appends

> db.arrays.update( { "_id": 0 }, { $pop : { a : 1 } } ) # 1:last, -1:first

> db.arrays.update( { "_id": 0 }, { $pushAll : { a : [5, 6, 7] } } )

> db.arrays.update( { "_id": 0 }, { $pull: { a : [5] } } ) # removes value '5'

> db.arrays.update( { "_id": 0 }, { $pullAll : { a : [1, 2] } } )

> db.arrays.update( { "_id": 0 }, { $addToSet : { a: {3} } } ) # doesnt add if exists

## UPSERT

> db.arrays.update( name: "Jully" }, { $set : { age: 40 } } )
# wont have any effect if there is not document with name field: Jully

> db.arrays.update( name: "Jully" }, { $set : { age: 40 } }, {upsert : true} )
# will update, or create if doesnt exist

## MULTI UPDATE

# SQL: The default behavior of an update query in SQL is to update every record
# that matches the where clause, or every record in the table if where clause not
# specified.

# The default behavior to update in MongoDB is to update just one document in
# the collection. You must specify an extra argument in the JS shell in order to
# update multiple documents.

> db.people.update( {}, { $set: {title: "Dr"} }, {multi : true} )

# it is use yielding not to hold resources for really long time.
# MongoDB does guarantee that a single document is being updated as atomic op
# multi-update: update some documents, yield, then update some more
```

## Remove


```shell
> db.people.remove( {name: "Alice"} )

> db.people.remove( {name : {$gt : "C"}} )

> db.scores.remove( { score : { $lt : 60 } } ) # removes all documents with score < 60

> db.people.remove( {} ) # all documents will be removed one by one

> db.people.drop() # remove a large collection in an efficient manner
```
