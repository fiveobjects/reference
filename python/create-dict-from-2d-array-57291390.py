list_of_Strings = ['index', 'substance', 'container']
# a list with 3 lists, each list has a few values
index_list = [0, 1, 2]
substance_list = ['water', 'oil', 'acetone']
container_list = ['B100', 'B200', 'B300']
list_of_lists = [index_list, substance_list, container_list]

dict_dummy_2 = dict.fromkeys(list_of_Strings, 0)
for i in range(len(list_of_Strings)):
    dict_dummy_2[list_of_Strings[i]] = list_of_lists[i]


# Shorthand of creating the dict
d = dict(zip(list_of_Strings, list_of_lists))
print(d)

# {'index': [0, 1, 2], 'substance': ['water', 'oil', 'acetone'],
#     'container': ['B100', 'B200', 'B300']}
