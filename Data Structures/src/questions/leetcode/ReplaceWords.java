package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    class Node {
        String val;
        Node[] children;
        boolean isWord;

        Node(String val) {
            this.val = val;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

    class Solution {

        private Node root = new Node("");

        private void insert(String word) {
            Node node = root;
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                int characterIndex = c - 'a';
                if (node.children[characterIndex] == null) {
                    node.children[characterIndex] = new Node(String.valueOf(c));
                }
                node = node.children[characterIndex];
            }
            node.isWord = true;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            // Build the trie
            for (String word : dictionary) {
                insert(word);
            }

            List<String> results = new ArrayList<>();
            List<String> input = Arrays.asList(sentence.split(" "));

            for (String word : input) {
                Node node = root;
                StringBuilder sb = new StringBuilder();

                for (char c : word.toCharArray()) {
                    int characterIndex = c - 'a';
                    if (node.children[characterIndex] != null) {
                        sb.append(c);
                        node = node.children[characterIndex];

                        // If we find a word, we break early
                        if (node.isWord) {
                            results.add(sb.toString());
                            break;
                        }
                    } else {
                        // No matching prefix; keep the original word
                        results.add(word);
                        sb = null; // Signal to skip adding the word again
                        break;
                    }
                }

                // If no prefix was found, add the original word
                if (sb != null && sb.length() > 0 && !node.isWord) {
                    results.add(word);
                }
            }

            // Join results into a single string
            return String.join(" ", results);
        }
    }
}
