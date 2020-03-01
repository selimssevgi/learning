# Safety and Idempotency

- GET is special since it has the properties of being both safe and idempotent.

- PUT and DELETE are both idempotent, but neither is safe.

- POST is neither safe nor idempotent.

- GET, PUT, DELETE can be repeated without causing problems on service-side

- Since both PUT and DELETE introduce side effects (because they are not safe),
  it may not always be possible to simple repeat an operation if the server
  refuses it at first.
