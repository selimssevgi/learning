# WebSocket

- Asynchronous messaging is a common form of communication between applications

- when one of those applications is running in a web browser, something a little different is needed

- WebSocket is a protocol providing full-duplex communication across a single socket

- it enables among other things, asynchronous messaging between a web browser and a server

- being full-duplex means that the server can send messages to the browser as
  well as the browser sending message to the server


- WebSocket communication can be used between any kinds of application
- commonly used for facilitating communication between a server and browser

- a js client in the browser opens a connection to the server
- the server sends updates to the browser on that connection
- this is generally more efficient and more natural than the historically common
  alternative of polling the server for updates

* WebSocket is a relatively new specification (2011)
* It may not be widely supported on browser and application servers

* SockJS is a WebSocket emulator that mirrors the WebSocket API as closely as possible on the surface
* under the covers is clever enough to choose another form of communication when WebSocket isn't available
* SockJS will always favor WebSocket first, but if WebSocket is not an option,
  it will determine the best available option from the following:

- XHR streaming
- XDR streaming
- IFrame event source
- IFrame HTML file
- XHR poling
- XDR polling
- IFrame XHR polling
- JSONP polling

* no need to know the details, SockJS will handle that under the cover

- enable SockJS commmunication on the server side

- this is too low-level for practical use, see STOMP
