# String Formatting and Regular Expressions

# More Powerful Solutions to Creating String Representations
The need for more powerful string creation
- Concatenating strings is often not enough
  - Very focused on creation details
  - Numeric conversions awkward
- StringBuilder has the same issues

Options for more powerful string creation
- StringJoiner
  - Simplifies joining a sequence of values
- String formatting
  - Can specify desired appearance w/o dealing with creation details

## StringJoiner
has a specific purpose
- Simplify composing a string comprised of a sequence of values

How it works
- Construct the StringJoiner
  - Specify string to separate values
  - Optionally specify start/end strings
- Add values
- Retrieve the resulting string

- Deals with the edge cases internally
  - one value with separator, returns just that value
  - one value with sep, start and end, returns that value with start and end
  - empty returns empty, or with start and end

# Format Specifiers
- Focus is on describing the desired result
  - not concerned with the how
- Can control many aspect of appearance
  - Positioning
  - Decimal places
  - Representation

Some methods supporting format specifiers
- String.format
- System.out.printf
- Formatter.format

## Parts of a Format Specifier
% - Format specifier start
d - Format conversion
precision - Decimal places to display
width  - Minimum characters to display(space-padded,right-justified by default)

% [argument index] [flags] [width] [precision] [conversion]

### Common Format Conversion
d   - decimal 
o   - octol
x|X - hex
f   - floating point
e|E - scientific notation
s   - string (calls format if formattable, otherwise toString)

### Format Flags
(In the code)

# String Matching with Regular Expressions
Java support for regular expressions
- Methods on the String class
  - replaceFirst, replaceAll, split, match
- Dedicated class

## Regular expression considerations
- Compilation is processing intensive
- String methods repeat compilation on every use

### Pattern class
- Compiles a regular expression
- Factory for Matcher class instances

### Matcher class
- Applies compiled expression to a string
