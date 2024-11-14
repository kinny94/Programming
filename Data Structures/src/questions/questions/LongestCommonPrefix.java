package questions.questions;

class LCPConstant {
    private LCPConstant() {}
    public static final int ALPHABET_SIZE = 26;
}

class LCPNode {
    public String character;
    public LCPNode[] children;
    public boolean isLeaf;

    public LCPNode(String character) {
        this.character = character;
        this.children = new LCPNode[LCPConstant.ALPHABET_SIZE];
    }
}

class LCPTrie {

    private LCPNode root;
    private int lcpIndex;

    public LCPTrie() {
        this.root = new LCPNode("");
    }

    public void insert(String string) {
        LCPNode currentNode = root;
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            int indexOfCharacter = c - 'a';
            if (currentNode.children[indexOfCharacter] == null) {
                LCPNode newNode = new LCPNode(String.valueOf(c));
                currentNode.children[indexOfCharacter] = newNode;
                currentNode = newNode;
            } else {
                currentNode = currentNode.children[indexOfCharacter];
            }
        }
        currentNode.isLeaf = true;
    }

    public boolean search(String string) {
        LCPNode currentNode = root;
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            int indexOfCharacter = c - 'a';
            if (currentNode.children[indexOfCharacter] == null) {
                return false;
            } else {
                currentNode = currentNode.children[indexOfCharacter];
            }
        }
        return currentNode.isLeaf;
    }

    public String longestCommonPrefix() {
        LCPNode currentNode = root;
        StringBuilder lcp = new StringBuilder();

        while(numOfChildren(currentNode) == 1 && !currentNode.isLeaf) {
            currentNode = currentNode.children[lcpIndex];
            lcp.append(String.valueOf((char) (lcpIndex + 'a')));
        }
        return lcp.toString();
    }

    private int numOfChildren(LCPNode node) {
        int numOfChildren = 0;
        for (int i=0; i<node.children.length; i++) {
            if (node.children[i] != null) {
                numOfChildren++;
                lcpIndex = i;
            }
        }
        return numOfChildren;
    }
}


class LongestCommonPrefix {
    public static void main(String[] args) {
        LCPTrie trie = new LCPTrie();
        trie.insert("api");
        trie.insert("appa");
        trie.insert("appl");
        trie.insert("appro");
        System.out.println("Longest Common Prefix: " + trie.longestCommonPrefix());
    }
}
