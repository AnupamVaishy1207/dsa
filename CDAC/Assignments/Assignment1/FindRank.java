package CDAC.Assignments.Assignment1;
/*to find rank of an element in a stream of integers. rank: rank of a given integer "x", in stream is "total
no. of ele's less than or equal to x (including x).
Input: { 10, 20, 15, 3, 4, 4, 1 } Ouput: Rank of 4 is: 4 */
public class FindRank {
    public static int findRank(int arr[], int size, int key) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key < arr[i]) {
                count++;
            }
        }
        int rank = size - count;
        return rank;
        
    }
    public static void main(String args[]){
        int arr[]={ 10, 20, 15, 3, 4, 4, 1 };
        int key= 3;
        int rank=findRank(arr, arr.length, key);
        System.out.println("Rank of "+key+" is "+rank);
    }

}
