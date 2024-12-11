package questions.leetcode;

public class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        String minSubsequence = "";

        while (indexS1 < s1.length()) {
            if (s1.charAt(indexS1) == s2.charAt(indexS2)) {
                indexS2++;
                if (indexS2 == s2.length()) {
                    start = indexS1;
                    end = indexS1;
                    indexS2--;

                    while (indexS2 >= 0) {
                        if (s1.charAt(start) == s2.charAt(indexS2)) {
                            indexS2--;
                        }
                        start--;
                    }
                    start++;
                    if ((end - start + 1) < length) {
                        length = end - start + 1;
                        minSubsequence = s1.substring(start, end + 1);
                    }
                    indexS1 = start;
                    indexS2 = 0;
                }
            }
            indexS1++;
        }
        return minSubsequence;
    }
}
