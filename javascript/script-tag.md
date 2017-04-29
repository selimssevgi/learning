# Script Tag

- script tag can be anywhere in html file.
- no type attribute: type="text/javascript" by default
- no language attri: is javascript by default

```html
<!DOCTYPE HTML>
<html>
<body>
  <script>
    alert("Hello World!");
  </script>
</body>
</html>
```

## External Scripts

- Better to keep js code in external file
- Will be cached, save traffic and make pages faster

```html
<script src="path/to/js/file"></script>
```

- Both src and js code between script tag wont work. Choose one!
