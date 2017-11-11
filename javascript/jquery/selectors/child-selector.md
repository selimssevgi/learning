# Child Selector

- Sometimes instead of searching the whole page, may want to select only the
  direct children of a certain element


```html
<ul class="my-list">
  <li>
    <a href="http://jquery.com">jQuery supports</a>
      <ul>
        <li><a href="css1">CSS1</a></li>
        <li><a href="css2">CSS2</a></li>
        <li><a href="css3">CSS3</a></li>
        <li>Basic XPath</li>
      </ul>
  </li>
  <li>jQuery also supports
    <ul>
      <li>Custom selectors</li>
      <li>Form selectors</li>
    </ul>
  </li>
</ul>
```

```javascript
$('ul.mylist > li > a')
```
