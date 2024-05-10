package JavaConcept.Pattern;

import java.util.*;

class HollowRectangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = 0, col = 0;

        for (row = 0; row < n; row++) {
            if (row == 0 || row == n - 1) {
                for (col = 0; col < n * 3; col++) {
                    System.out.print("*");
                }
            } else {
                for (col = 0; col < n * 3; col++) {
                    if (col == 0 || col == n * 3 - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();

        }

    }
}
/*
******************************
*                            *
*                            *
*                            *
*                            *
*                            *
*                            *
*                            *
*                            *
******************************
 */