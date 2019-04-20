# Redux Overview

- Redux has emerged as one of the clear winners in the field of Flux or
  Flux-like libraries

- Redux is based on Flux, was designed to tackle the challenge of understanding
  how data changes flow through your application

- Redux was developed by Dan Abramow and Andrew Clark

- Redux is surprisingly small, only 99 lines of code

- Redux is Flux-like, but it is not exactly Flux

- It has actions, action creators, a store, and action objects that are used to
  change the state

- Redux simplifies the concepts of Flux a bit by removing the dispatcher and
  representing application state with a single immutable object

- Redux also introduces 'reducers', which are not a part of the Flux pattern

- Reducers are pure functions that return a new state based on the current state
  and an action: (state, action) => newState
