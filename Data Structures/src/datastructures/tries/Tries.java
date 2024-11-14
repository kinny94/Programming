package datastructures.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Constants {

    private Constants() {}

    public static final int ALPHABET_SIZE = 26;
}

class Node {
    public String character;
    public Node[] children;
    public boolean isLeaf;
    public boolean isVisited;

    public Node(String character) {
        this.character = character;
        this.children = new Node[Constants.ALPHABET_SIZE];
    }

    @Override
    public String toString() {
        return character;
    }
}

class Tries {

    private Node root;

    public Tries() {
        root = new Node("");
    }

    public List<String> autoComplete(String prefix) {
        Node currentNode = root;
        List<String> autoCompleteList = new ArrayList<>();
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int indexOfChar = c - 'a';
            if (currentNode.children[indexOfChar] == null) {
                return autoCompleteList;
            }
            currentNode = currentNode.children[indexOfChar];
        }
        collect(currentNode, prefix, autoCompleteList);
        return autoCompleteList;
    }

    private void collect(Node node, String prefix, List<String> autoCompleteList) {
        if (node == null) {
            return;
        }
        if (node.isLeaf) {
            autoCompleteList.add(prefix);
        }

        for (Node child: node.children) {
            if (child == null) {
                continue;
            }
            String childCharacter = child.character;
            collect(child, prefix+childCharacter, autoCompleteList);
        }
    }

    public void insert(String key) {
        Node currentNode = root;
        for (int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            int indexOfCharInChildren = c - 'a'; // a = 97 so ...we will check [2] in the children array
            if (currentNode.children[indexOfCharInChildren] == null) {
                Node newNode = new Node(String.valueOf(c));
                currentNode.children[indexOfCharInChildren] = newNode;
                currentNode = newNode;
            } else {
                currentNode = currentNode.children[indexOfCharInChildren];
            }
        }
        currentNode.isLeaf = true; // to let it know that is a word
    }

    public boolean search(String key) {
        Node currentNode = root;
        for (int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            int indexOfCharInChildren = c - 'a';
            if (currentNode.children[indexOfCharInChildren] == null) {
                return false;
            } else {
                currentNode = currentNode.children[indexOfCharInChildren];
            }
        }
        return currentNode.isLeaf;
    }

    public List<String> sort() {
        return autoComplete("");
    }

    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("air");
        tries.insert("apple");
        tries.insert("approve");
        tries.insert("bee");
        tries.insert("bus");
        tries.insert("banana");

        System.out.println(tries.search("appl"));

        for(String s: tries.autoComplete("a")) {
            System.out.println(s);
        }
        System.out.println();
        for(String s: tries.autoComplete("ap")) {
            System.out.println(s);
        }
        System.out.println();
        for(String s: tries.autoComplete("b")) {
            System.out.println(s);
        }

        System.out.println();
        for (String s: tries.sort()) {
            System.out.print(s + " ");
        }
    }
}
