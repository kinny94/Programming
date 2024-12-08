package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');

        int start = 0;
        int end = num.length() - 1;

        while(start <= end) {
            if (!map.containsKey(num.charAt(start)) || map.get(num.charAt(start)) != num.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
