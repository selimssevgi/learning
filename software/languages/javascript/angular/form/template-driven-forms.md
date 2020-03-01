# template-driven forms

- the key marker is `NgModel`

- tempalte forms are named primarily because the form controls are defined in
  the template of the component

- the form is primarily defined in the template layer, it also means that
  validation errors are managed primarily through the template

```shell
<input name="customer" placeholder="Customer Name" [(ngModel)]="customer.name">
```

### validation with NgModel

- NgModel already works with html5 form validations: required, minlength etc

```shell
<input name="customer"
       placeholder="Customer Name"
       [(ngModel)]="customer.name"
       required
       #name="ngModel">
<md-error *ngIf="name.touched && name.invalid">
  Name is required
</md-error>
```
