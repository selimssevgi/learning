# Routing

- In cloud environment there will be individually deployable services

- Each service runs on different ports, different addresses, different APIs, paths

- As a client (such as mobile or web) interacting with each individual service
  would be a disaster

* The solution is 'intelligent routing': appears as a whole but still individual pieces

## Via Gateway

- a single entry point for all clients

- is a lot like the front door, edge service, the gateway to services

- Services are placed behind the edge service

## Gateway Service Provides

- Dynamic routing & delivery

- Security & filtering (authenticate all request or filter out bad requests)

- Auditing & Logging

- Request enhancement(geolocation information adding in the header)

- Load balancing

- Different APIs for different clients
