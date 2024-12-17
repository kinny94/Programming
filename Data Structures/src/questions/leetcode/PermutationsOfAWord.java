package questions.leetcode;

import java.util.*;
public class PermutationsOfAWord {

    public static String swap(String word, int i, int j) {
        char[] swapIndex = word.toCharArray();
        char temp = swapIndex[i];
        swapIndex[i] = swapIndex[j];
        swapIndex[j] = temp;
        return new String(swapIndex);
    }

    private static void permuteWord(String word, int index, ArrayList<String> result) {
        if (index == word.length() - 1) {
            result.add(word);
            return;
        }

        for (int i=index; i < word.length(); i++) {
            String swappedStr = swap(word, index, i);
            permuteWord(swappedStr, index + 1, result);
        }
    }
    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> result = new ArrayList<>();
        permuteWord(word, 0, result);
        // Replace this placeholder return statement with your code
        return result;
    }
}
