import java.io.*;
import java.util.*;

public class Main {

  public static void insertionSort(int[] arr) {
    //write your code here
    for(int i=1;i<arr.length;i++){
        for(int j=i-1;j>=0;j--){
            if(arr[j+1]<arr[j]){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }else{
                break;
            }
        }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    insertionSort(arr);
    for(int i:arr){
        System.out.print(i+" ");
    }
  }

}