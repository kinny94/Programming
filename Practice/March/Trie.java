import java.util.Arrays;
import java.util.*;

class Node {

    private String character;
    private Node[] children;
    private boolean isLeaf;
    private boolean visited;
    private int value;

    public Node(String character) {
        this.character = character;
        children = new Node[Constants.ALPHABET_SIZE]; // each node is gonna have 26 children
    }

    public void setChild(int index, Node node, int value) {
        node.setValue(value);
        this.children[index] = node;
    }

    public void setValue(int value) {
        this.value = value;
    } 

    public int getValue() {
        return this.value;
    }

    public Node getChild(int index) {
        return this.children[index];
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return this.character;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public Node[] getChildren() {
        return this.children;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public boolean getIsLeaf() {
        return this.isLeaf;
    }

    @Override
    public String toString() {
        return this.character;
    }
}

class Constants {
    public static final int ALPHABET_SIZE = 26;
}

class Trie {

    private Node root;

    Trie() {
        this.root = new Node(""); // root node is always an empty string
    }

    public void insert(String key, int value) {

        Node tempNode = root;

        for(int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = (int) c - 'a'; // coz a starts from 65 in ascii and we need index to start from 0

            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex, node, value);
                tempNode = node;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        tempNode.setIsLeaf(true);
    }

    public boolean search(String key) {

        Node trieNode = root;

        for (int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex  = c - 'a';

            if (trieNode.getChild(asciiIndex) == null) {
                return false;
            } else {
                trieNode = trieNode.getChild(asciiIndex);
            }
        }

        if (!trieNode.getIsLeaf()) return false;

        return true;
    }

    public Integer searchAsMap(String key) {

        Node trieNode = root;

        for (int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex  = c - 'a';

            if (trieNode.getChild(asciiIndex) != null) {
                trieNode = trieNode.getChild(asciiIndex);
            } else {
                return null;
            }
        }

        return trieNode.getValue();
    }

    public List<String> allwordsWithPrefix(String prefix) {
        Node trieNode = root;
        List<String> allWords = new ArrayList<String>();

        for (int i=0; i<prefix.length(); ++i) {
            char c = prefix.charAt(i);
            int asciiIndex = c - 'a';
            trieNode = trieNode.getChild(asciiIndex);
        }

        collect(trieNode, prefix, allWords);
        return allWords;
    }

    private void  collect(Node node, String prefix, List<String> allWords) {
        if (node== null) return;

        if (node.getIsLeaf()) {
            allWords.add(prefix);
        }

        for (Node childNode: node.getChildren()) {
            if (childNode == null) continue;
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix+childCharacter, allWords);
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("joe", 1);
        trie.insert("john", 2);
        trie.insert("johna", 3);
        trie.insert("jana", 3);
        trie.insert("jane", 3);
        trie.insert("jade", 3);
        trie.insert("helloworld", 4);

        System.out.println(trie.search("joe"));
        System.out.println(trie.search("joee"));
        System.out.println(trie.search("jon"));

        System.out.println(trie.searchAsMap("joe"));
        System.out.println(trie.searchAsMap("johna"));

        System.out.println();
        List<String> list = trie.allwordsWithPrefix("jo");
        System.out.println(list);

        System.out.println();
        List<String> list2 = trie.allwordsWithPrefix("jo");
        System.out.println(list2);

        System.out.println();
        List<String> list3 = trie.allwordsWithPrefix("j");
        System.out.println(list3);

        System.out.println();
        List<String> list4 = trie.allwordsWithPrefix("ja");
        System.out.println(list4);
    }
}