
import java.util.Scanner;

public class BitwiseComplement {
     // Method to Convert Decimal to Binary
    public static int DecToBin(int n) {

        int Binary = 0;
        int power = 0;
        while (n != 0) {
            // Check last bit is zero or one
            int bit = n & 1;
            bit=~bit;
            // Rught Shift by one
            n = n >> 1;

Binary += (Math.pow(10, power) * bit) ;
            power++;

        }
        return Binary;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
// int not=~DecToBin(n);
        System.out.println(DecToBin(n));
    }
}
