# component life cycle

1. registration -- component registered with the module
2. request -- template includes a component
3. initialization -- component is instantiated
4. controller constructor() called
5. compiler renders any child components in template
  - component lifecycle hooks begin
  - when components needs to be updated
6. application state changes
7. component removed from view

## lifecycle hooks

- angular will only run a lifecycle hook if it's defined in the component

- when you implement the hook in your controllers, you prefix it with `ng`

- OnInit is the name of the hook, implementation function is ngOnInit

* `OnChanges`
  - provides previous and current value in case of change

* `OnInit`
  - best place to do any initialization, loading data from api

* `OnDestroy`
  - removed listening for incoming data or clear a timer

* `DoCheck`
  - provide your own type of change detection

* `AfterContentInit`
* `AfterContentChecked`

* `AfterViewInit`
  - whole tree is initialized and ready to be manipulated

* `AfterViewCheck`


