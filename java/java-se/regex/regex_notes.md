# Regular Expression in Java
If we want to present a group of strings according to a particular pattern, then
we should go for reguler expression.

Example; we can write a regular expression to present all valid mobile numbers,
we can write a regular expression to represent all email addresses.


The main important application areas of regular expression are:

1. to develop validation frameworks
2. to develop pattern matching applications(ctrl-f, grep)
3. to develop translators like assemblers, compiler, interpreters etc.
4. to develop digital circuits
5. to develop communication protocols like TCP/IP, UDP etc.


```java
import java.util.regex.*;

class RegexDemo {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("ab");
    Matcher matcher = pattern.matcher("abbabbba");
    int count = 0;

    while (m.find()) {
      ++count;
      System.out.println(matcher.start() + "..." + matcher.end() + ":" +
      matcher.group());
    }

    System.out.println("total number of occurrences: " + count);
  }
}

// 0...2:ab
// 3...5:ab
// total number of occurrences: 2
```

## Pattern
A pattern object is a compiled version of reguler expression. That is, it is a
Java equivalent object of pattern.

We can create a pattern object by using compile() method of Pattern class.

```java
public static Pattern compile(String re)
```

```java
Pattern p = Pattern.compile("ab");
```

## Matcher
We can use Matcher object to check the given pattern in the target string.

We can create a Matcher object by usin matcher() method of Pattern class.

```java
public Matcher matcher(String target)
```

```java
Matcher m = p.matcher("abbabbba");
```

### Important Methods of Matcher class

- boolean find(): it attempts to find next matched and returns true if it is available.

- int start(): returns start index of the match

- int end(): returns end+1 index of the match

- String group(): it returns the matched pattern


*NOTE:* Pattern and Matcher classes present in java.util.regex package, and
introduced in 1.4V.

## Character Classes

- [abc]       : either 'a' or 'b' or 'c'
- [^abc]      : except 'a' and 'b' and 'c'
- [a-z]       : any lower case alphabet symbol from a to z
- [A-Z]       : any upper case alphabet symbol from A to Z
- [a-zA-z]    : any alphabet symbol
- [0-9]       : any digit from 0 to 9
- [0-9a-zA-Z] : any alphanumeric symbol
- [^0-9a-zA-Z]: except alphanumeric symbol(special characters)


```java
Pattern pattern = Pattern.compile("X");
Matcher matcher = pattern.matcher("a3b#k@9Z");
while (matcher.find()) {
  System.out.println(matcher.start() + "..." + matcher.group());
}
```
[abc] |[^abc] |[a-z] |[0-9] |[0-9a-zA-Z] |[^0-9a-zA-Z]   |
---------------------|------|----------------------------|
0...a |1...3  |0...a |1...3 |0...a       |3...#          |
2...b |3...#  |2...b |6...9 |1...3       |5...@          |
      |4...k  |4...k |      |2...b       |               |
      |5...@  |7...Z |      |4...k       |               |
      |6...9  |      |      |6...9       |               |
      |7...Z  |      |      |7...Z       |               |


## Pre-defined Character Classes

- \s  - space character
- \S  - except space character
- \d  - any digit from 0 to 9 [0-9]
- \D  - except digit, any character [^0-9]
- \w  - any word character [A-Za-z0-9]
- \W  - except word character [^A-Za-z0-9], any special chacter
- .   - any character


*Note:* We have to use double \\ while specifying them in compile method as
strings, because compiler will complain that \s is not a valid escape character.

```java
Pattern pattern = Pattern.compile("X");
Matcher matcher = pattern.matcher("a7b k@9z");
while (matcher.find()) {
  System.out.println(matcher.start() + "..." + matcher.group());
}
```
\\s   |\\S    |\\d   |\\D   |\\w   |\\W   |.       |
---------------------|------|-------------|--------|
3...  |0...a  |      |0...a |0...a |      |0...a   |
      |1...7  |1...7 |      |1...7 |      |1...7   |
      |2...b  |      |2...b |2...b |      |2...b   |
      |       |      |3...  |      |3...  |3...    |
      |4...k  |      |4...k |4...k |      |4...k   |
      |5...@  |      |5...@ |      |5...@ |5...@   |
      |6...9  |6...9 |      |6...9 |      |6...9   |
      |7...z  |      |7...z |7...z |      |7...z   |


## Quantifiers
WE can use quantifiers to specify number of occurrences to match.

- a   - exactly one 'a'
- a+  - at least one 'a'
- a\* - any number of 'a' including zero number
- a?  - at most one 'a'

```java
Pattern p = Pattern.compile("X");
Matcher m = p.matcher("abaabaaab");
while (m.find()) {
  System.out.println(m.start() + "..." + m.group());
}
```

