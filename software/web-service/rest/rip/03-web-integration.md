# Basic Web Integration

* Some kinds of integration points:

- Methods that encapsulate some (coarse-grained) business concept rather than
  low-level technical detail.

- Methods that support existing presentation logic, such as controllers in the
  MVC pattern

- Scripts or workflows that orchestrate interactions with a domain model

* Integration points to avoid:

- Data access methods, especially those that are transactional

- Properties/getters and setters

- Anything that binds to an existing presentation tier such as reusing view
  logic or screen scraping


## From Intuitive URIs to URI Templates

- /orders/1234 intuitively can be called as /orders/1235

- While intuitive URIs are encouraged, intuition alone isn't enough.

- As implementers of web services, we need to provide richer metada for consumers.

- This is where URI templates come into their own, since they provide a way to
  parameterize URIs with variables that can be substituted at runtime.

- In turn, they can therefore be used to describe a service constract.

- URI template: restbucks.com/order/{order_id}

- POST template URI example

```shell
restbucks.com/PlaceOrder?coffee={type}&size={size}&milk={milk}&location={location}

# maps to
# public OrderConfirmation PlaceOrder(Order order) {}
```

- However, in the general case URI tunneling isn't web-friendly because URIs are
  used to encode operations rather than identify resources that can be
  manipulated through HTTP vers.

```shell
# if following URI is used as GET request
# HTTP tunneling can be used to violate the safe and idempotent nature of GET
restbucks.com/PlaceOrder?coffee={type}&size={size}&milk={milk}&location={location}
```

- POX (XML over HTTP) services are level zero in Richardson's maturity model

- Using URIs or XML for transferring messages over HTTP directly enables
  platform-independent integration.
