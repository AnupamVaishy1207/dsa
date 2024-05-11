package CDAC.Assignments.Assignment2;

import java.util.Arrays;

//2. Modify the insertion sort algorithm to sort the array in descending order
public class DesendingInsertionSort {
    public static void desendingInsertionSort(int arr[],int size){
        for(int i=1;i<size;i++){
            int temp =arr[i];
            int j=i-1;
            while(j>=0 && arr[j]<temp){
                arr[j+1]=arr[j];
                j--;
            }
arr[j+1]=temp;
        }
    }
     public static void main(String args[]) {
        int arr[] = { 55, 44, 22, 66, 11, 33 };

        System.out.println("Before sort array : " + Arrays.toString(arr));
        desendingInsertionSort(arr, arr.length);
        System.out.println("After sort array : " + Arrays.toString(arr));
    }
}
