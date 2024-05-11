package CDAC.Assignments.Assignment1;

import java.util.Arrays;

public class SelectionSortComparison {
    public static void selectionSort(int arr[],int size){
        int comparison=0;
        for (int i=0;i<size-1;i++){
            
            for(int j =i+1;j<size;j++){
                comparison++;
             if(arr[i]>arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
             }
            }
        }
        System.out.println("Comparison :"+comparison);
    }
    public static void main(String args[]){
        int arr[]={88,66,44,22,11,55,77,99,33};
        int size=arr.length;
        System.out.println("Array before Sorted"+Arrays.toString(arr));
        selectionSort(arr, size);
        System.out.println("Array After Sorted"+Arrays.toString(arr));

    }
    
}
