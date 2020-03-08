# pooling

- is not a standard feature mandated by the ejb specification
  - is left optional
  - most application servers support it

- certain number of objects handling incoming requests

- if requests are more than objects, request will be put on queue

- if object is done, it will go back to queue

- the maximum limit on the pooling will act as throttling not to overwhelm the system
