# templates 

- *interpolation:* displaying content in the page
- *attr and property bindings:* linking data from the component into attr or properties of other elements
- *event bindings* adding event listeners to elements
- *directives:* modifying behavior or adding additional structure to elements
- *pipes:* formatting data before it is displayed on the page

### interpolation binding

```html
{{10 + 20}}

{{'just a simple string'}}

<a href="/users/{{user.id}}">View Profile</a>

<p>{{user.name}}</p> // interpolation binding

{{getName()}}
```

### property binding

- using the [] binds to an element's property, not the attribute

```html
<img src="{{user.img}}" /> // property binding
<img [src]="user.img" /> // property binding
```

### event binding

- the other two are moving data from component to template

- this one goes from template to component

- the syntax uses () for event bindings

- use the name of the event inside () without the "on" part of the name

```html
<form (submit)="save()"> // event binding
```

### two-way binding

- it uses both the property and event binding syntax together: [()]
