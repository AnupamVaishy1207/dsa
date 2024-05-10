package CDAC.Assignments.Assignment1;

public class LastOccuranceLinearSearch {
    public static int linearSearch(int arr[], int size, int key) {
        for (int i = size - 1; i > 0; i--) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 11, 55, 77, 44, 66, 88, 55, 99, 11, 22, 3 };
        int key = 55;
        int size = arr.length;
        int index = linearSearch(arr, size, key);
        if (index != -1) {
            System.out.println("Last Occurrance of Element found at index " + index);
        } else {
            System.out.println("Element not found in an array");
        }
    }

}
