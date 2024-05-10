package CDAC.Assignments.Assignment1;

public class ComparisonDoneInLinearAndBinary {

    public static void binarySearch(int arr[], int size, int key) {
        int comparison = 0;
        int left = 0, right = size - 1;
        while (left <= right) {
            comparison++;
            int mid = left + (right - left) / 2; // Calculate mid inside the loop
            if (key == arr[mid]) {
                System.out.println("Element found at index number " + mid);
                break;
            } else if (key < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("No of comparisons in binary search: " + comparison);

    }

    public static void linearSearch(int arr[], int size, int key) {
        int comparison = 0;
        for (int i = 0; i < size; i++) {
            comparison++;
            if (key == arr[i]) {
                System.out.println("Element found in arr at index number " + i);
                break;

            }
        }
        System.out.println("No of comparisons in linear search: " + comparison);

    }

    public static void main(String args[]) {
        int arr[] = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
        int size = arr.length;
        int key = 55;
        binarySearch(arr, size, key);
        linearSearch(arr, size, key);
    }
}
