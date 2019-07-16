
# coding: utf-8

# In[14]:


import pandas as pd


# In[15]:


from pandas import DataFrame


# In[16]:


df = pd.read_csv(r'C:\data\user.csv', header='infer', sep=';')


# In[17]:


df


# In[19]:


json = df.to_json(orient='records')


# In[20]:


json

