# Form Filters

* Trying to match by attribute will check only the initial state of the control
  as specified in the HTML markup

```javascript
$('input[type="checkbox"][checked]');
```

* What you really want to check is the real-time state of the controls

- CSS offers a pseudo-class, :checked, that matches the elements that are in a
  checked state


```javascript
$('input[type="checkbox"]'); // selects all input elements that are check boxes

$('input[type="checkbox"]:checked'); // currently checked check boxes
```

* jQuery also provides a handful of powerful custom filter selectors

- custom :checkbox selector identifies all check box elements

```javascript
$('input:checkbox:checked')
```

Selector | Description  | in CSS?
---------|--------------|--------
:button  | only button elements, input[type=submit/reset/button] | NO
:checkbox | only check box elements | NO
:checked | check boxes/radio elements/options of select in checked state | YES
:disabled | only elements in the disabled state | YES
:enabled | only elements in the enabled state | YES
:file | only file input elements (input[type=file]) | NO
:focus | elements that have focus at the time the selector is run | YES
:image | only image input elements (input[type=image]) | NO
:input | only form elements (input, select, textarea, button) | NO
:password | only password elements (input[type=password]) | NO
:radio | only radio elements (input[type=radio]) | NO
:reset | only reset elements (input[type=reset]) | NO
:selected | only 'option' elements that are in the selected state | NO
:submit | (button[type=submit]) or (input[type=submit]) | NO
:text | (input[type=text]) or input without 'type' specified (default) | NO

* Filter selectors can be combined

```javascript
$('input:checkbox:checked:enabled');
```
