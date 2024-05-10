package CDAC.Assignments.Assignment1;
//1. Write all possibilites to check palindrome. Also do time and space complexity analysis.
public class Palindrome {
    public static boolean palindrome(String str, int size) {
        String reverse = "";
        for (int i = size - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }

        return str.equals(reverse);

    }
//Time Complexity is better because we use two pointer approach
    public static boolean optimizePalindrome(String str, int size) {
        boolean flag = false;
        int i = 0, j = str.length()-1;
        
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) 
            {
                flag = true;
            }
            i++;
            j--;
        }
        return flag;
    }

    public static void main(String args[]) {
        String str = "anuna";
        int size = str.length();
        // boolean isPalindrome=palindrome(str, size);
        boolean isPalindrome = optimizePalindrome(str, size);
        if (isPalindrome)
            System.out.println("String is PalinDrome");
        else
            System.out.println("String is not a palindrome");
    }
}
