# ID Selector

- Used when you want to select one and only one element

- jQuery returns a collection of either zero or one DOM element

- In case of more than elements with the same ID, it returns the first match

- ID names can contain characters that have meaning in jQuery, escape them

- Behind the scenes the library uses getElementByID()

```javascript
$('#my_id').fadeOut();

$('#\\.description'); // #.description
```
