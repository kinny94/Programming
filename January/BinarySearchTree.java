class Node {
    int key;
    String name;

    Node leftchild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }
}

class BinarySearchTree {
    
    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parentNode;

            while (true) {
                parentNode = currentNode;
                if (key < currentNode.key) {
                    currentNode = currentNode.leftchild;
                    if (currentNode == null) {
                        parentNode.leftchild = newNode;
                        return;
                    } 
                } else {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversal(Node currentNode) {
        if (currentNode != null) {
            inOrderTraversal(currentNode.leftchild);
            System.out.println(currentNode);
            inOrderTraversal(currentNode.rightChild);
        }
    }

    public void preOrderTraversal(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode);
            preOrderTraversal(currentNode.leftchild);
            preOrderTraversal(currentNode.rightChild);
        }
    } 

    public void postOrderTraversal(Node currentNode) {
        if (currentNode != null) {
            postOrderTraversal(currentNode.leftchild);
            postOrderTraversal(currentNode.rightChild);
            System.out.println(currentNode);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.addNode(50, "Node 1");
        tree.addNode(24, "Node 2");
        tree.addNode(15, "Node 3");
        tree.addNode(30, "Node 4");
        tree.addNode(75, "Node 5");
        tree.addNode(80, "Node 6");

        tree.inOrderTraversal(tree.root);
        tree.preOrderTraversal(tree.root);
        tree.postOrderTraversal(tree.root);
    }
}