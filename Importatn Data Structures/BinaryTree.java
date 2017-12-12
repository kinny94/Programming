import javax.swing.text.html.FormView;

import com.sun.javafx.stage.FocusUngrabEvent;

class Node{

    int key;
    String name;

    Node rightChild;
    Node leftChild;

    Node(int key, String name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has  a key " + key; 
    }
}

class BinaryTree{

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

    public Node findNode(int key){

        Node focusNode = root;

        while(focusNode.key != key){

            if(key < focusNode.key){
                focusNode = focusNode.leftChild;
            }else{
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null){
                return null;
            }
        }

        return focusNode;
    } 

    public boolean remove(int key){
        
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while(focusNode.key != key){
            parent = focusNode;

            if(key < focusNode.key){
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            }else{
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null){
                return false;
            }
        }

        if(focusNode.leftChild == null && focusNode.rightChild == null){
            
            if(focusNode == root){
                root = null;
            }else if(isItALeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }

        }

        else if(focusNode.rightChild == null){
            if(focusNode == root){
                root = focusNode.leftChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.leftChild;
            }else{
                parent.rightChild = focusNode.leftChild;
            }
        }

        else if(focusNode.leftChild == null){
            if(focusNode == root){
                root = focusNode.rightChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.rightChild;
            }else{
                parent.rightChild = focusNode.leftChild;
            }
        }

        else{
            Node replacementNode = getReplacementNode(focusNode);

            if(focusNode == root){
                root = replacementNode;
            }else if(isItALeftChild){
                parent.leftChild = replacementNode;
            }else{
                parent.rightChild = replacementNode;
            }

            replacementNode.leftChild = focusNode.leftChild;
        }

        return true;
    }

    public Node getReplacemeNode(Node replacedNode){
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while(focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if(replacement != replacedNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(50, "Boss");
        tree.addNode(25, "VP");
        tree.addNode(15, "Manager");
        tree.addNode(75, "Sales Manager");
        tree.addNode(85, "Salesman");

        tree.inOrderTraversal(tree.root);
        System.out.println();

        tree.preOrderTraversal(tree.root);
        System.out.println();

        tree.postOrderTraversal(tree.root);
    
        System.out.println("Search for 25");
        System.out.println(tree.findNode(25));
    }
}

