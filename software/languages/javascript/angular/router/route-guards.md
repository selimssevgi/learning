# route guards

- is like a lifecycle hook for route changes that allows an application to
  verify certain conditions or load data before a change occurs

### guard types

1. `CanActivate` used to determine whether the route can be activated (such as user validation)

2. `CanActivateChild` same as CanActivate, but specifically for child routes

3. `CanDeactivate` used to determine whether the current route can be
   deactivated (such as preventing leaving an unsaved form without confirmation)

4. `CanLoad` used to determine whether the user can navigate to a lazy loaded module prior to loading it

5. `Resolve` used to access route data and pass data to the component's list of providers
