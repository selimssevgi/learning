# introduction to OAuth2 and OpenID Connection

- OpenID Connect is built on top of OAuth2

- Auth is about the delegation of access

- vallay parking: give your car keys and they will park it somewhere for you
  - this key will be only useful to un/lock and start the car
  - that key will not be useful for unlocking other compartments


- buffer app(twitter client) post tweets on the behalf of us
  - we need to delegate access to buffer for twitter

- *Authorization Server*: key component in OAuth

- *Client(buffer app):* request access from the resource owner(us)
  - we want to grand access to buffer client

- when buffer client has the access token, it can access to resource server(twitter api to post a tweet)

- resource server verify client access(verification of token through auth server)

### why having such setup?

- if there is only one auth server, one client, and one resource server, does it
  worth to go through the trouble?

- this will make sense if we have many clients(mobile, cli, web, service) and
  many resource servers(microservices)
