# Installing jQuery

- jquery.com

## Choosing the right version

- 2006, jQuery 1.0
  - 1.x supports old browsers

- In April 2013, jQuery 2.0
  - with intention of looking at the future instead of past
  - decided to leave behind IE 6, 7, 8
  - supports modern browsers

- There is feature parity between version 1.10 and 2.0, 1.11 and 2.1 and so on

- In October 2014, jQuery 3.0
  - jQuery Compat 3 is the successor of 1.x, wider browsor support, large size, lower performance
  - jQuery 3 is the successor of 2.x

Browsers | jQuery 1           | jQuery 2           | jQuery Compat      | jQuery 3
---------|--------------------------------------------------------------------------
IE       | 6+                 | 9+                 | 8+                 | 9+                 |
Chrome   | Current n previous | Current n previous | Current n previous | Current n previous |
Firefox  | Current n previous | Current n previous | Current n previous | Current n previous |
Safari   | 5.1+               | 5.1+               | 7.0+               | 7.0+               |
Opera    | Current n previous | Current n previous | Current n previous | Current n previous |
iOS      | 6.1+               | 6.1+               | 7.0+               | 7.0+               |
Android  | 2.3 and 4.0+       | 2.3 and 4.0+       | 2.3 and 4.0+       | 2.3 and 4.0+       |

## Use Cases

- 3.x for websites running in a controller environment such as a company local network

- 1.x for targetting an audience as wide as possible, such as a goverment website

- Compat 3.x for targetting wide audience but not IE 6-7 and old Opera, Safari

- 2.x, no support for IE8- but old Opera and Safari

- Firefox OS or Chrome OS apps can use jQuery 3.x

- Websites that rely on very old plugins, depending on the actual code of the
  plugins, may be forced to use jQuery 1.x

## Compressed vs Uncompressed

- Compressed, minified, intended for the production stage
  - removed useless white space(indentation)
  - removed comments
  - shrinking the names of the variables (obfuscation)

- Uncompressed, intended for the development stage

## Using a CDN

- Common practise to serve files like images and libraries through CDN to improve performance of a website

- Content Delivery Network

- Distributed system of servers created to offer content with high availability and performance

- Browsers can download a fixed set of contents, usually 4 to 8 files, from a host a the same time

- the files served using a CDN are provided from a different host

- Lots of websites use CDNs, higher probability that the library is already in the user's browser cache

- Some reliable CDNs:
  - jQuery CDN     - http://code.jquery.com
  - Google CDN     - https://developers.google.com/speed/libraries/
  - Microsoft CDN

```javascript
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
```

- no protocol specified, same protocol is used in your website
- error if that code doesnt run on a web server

*NOTE:*

- CDNs are not guaranteed to up %100 of the time

- To always be on the safe side use the following:

```javascript
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>window.jQuery || document.write('<script src="javascript/jquery-
1.11.3.min.js"><\/script>');</script>'""')
```
