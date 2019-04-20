# MongoDB Java Driver

- get the dependency details from maven repo

- 

## MongoClient

- It is a heighweight object, represents a pool of sockets or connections to all
  the servers

- Dont create more than necessary, might a static variable, or IOC: spring or guice

### Constructors

```java
MongoClient client0 = new MongoClient(); //localhost:27017

MongoClient client1 = new MongoClient("localhost", 27017);

MongoClient client2 = new MongoClient(new ServerAddress("locahost", 27017));

// connecting to a cluster
MongoClient client3 = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017)));

MongoClient client4 = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

MongoClientOptions options = MongoClientOptions.builder().build(); // immutable
MongoClient client5 = new MongoClient(new ServerAddress(), options);
```

### Methods

```java
// lightweight object, can have many, immutable
MongoDatabase db = client.getDatabase("test");

// lighweight, immutable object
MongoCollection<Document> collection = db.getCollection("things");

MongoCollection<BsonDocument> collection1 = db.getCollection("things", BsonDocument.class);
```

## Document

- It is not type-safe

```java
Document document = new Document()
        .append("str", "MongoDB, hello")
        .append("int", 42)
        .append("long", 1L)
        .append("double", 1.1)
        .append("b", false)
        .append("date", new Date())
        .append("id", new ObjectId())
        .append("null", null)
        .append("embedded", new Document("x", 0))
        .append("list", Arrays.asList(1, 2, 3, 4));

String str1 = (String) document.get("str");
String str2 = document.getString("str");

Helpers.printJson(document);
```

## Insert

```java
MongoClient client   = new MongoClient();
MongoDatabase db     = client.getDatabase("course");
MongoCollection coll = db.getCollection("people");

coll.drop();

Document smith = new Document()
        .append("name", "smith")
        .append("age", 40)
        .append("profession", "programmer");

Document john = new Document()
        .append("name", "john")
        .append("age", 45)
        .append("profession", "haccker");

// coll.insertOne(smith);
coll.insertMany(Arrays.asList(smith, john));
```
