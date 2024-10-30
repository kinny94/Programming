package datastructures.avltress;

public class AVLTree<T extends Comparable<T>> {

    static class Node<T> {
        T data;
        Node<T> left, right, parent;
        int height;

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
            this.height = 1;
        }
    }

    private Node<T> root;

    // Helper function to get the minimum value node in the subtree
    private T getMinValue(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // Update the height of a node
    private void updateHeight(Node<T> node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Helper function to get the height of a node
    private int getHeight(Node<T> node) {
        return (node == null) ? 0 : node.height;
    }

    // Helper function to get the balance factor of a node
    private int getBalance(Node<T> node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Right rotation
    private void rightRotate(Node<T> node) {
        Node<T> tempLeft = node.left;
        Node<T> grandChild = tempLeft.right;

        // Perform rotation
        tempLeft.right = node;
        node.left = grandChild;

        if (grandChild != null) {
            grandChild.parent = node;
        }

        // Update parents
        Node<T> tempParent = node.parent;
        tempLeft.parent = tempParent;
        node.parent = tempLeft;

        if (tempParent == null) {
            root = tempLeft;
        } else if (tempParent.left == node) {
            tempParent.left = tempLeft;
        } else {
            tempParent.right = tempLeft;
        }

        // Update heights
        updateHeight(node);
        updateHeight(tempLeft);
    }

    // Left rotation
    private void leftRotate(Node<T> node) {
        Node<T> tempRight = node.right;
        Node<T> grandChild = tempRight.left;

        // Perform rotation
        tempRight.left = node;
        node.right = grandChild;

        if (grandChild != null) {
            grandChild.parent = node;
        }

        // Update parents
        Node<T> tempParent = node.parent;
        tempRight.parent = tempParent;
        node.parent = tempRight;

        if (tempParent == null) {
            root = tempRight;
        } else if (tempParent.left == node) {
            tempParent.left = tempRight;
        } else {
            tempParent.right = tempRight;
        }

        // Update heights
        updateHeight(node);
        updateHeight(tempRight);
    }

    // Settle violations in the AVL Tree
    private void settleViolations(Node<T> node) {
        while (node != null) {
            updateHeight(node);
            int balance = getBalance(node);

            // Left heavy
            if (balance > 1) {
                if (getBalance(node.left) < 0) {
                    leftRotate(node.left);
                }
                rightRotate(node);
            }

            // Right heavy
            if (balance < -1) {
                if (getBalance(node.right) > 0) {
                    rightRotate(node.right);
                }
                leftRotate(node);
            }

            node = node.parent;
        }
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insertRec(data, root);
        }
    }

    private void insertRec(T data, Node<T> node) {
        if (data.compareTo(node.data) < 0) {
            if (node.left != null) {
                insertRec(data, node.left);
            } else {
                node.left = new Node<>(data, node);
            }
        } else {
            if (node.right != null) {
                insertRec(data, node.right);
            } else {
                node.right = new Node<>(data, node);
            }
        }
        settleViolations(node);
    }

    public void remove(T data) {
        if (root != null) {
            removeRec(data, root);
        }
    }

    private void removeRec(T data, Node<T> node) {
        if (node == null) return;

        if (data.compareTo(node.data) < 0) {
            removeRec(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            removeRec(data, node.right);
        } else {
            // Node with only one child or no child
            if (node.left == null || node.right == null) {
                Node<T> temp = (node.left != null) ? node.left : node.right;

                if (temp == null) {  // No child case
                    if (node == root) root = null;
                    else if (node.parent.left == node) node.parent.left = null;
                    else node.parent.right = null;
                } else {  // One child case
                    if (node == root) root = temp;
                    else if (node.parent.left == node) node.parent.left = temp;
                    else node.parent.right = temp;

                    temp.parent = node.parent;
                }
                settleViolations(node.parent);
            } else {
                // Node with two children
                Node<T> predecessor = getPredecessor(node.left);
                node.data = predecessor.data;
                removeRec(predecessor.data, predecessor);
            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
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
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Insert elements
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        System.out.println("Inorder traversal after insertions:");
        avlTree.inorderTraversal();

        // Remove elements
        avlTree.remove(10);
        System.out.println("Inorder traversal after deleting 10:");
        avlTree.inorderTraversal();

        avlTree.remove(30);
        System.out.println("Inorder traversal after deleting 30:");
        avlTree.inorderTraversal();

        avlTree.remove(50);
        System.out.println("Inorder traversal after deleting 50:");
        avlTree.inorderTraversal();
    }
}
