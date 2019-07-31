import pandas as pd
import numpy as np

df = pd.DataFrame([['2019-07-05', '2019-06-01'], ['2019-07-18', '2019-09-03']])

df.loc[pd.to_datetime(df[0]) > pd.to_datetime(df[1]), "var1"] = 1
df.loc[pd.to_datetime(df[0]) <= pd.to_datetime(df[1]), "var1"] = 0

df.loc[pd.to_datetime(df[0]) <= pd.to_datetime(df[1]), "var2"] = 1
df.loc[pd.to_datetime(df[0]) > pd.to_datetime(df[1]), "var2"] = 0


print(df)
#    0           1            var1  var2
# 0  2019-07-05  2019-06-01   1.0   0.0
# 1  2019-07-18  2019-09-03   0.0   1.0


df['var1'] = np.where(pd.to_datetime(df[0]) > pd.to_datetime(df[1]), 1, 0)
df['var2'] = np.where(pd.to_datetime(df[0]) <= pd.to_datetime(df[1]), 1, 0)

print(df)

#     0           1             var1  var2
# 0  2019-07-05  2019-06-01     1     0
# 1  2019-07-18  2019-09-03     0     1
