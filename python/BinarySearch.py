from math import floor as fl
import random


def binarysearch(arr, l, r, q):
    if r >= l:
        mid = int(fl((l + r)/2))
        print("left = ", l)
        print("right =", r)
        print("Current middle of array is :", mid)
        if arr[mid] == q:
            print(" i am here now and mid=", mid)
            return mid
        elif arr[mid] > q:
            return binarysearch(arr, 0, mid, q)
        else:
            return binarysearch(arr, mid, r, q)
    else:
        return -1


my_List = list(range(50))
random.shuffle(my_List)
my_List.sort()
print("Sort List = ", my_List)
query = 31

result = binarysearch(my_List, 0, len(my_List), query)
if result == -1:
    print("31 not present in list")
else:
    print("index location ", result)
