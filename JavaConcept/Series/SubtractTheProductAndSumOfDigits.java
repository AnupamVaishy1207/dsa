package JavaConcept.Series;

import java.util.Scanner;

public class SubtractTheProductAndSumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0, product = 1, n,subtract=0;
        n = sc.nextInt();
        while (n != 0) {
            int rem = n % 10;
            n = n / 10;
            product = product * rem;
            sum=sum+rem;
           subtract = product-sum;

        }
        System.out.println(product+" -  "+sum+" = "+subtract);

    }

}
