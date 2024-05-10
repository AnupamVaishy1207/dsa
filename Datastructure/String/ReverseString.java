import java.util.Scanner;

public class ReverseString {
	
	public void reverseString(Scanner sc,String str)
{
        String reverseStr="";
	
		for(int i=str.length()-1;i>=0;i--)
		{
			reverseStr=reverseStr+str.charAt(i);
			
			
		}
		System.out.println(reverseStr);
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);	
		System.out.println("Enter the String ");
		String s=sc.next();
		ReverseString r= new ReverseString();
		r.reverseString(sc,s);
		
	}

}