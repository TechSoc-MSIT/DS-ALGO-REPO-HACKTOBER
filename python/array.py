#Array


from array import *


array1 = array('i', [10,20,30,40,50])

#Insertion
array1.insert(1,60)
print("Insertion")
for x in array1:
 print(x)
 
#deletion
array1.remove(30)
print("Deletion")
for x in array1:
 print(x)
 
 
#Searching
print("Searching")
print (array1.index(40))
 
 
 
 #Updation
array1[2] = 80
print("Updation")
for x in array1:
 print(x)
