# RestTemplate

- just as JdbcTemplate handles the ugly parts of working with JDBC data access,
  RestTemplate frees you from the tedium of consuming RESTful resurces

- defines many unique operations, many of them are overloaded

method            | description
----------------------------------------------------------------------
delete()          | performs delete request on a resource at a specified URL
exchange()        | returns ResponseEntity
execute()         | return an object
getForEntity()    | return ResponseEntity
getForObject()    | return object
headForHeaders()  | HEAD request, return HTTP headers
optionsForAllow() | OPTIONS request, returns Allow header
postForEntity()   |
postForLocation() | returning the URL of the newly created resource
postForObject()   |
put()             |

- execute() and exchange() offer lower-level, general-purpose methods for using any of the HTTP methods

```java
public Profile fetchFacebookProfile(String id) {
  return restTemplate.getForObject("http:://graph.facebook.com/{spitter}", Profile.class, id);
}
```

- can use getForEntity#getHeaders for inspecting resource headers

- when you need to send headers to the server: exchange() is handy

```java
MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
headers.add("Accept", "application/json");
HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
```
