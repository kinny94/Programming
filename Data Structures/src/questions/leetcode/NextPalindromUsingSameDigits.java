package questions.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPalindromUsingSameDigits {
    public String nextPalindrome(String num) {

        int n = num.length();
        if (n == 0) {
            return "";
        }

        if (n == 1) {
            return "";
        }

        int halfLength = n/2;

        List<Character> leftHalf = new ArrayList<>();
        for (int i=0; i<halfLength; i++) {
            leftHalf.add(num.charAt(i));
        }

        int i = leftHalf.size() - 2;
        while (i >= 0 && leftHalf.get(i) >= leftHalf.get(i+1)) {
            i--;
        }

        if (i == -1) {
            return "";
        }

        int j = leftHalf.size() - 1;
        while (leftHalf.get(j) <= leftHalf.get(i)) {
            j--;
        }

        Collections.swap(leftHalf, i, j);
        Collections.reverse(leftHalf.subList(i+1, leftHalf.size()));

        StringBuilder sb = new StringBuilder();
        for (char c: leftHalf) {
            sb.append(c);
        }

        String reverseString = "";
        for (int k=sb.length() - 1;k>=0; k--) {
            reverseString += sb.charAt(k);
        }

        if (n % 2 == 0) {
            return sb.append(reverseString).toString();
        } else {
            return sb.append(num.charAt(halfLength)).append(reverseString).toString();
        }
    }
}
