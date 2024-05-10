package CDAC.SortingAlgorithms.SelectionSort;

import java.util.Arrays;

public class SelectioSort {
    public static void selectionSort(int arr[],int size){
        for(int i=0;i<size-1;i++){
			//1. select one position from array (0 to N-1) --> i
			//2. compare selected position element with all other elements one by one

            for(int j =i+1;j<size;j++){
				//3. if selected position element is greater than other element, then swap both
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
		}//4. repeat above steps untill array is sorted
    }
    public static void main(String args[]){
        int arr[]={44,55,77,22,11,33,99,88,66};
        System.out.println("Array before sort :"+Arrays.toString(arr));
        selectionSort(arr,arr.length);
        System.out.println("Array After sort :"+Arrays.toString(arr));

    }
}
