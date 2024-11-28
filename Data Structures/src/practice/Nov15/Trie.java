package practice.Nov15;
import java.util.ArrayList;
import java.util.List;

class Constant {
    private Constant() {};
    public static final int ALPHABET_SIZE = 26;
}

class Node {

    public String character;
    public Node[] children;
    public boolean isLeaf;

    Node(String character) {
        this.character = character;
        this.children = new Node[Constant.ALPHABET_SIZE];
    }
}

class Trie {

    private Node root;

    Trie() {
        this.root = new Node("");
    }

    public void insert(String text) {
        Node currentNode = root;

        for (int i=0; i<text.length(); i++) {
            int characterIndex = text.charAt(i) - 'a';
            if (currentNode.children[characterIndex] == null) {
                Node newNode = new Node(String.valueOf(text.charAt(i)));
                currentNode.children[characterIndex] = newNode;
                currentNode = newNode;
            } else {
                currentNode = currentNode.children[characterIndex];
            }
        }

        currentNode.isLeaf = true;
    }

    public boolean search(String text) {
        Node currentNode = root;
        
        for (int i=0; i<text.length(); i++) {
            int characterIndex = text.charAt(i) - 'a';
            if (currentNode.children[characterIndex] == null) {
                return false;
            } else {
                currentNode = currentNode.children[characterIndex];
            }
        }

        return currentNode.isLeaf;
    }

    public List<String> autoCompelte(String prefix) {
        List<String> autoCompleteList = new ArrayList<>();
        Node currentNode = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            int characterIndex = c - 'a';
            if (currentNode.children[characterIndex] == null) {
                return autoCompleteList;
            }
            currentNode = currentNode.children[characterIndex];
        }
        collect(currentNode, prefix, autoCompleteList);
        return autoCompleteList;
    }

    private void collect(Node node, String prefix, List<String> list) {
        if (node == null) {
            return;
        }

        if (node.isLeaf) {
            list.add(prefix);
        }

        for (Node child: node.children) {
            if (child == null) {
                continue;
            }
            String childCharacter = child.character;
            collect(child, prefix + childCharacter, list);
        }
    }

    public static void main(String[] args) {
        Trie tries = new Trie();
        tries.insert("air");
        tries.insert("apple");
        tries.insert("approve");
        tries.insert("bee");
        tries.insert("bus");
        tries.insert("banana");

        System.out.println(tries.search("appl"));
        System.out.println(tries.search("apple"));


        for(String s: tries.autoCompelte("a")) {
            System.out.println(s);
        }
        System.out.println();
        for(String s: tries.autoCompelte("ap")) {
            System.out.println(s);
        }
        System.out.println();
        for(String s: tries.autoCompelte("b")) {
            System.out.println(s);
        }

        System.out.println();
        for (String s: tries.autoCompelte("")) {
            System.out.print(s + " ");
        }
    }

}