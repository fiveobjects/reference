import numpy as np
numbers = np.array([2, 3, 6]).reshape(1, 1)


def prime(numbers):
    biggest = np.max(numbers)
    division_array = np.arange(2, np.ceil(biggest / 2) + 1).reshape(1, 1)
    print(division_array)
    # division_array = [2, 3]
    return numbers / division_array


prime(numbers)
