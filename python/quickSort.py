import sys
from random import randint

array = [6, 2, 12, 9, 4, 3]
less =[]
greater = []
print(array)

sys.setrecursionlimit(10000)


def quicksort(array):
    if len(array) < 2:
        return array
    else:
        pivot_index = randint(0,len(array)-1)
        pivot = array[pivot_index]
        less = [i for i in array[0: pivot_index]+array[pivot_index+1:] if i <= pivot]
        greater = [i for i in array[0: pivot_index]+array[pivot_index+1:] if i > pivot]
        return quicksort(less) + [pivot] + quicksort(greater)


print(quicksort(array))
