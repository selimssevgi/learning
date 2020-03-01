# The Web As a Platform for Building Distributed Systems

## Resources and Identifiers

- To use a resource we need both to be able to identify it on the network and to
  have some means of manipulating it.

- The Web provides the Uniform Resource Identifier just for these purposes.

- A resource's URI distinguishes it from any other resource, and it's through
  its URI that interactions with that resource take place.

- The relationship between URIs and resources is many-to-one.

- A URI identifies only one resources, but a resource can have more than one URI


```shell
# <scheme>:<scheme-specific-structure>

http://example.org/reports/book.tar # find example.org, it handles the rest
ftp://example.org/reports/book.txt  # find host, cd to reports, find book.txt
mailto:name@host.com
```

- Several other terms are used to refer to web resource identifier: URL, URN
- Which are specific forms of URI

## Resource Representations

- A representation is a transformation or a view of a resource's state at an
  instant in time.

- This view is encoded in one or more transferable formats: XHTML, Atom, XML,
  JSON, plain text, CSV, MP3, JPEG.

- Access to a resource is always mediated by way of its representations. That
  is, web components 'exchange' representations; then never access the
  underlying resource directly.

- This separation between a resource and its representations promotes loose
  coupling between backend systems and consuming applications.
- One resource can have many representations. one-to-many relationship.
