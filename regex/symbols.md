
## Examples:
(ht|f)tps?://.+ matches web site names

## Symbols
. -> matches any character except for line breaks if dotall is false
? -> character or token comes before is optional. 0 or 1
hello? -> o is optional hell or hello
(hello)? -> hello is optional hello or nothing

+ -> 1 or more, greed matcher
* -> 0 or more
| -> or: gr(a|e)y (f|ht)ths? matches ftp, http, https
^ -> matches the beginning of the string. ^H
  - ^[abc] -> here it means at the beginning
  - [^abc] -> here it negates, not a and b and c
$ -> matches the end of the string. [.](jpg|png|gif)$

{min,max}: \d{3,4} matches 333 and 3334

## Character Classes []
Matches any single character in the set.

gr[ea]y -> matches gray or grey
[tT]he  -> matches the or The


## Capturing Values
$1, $2
