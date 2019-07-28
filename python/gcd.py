def gcdRecur(a, b):
    if a != 0:
        return gcdRecur(b % a, a)
    else:
        return b


print(gcdRecur(9, 12))
