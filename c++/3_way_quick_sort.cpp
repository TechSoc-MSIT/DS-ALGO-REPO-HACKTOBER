#include <bits/stdc++.h>
using namespace std;

/**
 * Swap two Integers
 * 
 * @param a: First Integer Value
 * @param b: Second integer Value 
 */
void swap(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

/**
 * Print Array
 * 
 * @param arr: Array of Integers
 * @param n  : Size of Array of Integers
 */
void printarr(int arr[], int n) {
	for (int i = 0; i < n; ++i)
		cout<<arr[i]<<" ";
	cout<<endl;
}

/**
 * Partition the array into three parts
 * Part 1: Numbers lower than pivot number.
 * Part 2: Numbers equal to pivot number.
 * Part 3: Numbers greater than pivot number.
 * 
 * @param arr : Array of Integers.
 * @param low : Part 1 start index
 * @param high: Part 3 end index.
 * @param i   : Part 1 end index.
 * @param j   : Part 3 start index.
 */
void partition(int arr[], int low, int high, int& i, int& j) {
	if (high - low <= 1) {
		if (arr[high] < arr[low])
			swap(&arr[high], &arr[low]);
		i = low;
		j = high;
		return;
	}

	int mid = low;
	int pivot = arr[high];
	while (mid <= high) {
		if (arr[mid] < pivot)
			swap(&arr[low++], &arr[mid++]);
		else if (arr[mid] == pivot)
			mid++;
		else if (arr[mid] > pivot)
			swap(&arr[mid], &arr[high--]);
	}

	i = low - 1;
	j = mid;
}

/**
 * 3-way Quick Sort 
 * 
 * @param arr : Array of Integers.
 * @param low : Staring index of the Partition.
 * @param high: Enc index of the Partition.
 */
void quicksort(int arr[], int low, int high) {
	if (low >= high)
		return;

	int i, j;

	partition(arr, low, high, i, j);

	// Recursively sort the 2 parts.
	quicksort(arr, low, i); // Sort the lower half.
	quicksort(arr, j, high); // Sort the higher half.
}

int main()
{
	int a[] = { 5, 8, 3, 5, 6, 1, 8, 3, 3, 8, 4, 3, 1, 4, 6 };
	int size = sizeof(a) / sizeof(int);

	cout<<"Before Sorting:-"<<endl;
	printarr(a, size);

	quicksort(a, 0, size - 1);
	
	cout<<"After Sorting:-"<<endl;
	printarr(a, size);

	return 0;
}
