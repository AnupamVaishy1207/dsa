package Datastructure.Interger;
/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside 
the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1 */


import java.util.Scanner;

public class ReverseInteger {
    public static int reverse(int x) {
        int INT_MIN=(int)Math.pow(-2, 31);
         int INT_MAX=(int)Math.pow(2, 31)-1;
         int ans=0;
        while(x!= 0){
          
            int digit=x % 10;
              if((ans<INT_MIN/10) || (ans>INT_MAX/10)){
                return 0;
            }
             ans=(ans*10)+digit;
            x=x/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(reverse(n));
    }
}

