# Normalization

- How you are going to use your data will affect how you set up your table

- Relational does not mean multiple tables relating each other, how the columns
  relate to each other to describe one thing

1. Pick your thing 'the one thing' you want your table to describe.
   (What is the main thing you want your table be about?)

2. Make 'a list of information' you need to know about your one thing when you
   are 'using the table'. (How will you use this table?)

3. Using the list, 'break down the information' abot your thing into pieces you
   can use for 'organizing' your table. (how most easily query this table?)

- see atomic-data.md

- making your data atomic is the first step in creating a NORMAL table

## The benefits of normal table

1. Normal table won't have duplicate data, which will reduce the size of db

2. With less data to search through, queries will be faster

