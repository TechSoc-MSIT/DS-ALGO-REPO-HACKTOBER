public class bubble_sort
{
	/*
	Bubble Sort Algorithm Implementation in Java
	time complexity : O(n^2)
	*/ 
	static int[] selectionSort(int[] arr)
	{
		int n = arr.length; 
		
		int temp;
		for (int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if (arr[j]>arr[j+1])
				{
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}

		return arr;
	}
	
	
	//Driver main method
   public static void main(String args[])
   {
		int[] arr = {5,1,3,6,8,12,4};   
		
		arr=selectionSort(arr);
		
		for (int i = 0 ;i< arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
   }  
}