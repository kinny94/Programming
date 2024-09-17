package datastructures.binarysearchtrees;

class Node<T> {

    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> insert(T data) {
        if (root == null) {
            root = new Node(data);
        }
        return insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> node, T data) {

        if (node == null) {
            node = new Node<T>(data);
            return node;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insertRec(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insertRec(node.getRight(), data));
        }

        return node;
    }

    public Node<T> search(T data) {
        return searchRec(root, data);
    }

    private Node<T> searchRec(Node<T> node, T data) {
        if (node == null) {
            System.out.println("Item is not found!");
            return null;
        }

        if (node.getData().equals(data)) {
            return node;
        }

        if (data.compareTo(node.getData()) < 0) {
            return searchRec(node.getLeft(), data );
        } else {
            return searchRec(node.getRight(), data);
        }
    }

    public T getMin() {
        return getMinRec(root);
    }

    private T getMinRec(Node<T> node) {
        if (node.getLeft() == null) {
            return node.getData();
        }
        return getMinRec(node.getLeft());
    }

    public T getMax() {
        return getMaxRec(root);
    }

    private T getMaxRec(Node<T> node) {
        if (node.getRight() == null) {
            return node.getData();
        }
        return getMaxRec(node.getRight());
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<T> node) {
        if (node.getLeft() != null) {
            inOrderRec(node.getLeft());
        }

        System.out.print(node.getData() + " -> ");

        if (node.getRight() != null) {
            inOrderRec(node.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderRec(root);
    }

    private void preOrderRec(Node<T> node) {
        System.out.print(node.getData() + " -> ");

        if (node.getLeft() != null) {
            preOrderRec(node.getLeft());
        }

        if (node.getRight() != null) {
            preOrderRec(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderRec(root);
    }

    public void postOrderRec(Node<T> node) {
        if (node.getLeft() != null) {
            postOrderRec(node.getLeft());
        }

        if (node.getRight() != null) {
            postOrderRec(node.getRight());
        }

        System.out.print(node.getData() + " -> ");
    }

    public Node<T> remove(T data) {
        if (root == null) {
            System.out.println("Tree is empty!");
            return null;
        }

        return removeNodeRec(root, null, data);
    }

    private Node<T> removeNodeRec(Node<T> currentNode, Node<T> parent, T data) {
        if (currentNode == null) {
            return null;
        }

        // finding the element we need to delete
        if (data.compareTo(currentNode.getData()) < 0) {
            removeNodeRec(currentNode.getLeft(), currentNode, data);
        } else if (data.compareTo(currentNode.getData()) > 0) {
            removeNodeRec(currentNode.getRight(), currentNode, data);
        } else {
            // we are at the node to be deleted.


            // CASE 1: Node has no children
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                if (parent == null) {
                    return null;
                } else if (parent.getLeft() == currentNode) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
                return null;
            }

            // CASE 2: Node has one child
            if (currentNode.getLeft() == null) {
                return currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                return currentNode.getLeft();
            }

            // CASE 3: Node has two children
            // Find the min value node in the right subtree
            T min = getMinRec(currentNode.getRight());
            currentNode.setData(min);

            // remove the inorder successor
            currentNode.setRight(removeNodeRec(currentNode.getRight(), currentNode, min));
        }
        return currentNode;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);

        System.out.println(bst.getMin().toString());
        System.out.println(bst.getMax().toString());
        System.out.println();

        bst.preOrderTraversal();

        System.out.println();

        bst.inOrderTraversal();

        System.out.println();

        bst.postOrderTraversal();

        System.out.println();

        System.out.println(bst.remove(4));

        bst.preOrderTraversal();

        System.out.println();

        bst.inOrderTraversal();

        System.out.println();

        bst.postOrderTraversal();

        System.out.println();

    }

}
