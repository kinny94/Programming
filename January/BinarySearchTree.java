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

    public Node findNode(int key) {
        Node currentNode = root;

        while (currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.leftchild;
            } else {
                currentNode = currentNode.rightChild;
            }

            if (currentNode == null) {
                return null;
            }
        }

        return currentNode;
    }

    public boolean deleteNode(int key) {
        Node currentNode = root;
        Node parentNode = root;

        boolean isLeftChild = true;
        
        while (currentNode.key != key) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                isLeftChild = true;
                currentNode = currentNode.leftchild;
            } else {
                isLeftChild = false;
                currentNode = currentNode.rightChild;
            }

            if (currentNode == null) {
                return false;
            }
        }

        if (currentNode.leftchild == null && currentNode.rightChild == null) {
            if (currentNode == root) {
                root = null;
            } else if(isLeftChild) {
                parentNode.leftchild = null;
            } else {
                parentNode.rightChild = null;
            }
        } else if (currentNode.rightChild == null) {
            if (currentNode == root) {
                root = currentNode.leftchild;
            } else if (isLeftChild) {
                parentNode.leftchild = currentNode.leftchild;
            } else {
                parentNode.rightChild = currentNode.leftchild;
            }
        } else if (currentNode.leftchild == null) {
            if (currentNode == root) {
                root = currentNode.rightChild;
            } else if (isLeftChild) {
                parentNode.leftchild = currentNode.rightChild;
            } else {
                parentNode.rightChild = currentNode.leftchild;
            }
        } else {
            Node replacement = getReplacementNode(currentNode);

            if (currentNode == root) {
                root = replacement;
            } else if (isLeftChild) {
                parentNode.leftchild = replacement;
            } else {
                parentNode.rightChild = replacement;
            }

            replacement.leftchild = currentNode.leftchild;
        }
        
        return true;

    }

    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node currentNode = replacedNode.rightChild;

        while (currentNode != null) {
            replacementParent = replacement;
            replacement = currentNode;
            currentNode = currentNode.leftchild;
        }

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftchild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
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

        System.out.println("\n Search for 30");
        System.out.println(tree.findNode(30));

        System.out.println("\"n Delete 25");
        System.out.println(tree.deleteNode(30));
    }
}