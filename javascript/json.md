# JSON

- They are analogous to the dict and hashmaps of other programming languages.

- The file type for JSON files is ".json"
- MIME type for JSON text is "application/json"

- Strings in JSON must be written in double quotes, so it would be valid
- Numbers in JSON must be an integer or a floating point

- JSON is purely a data format -- it contains only properties, no methods

- Unlike in JS code in which identifiers may be used as properties, in JSON,
  only strings may be used as properties

- use jsonlint.com to validate json

## Retrieving JSON

```javascript
var requestUrl = "A url that returns json";
var request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'json';
request.send();

request.onload = function() {
  var jsonObj = request.response;
}
```

## Conversion between text and json

- JSON.parse([String])
- JSON.stringify([JSON])

```javascript
request.responseType = 'text';
request.send();

request.onload = function() {
  var text = request.response;
  var json = JSON.parse(text);
}
```

### Syntax

- Data is in name/value pairs
- Data is separated by commas
- Curly braces hold objects
- Square brackets hold arrays

* JSON values can be:
  - a string   - { "name":"selim" }
  - a number   - { "age":25, "pi":3.14 }
  - an object  - { "person":{ "name":"selim", "age":25 } }
  - an array   - { "languages":["java", "scala"] }
  - a boolean  - { "gaveup":false }
  - null       - { "surname":null }

* JSON data

```json
{
  "squadName": "Super hero squad",
  "homeTown": "Metro City",
  "formed": 2016,
  "secretBase": "Super tower",
  "active": true,
  "members": [
    {
      "name": "Molecule Man",
      "age": 29,
      "secretIdentity": "Dan Jukes",
      "powers": [
        "Radiation resistance",
        "Turning tiny",
        "Radiation blast"
      ]
    },
    {
      "name": "Madame Uppercut",
      "age": 39,
      "secretIdentity": "Jane Wilson",
      "powers": [
        "Million tonne punch",
        "Damage resistance",
        "Superhuman reflexes"
      ]
    }
  ]
}
```

## Arrays as JSON

- An array can also be a valid JSON object

```json
[
  {
    "name": "Molecule Man",
    "age": 29,
    "secretIdentity": "Dan Jukes",
    "powers": [
      "Radiation resistance",
      "Turning tiny",
      "Radiation blast"
    ]
  },
  {
    "name": "Madame Uppercut",
    "age": 39,
    "secretIdentity": "Jane Wilson",
    "powers": [
      "Million tonne punch",
      "Damage resistance",
      "Superhuman reflexes"
    ]
  }
]
```
