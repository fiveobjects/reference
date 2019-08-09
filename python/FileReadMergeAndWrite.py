file1 = open('../data/user.csv')
file2 = open('../data/sales.csv')
file3 = open('../data/out.csv', 'w')

lines = file1.readlines()
lines2 = file2.readlines()

class_label = []

for line in lines[1:]:
    # print line.split('\t')[2]
    for line2 in lines2:
        if line.split('\t')[0] in line2:
            print(line2.strip('\n'), line.split('\t')[2].strip('\n'))
            file3.write(line2.strip('\n')+'\t'+line.split('\t')[2])
        else:
            file3.write('aaa 0')

file3.close()
