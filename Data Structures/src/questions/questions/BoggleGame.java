package questions.questions;

class Constants {

    private Constants() {};
    public static final int BOARD_SIZE = 3;
}

class BoggleNode {
    public char character;
    public BoggleNode leftChild;
    public BoggleNode rightChild;
    public BoggleNode middleChild;
    public boolean isLeaf;

    BoggleNode(char character) {
        this.character = character;
    }
}

class TernarySearchTree {

    private BoggleNode root;

    public TernarySearchTree() {
        insert("car");
        insert("bus");
        insert("animal");
    }

    public boolean isWordInTree(String letterSequence) {
        BoggleNode node = get(root, letterSequence, 0);
        if (node == null) return false;
        return node.isLeaf;
    }

    private BoggleNode get(BoggleNode node, String key, int index) {
        if (node == null) {
            return null;
        }
        char c = key.charAt(index);
        if (c < node.character) {
            return get(node.leftChild, key, index);
        } else if (c > node.character) {
            return get(node.rightChild, key, index);
        } else if (index < key.length() - 1) {
            return get(node.middleChild, key, index+1);
        } else {
            if (!node.isLeaf) return null;
            return node;
        }
    }

    public void insert(String key) {
        root = insert(root, key, 0);
    }

    private BoggleNode insert(BoggleNode currentNode, String key, int index) {
        char c = key.charAt(index);
        if (currentNode == null) {
            currentNode = new BoggleNode(c);
        }

        // check the location of the new node
        if (c < currentNode.character) {
            currentNode.leftChild = insert(currentNode.leftChild, key, index);
        } else if (c > currentNode.character) {
            currentNode.rightChild = insert(currentNode.rightChild, key, index);
        } else if (index < key.length() - 1) {
            // this is not the last letter and this is the middle child
            currentNode.middleChild = insert(currentNode.middleChild, key, index+1);
        } else {
            // this node is the leaf node
            currentNode.isLeaf = true;
        }
        return currentNode;
    }

    public void traverse() {
        if (root != null) {
            traverse(root, "");
        }
    }

    private void traverse(BoggleNode currentNode, String s) {
        if (currentNode.middleChild == null) {
            System.out.println(s + currentNode.character + " : ");
        }

        if (currentNode.leftChild != null) {
            traverse(currentNode.leftChild, s);
        }

        if (currentNode.middleChild != null) {
            traverse(currentNode.middleChild, s + currentNode.character);
        }

        if (currentNode.rightChild != null) {
            traverse(currentNode.rightChild, s);
        }
    }
}

class BoggleGame {

    private boolean[][] visited;
    private char[][] table;
    private TernarySearchTree tree;

    public BoggleGame(char[][] table) {
        this.table = table;
        this.visited = new boolean[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        this.tree = new TernarySearchTree();
    }

    private boolean isValid(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= Constants.BOARD_SIZE || colIndex < 0 || colIndex >= Constants.BOARD_SIZE) return false;
        return !visited[rowIndex][colIndex];
    }

    public void findWords() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                search(i, j, ""+table[i][j]);
            }
        }
    }

    private void search(int i, int j, String s) {
        if (tree.isWordInTree(s)) {
            System.out.println(s);
        }

        if (isValid(i, j)) {
            visited[i][j] = true;

            if (isValid(i-1, j)) {
                search(i-1, j, s+table[i-1][j]);
            }

            if (isValid(i+1, j)) {
                search(i+1, j, s+table[i+1][j]);
            }

            if (isValid(i, j+1)) {
                search(i, j+1, s+table[i][j+1]);
            }

            if (isValid(i, j-1)) {
                search(i, j-1, s+table[i][j-1]);
            }

            visited[i][j] = false;
        }
    }

    public static void main(String[] args) {
        char table[][] = {
                {'r', 'u', 's'},
                {'a','c','h'},
                {'b','t','e'}
        };
        BoggleGame game = new BoggleGame(table);
        game.findWords();
    }
}
