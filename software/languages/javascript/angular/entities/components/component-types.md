# component types

- technically they are same but the way they are being used in different

- *app component:* root app component, one per application

- *display component:* stateless component that reflects the values passed into it, making it highly reusable

- *data component:* helps to get data into the application by loading it from external resources

- *route component:* when using the router,each route will render a component
  and this makes the component intrinsically linked to the route


### AppComponent

- keep it simple -- dont put any logic

- use for app layout scaffolding -- create the primary app layout in this component

- avoid loading data -- 

### display component

- most third-party components will be in this role

* decouple: no coupling except data being sent to it

* make it only as flexible as necessary

* dont load data - pass data instead of loading

* have a clean api

* optionally use a service for configuration

### data component

- primarily about handling, retrieving, or accepting data

* use appropriate lifecycle hooks

* dont worry about reusability

* set up display components

* isolate business logic inside
