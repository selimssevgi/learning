# BSON

- MongoDB stores data as BSON or Binary JSON.
- MongoDB drivers send and receive data as BSON.

- When data is written to MongoDB, it is stored as BSON.
- On the app side, MDB drivers map BSON to whatever native data types are most
  appropriate for a given programming language.

## BSON - Binary JSON

- lightweight: min space
- Traversable: ops like reading, writing, indexing
- Efficient:

- JSON doesnt support all kinds of value data types.
- For ex, it just has number, but not int or float.
- Also it doesnt support date type.
- BSON add support for such things.

## BSON Types

- numeric encoding of the type in BSON

- 2 : string
