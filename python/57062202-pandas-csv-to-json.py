
# coding: utf-8

# In[67]:


import pandas as pd


# In[68]:


from pandas import DataFrame


# In[69]:


df = pd.read_csv(r'data/user.csv', header='infer', sep=';')


# In[70]:


df


# In[71]:


json = df.to_json(orient='records')


# In[72]:


json

