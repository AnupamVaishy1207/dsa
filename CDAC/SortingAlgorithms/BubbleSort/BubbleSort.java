package CDAC.SortingAlgorithms.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int arr[], int size) {
        int passes = 0, comps = 0;
        for (int i = 0; i < size - 1; i++) {
            passes++;
            // 1. compare all consecutive elements of array one by one
            for (int j = 0; j < size - 1; j++) {
                comps++;
                // 2. if left element is greater than right element, then swap both

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 3. repeat above two steps untill array is sorted
        System.out.println("No of passes : " + passes);
        System.out.println("No of comparisions : " + comps);
    }
    public static void improvedBubbleSort(int arr[], int size) {
        int passes = 0, comps = 0;
        for (int i = 1; i < size ; i++) {
            passes++;
            // 1. compare all consecutive elements of array one by one--> j-i
            for (int j = 0; j < size - i; j++) {
                comps++;
                // 2. if left element is greater than right element, then swap both

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 3. repeat above two steps untill array is sorted
        System.out.println("No of passes : " + passes);
        System.out.println("No of comparisions : " + comps);
    }

    public static void furtherImprovedBubbleSort(int arr[],int size){
        int passes =0 ,comps = 0;
        boolean flag=false;
        for(int i =1;i<size;i++){
            passes++;
            for(int j=0;j<size-i;j++){
                comps++;
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }

            }
            if(flag==false)
            break;
        }
        System.out.println("No of passes : " + passes);
        System.out.println("No of comparisions : " + comps);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // int arr[] = {33, 22, 66, 55, 44, 11};
        int arr[] = { 11, 22, 33, 44, 55, 66 };

        System.out.println("Array before sort : " + Arrays.toString(arr));
        //bubbleSort(arr, arr.length);
        // improvedBubbleSort(arr, arr.length);
        furtherImprovedBubbleSort(arr, arr.length);
        System.out.println("Array after sort : " + Arrays.toString(arr));
    }
}
