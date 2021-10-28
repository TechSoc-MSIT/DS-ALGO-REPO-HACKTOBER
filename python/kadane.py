"""
Find maximum sum of contigous subarray in an array.
This problem can be solved with Kadane's Algorithm.
In this python program  we will implement Kadane's Algorithm.
"""

"""
Input: an array of integers (Integers can be negative also)
Output: Maximum sum of contigous subarray in the array.

Example:
Input: [2, 3, -1, -9, 1, 0, 7, -2, 11]
Output: 17

Explanation:
Contigous subarray is [1, 0, 7, -2, 11] with maximum sum.
So, sum = 1+0+7+(-2)+11 = 17
"""

import math

def subArray_max_sum(arr):
    # Function implementation of Kadane's Algorithm

    max_sum = -math.inf # overall maximum sum
    """
    define a variable to store intermediate maximum sum
    if intermediate maximum sum < 0 then reassign it to 0
    find maximum of max_sum and intermediate maximum sum
    """
    intermediate_max_sum = 0

    for val in arr:
        intermediate_max_sum += val

        max_sum = max(max_sum, intermediate_max_sum)
        intermediate_max_sum = max(intermediate_max_sum, 0)

    return max_sum

arr = [2, 3, -1, -9, 1, 0, 7, -2, 11]
print(subArray_max_sum(arr))
