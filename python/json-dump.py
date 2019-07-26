import json
dict1 = {'a': 'b'}
dict2 = {'c': 'd'}
result = []
result.append(dict1)
result.append(dict2)
print(json.dumps(result))
