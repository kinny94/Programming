package algorithms.substringsearch;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String text1, String text2) {
        int commonLength = Math.min(text1.length(), text2.length());
        for (int i=0; i<commonLength; i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return text1.substring(0, i); //O(1)
            }
        }
        return text1.substring(0, commonLength);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix("hello", "hello"));
    }
}
