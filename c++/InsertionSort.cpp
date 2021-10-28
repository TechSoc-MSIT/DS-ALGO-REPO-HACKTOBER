#include <bits/stdc++.h> 
using namespace std; 
  
/**
 * Sort numbers in an Integer Array.
 * 
 * @param arr: Array of Integers to be sorted
 * @param n  : Size of the Integer Array
 */
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
  
        /**
         * Move elements of arr[0..i-1], that are
         * greater the key, to one position ahead
         * of their current position
         */
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}
  
/**
 * Print numbers from an Integer Array.
 * 
 * @param arr: Array of Integers to be sorted
 * @param n  : Size of the Integer Array
 */
void printArray(int arr[], int n) {
    int i;
    for (i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main() {
    int arr[] = { 21, 42, 3, 15, 37 }; // The Integer Array to be sorted.
    int n = sizeof(arr) / sizeof(arr[0]);  // Calculating the size of the Array
    
    insertionSort(arr, n);  // Sorting Array
    printArray(arr, n);  // Printing Sorted Array
    
    return 0;
}
