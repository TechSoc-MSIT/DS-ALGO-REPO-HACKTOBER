# Longest Increasing Subsequence

# longestSubsequence returns length of the longest increasing subsequence in arr of size n 
def longestSubsequence(arr): 
	n = len(arr) 
	l = [1]*n 

	for i in range (1, n): 
		for j in range(0, i): 
			if arr[i] > arr[j] and l[i]< l[j] + 1 : 
				l[i] = l[j]+1


	mx = 0

	for i in range(n): 
		mx = max(mx, l[i]) 

	return mx 



arr = [1,5,0,2,10,3,14,2,18] 
print("Length of longest subsequence in array is", longestSubsequence(arr))

