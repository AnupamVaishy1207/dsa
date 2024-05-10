class GreatestCommonDivisor {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (str2.equals(str1)) {
            return str1;
        }
        if (str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
        return "";
    }

    public static void main(String[] args) {
        GreatestCommonDivisor gcdCalculator = new GreatestCommonDivisor();

        // Test cases
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out
                .println("GCD of \"" + str1 + "\" and \"" + str2 + "\" is: " + gcdCalculator.gcdOfStrings(str1, str2));

        str1 = "ABABAB";
        str2 = "ABAB";
        System.out
                .println("GCD of \"" + str1 + "\" and \"" + str2 + "\" is: " + gcdCalculator.gcdOfStrings(str1, str2));

        str1 = "LEET";
        str2 = "CODE";
        System.out
                .println("GCD of \"" + str1 + "\" and \"" + str2 + "\" is: " + gcdCalculator.gcdOfStrings(str1, str2));
    }

}