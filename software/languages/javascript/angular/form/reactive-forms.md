# reactive forms

- reactive, programming, immutability, no mutation

- no two-way binding is allowed

- you can use an observable to watch a particular form control for changes

```html
<form *ngIf="invoice" [formGroup]="invoiceForm">
<input name="service" type="text" placeholder="Service" formControlName="service">
<input placeholder="Choose a date" formControlName="date">
```
