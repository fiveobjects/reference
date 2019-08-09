import json

with open("../data/page-data.json") as file:
    data = json.load(file)
output = {}
for page in data:
    for pr in data[page]:
        user = data[page][pr]['user']
        if user not in output:
            output[user] = [page]
        else:
            output[user].append(page)

print(json.dumps(output))
