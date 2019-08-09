a = zip(('a', 'b'), ('c', 'd'))
print("Zipped result is ", list(a))
c = zip(*a)
print("unzip is ", list(c))


a = zip(('a', 'b'), (1, 2))
print("Zipped result is ", list(a))
c = zip(*a)
print("unzip is ", list(c))
