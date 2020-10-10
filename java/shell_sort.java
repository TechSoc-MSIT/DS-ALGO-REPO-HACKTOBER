import java.util.Scanner;

public class shell_sort {
    //display array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

   //sort function
    int sort(int arr[])
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {

                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
        }
        return 0;
    }

    // Driver main function
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Shell sort : Enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }

            shell_sort ob = new shell_sort();
        ob.sort(arr);

        System.out.println("Sorted Array");
        printArray(arr);
    }


}
