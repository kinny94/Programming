package datastructures.redBlackTree;

public class RedBlackTree<T extends Comparable<T>> {

    enum NodeColor {
        RED, BLACK
    }

    static class Node<T> {
        T data;
        Node<T> left, right, parent;
        NodeColor color;

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
            this.color = NodeColor.RED;
        }
    }

    private Node<T> root;

    // Helper method to check if a node is red
    private boolean isRed(Node<T> node) {
        return node != null && node.color == NodeColor.RED;
    }

    // Helper method to check if a node is black
    private boolean isBlack(Node<T> node) {
        return node == null || node.color == NodeColor.BLACK;
    }

    // Fixes red-black properties after insertion
    private void settleViolation(Node<T> node) {
        Node<T> parent = null;
        Node<T> grandParent = null;

        while (node != root && isRed(node) && isRed(node.parent)) {
            parent = node.parent;
            grandParent = parent.parent;

            if (parent == grandParent.left) {
                Node<T> uncle = grandParent.right;

                if (isRed(uncle)) {  // Case 1: Uncle is red
                    grandParent.color = NodeColor.RED;
                    parent.color = NodeColor.BLACK;
                    uncle.color = NodeColor.BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.right) {  // Case 2: node is right child
                        leftRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    // Case 3: node is left child
                    rightRotate(grandParent);
                    NodeColor tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            } else {  // Mirror case for right child of grandparent
                Node<T> uncle = grandParent.left;

                if (isRed(uncle)) {
                    grandParent.color = NodeColor.RED;
                    parent.color = NodeColor.BLACK;
                    uncle.color = NodeColor.BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        rightRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    leftRotate(grandParent);
                    NodeColor tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            }
        }
        root.color = NodeColor.BLACK;
    }

    // Fixes red-black properties after deletion
    private void fixDeletion(Node<T> node) {
        while (node != root && isBlack(node)) {
            Node<T> sibling;

            if (node == node.parent.left) {
                sibling = node.parent.right;
                if (isRed(sibling)) {
                    sibling.color = NodeColor.BLACK;
                    node.parent.color = NodeColor.RED;
                    leftRotate(node.parent);
                    sibling = node.parent.right;
                }
                if (isBlack(sibling.left) && isBlack(sibling.right)) {
                    sibling.color = NodeColor.RED;
                    node = node.parent;
                } else {
                    if (isBlack(sibling.right)) {
                        sibling.left.color = NodeColor.BLACK;
                        sibling.color = NodeColor.RED;
                        rightRotate(sibling);
                        sibling = node.parent.right;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = NodeColor.BLACK;
                    sibling.right.color = NodeColor.BLACK;
                    leftRotate(node.parent);
                    node = root;
                }
            } else {
                sibling = node.parent.left;
                if (isRed(sibling)) {
                    sibling.color = NodeColor.BLACK;
                    node.parent.color = NodeColor.RED;
                    rightRotate(node.parent);
                    sibling = node.parent.left;
                }
                if (isBlack(sibling.left) && isBlack(sibling.right)) {
                    sibling.color = NodeColor.RED;
                    node = node.parent;
                } else {
                    if (isBlack(sibling.left)) {
                        sibling.right.color = NodeColor.BLACK;
                        sibling.color = NodeColor.RED;
                        leftRotate(sibling);
                        sibling = node.parent.left;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = NodeColor.BLACK;
                    sibling.left.color = NodeColor.BLACK;
                    rightRotate(node.parent);
                    node = root;
                }
            }
        }
        node.color = NodeColor.BLACK;
    }

    // Rotate left
    private void leftRotate(Node<T> node) {
        Node<T> tempRight = node.right;
        node.right = tempRight.left;

        if (tempRight.left != null) {
            tempRight.left.parent = node;
        }
        tempRight.parent = node.parent;

        if (node.parent == null) {
            root = tempRight;
        } else if (node == node.parent.left) {
            node.parent.left = tempRight;
        } else {
            node.parent.right = tempRight;
        }
        tempRight.left = node;
        node.parent = tempRight;
    }

    // Rotate right
    private void rightRotate(Node<T> node) {
        Node<T> tempLeft = node.left;
        node.left = tempLeft.right;

        if (tempLeft.right != null) {
            tempLeft.right.parent = node;
        }
        tempLeft.parent = node.parent;

        if (node.parent == null) {
            root = tempLeft;
        } else if (node == node.parent.right) {
            node.parent.right = tempLeft;
        } else {
            node.parent.left = tempLeft;
        }
        tempLeft.right = node;
        node.parent = tempLeft;
    }

    // Insertion method
    public void insert(T data) {
        Node<T> newNode = new Node<>(data, null);
        root = bstInsert(root, newNode);
        settleViolation(newNode);
    }

    // Standard BST insert
    private Node<T> bstInsert(Node<T> root, Node<T> newNode) {
        if (root == null) return newNode;

        if (newNode.data.compareTo(root.data) < 0) {
            root.left = bstInsert(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.data.compareTo(root.data) > 0) {
            root.right = bstInsert(root.right, newNode);
            root.right.parent = root;
        }
        return root;
    }

    // Deletion method with fixup
    public void remove(T data) {
        Node<T> node = root;
        while (node != null) {
            if (data.compareTo(node.data) < 0) node = node.left;
            else if (data.compareTo(node.data) > 0) node = node.right;
            else break;
        }
        if (node != null) deleteNode(node);
    }

    // Perform deletion and fix red-black properties
    private void deleteNode(Node<T> node) {
        Node<T> child, parent;
        NodeColor originalColor = node.color;

        if (node.left == null) {
            child = node.right;
            transplant(node, node.right);
        } else if (node.right == null) {
            child = node.left;
            transplant(node, node.left);
        } else {
            Node<T> successor = minimum(node.right);
            originalColor = successor.color;
            child = successor.right;

            if (successor.parent == node) {
                if (child != null) child.parent = successor;
            } else {
                transplant(successor, successor.right);
                successor.right = node.right;
                successor.right.parent = successor;
            }
            transplant(node, successor);
            successor.left = node.left;
            successor.left.parent = successor;
            successor.color = node.color;
        }
        if (originalColor == NodeColor.BLACK) {
            fixDeletion(child);
        }
    }

    // Transplant replaces one subtree as a child of its parent
    private void transplant(Node<T> u, Node<T> v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }

    // Returns the minimum node of a subtree
    private Node<T> minimum(Node<T> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public void inorderTraversal() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node<T> node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

        // Insert elements
        System.out.println("Inserting elements:");
        int[] elementsToInsert = {10, 20, 30, 15, 25, 5, 1};
        for (int element : elementsToInsert) {
            System.out.print("Inserting " + element + ": ");
            rbTree.insert(element);
            rbTree.inorderTraversal();
        }

        // Test in-order traversal
        System.out.println("In-order traversal after insertions:");
        rbTree.inorderTraversal();

        // Remove elements
        System.out.println("\nRemoving elements:");
        int[] elementsToRemove = {15, 25, 5, 1};
        for (int element : elementsToRemove) {
            System.out.print("Removing " + element + ": ");
            rbTree.remove(element);
            rbTree.inorderTraversal();
        }

        // Final in-order traversal
        System.out.println("Final in-order traversal after deletions:");
        rbTree.inorderTraversal();
    }
}
