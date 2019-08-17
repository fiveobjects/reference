data = []
headers = []
f = open("../data/user.csv", "r")

for (index, line) in enumerate(f, start=0):
    line = line.rstrip("\n\r")
    if(index == 0):
        headers = line.split(",")
        continue
    element = {}
    for (index, value) in enumerate(line.split(","), start=0):
        if(headers[index]=='Id'):
            element[headers[index]]=int(value)
        else:    
            element[headers[index]]=value
    data.append(element)

f.close()

print (str(data).replace("'", "\""))