import java.util.Scanner;

public class merge_sort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        int Left[] = new int[n1];
        int Right[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            Left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            Right[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            }
            else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }


    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    //display array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver function ; main
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr[i] = a;

        }
        merge_sort ob = new merge_sort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
