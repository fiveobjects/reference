import random

list_x = ["a", "y", "l", "d", "e", "l", "g", "o", "i"]
list_y = ["e", "p", "z"]

for item in list_y:
    if item in list_x:
        pass
    else:
        list_x[random.randint(0, len(list_x)-1)] = item
print(list_x)
