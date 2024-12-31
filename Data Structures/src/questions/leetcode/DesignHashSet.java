package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    class BinarySearchTree {
        public TreeNode root;

        public BinarySearchTree() {
            root = null;
        }

        public TreeNode find(TreeNode node, int value) {
            if (node == null || value == node.val) {
                return node;
            }

            return value < node.val ? find(node.left, value) : find(node.right, value);
        }

        public TreeNode insert(TreeNode node, int value) {
            if (node == null) {
                return new TreeNode(value);
            }

            if (value > node.val) {
                node.right = insert(node.right, value);
            } else if (value < node.val) {
                node.left = insert(node.left, value);
            }
            return node;
        }

        private int findSuccessor(TreeNode node) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node.val;
        }

        private int findPredecessor(TreeNode node) {
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
            return node.val;
        }

        public TreeNode remove(TreeNode node, int key) {
            if (node == null) return null;

            if (key > node.val) {
                node.right = remove(node.right, key);
            } else if (key < node.val) {
                node.left = remove(node.left, key);
            } else {
                if (node.left == null && node.right == null) {
                    node = null;
                } else if (node.right != null) {
                    node.val = findSuccessor(node);
                    node.right = remove(node.right, node.val);
                } else {
                    node.val = findPredecessor(node);
                    node.left = remove(node.left, node.val);
                }
            }
            return node;
        }
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    class Bucket {
        private BinarySearchTree bst;

        public Bucket() {
            bst = new BinarySearchTree();
        }

        public void add(int value) {
            bst.root = bst.insert(bst.root, value);
        }

        public void remove(int value) {
            bst.root = bst.remove(bst.root, value);
        }

        public boolean contains(int value) {
            return bst.find(bst.root, value) != null;
        }
    }

    private int keyRange;
    private List<Bucket> bucketArray;

    public MyHashSet() {
        keyRange = 769;
        bucketArray = new ArrayList<>(keyRange);
        for (int i=0; i<keyRange; i++) {
            bucketArray.add(new Bucket());
        }
    }

    public int hash(int key) {
        return key % keyRange;
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        bucketArray.get(bucketIndex).add(key);
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        bucketArray.get(bucketIndex).remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return bucketArray.get(bucketIndex).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
