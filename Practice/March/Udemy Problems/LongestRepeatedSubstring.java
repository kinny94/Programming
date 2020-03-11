import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class LongestRepeatedSubstring {

    private List<String> getSuffixes(String text) {
        int lengthOfText = text.length();
        List<String> suffixes = new ArrayList<>();

        for (int i=0; i<lengthOfText; ++i) {
            suffixes.add(text.substring(i, lengthOfText)); //O(1); StringBuilder takes O(N)
        }

        return suffixes;
    }

    private String longestCommonPrefix(String text1, String text2) {
        int commonLength = Math.min(text1.length(), text2.length());
        for (int i=0; i<commonLength; i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return text1.substring(0, i);
            }
        }

        return text1.substring(0, commonLength);
    }   

    public String longestRepeatedSubstring(String text) {
        int length = text.length();
        List<String> suffixes = getSuffixes(text);
        Collections.sort(suffixes);
        String longestSubString = "";
        for (int i=0; i<length-1; i++) {
            String temp = longestCommonPrefix(suffixes.get(i), suffixes.get(i+1));
            if (temp.length() > longestSubString.length()) {
                longestSubString = temp;
            } 
        }
        return longestSubString;
    }

    public static void main(String[] args) {
        LongestRepeatedSubstring lps = new LongestRepeatedSubstring();
        System.out.println(lps.longestRepeatedSubstring("hellohellohehe"));
    }
}