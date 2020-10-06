public class SelectionSort
{
	/*
	SelectionSort Algorithm Implementation in Java
	time complexity : O(n^2)
	*/ 
	static int[] selectionSort(int[] arr)
	{
		int size = arr.length;

		for (int i = 0 ;i< size-1; i++)
		{
			int min = i;

			for (int j = i+1; j<size; j++)
			{
				if (arr[j] < arr[min])
				{
					min = j;
				}
			}
		 
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
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