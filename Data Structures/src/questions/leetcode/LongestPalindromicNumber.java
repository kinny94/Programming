package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicNumber {
    public String largestPalindromic(String num) {
        Map<Character, Integer> map = new HashMap<>();

        for(char digit: num.toCharArray()) {
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        List<String> firstHalf = new ArrayList<>();
        String middle = "";

        for(char digit = '9'; digit >= '0'; digit--) {
            if(map.containsKey(digit)) {
                int digitCount = map.get(digit);
                int numPairs = digitCount / 2;

                if(numPairs > 0) {
                    if(firstHalf.isEmpty() && digit == '0') {
                        map.put('0', 1);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for(int i = 0; i < numPairs; i++) {
                            sb.append(digit);
                        }
                        firstHalf.add(sb.toString());
                    }
                }

                if(digitCount % 2 == 1 && middle.isEmpty()) {
                    middle = Character.toString(digit);
                }
            }

        }

        if(middle.isEmpty() && firstHalf.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();
        for(String part : firstHalf) {
            res.append(part);
        }
        String secondHalf = res.toString();
        res.append(middle).append(new StringBuilder(secondHalf).reverse().toString());
        return res.toString();
    }
}
