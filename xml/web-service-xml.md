#

- Configuration and Data Exchange

- Data and Meta Data

```xml
<? xml version="1.0" ?>

<patient id="123">
  <name>John</name>
</patient>
```

- XML Schema is a Blue Print for the XML Document.

- Valid XMl - If a XML Document has a associated schema and if it complies with
  the schema it is called a valid XML.

## XML Schema
- Contract between a XML provider and consumer

- It is a XML Document

- Used for Data/Meta-Data Validation

- Popular Schemas
  - web.xsd for web.xml the JEE web application descriptor
  - project.xsd for eclipse IDE projects

## XSD Types
1. In-Built Types
   - string, boolean, decimal, float, double, dateTime
2. Simple Types
3. Complex Types

## XML Namespace
Similar to packages in Java.

- Two uses:
  1. Uniquely qualify elements: <amazon:order>, <ebay:order>
  2. Organize types across schemas
