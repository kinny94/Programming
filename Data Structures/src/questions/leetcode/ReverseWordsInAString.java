package questions.leetcode;

public class ReverseWordsInAString {
    private static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        char[] charArray = s.toCharArray();
        int strLen = charArray.length - 1;
        strRev(charArray, 0, charArray.length - 1);

        for (int start = 0, end =0; end <= charArray.length - 1; ++end) {
            if (end == strLen || charArray[end] == ' ') {
                int endIndex = (end == strLen) ? end : end - 1;
                strRev(charArray, start, endIndex);
                start = end + 1;
            }
        }

        return new String(charArray);

    }
}
