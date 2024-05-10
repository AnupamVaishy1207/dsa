


import java.util.Scanner;

public class FindbitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int checkBit = 0;
        while (n != 0) {
            checkBit = n & 1;
            if (checkBit == 1) {
                count++;

            }
            n = n >> 1;

        }
        System.out.println(count);

    }

}
