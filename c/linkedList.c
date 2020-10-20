#include <stdio.h> 
#include <stdlib.h> 
  
struct Node { 
    int data; 
    struct Node* next; 
}; 
  
// Program to create a simple linked 
// list with 3 nodes 
int main() 
{ 
    struct Node* head = NULL; 
    struct Node* second = NULL; 
    struct Node* third = NULL; 
  
    // allocate 3 nodes in the heap 
    head = (struct Node*)malloc(sizeof(struct Node)); 
    second = (struct Node*)malloc(sizeof(struct Node)); 
    third = (struct Node*)malloc(sizeof(struct Node)); 
  
 
  
    head->data = 1; // assign data in first node 
    head->next = second; // Link first node with 
    // the second node 

  
    // assign data to second node 
    second->data = 2; 
  
    // Link second node with the third node 
    second->next = third; 

  
    third->data = 3; // assign data to third node 
    third->next = NULL; 
\
  
    return 0; 
} 
