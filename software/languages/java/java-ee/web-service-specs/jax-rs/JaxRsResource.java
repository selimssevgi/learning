@Path("v1")
@Produces(MediaType.APPLICATION_JSON)
public class JaxRsResource {

  public JaxRsResource() {
    // for ejb container
  }

  // /v1/exampes/5?langCode=en
  @GET
  @Path("/examples/{id}")
  public Response getById(@PathParam("id") String id,
                          @QueryParam("langCode") String langCode) {
    return Response.ok("OK").build();
  }

  @POST
  @Path("/examples/")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(ReqBody reqBody) {
    return Response.ok().build();
  }
}
