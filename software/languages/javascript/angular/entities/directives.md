# directives

- allow you to modify the behavior and display of DOM elements

- make it possible to add some conditional logic or otherwise modify the way the template behaves or is rendered

### \*ngIf


```html
<main *ngIf="stocks">
<!--...-->
</main>
```

### \*ngFor

```html
<div *ngFor="let stock of stocks">
<!--...-->
</div>
```

### NgClass

- able to add or remove CSS classes to and from the element


```html
<div class="mdl-card stock-card mdl-shadow--2dp"
     [ngClass]="{increase: isPositive(), decrease: isNegative()}" style="width: 100%;">

```
