package questions.leetcode;

public class MergeStringAlternatively {
    public String mergeAlternately(String word1, String word2) {

        int maxLength = Math.max(word1.length(), word2.length());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<maxLength; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }
}
