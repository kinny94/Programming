package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentWords {

    class Node {
        Node[] children;
        String word;

        Node() {
            children = new Node[26];
            word = null;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void addWord(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    if (cur.children[c - 'a'] == null) {
                        cur.children[c - 'a'] = new Node();
                    }
                    cur = cur.children[c - 'a'];
                } else {
                    continue;
                }
            }
            cur.word = word;
        }

        public void getWords(Node node, List<String> ans) {
            if (node == null) {
                return;
            }
            if (node.word != null) {
                ans.add(node.word);
            }
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    getWords(node.children[i], ans);
                }
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        Trie[] buckets = new Trie[words.length + 1];
        List<String> topK = new ArrayList<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new Trie();
            }
            buckets[frequency].addWord(word);
        }

        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] != null) {
                List<String> retrieveWords = new ArrayList<>();
                buckets[i].getWords(buckets[i].root, retrieveWords);
                if (retrieveWords.size() < k - topK.size()) {
                    topK.addAll(retrieveWords);
                } else {
                    topK.addAll(retrieveWords.subList(0, k - topK.size()));
                }
            }
        }


        return topK;
    }
}