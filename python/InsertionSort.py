# Python program for implementation of Insertion Sort 

def insertionSort(arr): 

	for i in range(1, len(arr)): 

		key = arr[i]  
		j = i-1
		while j >= 0 and key < arr[j] : 
				arr[j + 1] = arr[j] 
				j -= 1
		arr[j + 1] = key 

print("Enter array elements")
arr = list(map(int,input().split()))
insertionSort(arr) 
print ("\nSorted array is ",str(arr)) 


