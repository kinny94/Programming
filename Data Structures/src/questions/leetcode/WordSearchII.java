package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordSearchII {

    class Node {
        Map<Character, Node> children;
        boolean isString;

        Node() {
            this.children = new HashMap<>();
            this.isString = false;
        }
    }

    class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        void insert(String word) {
            Node node = root;
            for (char c: word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Node());
                }
                node = node.children.get(c);
            }
            node.isString = true;
        }

        void removeCharacters(String stringToDelete) {
            Node node = this.root;
            List<Node> childList = new ArrayList<>();

            for (char c: stringToDelete.toCharArray()) {
                childList.add(node);
                node = node.children.get(c);
            }

            for (int i=childList.size() - 1; i>=0; i--) {
                Node parent = childList.get(i);
                char childChar = stringToDelete.charAt(i);
                Node target = parent.children.get(childChar);

                if (!target.children.isEmpty()) {
                    return;
                }
                parent.children.remove(childChar);
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();

        for (String word: words) {
            trie.insert(word);
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                dfs(trie, trie.root, board, i, j, result, new String());
            }
        }
        return result;
    }

    private void dfs(Trie trie, Node node, char[][] grid, int row, int col, List<String> result, String word) {
        if (node.isString) {
            result.add(word);
            node.isString = false;
            trie.removeCharacters(word);
        }

        if (0 <= row && row < grid.length && 0 <= col && col < grid[0].length) {
            char c = grid[row][col];
            Node child = node.children.get(c);
            if (child != null) {
                String newWord = word + c;
                grid[row][col] = 0;
                int[][] offsets = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
                for (int[] offset: offsets) {
                    int newRow = row + offset[0];
                    int newCol = col + offset[1];
                    dfs(trie, child, grid, newRow, newCol, result, newWord);
                }
                grid[row][col] = c;
            }
        }
    }
}