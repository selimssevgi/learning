# Event Loop

- Nodejs is a single-threaded application
- It can support concurrency via the concept of event and callback
- Every API of Nodejs is asynch and being single-threaded, they use 'async
  function calls' to maintain concurrency
- Node uses observer pattern

## Event-Driven Programming

- A main loop listens for events, and then triggers a callback function when one
  of those event is detected

- Events look similar to callbacks:
  - Callbacks are called when an async function returns its result
  - Event handling works on observer pattern

- The functions that listen to events act as "Observers"

- see events module: modules/core/events
