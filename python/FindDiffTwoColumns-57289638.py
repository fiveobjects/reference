import numpy as np


def findDiff(a):
    a = np.array(a)
    b = a[0:, 2].astype(int) - a[0:, 1].astype(int)
    maxIndex = np.where(b == np.amax(b))
    minIndex = np.where(b == np.amin(b))
    max = a[maxIndex[0][0]][0]
    min = a[minIndex[0][0]][0]

    print("Diff: ", b)
    print("Max: ", max)
    print("Min: ", min)


findDiff([['team1', 10, 12], ['team2', 21, 45], ['team3', 12, 23]])
