package practice.Nov28;

import java.util.ArrayList;
import java.util.List;

public class Tries {

    static class Node {
        public String character;
        public Node[] children;
        public boolean isLeaf;

        public Node(String character) {
            this.character = character;
            this.children = new Node[26]; // Considering 26 characters in english language
        }

        @Override
        public String toString() {
            return character;
        }
    }

    public Node root;

    public Tries() {
        root = new Node("");
    }

    public void insert(String string) {
        Node currentNode = root;
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            int characterIndex = c - 'a'; // getting the character index so we can map it to value in the array
            if (currentNode.children[characterIndex] == null) {
                Node newNode = new Node(String.valueOf(c));
                currentNode.children[characterIndex] = newNode;
                currentNode = newNode;
            } else {
                currentNode = currentNode.children[characterIndex];
            }
        }
        currentNode.isLeaf = true; // setting it as the end of a string; ot mark it as a word
    }

    public boolean search(String string) {
        Node currentNode = root;
        for (char c: string.toCharArray()) {
            int characterIndex = c - 'a';
            if (currentNode.children[characterIndex] == null) {
                System.out.println("String not found!");
                return false;
            } else {
                currentNode = currentNode.children[characterIndex];
            }
        }
        return currentNode.isLeaf;
    }

    public List<String> autoComplete(String string) {
        List<String> autoCompleteList = new ArrayList<>();
        Node currentNode = root;
        for (char c: string.toCharArray()) {
            int characterIndex = c - 'a';
            if (currentNode.children[characterIndex] == null) {
                return autoCompleteList;
            }
            currentNode = currentNode.children[characterIndex];
        }
        collect(currentNode, string, autoCompleteList);
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
            } else {
                String childCharacter = child.character;
                collect(child, prefix + childCharacter, autoCompleteList);
            }
        }
        
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
