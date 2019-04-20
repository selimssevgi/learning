# Strings in C++

- C++ provides two types of string representations:

1. C-style character string
2. The string class type introduced with Standard C++

```cpp
char greeting[] = { 'H', 'e', 'l', 'l', 'o', '\n' };
char greeting[] = "hello";

// some string functions
strcpy(s1, s2); // copies string s2 into s1

strcat(s1, s2); // concatenates string s2 onto the end of s1

strlen(s1); // returns the length of s1

strcmp(s1, s2); // -1, 0, 1

strchr(s1, ch); // return the pointer to the first occurrence of char ch in s1

strstr(s1, s2);
```

## String Class

```cpp
#include <string>

string str1 = "Hello";
string str2 = "World";
string str3;
int len;

// strcpy(s3, s1)
str3 = str1;

// strcat(s1, s2)
str3 = str1 + str2

// strlen(s1)
len = str3.size();
```
