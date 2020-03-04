class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;
    private int height;

    Node(int data) {
        this.data = data;
    }

    public String toString() {
        return "" + this.data;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight() {
        this.height = height;
    }
}

interface Tree {
    public void insert(int data);
    public void traverse();
} 

class AVLTree implements Tree {
    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.getData()) {
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }
        
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()) + 1);
        node = settleViolation(data, node);
        return node;
    }

    public Node settleViolation(int data, Node node) {
        int balance = getBalance(node);

        // this is case 1 - left left case
        if (balance > 1 && data < node.getLeftNode().getData()) {
            return rightRotation(node);
        }

        // this is case 2 - right right
        if (balance < -1 && data > node.getRightNode().getData()) {
            return leftRotation(node);
        }

        // left -right case
        if (balance > 1 && data > node.getLeftNode().getData()) {
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        } 

        // right -left case
        if (balance < -1 && data < node.getRightNode().getData()) {
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        } 

        return node;
    }

    private int height(Node node) {
        if (node == null ) {
            return -1;
        }

        return node.getHeight();
    }

    private Node rightRotation(Node node) {
        System.out.println('Rotating to the right....');

        // its gonna be the new root node of the subtree
        Node tempLeftNode = node.getLeftNode();
        Node t = tempLeftNode.getRightNode();

        tempLeftNode.setRightNode(node);
        node.setLeftNode(t);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

        return tempLeftNode;
    }

    private Node leftRotation(Node node) {
        System.out.println('Rotating to the left....');

        // its gonna be the new root node of the subtree
        Node tempRightNode = node.getRightNode();
        Node t = tempRightNode.getLeftNode();

        tempRightNode.setLeftNode(node);
        node.setRightNode(t);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

        return tempRightNode;
    }

    // if it is between -1 and 1, that means that the tree is balanced
    private int getBalance(Node node) {
        if (node  == null) {
            return 0;
        }

        // if difference is greater than 1 then its is left heavy tree, if its less than -1 (-2, -3...), then its a right heavy tree
        return height(node.getLeftNode() - node.getRightNode());
    }

    public void traverse() {
        if (root == null) {
            return;
        }

        inOrderTraversal(root);
    }

    public void inOrderTraversal(Node node) {
        if (node.getLeftNode() !== null) {
            inOrderTraversal(node.getLeftNode());
        }

        System.out.println(node);

        if (node.getRightNode() !== null) {
            inOrderTraversal(node.getRightNode());
        }
    }
}