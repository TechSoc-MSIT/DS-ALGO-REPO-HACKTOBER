#DICTIONARY

dict = {'Name': 'Zara', 'Age': 7, 'Class': 'First'}

#Accessing
print ("Accessing")
print "dict['Name']: ", dict['Name']
print "dict['Age']: ", dict['Age']


#UPDATION
print("Updation")
dict['Age'] = 8; # update existing entry
dict['School'] = "DPS School"; # Add new entry
print "dict['Age']: ", dict['Age']
print "dict['School']: ", dict['School']

#DELETION
del dict['Name']; # remove entry with key 'Name'
dict.clear();     # remove all entries in dict
del dict ;        # delete entire dictionary
