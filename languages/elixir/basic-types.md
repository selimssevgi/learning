# Elixir Basic Types

```shell
iex # interactive elixir

1 + 1
i 5 * 5 # inspect result
b = 5 * 5
i b
i 10/2
div(10, 5)
rem(10, 5)
```

## Atom

- symbol in ruby and clojure
- memory efficient
- similar to enums
- nil and false are falsy, other values are truthy values

```shell
:"ok"
:"the vlaue is the same as the string"
:true
:false
i true
true == :true
:nil
```

## String

```shell
hello = "Hello, "
name = "Elixir."
hello <> name # concat
"Hello #{name}" # string interplation
```

## Tuples

```shell
book = {"book title", "author", 25.00} # can put different types
elem(book, 2)
put_elem(book, 2, 48.00)
book # in elixir data is immutable

# pattern matching
{title, author, price} = book
{title, author, _} = book
```

## List

```shell
list = [1,2,3] # single-linked list
second_list = [:ok, 1, "test", list]
hd(list)
tl(list)
third_list [ 1 | [2, 3] ]
# pattern matching
[head | tail] = list
```

## Map

```shell
empty_map = %{}
map = %{"one" => 1, "onetwo" => [1, 2]}
```

## Immutability

- Can reassign variables, but cannot change the data
