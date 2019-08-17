import pandas as pd

df = pd.DataFrame()
df = df.append({'neg': 0.0, 'neu': 0.492, 'pos': 0.508,
                'compound': 0.4754}, ignore_index=True)
df = df.append({'neg': 0.0, 'neu': 0.367, 'pos': 0.633,
                'compound': 0.7845}, ignore_index=True)
df = df.append({'neg': 0.0, 'neu': 0.691, 'pos': 0.309,
                'compound': 0.8004}, ignore_index=True)
df = df.append({'neg': 0.0, 'neu': 0.462, 'pos': 0.538,
                'compound': 0.5413}, ignore_index=True)
df = df.append({'neg': 0.0, 'neu': 0.636, 'pos': 0.364,
                'compound': 0.7906}, ignore_index=True)
print(df)
print(df.to_csv())
