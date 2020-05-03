# what is OAuth 2.0

- is a delegation protocol
  - the end user delegates some part of their authority

- valet key

- authorization framework

- resource owner: has access to an API and can delegate access to that API
- protected resource: the component that the resource owner has access to
- client: the piece of software that accesses the proctected resource on behalf of the resource owner


**GOAL:**

Give the client access to the proctected resource on behalf of the resource owner


### old days

- everything in a single domain, same user/pass used for all services

- different application in different domain:
  - one service asks user to give its credentials so it can access to the other server on their behalf
  - no difference between user and other app access


- developer key: can impersonate any user
  - too much power with a single universal key

- user generate and use different passwords and share them with services
  - user has to manage those passwords
  - which client uses which password?
  - what if they want to revoke access?

### what-is-not

- two actions as fundamental parts of OAuth

1. how to get a token
2. how to use a token

- OAuth is not defined outside of the HTTP protocol

- OAuth is not an authentication protocol

- OAuth does not define a mechanism for user-to-user delegation

- OAuth does not define authorization-processing mechanisms

- OAuth does not define a token format

- OAuth defines no cryptographic methods

- OAuth is also not a single protocol
