package CDAC.Assignments.Assignment2;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int arr[], int size) {
        int comps = 0;
        for (int i = 0; i < size; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comps++;
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    j--;

                } else {
                    break;
                }
            }
            arr[j + 1] = temp;

        }
        System.out.println("Number of comparisons done in an array is " + comps);

    }

    public static void main(String args[]) {
        int arr[] = { 55, 44, 22, 66, 11, 33 };

        System.out.println("Before sort array : " + Arrays.toString(arr));
        insertionSort(arr, arr.length);
        System.out.println("After sort array : " + Arrays.toString(arr));
    }

}
