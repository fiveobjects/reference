import pandas as pd
import numpy as np

df = pd.DataFrame([['2019-07-05', '2019-08-01'],
                   ['2019-08-18', '2019-09-03'], ['2019-10-02', '2019-05-03']])

df.loc[pd.to_datetime(df[0]) > pd.to_datetime('2019-07-31'), "var1"] = 1
df.loc[pd.to_datetime(df[0]) <= pd.to_datetime('2019-07-31'), "var1"] = 0

df.loc[pd.to_datetime(df[1]) > pd.to_datetime(df[0]), "var2"] = 1
df.loc[pd.to_datetime(df[1]) <= pd.to_datetime(df[0]), "var2"] = 0


print(df)
#    0           1            var1  var2
# 0  2019-07-05  2019-08-01   0.0   1.0
# 1  2019-08-18  2019-09-03   1.0   1.0
# 2  2019-10-02  2019-05-03   1.0   0.0


df['var1'] = np.where(pd.to_datetime(
    df[0]) > pd.to_datetime('2019-07-31'), 1, 0)
df['var2'] = np.where(pd.to_datetime(df[1]) > pd.to_datetime(df[0]), 1, 0)

print(df)

#    0           1              var1  var2
# 0  2019-07-05  2019-08-01     0     1
# 1  2019-08-18  2019-09-03     1     1
# 2  2019-10-02  2019-05-03     1     0
