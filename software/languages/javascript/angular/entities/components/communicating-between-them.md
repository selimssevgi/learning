# communicating between components

- @Input -- from parent to child
- events -- from component tree to parent


## output events

```script
//NavBar.component
  @Output() onRefresh: EventEmitter<null> = new EventEmitter<null>();

  refresh() {
    this.onRefresh.emit();
  }
```

```html
//NavBar.html
<button type="button" (click)="refresh()">Refresh</button>
```

- local variable reference to dashboard, and call a method in that component

```javascript
//AppComponent
<app-navbar (onRefresh)="dashboard.generateData()"></app-navbar>
<app-dashboard #dashboard></app-dashboard>
```

- if no components are listening to the event, then it will not propagate up the component tree
- output events only go to the parent component, unlike regular DOM event that
  do propagate up the DOM tree


* this is handy for accessing components that exist in the same template
* the major negative is that it only allows you to access the component from the
  template and not fron the component, meaning the AppComponent controller can't
  call the DashBoard component methods directly

## view child to reference components

- it is limited to injecting only children

- if you try to inject a component that isn't a direct descendent, it will
  provide you with an undefined value

```javascript
// AppComponent
	@ViewChild(DashboardComponent) dashboard: DashboardComponent;

  refresh() {
    this.dashboard.generateData();
	}
```
