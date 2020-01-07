class Node2 {

    int key;
    String name;

    Node2 rightChild;
    Node2 leftChild;

    Node2(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has  a key " + key; 
    }
}

class BinaryTree2 {

    Node2 root;
    
    public void addNode(int key, String name) {

        Node2 newNode = new Node2(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node2 focusNode = root;
            Node2 parent;

            while(true) {
                parent = focusNode;

                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversal(Node2 focusNode) {
        inOrderTraversal(focusNode.leftChild);
        System.out.println(focusNode);
        inOrderTraversal(focusNode.rightChild);
    }

    public void preOrderTraversal(Node2 focusNode) {
        System.out.println(focusNode);
        preOrderTraversal(focusNode.leftChild);
        preOrderTraversal(focusNode.rightChild);
    }

    public void postOrderTraversal(Node2 focusNode) {
        postOrderTraversal(focusNode.leftChild);
        postOrderTraversal(focusNode.rightChild);
        System.out.println(focusNode);
    }

    public void findANode(int key) {
        Node2 focusNode = root;

        while(focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public boolean remove(int key) {
        Node2 focusNode = root;
        Node2 parent = root;

        boolean isLeftChild = false;

        while (focusNode.key != key) {
            parent = focusNode;

            if (key < focusNode.leftChild) {
                isLeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isLeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return false;
            }
        }

        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.rightChild;
            }
        } else {
            Node2 replacementNode = getReplacementNode(focusNode);

            if(focusNode == root){
                root = replacementNode;
            }else if(isItALeftChild){
                parent.leftChild = replacementNode;
            }else{
                parent.rightChild = replacementNode;
            }

            replacementNode.leftChild = focusNode.leftChild;
        }

        return true;
    }

    Node2 getReplacementNode(Node2 replacedNode) {
        Node2 focusNode = replacedNode.rightChild;

        while(focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if(replacement != replacedNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }
 
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(50, "Boss");
        tree.addNode(25, "VP");
        tree.addNode(15, "Manager");
        tree.addNode(75, "Sales Manager");
        tree.addNode(85, "Salesman");
        tree.addNode(18, "Someone");
        tree.addNode(3, "Sometwo");
        tree.addNode(30, "Somethree");

        tree.inOrderTraversal(tree.root);
        System.out.println();

        tree.preOrderTraversal(tree.root);
        System.out.println();

        tree.postOrderTraversal(tree.root);
    
        System.out.println("Search for 25");
        System.out.println(tree.findNode(25));

        System.out.println();
        System.out.println(tree.remove(15));

        System.out.println();
        tree.inOrderTraversal(tree.root);
        System.out.println();

    }
}