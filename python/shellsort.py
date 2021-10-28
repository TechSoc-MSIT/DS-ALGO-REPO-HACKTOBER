def ShellSort(arr):

    n = len(arr)
    gap = n//2

    while (gap > 0):
        for i in range(gap, n):

            temp = arr[i]
            j = i
            while j >= gap and arr[j-gap] > temp:
                arr[j] = arr[j-gap]
                j = j - gap

            arr[j] = temp
        gap = gap//2


arr = [12, 34, 54, 2, 3]

ShellSort(arr)

for i in range(n):
    print(arr[i]),
