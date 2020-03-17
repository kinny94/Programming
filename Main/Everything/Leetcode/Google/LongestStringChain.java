import java.util.*;

/*
Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.
*/

class LongestStringChain {
    
    public int longestStrChain(String[] words) {
       if (words.length < 2) {
            return words.length;
        }

        int maxLen = 0;
        // Size Given in question
        List<String>[] map = new List[17];
        // O(17)
        for (int i = 0; i < 17; i++) {
            map[i] = new ArrayList<>();
        }

        // O(N); N = num of words
        for (String word : words) {
            int len = word.length();
            map[len].add(word);
            maxLen = Math.max(len, maxLen);
        }


        int longestChain = 0;
        // Start in reverse
        for (int j = maxLen; j > 1 && j > longestChain; j--) {
            longestChain = Math.max(longestChain, calculateMaxDepth(map, j, null));
        }
        return longestChain;
    }

    private int calculateMaxDepth(List<String>[] map, int len, String prev) {
        List<String> words = map[len];
        if (words.size() == 0) {
            return 0;
        }
        int max = 0;
        for (String s : words) {
            if (isPredecessor(s, prev)) {
                int depth = calculateMaxDepth(map, len - 1, s);
                max = Math.max(max, depth + 1);
            }
        }
        return max;
    }

    private boolean isPredecessor(String word, String prev) {
        if (prev == null) return true;
        int i = 0, j = 0;

        while (i < prev.length() && j < word.length()) {
            if (prev.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                if (i - j > 1) return false;
            }
        }
        return i - j <= 1;
    }
}