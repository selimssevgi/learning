# How to read a tabular data

- pd.read_table expects data to be separated by tab character 


```python
import pandas as pd

orders = read_table('http://bitly.com/chiporders')

// columns would be 0, 1, 2, 3 etc
pd.read_table('http://bitly.com/movieusers', sep='|', header=None)

user_cols = ['user_id', 'age', 'gender', 'occupation', 'zip_code']
pd.read_table('http://bitly.com/movieusers', sep='|', header=None, names=user_cols)

```
