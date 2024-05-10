package CDAC.Assignments.Assignment1;

public class BinaySortForDesending {
    public static int binarySearch(int arr[], int size, int key) {
        int left = 0, right = size - 1, mid;
        mid = (left + right) / 2;
        while (left <= right) {
            if (key == arr[mid])
                return mid;
           else if (key < arr[mid])
           right = mid - 1;
           else
           left = mid + 1;

        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 99,88,77,66,55,44,33,22,11 };
        int key = 66;
        int index = binarySearch(arr, arr.length, key);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
