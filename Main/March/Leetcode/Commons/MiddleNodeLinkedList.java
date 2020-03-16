// find the middleNode without using thr extra space


class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;

    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    } 

    @Override
    public String toString() {
        return this.data.toString();
    }
}

interface List<T extends Comparable<T>> {
    public Node<T> getMiddleNode();
    public void insert(T data);
    public void remove(T data);
    public void traverseList();
    public int size();
}

class MiddleNodeLinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeCounter;

    @Override
    public Node<T> getMiddleNode() {
        Node<T> fastPointer = this.root;
        Node<T> slowPointer = this.root;

        while(fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
            fastPointer = fastPointer.getNextNode().getNextNode();
            slowPointer = slowPointer.getNextNode();
        }

        return slowPointer;
    }

    @Override
    public void insert(T data) {
        ++this.sizeCounter;

        if (root == null) {
            root = new Node<T>(data);
        } else {
            insertDataAtBeginning(data);
        }
    }

    // O(1) constant time complexity, update the references
    private void insertDataAtBeginning(T data) {

        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;
    }

    // O(N) inserting at the end
    private void insertDataEnd(T data, Node<T> node) {

        if (node.getNextNode() != null) {
            insertDataEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode != null) {

            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void remove(T data) {

        if (this.root == null) {
            return;
        }

        --this.sizeCounter;

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    @Override
    public void traverseList() {

        if (this.root == null) {
            return;
        }

        Node<T> node = this.root;

        while (node != null) {
            System.out.print(node + " ");
            node = node.getNextNode();
        }
    }


	@Override
	public int size() {
		return this.sizeCounter;
	}
    public static void main(String[] args) {
        List<Integer> myLinkedList = new MiddleNodeLinkedList();

        myLinkedList.insert(10);
        myLinkedList.insert(2);
        myLinkedList.insert(13);
        myLinkedList.insert(5);
        myLinkedList.insert(7);
        myLinkedList.insert(8);
        myLinkedList.insert(9);
        myLinkedList.insert(10);
        myLinkedList.insert(10);
        myLinkedList.insert(10);

        System.out.println(myLinkedList.getMiddleNode());
    }
}