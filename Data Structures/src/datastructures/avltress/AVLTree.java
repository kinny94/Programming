package datastructures.avltress;

public class AVLTree<T extends Comparable<T>> {

    private class Node {
        T data;
        Node left, right;
        int height;

        public Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    // Public method to insert data into the AVL tree
    public void insert(T data) {
        root = insertRec(root, data);
    }

    // Recursive function to insert data and balance the tree
    private Node insertRec(Node node, T data) {
        if (node == null) {
            return new Node(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data);
        } else {
            return node; // Duplicate data is not allowed
        }

        // Update height of current node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Balance the node if needed
        return balanceNode(node);
    }

    // Public method to remove data from the AVL tree
    public void remove(T data) {
        root = removeRec(root, data);
    }

    // Recursive function to delete a node and balance the tree
    private Node removeRec(Node node, T data) {
        if (node == null) {
            System.out.println("Item " + data + " not found in the tree.");
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = removeRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = removeRec(node.right, data);
        } else {
            // Node with only one child or no child
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                // Node with two children
                T minValue = getMinValue(node.right);
                node.data = minValue;
                node.right = removeRec(node.right, minValue);
            }
        }

        if (node == null) {
            return null;
        }

        // Update height of current node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Balance the node if needed
        return balanceNode(node);
    }

    // Helper function to get the minimum value node in the subtree
    private T getMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // Balances a node after insertion or deletion
    private Node balanceNode(Node node) {
        int balanceFactor = getBalance(node);

        // Left Left (LL) case
        if (balanceFactor > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // Left Right (LR) case
        if (balanceFactor > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right (RR) case
        if (balanceFactor < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // Right Left (RL) case
        if (balanceFactor < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Right rotation function for balancing
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // Left rotation function for balancing
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    // Helper function to get the height of a node
    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Helper function to get the balance factor of a node
    private int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Inorder traversal to print the tree (for testing)
    public void inorderTraversal() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    // Main function to test the AVL Tree implementation
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Insert elements
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        System.out.println("Inorder traversal of AVL Tree after insertion:");
        avlTree.inorderTraversal();

        // Remove elements
        avlTree.remove(10);
        System.out.println("Inorder traversal of AVL Tree after deleting 10:");
        avlTree.inorderTraversal();

        avlTree.remove(30);
        System.out.println("Inorder traversal of AVL Tree after deleting 30:");
        avlTree.inorderTraversal();

        avlTree.remove(50);
        System.out.println("Inorder traversal of AVL Tree after deleting 50:");
        avlTree.inorderTraversal();
    }
}
