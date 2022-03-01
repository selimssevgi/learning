# reducer

- to change state

- examples:
  - set a userDetails property on login
  - toggle a sideMenuVisible property to true on button click
  - set successfully retrieved data on component initialization


- not all dispatched actions can directly update the store via the reducer, as some actions have side effects

- reducers are pure functions and handle each state transition synchronously

```shell
export const userReducer = createReducer(
  initialState,
  on(UserActions.loadUser, (state, action) => {
    return {
      ...state,
      user: action.user
    };
  })

);
```
