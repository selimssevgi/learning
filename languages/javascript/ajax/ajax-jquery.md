# AJAX calls with jQuery

```javascript
// jQuery method

const link = 'http://www.filltext.com?rows=5&content={string}'

$.get(link, (data) => {
  console.log(data);
});
```

```javascript

$.ajax({
  type: 'GET',
  url: link,
  success: function(data) {},
  error: function(jqXHR, textStatus, error) {}
});
```

## Form and Post Method

```javascript
$('#my-form').submit(function (e) {
  // get data from form
  let formData = {
    'thing': $('input[name=thing]').val(),
  };

  // make post ajax call
  $.ajax({
    type : 'POST',
    url  : '/things',
    data : formData,
  }).done(function (data) { // using promise
    insertItem(data); // anonfunc doesnt work!
  });

  e.preventDefault();
});
```

## Anchor and Delete

```javascript
$('.delete-link').click(function (e) {

  let id = $(this).attr('thingid');
  let p  = $(this).parent();

  $.ajax({
    type: 'DELETE',
    url:  '/things/' + id,
  }).done(function () {
    $(p).remove();
  });
});
```
