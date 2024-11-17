package algorithms.substringsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestRepeatedSubstring {

    public String longestRepeatedSubstring(String text) {
        List<String> suffixes = getSuffixes(text);
        Collections.sort(suffixes);
        String longestSubstring = "";
        for (int i=0; i<text.length()-1; i++) {
            String temp = longestCommonPrefix(suffixes.get(i), suffixes.get(i+1));
            if (temp.length() > longestSubstring.length()) {
                longestSubstring = temp;
            }
        }
        return longestSubstring;
    }

    public String longestCommonPrefix(String text1, String text2) {
        int commonLength = Math.min(text1.length(), text2.length());
        for (int i=0; i<commonLength; i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return text1.substring(0, i); //O(1)
            }
        }
        return text1.substring(0, commonLength);
    }

    private List<String> getSuffixes(String text) {
        List<String> suffixes = new ArrayList<>();
        for (int i=0; i<text.length(); i++) {
            suffixes.add(text.substring(i, text.length()));
        }
        return suffixes;
    }

    public static void main(String[] args) {
        LongestRepeatedSubstring longestRepeatedSubstring = new LongestRepeatedSubstring();
        System.out.println(longestRepeatedSubstring.longestRepeatedSubstring("hehhe"));
    }

}
