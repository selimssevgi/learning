# client perspective

- client(buffer app in twitter example) app needs to be registered to Authorization Server
  - appname: client identifier
  - callback url: auth server calls this callback url

- after registration, client will get *consumer api keys*

- twitter is an example of public service(open system)
  - anyone can build a client and register

- you can build your own auth server in enterprise architecture for your client and resource servers(closed system)
  - registration is not public
  - someone could be responsible registering clients


### client credentials grant flow (client, auth server, resource server)

1. *client* goes to *auth server* with its *client credentials*(the one we got when registered to twitter api)

2. *auth server* gives back an *access token* to client if credentials are correct

3. *client* send a request with *access token* to *resource server* (twitter api)

4. *resource server* sends back *protected resource* (tweets) to client

- no user involved, is machine to machine communication.

* direct access by the client application
* access token obtained using client credentials

### authorization code grant flow(user, browser, auth server, client, resource server)

- client requests access on browser

- browser is redirected to auth server to request access

- auth server asks user to authenticate themselves

- user sends login credentials auth server(logging in twitter account)

- auth server requests client authorization

- auth server redirect with authorization code to browser

- through browser auth server used callback url(give that info on registering
  client) and client callback is called with authorization code

- client sends(exchanges) that authorization code with client credentials to auth server

- auth server sends back *access token & refresh token* to client if creds are correct
