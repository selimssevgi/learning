# security design considerations

- authentication
- authorization
- transport protection
- CORS (cross-origion resource sharing)
- CSRF (cross site request forgery)
- XSS (cross site scripting)

### transport proctection

- use https everywhere

- TLS


### CSRF (cross site request forgery)

- vulnability exists when using cookies to maintain a secure session with backend service

- browser automatically sends cookies with the associated site when a request is made
  - even if another client application makes request to that resource

- with token approach instead of using cookies we can send the token directly via a header
