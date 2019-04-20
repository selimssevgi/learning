# Response Headers

- We could communicate http status via @ResponseStatus without using ResponseEntity
- there is not much we can do except using ResponseEntity for headers

- it would be nice if we could communicate a better status code and location URL
  for the resource that was created

```java
@PostMapping("/")
public ResponseEntity<Spittle> save(@RequestBody Spittle spittle) {
   Spittle spittle = spittleRepository.save(spittle);

   HttpHeaders headers = new HttpHeaders();
   URI locationUri =
    URI.create("http://localhost:8080/spittr/spittles/" + spittle.getId());
   headers.setLocation(locationUri);

   ResponseEntity<Spittle> responseEntity =
      new ResponseEntity<>(spittle, headers, HttpStatus.CREATED);
   return responseentity;
}
```

- HttpHeaders is a special implementation of MultiValueMap(String, String)

- UriComponentsBuilder instead of hard-coding uri

- UriComponentsBuilder given to the handler is preconfigured with know
  information such as host, port, and servlet content

```java
@PostMapping("/")
public ResponseEntity<Spittle> save(@RequestBody Spittle spittle, UriComponentsBuilder ucb) {
   Spittle spittle = spittleRepository.save(spittle);

   HttpHeaders headers = new HttpHeaders();
   URI locationUri =
      ucb.path("/spittles")
         .path(String.valueOf(spittle.getId()))
         .build()
         .toUri();
   headers.setLocation(locationUri);

   ResponseEntity<Spittle> responseEntity =
      new ResponseEntity<>(spittle, headers, HttpStatus.CREATED);
   return responseentity;
}
```
