package datastructures.tries;

class AssociativeNode {
    public String character;
    public AssociativeNode[] children;
    public boolean isLeaf;
    public boolean isVisited;
    public int value;

    AssociativeNode(String character) {
        this.character = character;
        this.children = new AssociativeNode[Constants.ALPHABET_SIZE];
    }
}

class TrieAssociateArray {

    private AssociativeNode root;

    public TrieAssociateArray() {
        root = new AssociativeNode("");
    }

    public void insert(String string, int value) {
        AssociativeNode currentNode = root;
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            int indexOfCharacter = c - 'a';
            if (currentNode.children[indexOfCharacter] == null) {
                AssociativeNode newNode = new AssociativeNode(String.valueOf(c));
                currentNode.children[indexOfCharacter] = newNode;
                currentNode = newNode;
            } else {
                currentNode = currentNode.children[indexOfCharacter];
            }
        }
        currentNode.isLeaf = true;
        currentNode.value = value; // value should be set to the leaf node
    }

    public Integer search(String string) {
        AssociativeNode currentNode = root;
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            int indexOfCharacter = c - 'a';
            if (currentNode.children[indexOfCharacter] == null) {
                return null;
            } else {
                currentNode = currentNode.children[indexOfCharacter];
            }
        }
        return currentNode.value;
    }

    public static void main(String[] args) {
        TrieAssociateArray trie = new TrieAssociateArray();
        trie.insert("air", 5);
        trie.insert("apple", 10);
        trie.insert("approve", 6);
        trie.insert("bee", 4);
        System.out.println(trie.search("airstrike"));
        System.out.println(trie.search("air"));
        System.out.println(trie.search("apple"));
    }
}
