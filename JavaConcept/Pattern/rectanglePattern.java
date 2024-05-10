package JavaConcept.Pattern;

import java.util.*;

public class rectanglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row, col;
        for (row = 0; row < n; row++) {
            for (col = 0; col < n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
