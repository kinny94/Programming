package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public void solve(int index, StringBuilder path, String digits, Map<Character, String[]> map, List<String> results) {
        if (path.length() == digits.length()) {
            results.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String[] possibleCharacter = map.get(digit);
        for (String letter: possibleCharacter) {
            path.append(letter);
            solve(index + 1, path, digits, map, results);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }

        Map<Character, String[]> map = new HashMap<>();
        map.put('1', new String[]{""});
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        solve(0, new StringBuilder(), digits, map, results);
        return results;
    }
}
