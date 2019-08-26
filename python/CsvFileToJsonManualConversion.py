data = []
headers = []
#f = open("../data/user.csv", "r")
f = open("/Users/msaha/Work/Projects/Itfm/mywork/customer-issues/credit suisse/emea/vrbcdp.csv", "r")

for (index, line) in enumerate(f, start=0):
    line = line.rstrip("\n\r")
    if(index == 0):
        headers = line.split("\t")
        continue
    element = {}
    for (index, value) in enumerate(line.split("\t"), start=0):
        element[headers[index]] = value
    data.append(element)

f.close()

print(str(data).replace("'", "\""))
