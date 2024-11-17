package algorithms.datacompression;

import java.util.PriorityQueue;

class HuffmanLeaf extends HuffmanTree {

    public char value;

    public HuffmanLeaf(int frequency) {
        super(frequency);
    }

    public HuffmanLeaf(int frequency, char value) {
        super(frequency);
        this.value = value;
    }
}

class HuffmanNode extends HuffmanTree {

    public HuffmanTree rightTree;
    public HuffmanTree leftTree;

    public HuffmanNode(HuffmanTree leftTree, HuffmanTree rightTree) {
        super(rightTree.frequency + leftTree.frequency);
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }
}

class HuffmanTree implements Comparable<HuffmanTree> {
    public int frequency;

    public HuffmanTree (int frequency) {
        this.frequency = frequency;
    }
    public static void main(String[] args) {

    }

    @Override
    public int compareTo(HuffmanTree otherTree) {
        return Integer.compare(this.frequency, otherTree.frequency);
    }
}

class HuffmanEncoding  {

    public HuffmanTree buildTree(int[] charFrequencies) {
        PriorityQueue<HuffmanTree> pq = new PriorityQueue<HuffmanTree>();
        for (int i = 0; i < charFrequencies.length; i++) {
            if (charFrequencies[i] > 0) {
                pq.add(new HuffmanLeaf(charFrequencies[i], (char) i));
            }
        }

        while (pq.size() > 1) {
            HuffmanTree tree1 = pq.poll();
            HuffmanTree tree2 = pq.poll();
            pq.add(new HuffmanNode(tree1, tree2));
        }

        return pq.poll();
    }

    public void printCodes (HuffmanTree tree, StringBuilder prefix) {
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            System.out.println(leaf.value + " " + leaf.frequency + " " + prefix);
        } else {
            HuffmanNode node = (HuffmanNode) tree;
            prefix.append("0");
            printCodes(node.leftTree, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
            prefix.append("1");
            printCodes(node.rightTree, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        String text = "My name is Joiiii";
        int[] charFrequencies = new int[256];
        for (char c: text.toCharArray()) {
            ++charFrequencies[c];
        }
        HuffmanEncoding code = new HuffmanEncoding();
        HuffmanTree tree = code.buildTree(charFrequencies);
        code.printCodes(tree, new StringBuilder());
    }
}
