def search(arr, ele):
    # arr : an array in which liinear search is to be performed
    # ele : element which is to be searched
    # returns position of the element if found else returns -1
    for i in range(len(arr)):
        if arr[i]==ele:
            return i;
    return -1;
