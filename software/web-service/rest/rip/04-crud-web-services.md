# CRUD Web Services

- POST, GET, PUT, DELETE (GET,PUT,DELETE are idempotent)

- Create, Read, Update, Delete (CRUD)

- Since CRUD services embrace both HTTP and URIs, they are considered to be at
  level two in Richardson's maturity model.

- CRUD services embrace URIs to identify resources such as coffee orders and
  HTTP to govern the interactions with resources.

```shell
VERB    URI or template
--------------------------
POST    /order
GET     /order/{orderId}
PUT     /order/{orderId}
DELETE  /order/{orderId}
```

- A client can GET a representation many times over without the requests causing
  the resource to change. Of course, the resource may still change between
  requests fro other reasons. For example, the status of a coffee order could
  change from 'pending' to 'served' as the barista makes progress.

** Postel's Law

- be conservative in what you do; be liberal in what you accept from others

- A good service implementation is very strict about the resource
  representations it generates, but is permissive about any representations it
  receives.

## Updating a Resource with PUT

- HTTP offers two ways of transmitting information from client to server with
  the POST and PUT verbs.

- Use POST to create a resource identified by a service-generated URI

- Use POST to append a resource to a collection identified by a service-generated URI

- Use PUT to create or overwrite a resource identified by a URI computed by the client

** NOTE: **

Put expects the entire resource representation to be supplied to the server,
rather than just changes to the resource state. Another relatively unknown HTTP
verb, PATCH, has been suggested for use in situations -- typically involving
large resource representations -- where only changes are provided.

- PUT can return 409 (CONFLICT) status, if resource can not be changed
  anymore(in case of coffee that is already serverd), then would be useful to
  return the current representation in the body instead of 200 or 204

- PUT can be retried in case of 500. Since PUT is idempotent, because
  service-side state is 'replaced wholesale' by consumer-side state. The
  consumer can safely repeat the operation as many time as necessary.

- PUT can only be safely used for absolute updates; it cannot be used for
  relative updates such as "add an extra shot to the cappuccino in order 1234".
  That would violate its semantics.

## Removing a Resource with DELETE

- Deleting a resource doesn't always mean the resource is physically deleted;
  there are a range of outcomes. A service may leave the resource accessible to
  other applications, make it inaccessible from the Web and maintain its state
  internally, or even delete it outright.

- If the order has already bean prepared, which means it can't be deleted, a 405
  Method Not Allowed response would be used. (204 in case of success)

- Sometimes deleted resource can be returned to client, 200 + content
