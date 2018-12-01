# DataFrame and Series



```python
# pd.read_table('', sep=',')
ufo = pd.read_csv('http://bit.ly/uforeports')

type(ufo) # pandas.core.frame.DataFrame

type.head()
```

## How to select series

- bracket notation (case-sensitive)
- dot notation (each column name, becomes attribute name)
- dot notation does not work if column has more than one word
- dot notation does not wokr if column name has built-in function name(head?)

```python
ufo['City']

cities = ufo.City

type(cities) # pandas.core.series.Series

# creating a new column
ufo.['Location'] = ufo.City + ', ' + ufo.State
```

# Rename column names

```python
ufo.columns

ufo.rename(columns = {'Colors Reported': 'Colors_Reported'}, inplace=True)

# rename all columns at once
ufo_cols = ['city', 'colors reported', 'shape reported', 'state', 'time']
ufo.columns = ufo_cols

# replace all spaces
ufo.columns = ufo.columns.str.replace(' ', '_')
```

# How to remove a column

```python
ufo.drop('Colors Reported', axis=1, inplace=True)

# multiple drop
ufo.drop(['Colors Reported', 'City'], axis=1, inplace=True)

# remove rows
ufo.drop([0, 1], axis=0, inplace=True) # removes first two columns

```

## How to sort DataFrame or Series

```python
import pandas as pd

movies = pd.read_csv('http://bit.ly/imdbratings')

# not in place

# sort Series
movies.title.sort_values()

movies.title.sort_values(ascending=False)

# sort dataframe
movies.sort_values('title')

movies.sort_values(['content_rating', 'duration'])
```

## How to filter rows

```python
# one way
booleans = []
for length in movies.duration:
  if length >= 200:
    booleans.append(True)
  else:
    booleans.append(False)

is_long = pd.Series(booleans)

movies[is_long] # brings up movies longer or equal 200

# second way
is_long = movie.duration >= 200 # overloaded operator, return a series of bool
movies[is_long]

# shorter
movies[movies.duration >= 200]
```

## How to apply multiple filter to DataFrame

```python
# single & or | for logical ops
movies[(movies.duration >= 200) & (movies.genre == 'Drama')]

# instead of multiple or
movies[movies.genre.isin(['Drama', 'Crime', 'Action'])]
```

## How to use string methods


```python
orders.item_name.str.upper()

orders.item_name.str.contains('Chickin') # Series
```

## how to use gruopby

```python
drinks.groupby('continent').bear_servings.mean
```
