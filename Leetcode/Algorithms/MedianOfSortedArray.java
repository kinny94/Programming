/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int len = 1;
        int checkIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            len++;
            for (int j = checkIndex; j < i; j++) {
                if (chars[i] == chars[j]) {
                    if (maxLen < len - 1) {
                        maxLen = len - 1;
                    }
                    checkIndex = j + 1;
                    len = i - j;
                    break;
                }
            }
        }
        return Math.max(maxLen, len);
    }
}

public class MedianOfSortedArray {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().lengthOfLongestSubstring(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}