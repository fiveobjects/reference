import pandas as pd
import numpy as np

df = pd.DataFrame([['2019-07-05', '2019-06-01'], ['2019-07-18', '2019-09-03']])
df.loc[pd.to_datetime(df[0]) > pd.to_datetime(df[1]), "var"] = 1
df.loc[pd.to_datetime(df[0]) <= pd.to_datetime(df[1]), "var"] = 0
print(df)
# 0           1           var
# 0   2019-07-05  2019-06-01  1.0
# 1   2019-07-18  2019-09-03  0.0


df['var'] = np.where(pd.to_datetime(df[0]) > pd.to_datetime(df[1]), 1, 0)

print(df)

# 0           1           var
# 0   2019-07-05  2019-06-01  1
# 1   2019-07-18  2019-09-03  0
