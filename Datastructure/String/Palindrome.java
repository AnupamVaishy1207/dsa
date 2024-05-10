
import java.util.Scanner;

public class Palindrome {
	boolean flag;
	public boolean palindrome(Scanner sc,String str) {
		
		int i=0,j=str.length()-1;
		while(i<j) {
			 flag=false;
			if(str.charAt(i)==str.charAt(j)) {
				flag=true;
			}
			i++;
			j--;
		}
		return flag;
		
	}
public static void main(String args[]) {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter a String ");
	String str=sc.next();
	Palindrome p=new Palindrome();
	boolean res=p.palindrome(sc,str);
	
	if(res==true)
		System.out.println("String is a palindrome ");
		else
			System.out.println("String is a not Palindrome");
		
		
	
}

}
