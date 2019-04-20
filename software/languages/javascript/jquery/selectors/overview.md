# Selectors

- The main way to get at stuff with jQuery is to use 'selectors'

- The first thing you need to do when using virtually any jQuery method is to
  select some document elements to act upon

- jQuery() function and its alias ($) return a jQuery object containing a set of DOM elements

- The selectors are same one being used with CSS

0. All (Universal) selector
1. Element selector (tag selector)
2. Class selector
3. ID selector

- CSS selectors select elements to add "style" to those elements

- jQuery selectors select elements to add "behavior" to those elements

- Widely adopted convention is to prepend a dollar sign to the name of the variable

- Reason for adoption is to be sure not to invoke $() on a set of DOM elements again

- If another selector is not specified, the use of Universal selector is implicitly assumed

## Some Simple CSS Selectors

Example | Description | In CSS?
--------|-------------|-----------
\*      | Matches all elements | YES
\#special-id | Matches the element with ID | YES
.special-class | Matches all elements with given class | YES
a       | Matches all anchor elements | YES
a.special-class | Matches all anchor elements with given class | YES
.class.special-class | Matches all element with given classes | YES

## Hierarchial Selectors

Selector | Description | In CSS?
---------|-------------|--------
E F      | all emenets with tag name F that are descendants of E | YES
E>F      | all emenets with tag name F that are direct children of E | YES
E+F      | all emenets with tag name F that are immediately preceded by sibling E | YES
E~F      | all emenets with tag name F preceded by any sibling E | YES
