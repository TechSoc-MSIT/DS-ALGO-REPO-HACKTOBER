// Submitted by Aarambh Verma (https://github.com/AarambhVerma/)
// C++ code to linearly search a variable 'x' in array 'arr[]'.

// In this type of searching, all elements are checked one by one from starting in linear order
// If x is present then return its location, otherwise return -1 

#include <iostream> 
using namespace std; 

// Search function to search for the element 'x' in array 'arr'
int search(int arr[], int n, int x) 
{ 
    int i; 
    for (i = 0; i < n; i++) 
        if (arr[i] == x) 
            return i; 
    return -1; 
} 
  
int main(void) 
{ 
    int arr[] = { 2, 5, 7, 10, 20 }; 
    int x = 20; 
    int n = sizeof(arr) / sizeof(arr[0]); 
    int result = search(arr, n, x); 
   (result == -1)? cout<<"Element is not present in array" 
                 : cout<<"Element is present at index " <<result; 
   return 0; 
} 
