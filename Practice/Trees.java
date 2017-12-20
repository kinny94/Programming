class Node{
    
    String name;
    int key;

    Node rightChild;
    Node leftChild;

    Node(int key, String name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has a key " + key;
    }

}

class Trees{
    Node root;

    public void addNode(int key, String name){
    
        Node newNode = new Node(key, name);

        if(root == null){
            root = newNode;
        }else{
            
            Node focusNode = root;
            Node parent;
            
            while(true){
                parent = focusNode;

                if(key < focusNode.key){

                    focusNode = focusNode.leftChild;

                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{

                    focusNode = focusNode.rightChild;

                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversal(Node focusNode){
        if(focusNode != null){
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public void preOrderTraversal(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    public void postOrderTraversal(Node focusNode){
        if(focusNode != null){
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.addNode(50, "Boss");
        tree.addNode(25, "VP");
        tree.addNode(15, "Manager");
        tree.addNode(75, "Sales Manager");
        tree.addNode(85, "Salesman");
        tree.addNode(18, "Someone");
        tree.addNode(3, "Sometwo");
        tree.addNode(30, "Somethree");

        tree.inOrderTraversal(tree.root);
        System.out.println();

        tree.preOrderTraversal(tree.root);
        System.out.println();

        tree.postOrderTraversal(tree.root);
    }
}
