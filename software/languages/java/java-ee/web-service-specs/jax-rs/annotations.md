# JAX-RS Annotations

## @PATH(your_path)

- /your_path

## @POST

- indicates that the following method will answer to an HTTP POST request

## @GET

## @PUT

## @DELETE

## @Produces(MediaType.TEXT_PLAIN)

- defines which MIME type is delivered by a method annotated with @GET

- MediaType.APPLICATION_XML will require @XmlRootElement on the exposed object for MessageBodyWriter
  - jersey doesnot know how to convert from POJO to XML

## @Consumes(type)

- defines which MIME type is consumed by this method

## @PathParam

- used to inject values form the URL into a method parameter.

- injecting ID of a resource into the method to get the correct object
