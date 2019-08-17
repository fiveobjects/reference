data = []
headers = []
types = []
name = ""
f = open("../data/user.csv", "r")

for (index, line) in enumerate(f, start=0):
    line = line.rstrip("\n\r")
    if(index == 0):
        name = line
        continue
    if(index == 1):
        headers = line.split(",")
        continue
    if(index == 2):
        types = line.split(",")
        continue
    element = ["insert into "+name+" values("]
    for (index, value) in enumerate(line.split(","), start=0):
        if(types[index]=='int'):
            element.append(int(value))
            element.append(",")
        else:    
            element.append(value)
            element.append(",")
    element.append(");")
    data.append("".join(element))

f.close()

print (str(data).replace("'", "\""))