package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        LinkedList<String> searchWords = new LinkedList<>();
    }

    class Solution {

        private TrieNode root = new TrieNode();

        private void insert(String product) {
            TrieNode node = root;
            for (int i=0; i<product.length(); i++) {
                char c = product.charAt(i);
                int characterIndex = c - 'a';
                if (node.children[characterIndex] == null) {
                    node.children[characterIndex] = new TrieNode();
                }
                node = node.children[characterIndex];
                node.searchWords.offer(product);
                if (node.searchWords.size() > 3) {
                    node.searchWords.pollLast();
                }
            }
        }

        private List<List<String>> search(String searchWord) {
            List<List<String>> result = new ArrayList<>();
            TrieNode node = root;
            for (int i=0; i<searchWord.length(); i++) {
                char c = searchWord.charAt(i);
                int characterIndex = c - 'a';
                if (node != null) {
                    node = node.children[characterIndex];
                }

                if (node == null) {
                    result.add(Arrays.asList());
                    continue;
                }

                result.add(node.searchWords);
            }
            return result;
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            for (String product: products) {
                insert(product);
            }
            return search(searchWord);
        }
    }
}
