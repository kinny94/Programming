// find the kth smallest element in a tree

// The left subtree of the node T contains items that are smaller than T
// If k is smaller that the number of node in the left subtree, then kth smallest item must b in the left subtree
// If k is greater that the number of node in the left subtree, then kth smallest item must b in the right subtree
// if the number of items in the left subtree + 1 is the kth value then we are done
// if nuOfNode < k, so we have to check the right sub tree and modify k


interface Tree<T> {
  public void traversal();
  public void insert(T data);
  public void delete(T data);
  public T getMaxValue();
  public T getMinValue();
  public Node<T> getRoot();
  public Node<T> getKSmallestElement(Node<T> node, int k);
}

class Node<T> {
  private T data;
  private Node<T> leftChild;
  private Node<T> rightChild;

  public Node(T data) {
      this.data = data; 
  }

  @Override
  public String toString() {
      return this.data.toString();
  }

  public T getData() {
      return data;
  }

  public void setData(T data) {
      this.data = data;
  }

  public Node<T> getLeftChild() {
      return this.leftChild;
  }

  public void setLeftChild(Node<T> leftChildData) {   
      this.leftChild = leftChildData;
  }

  public Node<T> getRightChild() {
      return this.rightChild;
  }

  public void setRightChild(Node<T> rightChildData) {
      this.rightChild = rightChildData;
  }

}

class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

  private Node<T> root; 

  @Override
  public void insert(T data) {
      if (root == null) {
          root = new Node<T>(data);
      } else {
          insertNode(data, root);
      }
  }

  @Override
  public void delete(T data) {
      if (root!= null) {
         root = deleteNode(root, data);
      }
  }   
  
  @Override
  public void traversal() {
      if (root != null) {
          System.out.println();
          System.out.println("Inorder");
          inOrderTraversal(root);
          System.out.println();
          System.out.println("PreOrder");
          preOrderTraversal(root);
          System.out.println();   
          System.out.println("Post order");
          postOrderTraversal(root);
          System.out.println();
      }
  }

  @Override
  public  T getMinValue() {
      if (root == null)  return null;
      return getMin(root);
  }

  @Override
  public T getMaxValue() {
      if (root == null) return null;
      return getMax(root);
  }

  @Override
  public Node<T> getRoot() {
    return this.root;
  }

  private Node<T> deleteNode(Node<T> node, T data) {
      if (node == null) {
          return node;
      }

      if (data.compareTo(node.getData()) < 0) {
          node.setLeftChild(deleteNode(node.getLeftChild(), data));
      } else if (data.compareTo(node.getData()) > 0) {
          node.setRightChild(deleteNode(node.getRightChild(), data));
      } else {
          // we have found the node we want to delete
          if (node.getLeftChild() == null && node.getRightChild() == null) {
              // its a leaf node
              System.out.println("Removing a leaf node...");
              return null;
          }

          // if the given node has a single left child or right child
          if (node.getLeftChild() == null) {
              System.out.println("Removing the right child...");
              Node<T> tempNode = node.getRightChild();
              node = null;
              return tempNode;
          } else if (node.getRightChild() == null) {
              System.out.println("Removing the right child...");
              Node<T> tempNode = node.getLeftChild();
              node = null;
              return tempNode;
          } 

          // we reach the case where the node has two children
          System.out.println("Removing node with two children...");
          // we get the predecessor
          Node<T> tempNode = getPredecessor(node.getLeftChild()); // can be done with successor as well i.e getRightChild()
          // we swap the two node
          node.setData(tempNode.getData());
          node.setLeftChild(deleteNode(node.getLeftChild(), tempNode.getData()));
      }

      return node;
  }

  private Node<T> getPredecessor(Node<T> node) {
      if (node.getRightChild() != null) {
          getPredecessor(node.getRightChild());
      }

      System.out.println("Predecessor is : " + node);
      return node;
  }

  private void inOrderTraversal(Node<T> node) {
      if (node.getLeftChild() != null) {
          inOrderTraversal(node.getLeftChild());
      }

      System.out.print(node.getData() + " --> ");

      if (node.getRightChild() != null) {
          inOrderTraversal(node.getRightChild());
      }
  }

  private void  preOrderTraversal(Node<T> node) {
      System.out.print(node.getData() + " --> ");

      if (node.getLeftChild() != null) {
          preOrderTraversal(node.getLeftChild());
      }

      if (node.getRightChild() != null) {
          preOrderTraversal(node.getRightChild());
      }
  }

  private void postOrderTraversal(Node<T> node) {

      if (node.getLeftChild() != null) {
          postOrderTraversal(node.getLeftChild());
      }

      if (node.getRightChild() != null) {
          postOrderTraversal(node.getRightChild());
      }

      System.out.print(node.getData() + " --> ");
  }

  private void insertNode(T newData, Node<T> node) {
      if (newData.compareTo(node.getData()) < 0) {
          if (node.getLeftChild() != null) {
              insertNode(newData, node.getLeftChild());
          } else {
              Node<T> newNode = new Node<T>(newData);
              node.setLeftChild(newNode);
          }
      } else {
          if (node.getRightChild() != null) {
              insertNode(newData, node.getRightChild());
          } else {
              Node<T> newNode = new Node<T>(newData);
              node.setRightChild(newNode);
          }
      }
  }

  public T getMin(Node<T> node) {
      if (node.getLeftChild() != null) {
          return getMin(node.getLeftChild());
      }
      return node.getData();
  }

  public T getMax(Node<T> node) {
      if (node.getRightChild() != null) {
          return getMax(node.getRightChild());
      }
      return node.getData();
  }

  @Override
  public Node<T> getKSmallestElement(Node<T> node, int k) {
    int n = treeSize(node.getLeftChild()) + 1;

    if (n == k) {
      return node;
    }

    if (n>k) {
      return getKSmallestElement(node.getLeftChild(), k);
    }

    if (n<k) {
      return getKSmallestElement(node.getRightChild(), k - n);
    }

    return null;
  }

  private int treeSize(Node<T> node) {
    if (node == null) return 0;

    // recurssively sum up the size of the left subtree + size of the right subtree
    // size of the tree = size of the left subtree + sum of right subtree + 1 (root);
    return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
  }
}


class KthSmallestElementInATree<T extends Comparable<T>> {
  public static void main(String[] args) {
    Tree<Integer> bst = new BinarySearchTree();
    bst.insert(30);
    bst.insert(20);
    bst.insert(10);
    bst.insert(125);

    System.out.println(bst.getKSmallestElement(bst.getRoot(), 3));
  }
  
}