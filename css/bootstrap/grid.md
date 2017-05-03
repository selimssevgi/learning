# Grids

- Bootstrap comes with a 12-column grid system
- Add content into the 'rows' and 'columns' of this grid using css classes
- Bootstrap will take care of the responsive work

```shell
+---+---+---+---+---+---+---+---+---+---+---+---+
| 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+---+---+---+---+

+---+---+---+---+---+---+---+---+---+---+---+---+
|       4       |       4       |       4       |
+---+---+---+---+---+---+---+---+---+---+---+---+

+---+---+---+---+---+---+---+---+---+---+---+---+
|       4       |               8               |
+---+---+---+---+---+---+---+---+---+---+---+---+

+---+---+---+---+---+---+---+---+---+---+---+---+
|           6           |           6           |
+---+---+---+---+---+---+---+---+---+---+---+---+

+---+---+---+---+---+---+---+---+---+---+---+---+
|                      12                       |
+---+---+---+---+---+---+---+---+---+---+---+---+
```

## Containers

- 2 types of containers

1. Fixed container: 'container'
  - has fixed width, changes at certain breakpoints
  - padding: 15px;

2. Fluid container: 'container-fluid'
  - has fluid width, stretches to 100% of it's parent element
  - padding: 15px;

## Columns

- col-{size}-{number}
- {size}   : the size of the viewport
- {number} : number of columns the element to span

- size
  - xs (<768)
  - sm (>=768)
  - md (>=992)
  - lg (>=1200)

- number: between 1 and 12

```html
<div class="row">
  <div class="col-md-2 col-sm-4 col-xs-6">thumbnail</div>
  <div class="col-md-2 col-sm-4 col-xs-6">thumbnail</div>
  <div class="col-md-2 col-sm-4 col-xs-6">thumbnail</div>
  <div class="col-md-2 col-sm-4 col-xs-6">thumbnail</div>
  <div class="col-md-2 col-sm-4 col-xs-6">thumbnail</div>
  <div class="col-md-2 col-sm-4 col-xs-6">thumbnail</div>
</div>
```

## Columns Offsetting

- just appling offset would push the column to otherside
- also reduce the width

```html
<div class="col-xs-offset-2 col-xs-8 col-md-4 col-md-offset-0">
```
