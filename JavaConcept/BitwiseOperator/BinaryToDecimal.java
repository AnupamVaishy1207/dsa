

import java.util.Scanner;

public class BinaryToDecimal {

    // Method to Convert Decimal to Binary
    public static int BinToDec(int n) {

        int decimal = 0;
        int power = 0;
        while (n != 0) {

            int digit = n % 10;

            decimal += digit * Math.pow(2, power);

            // Rught Shift by one
            n = n / 10;

            power++;

        }
        return decimal;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Decimal representation of " + n + " is " + BinToDec(n));
    }

}
