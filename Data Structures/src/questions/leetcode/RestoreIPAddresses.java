package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    private boolean valid(String s, int start, int length) {
        if (length == 1) return true;
        if (s.charAt(start) == '0') return false;
        if (length < 3) return true;
        return s.substring(start, start + length).compareTo("255") <= 0;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(String s, int startIndex, List<Integer> dots, List<String> ans) {
        final int remainingLength = s.length() - startIndex;
        final int remainingNumberOfIntegers = 4 - dots.size();
        if (remainingLength > remainingNumberOfIntegers * 3 || remainingLength < remainingNumberOfIntegers) {
            return;
        }
        if (dots.size() == 3) {
            if (valid(s, startIndex, remainingLength)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for (Integer dot: dots) {
                    sb.append(s.substring(last, last + dot));
                    last += dot;
                    sb.append('.');
                }
                sb.append(s.substring(startIndex));
                ans.add(sb.toString());
            }
            return;
        }

        for (int currPos = 1; currPos <= 3 && currPos <=remainingLength; currPos++) {
            dots.add(currPos);
            if (valid(s, startIndex, currPos)) {
                helper(s, startIndex + currPos, dots, ans);
            }
            dots.remove(dots.size() - 1);
        }
    }

//    // Brute force - Not much difference since the search space is small
//
//    private static boolean isValid(String segment) {
//        if (segment.length() > 3 || segment.isEmpty()) {
//            return false;
//        }
//        if (segment.charAt(0) == '0' && segment.length() > 1) {
//            return false; // Leading zero
//        }
//        int value = Integer.parseInt(segment);
//        return value >= 0 && value <= 255;
//    }
//    public static List<String> restoreIpAddresses(String s) {
//        List<String> result = new ArrayList<>();
//        int n = s.length();
//
//        // Brute force: Try all positions for the three dots
//        for (int i = 1; i < n - 2 && i < 4; i++) {
//            for (int j = i + 1; j < n - 1 && j < i + 4; j++) {
//                for (int k = j + 1; k < n && k < j + 4; k++) {
//                    // Divide string into 4 segments
//                    String part1 = s.substring(0, i);
//                    String part2 = s.substring(i, j);
//                    String part3 = s.substring(j, k);
//                    String part4 = s.substring(k);
//
//                    // Validate each segment
//                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
//                        result.add(part1 + "." + part2 + "." + part3 + "." + part4);
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
}
