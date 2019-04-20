# Inverted Index

- An inverted index is at the heart of a search engine

- Document have content
  1. House Stark - winter is coming
  2. House Baratheon - ours is the fury
  3. House Tyrell - growing strong



1. Step 1: know of the document existence (run the crawler)
  - content of the documents are parsed and analyzed

```shell
# tokenize text into words
winter
is
coming
ours
the
fury
growing
strong
```

- Split workds, lowercased, removed punctuation

Words     | Frequency | document
---------------------------------
winter    | 1         | Stark
is        | 2         | Stark, Baratheon
coming    | 1         | Stark
ours      | 1         | Baratheon
the       | 1         | Baratheon
fury      | 1         | Baratheon
growing   | 1         | Tyrell
strong    | 1         | Tyrell

- inverted index: words + frequency + source document
- Dictionary: words + frequency

- dictionary is usually sorted so looking up a particular word is easy
