# testing jersey

- when response body is empty, content-type is not set and null

```java
@GET
@Path("/details")
@Produces(MediaType.APPLICATION_JSON)
public Response getCsDetails() {
  return Response.ok().build();
}
```

