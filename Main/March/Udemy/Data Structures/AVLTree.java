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

    public void setHeight(int height) {
        this.height = height;
    }
}

interface Tree {
    public void insert(int data);
    public void traverse();
    public void remove(int data);
} 

class AVLTree implements Tree {
    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

	public void remove(int data) {
		root = delete(root, data);
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
        
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
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
        System.out.println("Rotating to the right on node : " + node);

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
        System.out.println("Rotating to the left on node : " + node);

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
        return height(node.getLeftNode()) - height(node.getRightNode());
    }

    public void traverse() {
        if (root == null) {
            return;
        }

        inOrderTraversal(root);
    }

    public void inOrderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }

        System.out.println(node);

        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
    }

    private Node delete(Node node, int data) {
		if (node == null)
			return node;

		// first we have to look for the node we want to get rid of
		if (data < node.getData()) {  // data smaller than given node's data -> go to the left recursively
			node.setLeftNode(delete(node.getLeftNode(), data));
		} else if (data > node.getData()) { // data greater than given node's data -> go to the right recursively
			node.setRightNode(delete(node.getRightNode(), data));
		} else {  // we have found the node we want to remove !!!

			if (node.getLeftNode() == null && node.getRightNode() == null) {
				System.out.println("Removing a leaf node...");
				return null;
			}

			if (node.getLeftNode() == null) {
				System.out.println("Removing the right child...");
				Node tempNode = node.getRightNode();
				node = null;
				return tempNode;
			} else if (node.getRightNode() == null) {
				System.out.println("Removing the left child...");
				Node tempNode = node.getLeftNode();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			Node tempNode = getPredecessor(node.getLeftNode());

			node.setData(tempNode.getData());
			node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));
		}

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		// have to check on every delete operation whether the tree has become unbalanced or not !!!
		return settleDeletion(node);
	}

    private Node getPredecessor(Node node) {
		Node predecessor = node;
		while (predecessor.getRightNode() != null)
            predecessor = predecessor.getRightNode();
            
		return predecessor;
    }
    
    private Node settleDeletion(Node node) {
		
		int balance = getBalance(node);
		// OK, we know the tree is left heavy BUT it can be left-right heavy or left-left heavy
		if (balance > 1) {
			// left right heavy situation: left rotation on parent + right rotation on grandparent
			if (getBalance(node.getLeftNode()) < 0) {
				node.setLeftNode(leftRotation(node.getLeftNode()));
			}
			// this is the right rotation on grandparent ( if left-left heavy, thats single right rotation is needed
			return rightRotation(node);
		}
		// OK, we know the tree is right heavy BUT it can be left-right heavy or right-right heavy
		if (balance < -1) {
			// right - left heavy so we need a right rotation ( on parent!!! ) before left rotation
			if (getBalance(node.getRightNode()) > 0) {
				node.setRightNode(rightRotation(node.getRightNode()));
			}
			// left rotation on grand parent
			return leftRotation(node);
		}
		return node;
	}

    public static void main(String[] args) {
        Tree avl = new AVLTree();
        avl.insert(10);
        avl.insert(15);
        avl.insert(5);
        avl.insert(14);

        avl.remove(5);
        avl.traverse();

    }
}