import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
        System.out.println("Array has been sort using Selection Sort " + Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums, int x, int y) {
        for (int i = 0; i < nums.length; i++) {
            int max = i;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[i]) {
                    max = j;
                }
            }
            swap(nums, i, max);
        }
        System.in.println("Array has been sorted using Bubble Sort" + Arrays.toString(nums));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the size of an array");
        int size = sc.nextInt();
        System.out.println("Please enter the element for an array");
        int nums[] = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("type 1 for selection sort");
        System.out.println("type 2 for Bubble sort");
        System.out.println("type 3 for Insertion sort");
        int selectSortingAlgo = sc.nextInt();

        switch (selectSortingAlgo) {
            case 1: {
                selectionSort(nums);
                break;
            }
            case 2: {
                bubbleSort(nums);
                break;
            }
            // case 3: {
            // insertionSort(nums);
            // break;
            // }
            default:
                System.out.println("Please select the above option only");
                break;
        }

    }
}
