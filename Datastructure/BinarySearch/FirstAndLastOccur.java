package Datastructure.BinarySearch;

public class FirstAndLastOccur {
    public int[] firstAndLastPosition(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1, last = -1;

        // Binary search to find the first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                return new int[]{-1, -1};
            }
        }

        low = 0;
        high = n - 1; // Reset low and high for the second binary search

        // Binary search to find the last occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                return new int[]{-1, -1};
            }
        }

        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 5, 5, 6};
        int k = 3;
        int n = arr.length;
        FirstAndLastOccur f=new FirstAndLastOccur();

        int[] result = f.firstAndLastPosition(arr, n, k);
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }
}
