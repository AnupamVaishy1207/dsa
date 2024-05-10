public class GreatestComonDivisor {
    public static String gcdOfStrings(String str1, String str2) {
        int i=0;
        String result="";
        while(i<str1.length()){
            if(str1.charAt(i)!=str2.charAt(i)){
               result=result+str1.charAt(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
    
        
        String str1 = "ABCABC";
        String str2 = "ABC";
        
        String result = gcdOfStrings(str1, str2);
        
        System.out.println("GCD of Strings: " + result);
    }
    
}
