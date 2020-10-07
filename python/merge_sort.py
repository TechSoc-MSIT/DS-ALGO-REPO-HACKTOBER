def merge_sort(lists): #creating a function to handle this
    if len(lists) < 2: #sorting is redundant for single or empty lists
        return lists

    result = []
    middle_val = len(lists)//2

    y = merge_sort(lists[:middle_val]) #separately dealing with y and z, merging later
    z = merge_sort(lists[middle_val:])

    while len(y) > 0 and len(z) > 0:
        if y[0] > z[0]: 
            result.append(z.pop(0))   #appending the lower element and popping it
        else:
            result.append(y.pop(0))

    result.extend(y+z) #extending the remaining elements
    return result

print(merge_sort([32,542,45,23,1,43,54])) #some sample sorting 
