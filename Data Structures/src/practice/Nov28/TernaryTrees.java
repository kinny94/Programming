package practice.Nov28;

public class TernaryTrees {
    static class Node {
        public char character;
        public Node leftChild;
        public Node rightChild;
        public Node middleChild;
        public int value;
        public boolean isLeaf;

        public Node(char character) {
            this.character = character;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "character=" + character +
                    '}';
        }
    }

    public Node root;

    public void insert(String string, int value) {
        root = insert(root, string, value, 0);
    }

    private Node insert(Node currentNode, String string, int value, int index) {
        char c = string.charAt(index);
        if (currentNode == null) {
            currentNode = new Node(c);
        }

        // check the location of the new node
        if (c < currentNode.character) {
            currentNode.leftChild = insert(currentNode.leftChild, string, value, index);
        } else if (c > currentNode.character) {
            currentNode.rightChild = insert(currentNode.rightChild, string, value, index);
        } else if (index < string.length() -1) {
            currentNode.middleChild = insert( currentNode.middleChild, string, value, index + 1);
        } else {
            currentNode.isLeaf = true;
            currentNode.value = value;
        }
        return currentNode;
    } 

    public Integer get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return node.value;
    }

    private Node get(Node node, String key, int index) {
        if (node == null) return null;
        char c = key.charAt(index);
        if (c < node.character) {
            return get(node.leftChild, key, index);
        } else if (c > node.character) {
            return get(node.rightChild, key, index);
        } else if (index < key.length() - 1) {
            return get(node.middleChild, key, index+1);
        } else {
            if (!node.isLeaf) return null;
            return node;
        }
    }

    public void traverse() {
        if (root != null) {
            traverse(root, "");
        }
    }

    private void traverse(Node currentNode, String s) {
        if (currentNode.middleChild == null || currentNode.value != 0) {
            System.out.println(s + currentNode.character + " : " + currentNode.value);
        }

        if (currentNode.leftChild != null) {
            traverse(currentNode.leftChild, s);
        }

        if (currentNode.middleChild != null) {
            traverse(currentNode.middleChild, s + currentNode.character);
        }

        if (currentNode.rightChild != null) {
            traverse(currentNode.rightChild, s);
        }
    }

    public static void main(String[] args) {
        TernaryTrees ternarySearchTree = new TernaryTrees();
        ternarySearchTree.insert("car", 1);
        ternarySearchTree.insert("bus", 5);
        ternarySearchTree.insert("banana", 7);
        ternarySearchTree.insert("city", 20);
        ternarySearchTree.insert("buses", 11);
        ternarySearchTree.insert("person", 2);

        System.out.println(ternarySearchTree.get("adam"));
        System.out.println(ternarySearchTree.get("ada"));
        System.out.println(ternarySearchTree.get("car"));
        System.out.println(ternarySearchTree.get("person"));
        System.out.println(ternarySearchTree.get("banana"));

        ternarySearchTree.traverse();
    }
}
