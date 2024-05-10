

import java.util.*;

class BitwiseOperator {    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a & b;
        System.out.println("A & B is : " + c);
        System.out.println("===============================================================================");
        c = a ^ b;

        System.out.println("A ^ B is : " + c);
        System.out.println("===============================================================================");
        c = ~a;
        System.out.println("A Not is : " + c);
        System.out.println("===============================================================================");
        c = a | b;
        System.out.println("A | B is : " + c);
        System.out.println("===============================================================================");
        c = a << b;
        System.out.println("A << B is : " + c);
        System.out.println("===============================================================================");
        c = a >> b;
        System.out.println("A >> B is : " + c);
        System.out.println("===============================================================================");
    }
}
