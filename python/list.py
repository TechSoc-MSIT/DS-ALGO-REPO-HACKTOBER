# LIST


#ACCESING
list1 = ['physics', 'chemistry', 1997, 2000]
list2 = [1, 2, 3, 4, 5, 6, 7 ]
print ("list1[0]: ", list1[0])
print ("list2[1:5]: ", list2[1:5])


#UPDATION
print("UPDATION")
print ("Value available at index 2 : ")
print (list1[2])
list1[2] = 2001
print ("New value available at index 2 : ")
print (list1[2])


#DELETION
print("DELETION")
print (list1)
del list1[2]
print ("After deleting value at index 2 : ")
print (list1)