a     |a+     |a\*    |a?    |
----------------------|------|
0...a |0...a  |0...a  |0...a |
2...a |2...aa |1...   |1...  |
3...a |5...aaa|2...aa |2...a |
5...a |       |4...   |3...a |
6...a |       |5...aaa|4...  |
7...a |       |8...   |5...a |
      |       |9...   |6...a |
      |       |       |7...a |
      |       |       |8...  |
      |       |       |9...  |


## Pattern Class Split Method
We can use Patter class split() method to split target string according to a
particular pattern.

```java
class SplitDemo {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("\\s");
    String[] words = p.split("Java Programming Language");
    for (String word : words) {
      System.out.println(word);  
    }
  }  
}

// output:
// Java
// Programming
// Language
```

```java
class SplitDemo {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("a");
    String[] words = p.split("Java Programming Language");
    for (String word : words) {
      System.out.println(word);  
    }
  }  
}

// output: except a, others will be tokens
// J
// v
//  Progr
// mming L
// ngu
// ge
```

```java
class SptitDemo {
  public static void main(String[] args) {
    // Pattern p = Pattern.compile("."); // it will match all character, there wont be token
    // Pattern p = Pattern.compile("\."); // CE: illegal escape character
    // Pattern p = Pattern.compile("\\."); // or
    Pattern p = Pattern.compile("[.]");
    String[] words = p.split("Java.Programming.Language");
    for (String word : words) {
      System.out.println(word);  
    }
  }  
}

// output:
// Java
// Programming
// Language
```

## String Class Split Method
String class also contains split() method to split target string according to a
particular pattern.

```java
String s = "Java Programming Language"
String[] words = s.split("\\s");
for(String word : words) {
  System.out.println(word);  
}

// output:
// Java
// Programming
// Language
```

*NOTE:* Pattern class split() method can take target string as argument, whereas
String class split() method can take pattern as argument.

## StringTokenizer
It is a specially designed class for tokenization activity. StringTokenizer
present in java.util package.

```java
StringTokenizer st = new StringTokenizer("Java Programming Language");
while (st.hasMoreTokens()) {
  System.out.println(st.nextToken());  
}

// output:
// Java
// Programming
// Language
```

*Note:* The default regular expression for StringTokenizer is space(\\s). 

```java
StringTokenizer st = new StringTokenizer("19-09-2017", "-");
while (st.hasMoreTokens()) {
  System.out.println(st.nextToken());  
}

// output:
// 19
// 09
// 2017
```

*Ex:* Write a regular expression to present all valid 10 digit mobile numbers.
Rules:
- Every number should contain exactly 10 digits.
- The first digit should be 7 or 8 or 9.

```java
// 10 digits mobile number
String pattern = "[789][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
// or
String pattern = "[7-9][0-9]{9}";

// 10 digits or 11 digits
String pattern = "0?[7-9][0-9]{9}";

// 10 digits or 11 digits or 12 digits
String pattern = "(0|91)?[7-9][0-9]{9}";
```

*Example2:* Write a regular expression to represent all valid email IDs.

```java
String emailPati = "[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-z]+)+"
String onlyGmail = "[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com
```

*Example3:* Write a regular expression to represent all Yava Language
Identifiers.
- Rules:
  - Allowed character are a to z, A to Z, 0 to 9, # and $.
  - Length of each identifier should at least 2.
  - The first charachter should be lower case alphabet symbol a to k.
  - Second character should be digit divisible by three(0,3,6,9)


```java
String p = "([a-k][0369])[a-zA-Z0-9#$]*"
```

*Example4* Write a program to check given mobile number is valid or not.


```java
import java.util.regex;

class PhoneNumberValidator {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
    Matcher m = p.matcher(args[0]);

    if (m.find() && m.group().equals(args[0])) {
      System.out.println("valid phone number");  
    } else {
      System.out.println("invalid phone number");  
    }
  }  
}

// 92929292929292 : it matches but not a valid phone number
```

*Example5:* Write a program to check whether given email is valid or not.
In the above program we have to replace mobile number regex with email id regex.

*Example6:* Write a program to read all mobile numbers present in a given input
file, where mobile numbers are mixed with normal text data.


```java
PrintWriter pw = new PrintWriter("output.txt");
Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
BufferedReader br = new BufferedReader(new FileReader("input.txt"));
String line = br.readLine();
while (line != null) {
  Matcher m = p.matcher(line);
  if (m.find()) {
    pw.println(m.group);
  }
}

pw.flush();
pw.close();
br.close();
```

*Example7:* Write a program to display .txt file names.

```java
Pattern p = Pattern.compile("[a-zA-Z0-9_.$]+[.]txt");
File f = new File("/home/ssselim");
String[] files = f.list();
for (String file : files) {
  Matcher m = p.matcher(file);
  if (m.find() && m.group().equals(file)) {
    System.out.println(file);  
  }
}
```
