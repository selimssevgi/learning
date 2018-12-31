# Message converters

- message conversion is a more direct way (than Negotiation) to transform data
  produced by a controller into a representation that's served to a client

- when using message conversion, DispatcherServlet doesn't bother with ferrying model data to a view

- Spring comes with a variety of message converters:

message converter   | description
----------------------------------------------------
AtomFeedHMC         | media type application/atom+xml
BufferedImageHMC    | converts BufferedImage to and from image binary data
ByteArrayHMC        | reads from all media types (\*/\*), and write as application/octet-stream
FormHMC             | application/x-www-form-urlencoded to MultiValueMap<String, String>
Jaxb2RootElementHMC | text/xml or application/xml
MappingJackson2HMC  | JSON to and from type objects or untyped HashMaps
ResourceHMC         | reads and write o.s.core.io.Resource
StringHMC           | reads all media types into a String, write String to text/plain

- Some of the HTTP message converters are registered by default
- you may need to add additional libraries to application classpath to support them
- for MappingJackson2HMC you need Jackson 2, for Jaxb2RootElementHMC, JAXB


* a slight twist to Spring MVC's programming model is required to support message conversion

### @ResponseBody

```java
@RequestMapping(method= RequestMethod.GET, produces = "application/json")
public @ResponseBody List<Spittle> spittles() {}
```

- @ResponseBody tell Spring that you want to send the returned object as a
  resource to the client, converted into some representational form that the client can accept

- DispatcherServlet considers the request's Accept header and looks for a
  message converter that can give the client the representation it wants

### @RequestBody

- tells Spring to find a message converter to convert a resources representation
  coming from a client into an object

```java
@RequestMapping(method= RequestMethod.POST, consumes = "application/json")
public @ResponseBody Spittle saveSpittle(@RequestBody Spittle spittle) {}
```

### @RestController

- if you are writing a controller that has several methods, all of which should
  use message conversion, then @ResponseBody gets somewhat repetitive

- Spring 4.0 introduced @RestController to help with that

```java
@RestController
public class MyController {

  @RequestMapping(method= RequestMethod.POST, consumes = "application/json")
  public Spittle saveSpittle(@RequestBody Spittle spittle) {}

}
```
