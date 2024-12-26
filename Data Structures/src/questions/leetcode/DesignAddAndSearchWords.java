package questions.leetcode;

public class DesignAddAndSearchWords {
    class Node {
        String val;
        Node[] children;
        boolean isWord;

        Node(String val) {
            this.val = val;
            this.children = new Node[26];
            this.isWord = false;
        }
    }
    class WordDictionary {

        private final Node root;

        public WordDictionary() {
            root = new Node("");
        }

        public void addWord(String word) {
            Node node = root;
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (String.valueOf(c).equals(".")) {
                    continue;
                }
                int characterIndex = c - 'a';
                if (node.children[characterIndex] == null) {
                    node.children[characterIndex] = new Node(String.valueOf(c));
                }
                node = node.children[characterIndex];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            return searchHelper(word, 0, root);
        }

        private boolean searchHelper(String word, int index, Node node) {
            if (index == word.length()) {
                return node.isWord;
            }

            char c = word.charAt(index);
            if (c == '.') {
                // Check all possible children
                for (Node child : node.children) {
                    if (child != null && searchHelper(word, index + 1, child)) {
                        return true;
                    }
                }
                return false; // No match found
            } else {
                int characterIndex = c - 'a';
                if (node.children[characterIndex] == null) {
                    return false;
                }
                return searchHelper(word, index + 1, node.children[characterIndex]);
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
