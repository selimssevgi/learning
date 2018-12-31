# Error Handling

- there is more to a response than the payload
- there are headers and status codes that can also provide useful information

```java
@GetMapping("/{id}")
public @ResponseBody Spittle spittleById(@PathVariable long id) {
   return spittleRepository.findOne(id);
}
```

- what will happen if findOne() returns null?
- the body of response will be empty, and http status will be 200

- Spring offers a few options for dealing with such scenarios:

* @ResponseStatus
* ResponseEntity for carrying more metadata concerning the response
* exception handler, leaving the handler methods to focus on the happy path

### ResponseEntity

- is an object that carries metadata (such as headers and status code)
- implies the semantics of @ResponseBody

```java
@GetMapping("/{id}")
public ResponseEntity<Spittle> spittleById(@PathVariable long id) {
   Spittle spittle = spittleRepository.findOne(id);
   HttpStatus status = spittle != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
   return new ResponseEntity<Spittle>(spittle, status);
}
```

- now the client is given a proper status code but the body is still empty for 404

```java
@GetMapping("/{id}")
public ResponseEntity<?> spittleById(@PathVariable long id) {
   Spittle spittle = spittleRepository.findOne(id);
   if (spittle != null) {
     Error error = new Error(4, "Spittle [" + id + "] not found");
     return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
   }
   return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
}
```

- now the handler method is bloated with error handling
- and generic ? does not look good

```java
@ExceptionHandler(SpittleNotFoundException.class)
public ResponseEntity<Error> spittleNotFound(SpittleNotFoundException e) {
  long id = e.getSpittleId();
  Error error = new Error(4, "Spittle [" + id + "] not found");
  return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
}
```

```java
@GetMapping("/{id}")
public ResponseEntity<Spittle> spittleById(@PathVariable long id) {
   Spittle spittle = spittleRepository.findOne(id);
   if (spittle != null) {
     throw new SpittleNotFoundException(id);
   }
   return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
}
```

### @ResponseStatus

- now we know different cases are handled by different pieces of code
- we can simplify code by not using ResponseEntity

```java
@ExceptionHandler(SpittleNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public Error spittleNotFound(SpittleNotFoundException e) {
  long id = e.getSpittleId();
  Error error = new Error(4, "Spittle [" + id + "] not found");
  return error;
}
```

```java
@GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Spittle spittleById(@PathVariable long id) {
   Spittle spittle = spittleRepository.findOne(id);
   if (spittle != null) {
     throw new SpittleNotFoundException(id);
   }
   return spittle;
}
```
