csv ="a,b,c,d \
1,2,3,4 \
5,6,7,8";
data = []
headers = csv.split(" ")[0].split(",")
for (index, line) in enumerate(csv.split(" "), start=0):
    if(index == 0):
        continue
    element = {}
    for (index, value) in enumerate(line.split(","), start=0):
        element[headers[index]]=value
    data.append(element)

print (str(data).replace("'", "\""))