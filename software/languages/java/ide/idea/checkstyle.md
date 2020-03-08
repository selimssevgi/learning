# idea checkstyle config

## lexicographical order

- google checkstyle configuration has this rule

- configure intellij so it will optimize imports based on this rule

- settings, code style, java, imports
  - delete java lines
  - first static imports
  - blank line
  - all other imports

* while there increase the number to max in order to disable * imports

## fix comment indentation

- Go to File > Settings > Editor > Code Style > Java > Code Generation and
  uncheck the option "Line comment at first column".

## suppression file

- use custom checkstyle.xml
- if it has reference to config_loc and probably that file is same as
  checkstyle.xml, use "./" it will pick it up

## CheckStyle Rules as Code Formatter

- Settings -> Code Style

- Dropdown the gear -> Import Schema -> Select your checkstyle file

- Now you can use IDEA code formatter so it will format based on rules in the checkstyle xml

- Formatting can be files based or directory based, right click

