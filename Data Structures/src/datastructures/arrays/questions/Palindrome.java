package datastructures.arrays.questions;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        // remove all white space and special characters from the string
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(s.length()-1-i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
