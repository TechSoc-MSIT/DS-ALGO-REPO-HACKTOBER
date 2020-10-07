# Python program to 
# demonstrate stack implementation 
# using list 


stack = [] 

# append() function to push element onto the stack
stack.append('a') 
stack.append('b') 
stack.append('c') 

print('Initial stack') 
print(stack) 

# pop() fucntion to remove element from the stack in LIFO order
print('\nElements poped from stack:') 
print(stack.pop()) 
print(stack.pop()) 
print(stack.pop()) 

print('\nStack after elements are poped:') 
print(stack) 

