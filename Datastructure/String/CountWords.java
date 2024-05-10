import java.util.Scanner;

public class CountWords {
	int count;
	public void countWords(Scanner sc,String str) {
	
		
		String s[]=str.trim().split(" ");
        //for(String ele:s){
        for(int i=0;i<s.length;i++){
           // if(!ele.equals("")){
            if(s[i].length()>0){
                count++;

            }
        }
	   System.out.println("Length of the string is "+count );
		
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a String ");
		String str=sc.nextLine();
		CountWords p=new CountWords();
		p.countWords(sc,str);

	}

}