# Literal Characters

- Strings
  /car/ matches "car"
  /car/ matches the first three letters of "carnival"

- Case-sensitive (by default)
- Case-insensitive /i

- Standard(non-global) matching /g
  - Earlies (leftmost) match is always preferred
    /zz/ matches the first set of z's in "pizzazz"

- Global matching /g
  All matches are found 

- Regular expression engines are eager to return smth as soon as possible.

## Metacharacters

- Characters with special meaning
  Like mathematical operators
  Transform literal characters into powerful expressions

- Only a few metacharacters to learn:

```shell
\ . * + - {} [] ^ $ | ? () : ! =
```

- Can have more than one meaning
  Depends on how it is used in context

- Variation between regex engines

### The Wildcard Metacharacter (dot)

- Matches any one character except newline
(original Unix regex tools were line based.)

```shell
/h.t/ matches
"hat", "hot", and "hit", "h#t", "h t", but not "heat"
```

- Broadest match possible

- Most common metacharacter

- Most common mistake

*!!* /9.00/ matches "9.00", "9500", and "9-00"

### Escaping Metacharacter (backslah \)
- \ : escape the next character

- Allows use of metacharacters as literal characters

- Match a period with \.
  /9\.00/ matches "9.00", but not "9500" or "9-00"

- Match a backslash by escaping a backslash (\\)

- Only for metacharacters
  - Literal characters should never be escaped, gives them meaning

- Quotation marks are not metacharacters, do not need to be escaped

## Character Set
- [ - Begin a character set
- ] - End   a character set

- Any one of several characters
- but only one character
- Order of characters does not matter

*Examples* 
- /[aeiou]/ matches any one vowel
- /gr[ae]y/ matches "grey" and "gray"
- /gr[ae]t/ does not match "great"

## Character Range
- - : range of characters

- Range metacharacter
  - Represents all characters between two characters
  - Only a metacharacter inside a character set, a literal dash otherwise

*Examples*
- [0-9]
- [A-Za-z]
- [a-ek-ou-y]

**!!** [50-99] is not all numbers from 50 to 99, it is the same as [0-9]

## Negative Character Sets
- ^ : negative a character set

- Not any one of several characters
  - Add ^ as the first character inside a character set
  - Still represents one character

*Examples:* 
- /[^aeiou]/ matches any one consonant (non-vowel)
- /see[^mn]/ matches "seek" and "sees" but not "seem" or "seen"

*!!* /see[^mn]/ matches "see " but not "see"

# Metacharacters inside Character Sets

- Metacharacters inside character sets are already escaped
  - Do not need to escape them again
  - /h[abc.xyz]t/ matches "hat" and "h.t", but not "hot"

