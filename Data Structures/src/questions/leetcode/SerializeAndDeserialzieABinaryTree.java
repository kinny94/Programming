package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserialzieABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static final String MARKER = "m"; // Null marker
    private static final String DELIMITER = ","; // Delimiter for serialization

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> stream = new ArrayList<>();
        serializeHelper(root, stream);
        return String.join(DELIMITER, stream);
    }

    private void serializeHelper(TreeNode node, List<String> stream) {
        if (node == null) {
            stream.add(MARKER);
            return;
        }
        stream.add(String.valueOf(node.val));
        serializeHelper(node.left, stream);
        serializeHelper(node.right, stream);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> stream = new ArrayList<>(Arrays.asList(data.split(DELIMITER)));
        int[] index = {0}; // Use an array to pass the current index by reference
        return deserializeHelper(stream, index);
    }

    private TreeNode deserializeHelper(List<String> stream, int[] index) {
        String val = stream.get(index[0]);
        index[0]++;
        if (MARKER.equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(stream, index);
        node.right = deserializeHelper(stream, index);
        return node;
    }
}
