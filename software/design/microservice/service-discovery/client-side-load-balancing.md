# Client-side Load Balancing

- When a consuming actor needs to invoke a service:

1. It will contact the service discovery service for all the service instances a
   service consumer is askinf for and then cache data locally on the service
   consumer's machine

2. Each time a client wants to call the service, the service consumer will look
   up the location information for the service from the cache. Usually
   client-side caching will use a simple load balancing algorithm like the
   "round-robin" to ensure that service calls are spread across multiple service
   instances

3. The client will then periodically contact the service discovery service and
   refresh its cache of service instances. The client cache is eventually
   consistent, but there's always a risk that between when the client contacts
   the service discovery instance for a refresh and calls are made, calls might
   be directed to a service instance that isn't healthy. Cache is invalidated,
   and refresh its entries
