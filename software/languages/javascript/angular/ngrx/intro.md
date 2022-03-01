# ngRx

- provide a format pattern for:
  - organizing state
  - managing state
  - communicating state changes


- ngrx = redux pattern + angular


## redux pattern

- view
- user event
- component
- dispatch
- action + store (state)
- reducer
- new state

## when to use

- there is state everywhere
  - the store provides a place for UI state to retain it between router views
- getting data again and again
  - the store provides a client-side cache to use as needed
- notify everyone
  - the reducer updates the store and the store notifies all subscribers
