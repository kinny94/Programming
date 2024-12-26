package questions.leetcode;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> mySet = new HashSet<>(wordList);
        if (!mySet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 0;

        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();

            for (int i=0; i<size; i++) {
                String curr = queue.poll();

                for (int j=0;j<curr.length(); j++) {
                    String alpha = "abcdefghijklmnopqrstuvwxyz";

                    for (int k=0; k<alpha.length(); k++) {
                        char[] temp = curr.toCharArray();
                        temp[j] = alpha.charAt(k);
                        String newWord = new String(temp);

                        if (newWord.equals(endWord)) {
                            return length + 1;
                        }

                        if (mySet.contains(newWord)) {
                            queue.offer(newWord);
                            mySet.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
