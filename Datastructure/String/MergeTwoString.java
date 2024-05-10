public class MergeTwoString {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));

            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));

            }
            i++;

        }
        return sb.toString();
    }
    public static void main(String[] args) {
        MergeTwoString mergeTwoString = new MergeTwoString();
        
        String word1 = "abc";
        String word2 = "12345";
        
        String result = mergeTwoString.mergeAlternately(word1, word2);
        
        System.out.println("Merged String: " + result);
    }
}