- Exceptions:
  - [, -, ^, \

*Examples:* 
- /2003[-/]10[-/]05/ may not require escaping
- /file[0-\_]1/ does required escaping

## Shorthand Character Sets

Shorthand | Meaning                 | Equivalent 
------------------------------------------------
  \d      | Digit                   | [0-9]
  \w      | Word character          | [a-zA-Z0-9\_]
  \s      | Whitespace              | [ \t\r\n]
  \D      | Not digit               | [^0-9]
  \W      | Not word character      | [^a-zA-Z0-9\_]
  \S      | Not whitespace          | [^ \t\r\n]

*Examples* 
/\d\d\d\d/ matches "1984", but not "text"
/\w\w\w/ matches "ABC", "123", and "1_A"
/\w\s\w\w/ matches "I am", but not "Am I"
/[\w\-]/ matches as word character or hyphen (useful)
/[\d\s]/ matches any digit or white space character
/[^\d]/ is the same as /\D/ and /[^0-9]/

*!!*
/[^\d\s]/ is not the same as [\D\S]
/[^\d\s]/ = NOT digit OR space character
/[\D\S]/ = EITHER NOT digit OR NOT space character

## POSIX Bracket Expressions

Class        | Meaning                               | Equivalent
----------------------------------------------------------------
[:alpha:]    | Alphabetic characters                 | A-Za-Z
[:digit:]    | Numeric characters                    | 0-9
[:alnum:]    | Alhpanumeric characters               | A-Za-z0-9
[:lower:]    | Lowercase alphabetic characters       | a-z
[:upper:]    | Uppercase alphabetic characters       | A-Z
[:punct:]    | Punctuation characters                |
[:space:]    | Space characters                      | \s
[:blank:]    | Blank characters(space, tab)          |
[:print:]    | Printable characters, spaces          |
[:graph:]    | Printable characters, no spaces       |
[:cntrl:]    | Control characters (non-printable)    |
[:xdigit:]   | Hexadecimal characters                | A-Fa-f0-9

* Use inside a character class, not stand alone

- Correct:   [[:alpha:]] or [^[:alpha:]]
- Incorrect: [:alpha:]

* Good idea not to mix POSIX sets and other shorthand sets

* Support
  - YES: Perl, PHP, Ruby, Unix
  - NO : Java, Javascript, .NET, Python

## Repetition Metacharacters

Metacharacter | Meaning
--------------------------------------------------
     *        | Preceding item zero or more times
     +        | Preceding item one  or more times
     ?        | Preceding item zero or more time (optional)

*Examples*
/apples\*/ matches "apple", "apples", and "applessssss"
/apples+/  matches "apples" and "applessss", but not "apple"
/apples?/  matches "apple" and "apples", but not "applessssss"
/\d\d\d\d\*/ matches numbers with three digits or more
/\d\d\d+/ matches numbers with three digits or more
/colou?r/ matches "color" and "colour"

- Support
  - * is supported in all regex engines
  - + and ? are not supported in BREs (old Unix programs)

## Quantified Repetition

Metacharacter | Meaning
---------------------------------------------------------
     {        | Start quantified repetition of preceding item
     }        | End   quantified repetition of preceding item

- {min, max}
  - min and max are positive numbers
  - min must always be included, can be zero
  - max is optional

- Three syntaxes
  - \d{4,8} matches numbers with four to eight digits
  - \d{4}   matches numbers with exactly four digits (min is max)
  - \d{4,}  matches numbers with four or more digits (max is infinite)

*Examples:*

- \d{0,} is the same as \d\*
- \d{1,} is the same as \d+
- /\d{3}-\d{3}-\d{4}/ matches most of U.S. phone numbers
- /A{1,2} bonds/ matches "A bonds" and "AA bonds", not "AAA bonds"

## Greddy Expressions

- Standard repetition quantifiers are greedy
- Expression tries to match the longest possible string

- Defers to achieving overall match
  - /.+\.jpg/ matches "filename.jpg"
  - + is greedy, but "gives back" the ".jpg" to make the match
  - Think of it as rewinding or backtracking

- Gives back as little as possible
  - /.\*[0-9]+/ matches "Page 266"
  - /.\*/ matches "Page 26" while /[0-9]+/ matches "6"


*NOTE:* Regular expression engines are eager and greddy.

## Lazy Expressions
- Syntax
  - \*?
  - +?
  - {min,max}?
  - ??

- Instruct quantifier to use a "lazy strategy" for making choices

- Greddy Strategy
  - Match as much as possible before giving control to the next expression part

- Lazy Strategy
  - Match as little as possible before giving control to the next expression part
  - Still defers to overall match
  - Not necessarily faster or slower

- Not supported in most Unix tools
- Other languages etc mostly supports

## Efficiency When Using Repetition

- Efficient matching + less backtracking = speedy results

- Define the quantity of repeated expressions
  - /.+/ is faster than /.\*/
  - /.{5}/ and /.{3,7}/ are even faster

- Narrow the scope of the repeated expression
  - /.+/ can become /[A-Za-Z]+/

- Provide clearer starting and ending points
  - /<.+>/ can become /<[^>]+>/
  - Use anchors and word boundaries

## Grouping Metacharacters

Metacharacters | Meaning
-----------------------------------------
      (        | Start grouped expression
      )        | End   grouped expression

- Group portions of the expression
  - Apply repetition operators to a group
  - Makes expressions easier to read
  - Captures group for use in matching and replacing
  - Cannot be used inside character set

*Examples:*
- /(abc)+/ matches "abc" and "abcabcabc"
- /(in)?dependent/ matches "independent" and "dependent"
- /run(s)?/ is same as /runs?/

## Altertion Metacharacters

Metacharacters | Meaning
-----------------------------------------
      |        | Match previous or next expression


- | is an OR operator
  - Either match expression on the left or match expression on the right
  - Ordered, leftmost expression gets precedence
  - Multiple choices can be daisy-chained
  - Group alternation expressions to keep them distinct

*Example:*
- /apple|orange/ matches "apple" and "orange"
- /abc|def|ghi|jkl/ matches "abc", "def", "ghi", and "jkl"
- /apple(juice|sauce)/ is not the same as /applejuice/sauce/
- /w(ei|ie)rd/ matches "wierd" and "wierd"

**NOTE:** Put simplest (most efficient) expression first.

## Repeating and Nesting Alternations
- Repeating
  - First matched alternation does not affect the next matches
    - /(AA|BB|CC){6}/ matches "AABBAACCAABB"

- Nesting 
  - Check nesting carefully (in text editor on separate lines)
  - Trade-off between precision, readability, and efficiency

## Start and End Anchors

Metacharacter | Meaning
----------------------------------------
     ^        | Start of string/line
     $        | End   of string/line
     \A       | Start of string, never end of line
     \Z       | End   of string, never end of line

- Reference a position, not an actual character
  - Zero-width

- Examples
  - /^apple/ or /\Aapple/
  - /apple$/ or /apple\Z/
  - /^apple$/ or /\Aapple\Z/

- Support
  - ^ and $ are supported in all regex engines
  - \A and \Z are supported in Java, .NET, Perl, PHP, Python, Ruby

## Line Breaks and Multiline Mode

- Single-line mode:
  - ^ and $ do not match at line breaks
  - \A and \Z do not match at line breaks
  - Many Unix tools support only single-line

- Multiline mode:
  - ^ and $ will match at the start and end of lines
  - \A and \Z do not match at line breaks
  - Languages usually offer a multiline option

## Word Boundaries

Metacharacter | Meaning
----------------------------------------
     \b       | Word boundary (start/end of word)
     \B       | Not a word boundary

- Reference a position, not an actual character

- Conditions for matching
  - Before the first word character in the string
  - After the last word character in the string
  - Between a word character and a non-word character

- Word characters: [A-Za-z0-9\_]

- Support
  - Most recent regex engines, not old unix regex tools

- Boundary Examples
  - /\b\w+\b/ finds four matches in "This is a test."
  - /\b\w+\b/ matches all of "abc_123" but only part of "top-notch"

- Not a boundary examples
  - /\BThis/ does not match "This is a test."
  - /\B\w+\B/ finds two matches in "This is a test." ("hi" and "es")

- Caution
  - A space is not a word boundary
  - Word boundaries reference a position
    - Not an actual character
    - Zero-length

- Examples
  - String: "apples and oranges"
  - No match: /apples\band\boranges/
  - Match: /apples\b \band\b \boranges/

## Backreferences

- Grouped expressions are captured
  - Stores the matched portion in parentheses
    - /a(p{2}l)e/ matches "apple" and stores "ppl"
    - Stores the data matched, not the expression
  - Automatically, by default

- Backreferences allow access to captured data
  - Refer to first backreference with \1

Metacharacter | Meaning
----------------------------------------------
\1 through \9 | Backreference for positions 1 to 9

- Usage
  - Can be used in the same expression as the group
  - Can be accessed after the match is complete
  - Cannot be used inside character classes

- Support
  - Most regex engines support \1 through \9
  - Some regex engines support \10 through \99
  - Some regex engines use $1 through $1 instead

- Examples
  - /(apples) to \1/ matches "apples to apples"
  - /<(i|em)>.+?</\1>/ matches "<i>Hello</i>" and "<em>Hello</em>"

## Non-capturing group expressions

- By default, engine captures the group in (), we can turn it off

Metacharacter | Meaning
----------------------------------------------
     ?:       | Specify a non-capturing group


- Syntax
  - /(\w+)/ becomes /(?:\w+)/

- Turns off capture and backreferences
  - Optimize for speed
  - Preserve space for more captures

- Support
  - Most regex engines except Unix tools

- /(?:regex)/
  - ? = "give this group a different meaning"
  - : = "the meaning is non-capturing"

## Positive Lookahead Assertions

Metacharacter | Meaning
----------------------------------------------
     ?=       | Positive lookahead assertion

- Assertion of what ought to be ahead
  - If lookahead expression fails, the match fails
  - Any valid regular expression can be used
  - Zero-width, does not include group in the match

- Support 
  - Most regex engines excep Unix

- Syntax
  - /(?=regex)/
  - no space between ?=r

- Examples
  - /(?=seashore)sea/ matches "sea" in "seashore" but not "seaside"
  - same as /sea(?=shore)/
  - in the first one: first assert of the word is seashore then match with see
  - in the second matches with sea then assert ahead whether it is shore
  - dont match with "shore" just confirm it is there

*NOTE:* We can do more than one test, which would be harder in otherwise. For
example, we can check a password will be 8 to 15 long and contains digits. It is
like having "and" conditions on string.

- /^(?=.\*\d)(?=.\*[A-Z]).{8,15}$/ : password length 8-15 contains digit and
  capital letter.

## Negative LookAhead Assertions

Metacharacter | Meaning
----------------------------------------------
     ?!       | Negative lookahead assertion

- Syntax
  - /(?!regex)/

- Examples
  - /(?!seashore)sea/ matches "sea" in "seaside" but not "seashore"
  - /online(?! training)/ does not match "online training"
  - /online(?!.\*training)/ does not match "online video training"
  - Specifying a condition to match
  - /\b[A-Za-z'A]+?\b(?![,.])/ matches words not ending with "." and ",".

## Lookbehind Assertions

Metacharacter | Meaning
----------------------------------------------
     ?<=      | Positive lookbehind assertion
     ?<!      | Negative lookbehind assertion

- Assertion of what ought to be behind
  - Similar to lookahead assertions
  - If lookbehind expression fails, the match fails
  - Any valid regular expression can be used
  - Zero-width, does not include group in the match

- Syntax
  ```shell
  /(?<=regex)/
  /(?<!regex)/
  ```

- Example
  - /(?<=base)ball/ matches the "ball" in "baseball" but not "football"

*NOTE:* Cars meant to be drived forward, is hard to drive it backward. Same in
regular expression when rewinding backward. Therefore support for lookbehind is
limited.

## The power of Positions

- Allows testing of regular expression apart from matching
- Peek forwards or backwards
  - /sea(?=shore)/
- Match a string using multiple expressions(password example)
- Define a rejection expressions
  - /online(?! training)/
- Find last occurrence
  /(item)(?!.\*\1)/

- Zero-width means zero position movement
  - it searches and assert but rewinds back

```shell
/(?<![$\d])\d+\.\d\d/ matches "54.00" but not "$54.00"
```

```shell
/(?<![$\d])(?=\d+\.\d\d)/ 

# What gets matched?
Goes backward, rewinds. Goes forward, rewinds. Matches with zero-length

# Where is the regex engine pointer?
at the asserted position.
```

*NOTE:* Useful for inserting text(using find and replace): replacing zero-length
with some legthy text.

## Examples
- They are not one-size-fits-all regular expressions

- Any regular expression can be written broadly and narrowly
  - Broad : permissive
  - Narrow: restrictive, brittle

- Regular expression to match a year
  - /\d{4}/ matches 2005, but also 0000-9999 : not good
  = /(19|20)\d\d/ matches 1900-2099          : too permissive
  - /(19[5-9]\d|20[0-4]\d)/ matches 1950-2049: too restrictive

*NOTE:* Never use someone else's regular expression without checking it
carefully and fine-tuning it for your specific needs.

- How to write or customize a regular expression
  - Examine the data to be matched
  - Determine what aspects of the data are important
  - Determine what level of precision is required
  - Make a list of "edge cases" to test
    - Longest, shortest
    - Highest, lowest
    - Most unusual, most oddly-formatted

  - Use anchors, delimeters, or context
    - /\w+/ matches "%^@X&!", matches any word character : X
    - /^\w+$/ 
    - /\b\w+\b/
    - / \w+ /
    - /,w+,/
    - /and \w+\./

  - Be mindful of greediness and laziness

## Match Names

- /\w+/ : matches $kevin
- /^\w+$/ : matches 0kevin
- /^[A-Za-z]+$/  matches kevin(first character must be capital)
- /^[A-Z][A-Za-z]+$/ doesnt match J.R.
- /^[A-Z][A-Za-z.'\-]$/ doesnt match ABC DEF(two names)
