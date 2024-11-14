package questions.questions;

class IPConstants {
    private IPConstants() {}
    public static final int ASCII_SIZE = 126;
}

class IPNode {
    public String character;
    public IPNode[] children;
    public boolean isLeaf;

    IPNode(String character) {
        this.character = character;
        this.children = new IPNode[IPConstants.ASCII_SIZE];
    }
}

class IPTrie {

    private IPNode root;
    private int lcpIndex;

    public IPTrie() {
        this.root = new IPNode("");
    }

    public String lcpForIp() {
        StringBuilder lcp = new StringBuilder();
        IPNode currentNode = root;

        while (numOfChildren(currentNode) == 1 && !currentNode.isLeaf) {
            currentNode = currentNode.children[lcpIndex];
            lcp.append(String.valueOf((char) (lcpIndex)));
        }
        return lcp.toString();
    }

    private int numOfChildren(IPNode node) {
        int num= 0;
        for (int i=0; i<node.children.length; i++) {
            if (node.children[i] != null) {
                num++;
                lcpIndex = i;
            }
        }
        return num;
    }

    public void insert(String string) {
        IPNode currentNode = root;
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            int asciiIndex = c; // getting the actual ascii index since we have special characters
            if (currentNode.children[asciiIndex] == null) {
                IPNode newNode = new IPNode(String.valueOf(asciiIndex));
                currentNode.children[asciiIndex] = newNode;
                currentNode = newNode;
            } else {
                currentNode = currentNode.children[asciiIndex];
            }
        }
        currentNode.isLeaf = true;
    }

    public boolean search(String string) {
        IPNode currentNode = root;
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            int asciiIndex = c;
            if (currentNode.children[asciiIndex] == null) {
                return false;
            } else {
                currentNode = currentNode.children[asciiIndex];
            }
        }
        return currentNode.isLeaf;
    }
}
class IPRouting {
    public static void main(String[] args) {
        IPTrie trie = new IPTrie();
        trie.insert("243.189.345.123");
//        trie.insert("243.189.562.173");
//        trie.insert("243.145.111.173");
//        trie.insert("243.189.123.763");
        trie.insert("243.189.345.221");
        System.out.println("Longest Common Prefix: " + trie.lcpForIp());
    }
}
