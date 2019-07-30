data_dict = {'Aesop': ['AGE: 7 Years Old', 'WEIGHT: 6 lbs', 'SEX: Female', 'BREED: African Aquatic Sideneck Turtle', 'SOURCE: found in Lake Erie'], 'Caesar': ['AGE: 2 Years Old', 'WEIGHT: 4 lbs',
                                                                                                                                                               'SEX: Male', 'BREED: Greek Tortoise', 'SOURCE: hatched in house'], 'Sulla': ['AGE: 1 Year Old', 'WEIGHT: 1 lb', 'SEX: Male', 'BREED: African Aquatic Sideneck Turtle', 'SOURCE: found in Lake Erie']}
name_num = 1
for name in list(data_dict.keys()):
    data_dict["turtle_"+str(name_num)] = data_dict.pop(name)
    data_dict["turtle_"+str(name_num)].append('NAME: '+name)
    name_num += 1

print(data_dict)
